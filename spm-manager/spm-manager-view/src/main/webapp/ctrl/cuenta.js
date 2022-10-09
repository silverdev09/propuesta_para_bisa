
__app.controller("spm$cuenta", function ($scope, $http) {
    const PATH = "manager/spm";
    $scope.view = new ViewHandler(PATH, 'cuenta', ['inbox', 'crear', 'depositar', 'retirar','consultar','historico']);
    $scope.part = new PartHandler(PATH, 'cuenta', ['depositar', 'retirar','consultar','historico']);
    var cuentaServ = new ServHandler(PATH, 'cuenta', ['crear','listar/cuenta', 'listar/cuenta/simple','retirar','depositar','historico','consultar']);
    var cuentaPanel = $scope.panel = new PanelHandler();
    var cuentaData = $scope.data = {
        filter: {},
        list: [],
        listCuentaSimple: [],
        listTransaccion :[],
        current: undefined,
        transaccion: undefined
    };
    var cuentaFilter = $scope.filter = {
        apply: function () {
            var call = $http.post(cuentaServ.listarCuenta, {});
            call.success(function (data) {
                cuentaData.list = data;
            });
            call.error(function () {
                cuentaData.list = [];
            });
        },
        clear: function () {
            cuentaData.list = [];
        }
    };
    cuentaFilter.apply();
    $scope.table = {
        toggle: function (value) {
            if (cuentaData.current && cuentaData.current.idCuenta === value.idCuenta) {
                cuentaData.current = null;
            } else {
                cuentaData.current = angular.copy(value, {});
            }
        },
        in: function (value) {
            return cuentaData.current && cuentaData.current.idCuenta === value.idCuenta;
        },
        isOneSelect: function () {
            return cuentaData.current && true;
        },
        isMoreSelect: function () {
            return cuentaData.current && true;
        }
    };
    $scope.action = {
        open: function (name) {
            if (name === 'crear') {
                cuentaData.current = {};
            }
            cuentaPanel.open(name);
        },
        cancel: function (name) {
            cuentaData.current = undefined;
            cuentaPanel.close(name);
        },
        listarCuentaSimple: function () {
            cuentaData.listCuentaSimple = [];
            var call = $http.post(cuentaServ.listarCuentaSimple, {});
            call.success(function (data) {
                cuentaData.listCuentaSimple = data;
            });
        },
        create: function () {
            var call = $http.post(cuentaServ.crear, cuentaData.current);
            call.success(function () {
                cuentaData.current = {};
                cuentaFilter.apply();
                cuentaPanel.close('crear');
            });
        },
        depositar: function () {
            var call = $http.post(cuentaServ.depositar, cuentaData.transaccion);
            call.success(function () {
                cuentaData.current = {};
                cuentaFilter.apply();
                cuentaPanel.close('depositar');
            });
        },
        retirar: function () {
            var call = $http.post(cuentaServ.retirar, cuentaData.transaccion);
            call.success(function () {
                cuentaData.current = {};
                cuentaFilter.apply();
                cuentaPanel.close('retirar');
            });
        },
        historico: function () {
            cuentaData.listTransaccion = [];
            var call = $http.post(cuentaServ.historico, cuentaData.current);
            call.success(function (data) {
                cuentaData.listTransaccion = data;
            });
        }
    };
});