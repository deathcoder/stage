'use strict';

angular
/**
 * @ngdoc overview
 * @name owEcommerceApp
 * @description
 * # owEcommerceApp
 *
 * Main module of the application.
 */
    .module('owProduct', [
    'ngAnimate',
    'ngAria',
    'ngCookies',
    'ngMessages',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'owCustomFilter'
  ]);

angular.
    module('owBasket', ['owProduct']);
angular
  .module('owEcommerceApp', [
    'owBasket'
  ])
  .config(function ($routeProvider, $httpProvider) {

/*
    $httpProvider.defaults.xsrfHeaderName = 'X-CSRF-TOKEN';
    $httpProvider.defaults.xsrfCookieName = 'csrftoken';
*/

    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
      })
      .when('/products', {
        templateUrl: 'views/products.html',
        controller: 'ProductCtrl',
        section: 'products'
      })
      .when('/orders', {
        templateUrl: 'views/orders.html',
        controller: 'OrdersCtrl',
        section: 'orders'
      })
      .when('/profile', {
        templateUrl: 'views/profile.html',
        controller: 'ProfileCtrl',
        section: 'profile'
      })
      .when('/product/:id', {
        templateUrl: 'views/product.html',
        controller: 'ProductCtrl',
        section: 'products'
      })
        .when('/basket', {
          templateUrl: 'views/products.html',
          controller: 'BasketCtrl',
          section: 'products'
        })
      .otherwise({
        redirectTo: '/'
      });
  });

var debug = false;
var mylog = function (message) {
  if(debug) {
    console.log(message);
  }
};
