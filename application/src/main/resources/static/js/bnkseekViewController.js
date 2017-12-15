angular.module('CBRFApp', ['xeditable'])
    .run(['editableOptions', function (editableOptions) {
      editableOptions.theme = 'bs3'; // bootstrap3 theme. Can be also 'bs2', 'default'
    }])
    .controller('bnkseekController', function ($scope, $window, $http, $filter) {
      $scope.bnkseek = [];
      $scope.pzn = [];
      $scope.reg = [];
      $scope.tnp = [];
      $scope.uer = [];
      $scope.currentPage = 0;
      new function () {
        return $scope.pzn.length ? null : $http.get('/load/pzn').success(function (data) {
              $scope.pzn = data;
            });
      };
      new function () {
        return $scope.reg.length ? null : $http.get('/load/reg').success(function (data) {
              $scope.reg = data;
            });
      };
      new function () {
        return $scope.tnp.length ? null : $http.get('/load/tnp').success(function (data) {
              $scope.tnp = data;
            });
      };
      new function () {
        return $scope.uer.length ? null : $http.get('/load/uer').success(function (data) {
              $scope.uer = data;
            });
      };
      function loadBnkseek() {
        return $http.get('/load/bnkseek?page=' + $scope.currentPage).success(function (data) {
          $scope.bnkseek = data.content;
          getPages(data.totalPages, $scope.currentPage);
          $scope.totalPages = data.totalPages - 1;
        });
      }

      $scope.setPage = function (page) {
        if (page == -1)
          page = 0;
        if (page > $scope.totalPages)
          page = $scope.totalPages;
        $scope.currentPage = page;
        loadBnkseek();
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
        if (bnk.regCode) {
          selected = $filter('filter')($scope.reg, {reg: bnk.regCode});
        }
        return selected.length ? selected[0].text : null;
      };
      $scope.showTnp = function (bnk) {
        var selected = [];
        if (bnk.tnpCode) {
          selected = $filter('filter')($scope.tnp, {tnp: bnk.tnpCode});
        }
        return selected.length ? selected[0].text : null;
      };
      $scope.showUer = function (bnk) {
        var selected = [];
        if (bnk.uerCode) {
          selected = $filter('filter')($scope.uer, {uer: bnk.uerCode});
        }
        return selected.length ? selected[0].text : null;
      };

      $scope.saveBnk = function (data, id) {
        //$scope.user not updated yet
        angular.extend(data, {id: id});
        return $http.post('/saveUser', data);
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
    });