'use strict';

var services = angular.module('shop.services',['ngResource']);

services.factory('UsersFactory', function ($resource) {
	return $resource('/people',{}, {
		query: 	{method: 'GET', isArray: true},
		create:	{method: 'POST'}
	})
});

services.factory('UserFactory', function ($resource) {
	return $resource('/people/:id',{}, {
		show: 	{method: 'GET'},
		update: {method: 'POST', 	params: {id: '@id'}},
		delete:	{method: 'DELETE', 	params: {id: '@id'}}
	})
});