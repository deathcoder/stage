'use strict';

/**
 * @ngdoc function
 * @name owEcommerceApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the owEcommerceApp
 */
angular.module('owProduct')
  .factory('ProductService', function ($resource) {
      var prefix = "/spring/api";
      return {
          products: $resource(prefix + "/products", {}, {}),
          product: $resource(prefix + "/product/:id", {}, {})
      };
  });
