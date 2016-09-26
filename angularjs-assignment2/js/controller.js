/*Getting the app for the whole page*/
var customerPage = angular.module("customer", ['ui.bootstrap']);

/*Controller for the customer cards*/
customerPage.controller("cardCtrl", function($window, $scope, $modal, $http, getCustomerDetails) {

    /*To load the customer details from the rest services*/
    $scope.loadDetails = function() {
        var url="http://localhost:8080/AngularJSProject/resource/customer/getCustomers";
        /*Getting response from REST services*/
        $http.get(url).then(function(response) {
            $scope.customerList = response.data.customer;
        });
    }
    
    /*To open the modal for editing the details*/
    $scope.editDetails = function(customer) {
        /*Calling factory services to store the data*/
        getCustomerDetails.setCustomer(customer);
        /*Open up the modal*/
        $scope.showModal();
    }

    /*To open the modal dialog box*/
    $scope.showModal = function() {

        /*Setting the modal options*/
        $scope.opts = {
            backdrop: true,
            backdropClick: true,
            dialogFade: false,
            keyboard: true,
            templateUrl : 'editForm.html',
            controller : ModalInstanceCtrl,
            resolve: {}
        };

        /*Setting up the data for the modal*/
        $scope.opts.resolve.item = function() {
            return angular.copy({customer:getCustomerDetails.getCustomer()});
        }

        /*Opening up the modal*/
        var modalInstance = $modal.open($scope.opts);
    }

    /*To delete a certain record*/
    $scope.deleteRecord = function(id) {
        var url="http://localhost:8080/AngularJSProject/resource/customer/deleteCustomer?id="+id;
        console.log(url);
        $http.get(url).then(function(response) {
            $window.location.reload();
        });
    }
});

/*Controller for the modal operations*/
var ModalInstanceCtrl = function($window, $scope, $modalInstance, $http, $modal, item, getCustomerDetails) {
    
    /*Checking if the modal is for edit or create*/
    if(item.customer != null) {
        item.customer.numberOfOrders = parseInt(item.customer.numberOfOrders, 10);
        $scope.customer = item.customer;
    } else {
        $scope.customer = {};
    }

    /*To dismiss or close the modal*/
    $scope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };

    /*To submit the form*/
    $scope.submitForm = function() {
        $http({
            method : 'POST',
            url : 'http://localhost:8080/AngularJSProject/resource/customer/insertCustomer',
            data : $scope.customer,
            headers : {'Content-Type': 'application/json'}
        }).success(function(data) {
            $scope.cancel();
            $window.location.reload();
        });
    }
}

/*Controller for the whole application*/
customerPage.controller("appCtrl", function($scope, $modal) {
    $scope.changeView = function(event) {
        if(event.target.id === 'grid' ) {
            $('.card').removeClass('col-lg-12');
            $('.card').addClass('col-lg-3');
        } else {
            $('.card').removeClass('col-lg-3');
            $('.card').addClass('col-lg-12');
        }
    }
    
    /*Open the modal for creating the customer*/
    $scope.showModal = function() {
        
        /*Setting the modal options*/
        $scope.opts = {
            backdrop: true,
            backdropClick: true,
            dialogFade: false,
            keyboard: true,
            templateUrl : 'editForm.html',
            controller : ModalInstanceCtrl,
            resolve: {}
        };

         /*Setting up the data for the modal*/
        $scope.opts.resolve.item = function() {
            return angular.copy({customer:null});
        }

        /*Opening up the modal*/
        var modalInstance = $modal.open($scope.opts);
    }
});
