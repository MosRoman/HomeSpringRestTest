/**
 * Created by Рома on 31.07.2018.
 */
var app = angular.module("PetsManagement", []);

// Controller Part
app.controller("PetsController", function($scope, $http) {


    $scope.employees = [];
    $scope.pets = {
        // Id: -1,
        name: "",
        color: ""
    };

    // Now load the data from server
    _refreshEmployeeData();

    // HTTP POST/PUT methods for add/edit employee
    // Call: http://localhost:8080/employee
    $scope.submitEmployee = function() {

        var method = "POST";
        var url = "/addPets";

        // var method = "";
        // var url = "";
        //
        // if ($scope.pets.Id == -1) {
        //     method = "POST";
        //     url = '/addPets';
        // } else {
        //     method = "PUT";
        //     url = '/employee';
        // }
        $http({
            method: method,
            url: url,
            data: angular.toJson($scope.pets),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

    $scope.createEmployee = function() {
        _clearFormData();
    }

    // HTTP DELETE- delete employee by Id
    // Call: http://localhost:8080/employee/{empId}
    $scope.deleteEmployee = function(employee) {
        $http({
            method: 'DELETE',
            url: '/employee/' + employee.empId
        }).then(_success, _error);
    };

    // In case of edit
    $scope.editEmployee = function(pets) {
        // $scope.employeeForm.empId = employee.empId;
        $scope.pets.name = pets.name;
        $scope.pets.color = pets.color;
    };

    // Private Method
    // HTTP GET- get all employees collection
    // Call: http://localhost:8080/employees
    function _refreshEmployeeData() {
        $http({
            method: 'GET',
            url: '/readPets'
        }).then(
            function(res) { // success
                $scope.pets = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }

    function _success(res) {
        _refreshEmployeeData();
        _clearFormData();
    }

    function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }

    // Clear the form
    function _clearFormData() {
        // $scope.pets.Id = -1;
        $scope.pets.name = "";
        $scope.pets.color = ""
    };
});
