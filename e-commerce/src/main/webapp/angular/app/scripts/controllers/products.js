'use strict';

/**
 * @ngdoc function
 * @name owEcommerceApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the owEcommerceApp
 */
angular.module('owProduct')
  .controller('ProductCtrl', function ($scope, ProductService, $routeParams) {

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

      $scope.getProduct = function() {
        ProductService.product.get({id:$routeParams.id}, function(response){
          $scope.products = response;
          console.log("prodotto", response);
        })
      }
});
