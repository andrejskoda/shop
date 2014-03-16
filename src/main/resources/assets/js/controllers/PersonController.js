'use strict';

/**
 * PersonController
 * @constructor
 */
var PersonController = function($scope, $http) {

    $scope.filteredPeople = [];
    $scope.people = [];
    $scope.currentPage = 1;
    $scope.numPerPage = 5;
    $scope.maxSize = 5;
    $scope.viewMode = false;

    $scope.fetchArticlesList = function() {
        $http.get('/people').success(function(peopleList){
            $scope.people = peopleList;
            $scope.filteredPeople = $scope.people.slice(0, $scope.numPerPage);

        });
    }

    $scope.viewPerson = function(selectedPerson) {
        $scope.resetError();
        $scope.viewMode = true;
        $http.get('/people/' + selectedPerson.id).success(function(person){
            $scope.person = person;
        });
    }

    $scope.numPages = function () {
        return Math.ceil($scope.people.length / $scope.numPerPage);
    };

    $scope.$watch('currentPage + numPerPage', function() {
        var begin = (($scope.currentPage - 1) * $scope.numPerPage)
        , end = begin + $scope.numPerPage;

        $scope.filteredPeople = $scope.people.slice(begin, end);
    }); 

    $scope.resetError = function() {
        $scope.error = false;
        $scope.errorMessage = '';
    }

    $scope.setError = function(message) {
        $scope.error = true;
        $scope.errorMessage = message;
    }

    $scope.fetchArticlesList();
    $scope.predicate = 'id';
}