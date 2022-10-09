
package com.propuesta.spm.manager;

import bo.union.lang.ServiceException;
import com.propuesta.spm.manager.data.Cuenta;
import com.propuesta.spm.manager.data.ParamValue;
import com.propuesta.spm.manager.data.Transaccion;
import java.util.List;

public interface CuentaServ {

    public List<Cuenta> listarCuenta() throws ServiceException;

    public List<ParamValue> listarCuentaSimple() throws ServiceException;

    public void crearCuenta(Cuenta value) throws ServiceException;

    public void retirar(Transaccion value) throws ServiceException;

    public void depositar(Transaccion value) throws ServiceException;

    public List<Transaccion> historico(Cuenta value) throws ServiceException;
    
    public Cuenta detalleCuenta (Cuenta value) throws ServiceException;
    
}
