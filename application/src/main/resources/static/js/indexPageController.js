angular.module('CBRFApp', [])
    .controller('indexPageController', function ($scope, $window) {
      $scope.asd = 'hi Alex.';
      $scope.loadDbf = function () {
        $window.location.href = '/load/dbf';
      };
    });