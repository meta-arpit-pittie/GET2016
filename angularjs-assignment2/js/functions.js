/*Factory service to inject the customer details*/
customerPage.factory('getCustomerDetails', function($http, $q) {
    var customerFucntions = {};
    var customer = [];

    /*Setting the customer details(Pushing the customer details)*/
    customerFucntions.setCustomer = function(data) {
        customer.push(data);
    }

    /*Getting the customer details*/
    customerFucntions.getCustomer = function() {
        return customer.pop();
    }
    return customerFucntions;
});
