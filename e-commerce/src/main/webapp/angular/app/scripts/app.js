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
        'ngRoute',
        'owCustomFilter',
        'owBasket'
    ])
    .config(function ($routeProvider, $httpProvider) {

        /* csrf config for spring security */
        $httpProvider.defaults.xsrfHeaderName = 'X-CSRF-TOKEN';
        $httpProvider.defaults.xsrfCookieName = 'XSRF-TOKEN';

        /** The custom "X-Requested-With" is a conventional header sent by browser clients,
         * and it used to be the default in Angular but they took it out in 1.3.0.
         * Spring Security responds to it by not sending a "WWW-Authenticate" header in a 401 response,
         * and thus the browser will not pop up an authentication dialog
         * (which is desirable in our app since we want to control the authentication).
         */
        $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';

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
                section: 'basket'
            })
            .when('/login', {
                templateUrl: 'views/login.html',
                controller: 'LoginCtrl',
                section: 'login'
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
