'use strict';

/**
 * @ngdoc function
 * @name owEcommerceApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the owEcommerceApp
 */
angular.module('owProduct')
  .controller('ProductsCtrl', function ($scope, Products) {
    Products.get(function (response) {
      $scope.products = response;
    });
  });
