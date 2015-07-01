'use strict';

/**
 * @ngdoc function
 * @name owEcommerceApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the owEcommerceApp
 */
angular.module('owProduct')
  .controller('ProductCtrl', function ($scope, ProductService, $routeParams, $location) {

      $scope.initProducts= function(){
        getProducts();
      };

      $scope.initProduct= function(){
        getProduct();
      };

      var getProducts = function () {
        ProductService.products.query(function (response) {
          $scope.products = response;
        });
      };

      var getProduct = function () {
        ProductService.product.get({id: $routeParams.id}, function (response) {
          $scope.product = response;
          console.log("prodotto", response);
        })
      };

      $scope.addToBasket = function() {
          ProductService.basket.save({}, $scope.product, function(success) {
                  $location.path("/basket");
          }, function(error) {
              $location.path("/error");
          });
      };

      $scope.customs = {
          title: "Product List",
          description: "Full product list"
      };

        $scope.isInBasket = function () {
            console.log("is in basket false");
            return false;
        }
    });
