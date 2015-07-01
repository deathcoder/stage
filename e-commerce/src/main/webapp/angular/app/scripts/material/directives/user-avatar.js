'use strict';

angular.module('owMain')
    .directive('userAvatar', function() {
      return {
        replace: true,
        templateUrl: 'views/material/directives/user-avatar.html'
      };
    });