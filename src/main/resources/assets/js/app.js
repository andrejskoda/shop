/**
 * Created by andrej on 3/5/14.
 */
'use strict';
var app = angular.module('myApp',['ngRoute']);


app.config(['$routeProvider', function ($routeProvider) {
	$routeProvider.
		when('/list', {
    		templateUrl: 'list/layout.html',
    		controller: PersonController
    	}).otherwise({
    		redirectTo: '/list'
    	});
}]);
