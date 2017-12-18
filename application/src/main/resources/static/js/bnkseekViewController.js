angular.module('CBRFApp', ["xeditable", "ui.bootstrap"])
    .run(['editableOptions', function (editableOptions) {
        editableOptions.theme = 'bs3'; // bootstrap3 theme. Can be also 'bs2', 'default'
    }])
    .controller('bnkseekController', function ($scope, $window, $http, $filter) {

        $scope.opened = {};

        $scope.open = function ($event, elementOpened, element) {
            $event.preventDefault();
            $event.stopPropagation();

            $scope.opened[elementOpened + element] = !$scope.opened[elementOpened + element];
        };

        $scope.bnkseek = [];
        $scope.pzn = [];
        $scope.reg = [];
        $scope.tnp = [];
        $scope.uer = [];
        $scope.currentPage = 0;

        $scope.search = {
            pzn: '',
            bik: '',
            region: ''
        };
        new function () {
            return $scope.pzn.length ? null : $http.get('/load/pzn').then(function (data) {
                $scope.pzn = data.data;
            });
        };
        new function () {
            return $scope.reg.length ? null : $http.get('/load/reg').then(function (data) {
                $scope.reg = data.data;
            });
        };
        new function () {
            return $scope.tnp.length ? null : $http.get('/load/tnp').then(function (data) {
                $scope.tnp = data.data;
            });
        };
        new function () {
            return $scope.uer.length ? null : $http.get('/load/uer').then(function (data) {
                $scope.uer = data.data;
            });
        };

        function loadBnkseek() {
            return $http.get('/load/bnkseek?page=0').then(function (data) {
                $scope.bnkseek = data.data.content;
                getPages(data.data.totalPages, $scope.currentPage);
                $scope.totalPages = data.totalPages - 1;
            });
        }

        $scope.filtering = function () {
            return $http.get('/load/bnkseek?page=' + ($scope.currentPage) + '&pzn=' + $scope.search.pzn + '&reg=' + $scope.search.region + '&rkc=' + $scope.search.bik).then(function (data) {
                $scope.bnkseek = data.data.content;
                getPages(data.data.totalPages, $scope.currentPage);
                $scope.totalPages = data.totalPages - 1;
            });
        };

        $scope.setPage = function (page) {
            if (page == -1)
                page = 0;
            if (page > $scope.totalPages)
                page = $scope.totalPages;
            $scope.currentPage = page;
            $scope.filtering();
        };
        $scope.showPzn = function (bnk) {
            var selected = [];
            if (bnk.pznCode) {
                selected = $filter('filter')($scope.pzn, {pzn: bnk.pznCode});
            }
            return selected.length ? selected[0].name : null;
        };
        $scope.showReg = function (bnk) {
            var selected = [];
            if (bnk.rgnCode) {
                selected = $filter('filter')($scope.reg, {rgn: bnk.rgnCode});
            }
            return selected.length ? selected[0].name : null;
        };
        $scope.showTnp = function (bnk) {
            var selected = [];
            if (bnk.tnpCode) {
                selected = $filter('filter')($scope.tnp, {tnp: bnk.tnpCode});
            }
            return selected.length ? selected[0].fullname : null;
        };
        $scope.showUer = function (bnk) {
            var selected = [];
            if (bnk.uerCode) {
                selected = $filter('filter')($scope.uer, {uer: bnk.uerCode});
            }
            return selected.length ? selected[0].uername : null;
        };

        $scope.saveBnk = function (data) {
            return $http.post('/load/save', data);
        };

        $scope.checkNotNull = function (data) {
            if (data == null)
                return 'field required';
        };

        function getPages(totalPages, currentPage) {
            var startPage, endPage;
            if (totalPages <= 10) {
                startPage = 1;
                endPage = totalPages;
            }
            else {
                if (currentPage <= 6) {
                    startPage = 1;
                    endPage = 10;
                }
                else if (currentPage + 4 >= totalPages) {
                    startPage = totalPages - 9;
                    endPage = totalPages;
                }
                else {
                    startPage = currentPage - 5;
                    endPage = currentPage + 4;
                }
            }
            $scope.pages = range(startPage, endPage, 1);
        }

        function range(start, stop, step) {
            if (stop == null) {
                stop = start || 0;
                start = 0;
            }
            if (!step) {
                step = stop < start ? -1 : 1;
            }

            var length = Math.max(Math.ceil((stop - start) / step), 0);
            var range = Array(length);

            for (var idx = 0; idx < length; idx++, start += step) {
                range[idx] = start;
            }

            return range;
        }

        if ($scope.currentPage === 0)
            $scope.setPage(1);

        $scope.removeBnk = function (index) {
            $scope.bnkseek.splice(index, 1);
            return $http.post('/load/delete', $scope.bnkseek[index]);
        };

        $scope.addBnkseek = function () {
            $http.get('/load/newnum').then(function (data) {
                $scope.inserted = {
                    newnum: data.data.newnum
                };
                $scope.bnkseek.push($scope.inserted);
            });
        };
    });