
package com.propuesta.spm.manager;

import bo.union.lang.ServiceException;
import com.propuesta.spm.manager.data.Cuenta;
import com.propuesta.spm.manager.data.ParamValue;
import com.propuesta.spm.manager.data.Transaccion;
import com.propuesta.spm.manager.local.CuentaLocal;
import com.propuesta.spm.manager.mapper.CuentaMapper;
import com.propuesta.spm.manager.mapper.TransaccionMapper;
import com.propuesta.spm.manager.utils.Fecha;
import com.propuesta.spm.model.entity.SpmCuenta;
import com.propuesta.spm.model.entity.SpmTransaccion;
import java.util.ArrayList;
import javax.ejb.*;

import java.util.List;
import java.util.logging.Logger;

@Stateless
@Local(CuentaServ.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class CuentaImpl implements CuentaServ {

    @EJB
    private CuentaLocal local;
    private static String STATE_ACTIVE = "ACTIVE";
    private static String STATE_HOLD = "HOLD";
    private static String RETIRO_MONTO_SUPERIOR_SALDO_NO = "NO";
    private static String RETIRO_MONTO_SUPERIOR_SALDO_SI = "SI";
    private static String TRANSACCION_EXITOSA = "Transacción realizada con éxito.";
    private static String MONDEDA_DIFERENTE = "La moneda de la operación es diferente a la moneda de la cuenta";
    private static String TRX_DEPOSITO = "DEPOSITO";
    private static String TRX_RETIRO = "RETIRO";

    @Override
    public List<Cuenta> listarCuenta() throws ServiceException {
        List<SpmCuenta> list = local.listaCuenta();
        return CuentaMapper.mapperToCuentaList(list);
    }

    public List<ParamValue> listarCuentaSimple() throws ServiceException {
        List<SpmCuenta> list = local.listaCuenta();
        List<ParamValue> result = new ArrayList<>();
        for (SpmCuenta c : list) {
            ParamValue p = new ParamValue();
            p.setValue(c.getIdCuenta());
            p.setDescription(c.getNumeroCuenta());
            result.add(p);
        }
        return result;
    }

    @Override
    public void crearCuenta(Cuenta value) throws ServiceException {
        SpmCuenta entity = CuentaMapper.mapperToSpmCuenta(value);
        local.crearCuenta(entity);
    }

    @Override
    public void retirar(Transaccion value) throws ServiceException {
        SpmCuenta cuenta = local.buscarCuenta(value.getIdCuenta());
        if (value.getMoneda().equals(cuenta.getMoneda())) {
            if (value.getMonto() > cuenta.getSaldo() && RETIRO_MONTO_SUPERIOR_SALDO_NO.equals(cuenta.getRetiroMontoSuperior())) {
                cuenta.setEstado(STATE_HOLD);
                cuenta.setRetiroMontoSuperior(RETIRO_MONTO_SUPERIOR_SALDO_SI);
                cuenta.setSaldo(cuenta.getSaldo() - value.getMonto());
                local.actualizaCuenta(cuenta);
                SpmTransaccion entity = TransaccionMapper.mapperToSpmTransaccion(value);
                entity.setSpmCuenta(cuenta);
                entity.setFecha(Fecha.fechaActual());
                entity.setTipoTransaccion(TRX_RETIRO);
                local.crearTransaccion(entity);
                Logger.getLogger(TRANSACCION_EXITOSA);
            } else {
                Logger.getLogger("Ya no se puede realizar retiros con monto mayor al saldo.");
            }
            if (STATE_HOLD.equals(cuenta.getEstado())) {
                Logger.getLogger("La cuenta esta en estado " + STATE_HOLD + " no puede retirar.");
            } else {
                if (value.getMonto() > cuenta.getSaldo() && RETIRO_MONTO_SUPERIOR_SALDO_SI.equals(cuenta.getRetiroMontoSuperior())) {
                    Logger.getLogger("Ya no se puede realizar retiros con monto mayor al saldo.");
                } else {
                    cuenta.setSaldo(cuenta.getSaldo() - value.getMonto());
                    local.actualizaCuenta(cuenta);
                    SpmTransaccion entity = TransaccionMapper.mapperToSpmTransaccion(value);
                    entity.setSpmCuenta(cuenta);
                    entity.setFecha(Fecha.fechaActual());
                    entity.setTipoTransaccion(TRX_RETIRO);
                    local.crearTransaccion(entity);
                    Logger.getLogger(TRANSACCION_EXITOSA);
                }
            }
        } else {
            Logger.getLogger(MONDEDA_DIFERENTE);
        }
    }

    @Override
    public void depositar(Transaccion value) throws ServiceException {
        SpmCuenta cuenta = local.buscarCuenta(value.getIdCuenta());
        if (value.getMoneda().equals(cuenta.getMoneda())) {
            if (STATE_HOLD.equals(cuenta.getEstado()) && value.getMonto() >= cuenta.getSaldo()) {
                cuenta.setEstado(STATE_ACTIVE);
            }
            cuenta.setSaldo(cuenta.getSaldo() + value.getMonto());
            local.actualizaCuenta(cuenta);
            SpmTransaccion entity = TransaccionMapper.mapperToSpmTransaccion(value);
            entity.setSpmCuenta(cuenta);
            entity.setFecha(Fecha.fechaActual());
            entity.setTipoTransaccion(TRX_DEPOSITO);
            local.crearTransaccion(entity);
            Logger.getLogger(TRANSACCION_EXITOSA);
        } else {
            Logger.getLogger(MONDEDA_DIFERENTE);
        }
    }

    @Override
    public List<Transaccion> historico(Cuenta value) throws ServiceException {
        return TransaccionMapper.mapperToTransaccionList(local.listaTransaccion(value.getIdCuenta()));
    }

    @Override
    public Cuenta detalleCuenta(Cuenta value) throws ServiceException {
        return CuentaMapper.mapperToCuenta(local.buscarCuenta(value.getIdCuenta()));
    }

}
