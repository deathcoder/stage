'use strict';

/**
 * @ngdoc function
 * @name owEcommerceApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the owEcommerceApp
 */
angular.module('owEcommerceApp')
  .directive('itemNav', function($route, $location, $routeParams) {
    return {
      restrict: 'E',
      replace: true,
      transclude: true,
      scope: {
        section: '@',
        link: '@'
      },
      templateUrl: 'templates/nav-item.html',
      controller: function ($scope) {
        $scope.isInSection = function(expectedSection) {
          console.log($route);
          console.log($route.routes[$location.$$path]);
          console.log($location.$$path);
          console.log($routeParams);
          var editMe = angular.copy($location.$$path);
          for (var key in $routeParams) {
            console.log("route key ", $routeParams[key]);
            editMe = editMe.replace("/" + $routeParams[key], "/:" + key);
            console.log("edit ", editMe);
          }
          return expectedSection === $route.routes[editMe].section
        }
      }
    };
  });
