'use strict';

/**
 * @ngdoc function
 * @name owEcommerceApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the owEcommerceApp
 */
angular.module('owBasket')
  .controller('BasketCtrl', function ($scope, ProductService) {
        $scope.customs = {
            title: "Basket",
            description: "Your products"
        };

        $scope.initProducts = function(){
            getBasketProducts();
        };

        var getBasketProducts = function () {
            ProductService.basket.query(function (response) {
                $scope.products = response;
            });
        };
  });