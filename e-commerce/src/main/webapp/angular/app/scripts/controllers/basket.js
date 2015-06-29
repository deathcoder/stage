'use strict';

/**
 * @ngdoc function
 * @name owEcommerceApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the owEcommerceApp
 */
angular.module('owBasket')
  .controller('BasketCtrl', function ($scope) {

      $scope.customs = {
        title: "Basket",
        description: "Your products"
      };
  });