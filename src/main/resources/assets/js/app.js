/**
 * Created by andrej on 3/5/14.
 */
'use strict';
var app = angular.module('myApp',['ngRoute','shop.services','shop.controllers']);


app.config(['$routeProvider', function ($routeProvider) {
	$routeProvider.when('/user-list', {templateUrl: 'partials/user-list.html',controller: 'UserListController'})
				  .when('/user-detail/:id', {templateUrl: 'partials/user-detail.html',controller: 'UserDetailController'})
				  .when('/user-creation', {templateUrl: 'partials/user-creation.html', controller: 'UserCreationController'})
				  .otherwise({redirectTo: '/user-list'});
}]);
