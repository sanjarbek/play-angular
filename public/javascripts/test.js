var scotchApp = angular.module('scotchApp', ['ui.router']);

// configure our routes
scotchApp.config(function($stateProvider, $urlRouterProvider) {

//    $urlRouterProvider.otherwise("/test")

    $stateProvider
        // HOME STATES AND NESTED VIEWS ========================================
        .state('home', {
            url: '/home.html',
            templateUrl : '/pages/home.html',
            controller  : 'mainController'
        })
        .state('contact', {
            url: '/contact.html',
            templateUrl : '/pages/contact.html',
            controller  : 'contactController'
        })
        .state('about', {
            url: '/about.html',
            templateUrl : '/pages/about.html',
            controller  : 'aboutController'
        });
});

// create the controller and inject Angular's $scope
scotchApp.controller('mainController', function($scope) {
    // create a message to display in our view
    $scope.message = 'Everyone come and see how good I look!';
});

scotchApp.controller('aboutController', function($scope) {
    $scope.message = 'Look! I am an about page.';
});

scotchApp.controller('contactController', function($scope) {
    $scope.message = 'Contact us! JK. This is just a demo.';
});