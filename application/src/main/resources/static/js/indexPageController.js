angular.module('CBRFApp', [])
    .controller('indexPageController', function ($scope, $window) {
      $scope.asd = 'hi Alex.';
      $scope.loadDbf = function () {
        $('.invisible').removeClass('invisible');
        // $window.location.href = '/load/dbf';
      };
    });