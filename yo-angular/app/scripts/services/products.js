'use strict';

/**
 * @ngdoc function
 * @name owEcommerceApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the owEcommerceApp
 */
angular.module('owProduct')
  .factory('Products', function () {
    var products = [
      {id: 1, name: "iPhone6", price: 600, description: "iPhone 6 by Apple"},
      {id: 2, name: "Samsung Galaxy S6", price: 500, description: "Samsung Galaxy S6 by Samsung"},
      {id: 3, name: "iPhone6", price: 600, description: "iPhone 6 by Apple"}
    ];
    return {
      get: function(aFunction) {
        aFunction(products);
      }
    }
  });
