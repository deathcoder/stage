'use strict';

/**
 * @ngdoc overview
 * @name owEcommerceApp
 * @description
 * # owEcommerceApp
 *
 * Main module of the application.
 */
angular
  .module('owProduct', [
    'ngAnimate',
    'ngAria',
    'ngCookies',
    'ngMessages',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch'
  ]);
angular
  .module('owEcommerceApp', [
    'owProduct'
  ])
  .config(function ($routeProvider) {
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
      .otherwise({
        redirectTo: '/'
      });
  });
