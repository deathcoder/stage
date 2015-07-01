'use strict';

var app = angular.module('StarterApp', [
    'ngMaterial',
    'ngMdIcons',
    'ngRoute',
    'owProduct',
    'owCustomFilter'])

    .config(function ($routeProvider, $mdThemingProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'views/material/products.html',
                controller: 'ProductCtrl'
            })
            .when('/product/:id', {
                templateUrl: 'views/product.html',
                controller: 'ProductCtrl'
            })
            .otherwise({
                redirectTo: '/'
            });
    });

app.controller('AppCtrl', ['$scope', '$mdBottomSheet','$mdSidenav', '$mdDialog', function($scope, $mdBottomSheet, $mdSidenav){
    $scope.toggleSidenav = function(menuId) {
        $mdSidenav(menuId).toggle();
    };
    $scope.menu = [
        {
            link : '',
            title: 'Dashboard',
            icon: 'dashboard'
        },
        {
            link : '',
            title: 'Products',
            icon: 'group'
        },
        {
            link : '',
            title: 'Basket',
            icon: 'shopping_cart'
        }
    ];
    $scope.admin = [
        {
            link : '',
            title: 'Trash',
            icon: 'delete'
        }
    ];
    $scope.activity = [
        {
            what: 'Brunch this weekend?',
            who: 'Ali Conners',
            when: '3:08PM',
            notes: " I'll be in your neighborhood doing errands"
        },
        {
            what: 'Summer BBQ',
            who: 'to Alex, Scott, Jennifer',
            when: '3:08PM',
            notes: "Wish I could come out but I'm out of town this weekend"
        },
        {
            what: 'Oui Oui',
            who: 'Sandra Adams',
            when: '3:08PM',
            notes: "Do you have Paris recommendations? Have you ever been?"
        },
        {
            what: 'Birthday Gift',
            who: 'Trevor Hansen',
            when: '3:08PM',
            notes: "Have any ideas of what we should get Heidi for her birthday?"
        },
        {
            what: 'Recipe to try',
            who: 'Brian Holt',
            when: '3:08PM',
            notes: "We should eat this: Grapefruit, Squash, Corn, and Tomatillo tacos"
        },
    ];
}]);

app.directive('userAvatar', function() {
    return {
        replace: true,
        templateUrl: "views/material/directives/user-avatar.html"
    };
});
