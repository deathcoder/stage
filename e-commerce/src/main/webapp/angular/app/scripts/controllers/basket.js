'use strict';

/**
 * @ngdoc function
 * @name owEcommerceApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the owEcommerceApp
 */
angular.module('owBasket')
  .controller('BasketCtrl', function ($scope, ProductService, $location) {
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

        $scope.isInBasket = function () {
            console.log("is in basket true");
            return true;
        };

        $scope.updateBasket = function(product) {
            console.log(product);
            ProductService.basket.update({}, product, function (success) {
                console.log("success", success);
                $location.path("/basket");
            });
        }
  });