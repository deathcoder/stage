'use strict';

/**
 * @ngdoc function
 * @name owEcommerceApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the owEcommerceApp
 */
angular.module('owEcommerceApp')
    .controller('LoginCtrl', function ($rootScope, $scope, $http, $location) {

      var authenticate = function (credentials, callback) {

        var headers = credentials ? {
          authorization: "Basic "
          + btoa(credentials.username + ":" + credentials.password)
        } : {};

        $http.get('/spring/api/user', {headers: headers}).success(function (data) {
           if (data.name) {
            $rootScope.authenticated = true;
          } else {
            $rootScope.authenticated = false;
          }
          callback && callback();
        }).error(function () {
          $rootScope.authenticated = false;
          callback && callback();
        });

      }

      authenticate();
      $scope.credentials = {};
      $scope.login = function () {
        authenticate($scope.credentials, function () {
          if ($rootScope.authenticated) {
            $location.path("/");
            $scope.error = false;
          } else {
            $location.path("/login");
            $scope.error = true;
          }
        });
      };
    });

