var app = angular.module('app', ['ngResource']);

app.config(['$resourceProvider', function ($resourceProvider) {
    // Don't strip trailing slashes from calculated URLs
    $resourceProvider.defaults.stripTrailingSlashes = false;
}]);

app.service('Users', ['$resource', function ($resource) {
    return $resource('/api/v1/users/:id', null,
        {
            'update': {method: 'PUT'},
            'query': {
                method: 'GET',
                transformResponse: function (data, headers) {
                    var json = JSON.parse(data);
                    if (json._embedded) {
                        return json._embedded;
                    }
                    return data;
                }
            }
        });
}]);