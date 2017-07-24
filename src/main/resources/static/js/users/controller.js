app.controller('UserController', ['$scope', 'Users',
    function ($scope, Users) {

        var message = function (success, failure) {
            $scope.message = success || '';
            $scope.errorMessage = failure || '';
        };

        $scope.getAllUsers = function () {
            $scope.users = Users.query();
            $scope.user = Users.get({id: 1});
        };

        $scope.getUser = function (user) {
            $scope.user = Users.get({id: user.id});
        };

        $scope.getAllUsers();

    }]);