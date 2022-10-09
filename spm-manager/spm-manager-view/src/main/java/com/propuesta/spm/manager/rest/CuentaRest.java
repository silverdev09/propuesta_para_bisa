
package com.propuesta.spm.manager.rest;

import bo.union.lang.ServiceException;
import com.propuesta.spm.manager.data.ParamValue;
import com.propuesta.spm.manager.data.Cuenta;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import com.propuesta.spm.manager.CuentaServ;
import com.propuesta.spm.manager.data.Transaccion;

/**
 * Administrador de cuentas
 */
@Path("cuenta")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CuentaRest {

    @EJB
    private CuentaServ serv;

    @POST
    @Path("listar/cuenta")
    public List<Cuenta> listarCuenta() throws ServiceException {
        return serv.listarCuenta();
    }

    @POST
    @Path("listar/cuenta/simple")
    public List<ParamValue> listarCuentaSimple() throws ServiceException {
        return serv.listarCuentaSimple();
    }

    @POST
    @Path("crear")
    public void crearCuenta(Cuenta value) throws ServiceException {
        serv.crearCuenta(value);
    }

    @POST
    @Path("retirar")
    public void retirar(Transaccion value) throws ServiceException {
        serv.retirar(value);
    }

    @POST
    @Path("depositar")
    public void depositar(Transaccion value) throws ServiceException {
        serv.depositar(value);
    }

    @POST
    @Path("historico")
    public List<Transaccion> historico(Cuenta value) throws ServiceException {
        return serv.historico(value);
    }

    @POST
    @Path("consultar")
    public Cuenta consultar(Cuenta value) throws ServiceException {
        return serv.detalleCuenta(value);
    }
}
