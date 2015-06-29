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
          mylog("route", $route);
          mylog($route.routes[$location.$$path]);
          mylog($location.$$path);
          mylog("routeparams", $routeParams);

          var editMe = angular.copy($location.$$path);
          mylog("location", $location);
          for (var key in $routeParams) {
            mylog("route key ", $routeParams[key]);
            editMe = editMe.replace("/" + $routeParams[key], "/:" + key);
            mylog("edit ", editMe);
          }

          if($route.routes[editMe] == undefined) {
            mylog("param empty");
            return false;
          }
          return expectedSection === $route.routes[editMe].section
        }
      }
    };
  });
