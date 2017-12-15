angular.module('CBRFApp', [])
    .controller('indexPageController', function ($scope, $window, $http) {
      $scope.asd = 'hi Alex.';
      $scope.loadDbf = function () {
        $('.load').removeClass('invisible');
        $http({
          method: 'POST',
          url: '/load/dbf'
        }).then(function success(response) {
          $('.load').addClass('invisible');
          $('#loadButton').addClass('disabled');
          if (angular.equals(response.data.status, 'Ok'))
            $scope.serverResponse = 'Данные успешно загружены, можно перейти к просмотру';
          else
            $scope.serverResponse = 'При загрузке данных произошла ошибка: ' + response.data.status;
        }, function fail(data) {
          $scope.serverResponse = 'При загрузке данных произошла ошибка: ' + data;
        });

      };
      $scope.goToTable = function () {
        $window.location.href = '/view/data';
      };
    });