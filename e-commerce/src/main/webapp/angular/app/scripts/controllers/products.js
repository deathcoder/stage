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
        $scope.getProducts();
      };

      $scope.initProduct= function(){
        $scope.getProduct();
      };

      $scope.getProducts = function () {
        ProductService.products.query(function (response) {
          $scope.products = response;
        });
      };

      $scope.getProduct = function () {
        ProductService.product.get({id: $routeParams.id}, function (response) {
          $scope.product = response;
          console.log("prodotto", response);
        })
      };

      $scope.addToBasket = function() {
          /*ProductService.basket.save({}, $scope.product);*/
          ProductService.test.save({}, $scope.product);
        $location.path("/basket");
      };

      $scope.customs = {
          title: "Product List",
          description: "Full product list"
      };
    });
