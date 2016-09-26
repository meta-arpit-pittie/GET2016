var phonecat = angular.module('phonecat',[]);

phonecat.controller('descriptionCtrl', function($scope, $http) {
    $http.get('phones.json').then(function(response) {
        $scope.mobileDescription = response.data;
    });
});
