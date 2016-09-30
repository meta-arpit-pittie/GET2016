/* The controller for getting the car list */
listOfCars.controller('carList', function($scope, $http) {

    /* For getting the list of cars available */
    $scope.loadCars = function(){
        $http({method: 'GET', url: 'pages/carlist'}).then(function(response) {
            if (response.status === 200) {
                $scope.cars = response.data.data;
            }
        });
    }
});

/* Controller for getting the car details */
carDetails.controller('details', function($scope, $http) {

    /* For loading the car details */
    $scope.getCarDetail = function(id){
        $http({method: 'GET', url: 'pages/cardetails?id='+id}).then(function(response) {
            if (response.status === 200) {
                $scope.car = response.data.data;
            }
        });
    }
});

/* Controller for the car create and edit form */
carForm.controller('formFilling', function($scope, $http) {

    /* For loading the car details */
    $scope.getCarDetail = function(id){
        if(angular.isUndefined(id)) {
            $scope.car = {};
        } else {
            $http({method: 'GET', url: 'pages/cardetails?id='+id}).then(function(response) {
                if (response.status === 200) {
                    $scope.car = response.data.data;
                }
            });
        }
    }

    /* For submitting the form data */
    $scope.submitForm = function() {
        $http({
            method : 'POST',
            url : '',
            data : $scope.customer,
            headers : {'Content-Type': 'application/json'}
        }).success(function(data) {
            $scope.cancel();
            $window.location.reload();
        });
    }
});
