
var app = angular.module('myApp', ['ngGrid', 'angular-loading-bar', 'ui.router']);

app.config(function($stateProvider, $urlRouterProvider) {

//    $urlRouterProvider.otherwise("/test")

    $stateProvider
        // HOME STATES AND NESTED VIEWS ========================================
        .state('new', {
            url: '/create.html',
            templateUrl : '/clients/create.html',
            controller  : 'ClientController'
        })
        .state('list', {
            url: '/list.html',
            templateUrl : '/clients/list.html',
            controller  : 'ClientController'
        });
});

app.controller('ClientController', function ($scope,
                                             $http) {

    $scope.pagingOptions = {
        pageSizes: [5, 10, 20],
        pageSize: 5,
        currentPage: 1
    };

    $scope.totalServerItems = 0;

    $scope.filterOptions = {
        filterText: "",
        useExternalFilter: true
    };

    $scope.setPagingData = function(data, page, pageSize){
        var pagedData = data.slice((page - 1) * pageSize, page * pageSize);
        $scope.myData = pagedData;
        $scope.totalServerItems = data.length;
        if (!$scope.$$phase) {
            $scope.$apply();
        }
    };
    $scope.getPagedDataAsync = function (pageSize, page, searchText) {
        setTimeout(function () {
            var data;
            if (searchText) {
                var ft = searchText.toLowerCase();
                $http.get('/clients/list.json/'+page+'/'+pageSize ).success(function (largeLoad) {
                    data = largeLoad.filter(function(item) {
                        return JSON.stringify(item).toLowerCase().indexOf(ft) != -1;
                    });
                    $scope.setPagingData(data,page,pageSize);
                });
            } else {
                $http.get('/clients/list.json/'+page+'/'+pageSize).success(function (largeLoad) {
                    $scope.setPagingData(largeLoad,page,pageSize);
                });
            }
        }, 100);
    };

    $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage);

    $scope.$watch('pagingOptions', function (newVal, oldVal) {
        if (newVal !== oldVal && newVal.currentPage !== oldVal.currentPage) {
            $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage, $scope.filterOptions.filterText);
        }
    }, true);
    $scope.$watch('filterOptions', function (newVal, oldVal) {
        if (newVal !== oldVal) {
            $scope.getPagedDataAsync($scope.pagingOptions.pageSize, $scope.pagingOptions.currentPage, $scope.filterOptions.filterText);
        }
    }, true);

    $scope.gridOptions = {
        data: 'myData',
        enablePaging: true,
        showFooter: true,
        totalServerItems: 'totalServerItems',
        pagingOptions: $scope.pagingOptions,
        filterOptions: $scope.filterOptions,
        showSelectionCheckbox: true,
        showFilter: false,
        showColumnMenu: false,
        jqueryUITheme: false,
        showGroupPanel: false,
        columnDefs: [
            {field: 'ean', displayName: 'Код', enableCellEdit: false},
            {field:'name', displayName:'Название', enableCellEdit: true},
            {field:'description', displayName:'Описание', enableCellEdit: true},
            {field:'', displayName:'', enableCellEdit: true,
            cellTemplate: '<button onclick="alert(\"Hello world\")" >Save</button>'}
        ]
    };
});