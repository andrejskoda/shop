/**
 * Created by andrej on 3/5/14.
 */
var app = angular.module('myApp',[]);
app.controller('FirstController', function($scope){
    $scope.counter = 0;
    $scope.add = function(amount){$scope.counter += amount;};
    $scope.subtract = function(amount){$scope.counter -= amount;};
});