
package com.propuesta.spm.manager.local;

import bo.union.lang.ServiceException;
import com.propuesta.spm.manager.local.utils.Config;
import com.propuesta.spm.model.entity.SpmCuenta;
import com.propuesta.spm.model.entity.SpmTransaccion;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@LocalBean
public class CuentaLocal {

    public static final String OBJECT_NAME = "Cuenta";
    public static final String OBJECT_ID = "Id de " + OBJECT_NAME;
    @PersistenceContext(unitName = Config.UNIT_NAME_MNG)
    private EntityManager em;

    public List<SpmCuenta> listaCuenta() throws ServiceException {
        List<SpmCuenta> list = new ArrayList<>();
        Query q = em.createQuery("SELECT o FROM SpmCuenta o");
        list = q.getResultList();
        return list;
    }

    public SpmCuenta buscarCuenta(Long idCuenta) {
        return em.find(SpmCuenta.class, idCuenta);
    }

    public SpmCuenta crearCuenta(SpmCuenta value) {
        value.setSaldo(0L);
        value.setEstado("ACTIVE");
        value.setRetiroMontoSuperior("NO");
        em.persist(value);
        return value;
    }
    public SpmCuenta actualizaCuenta(SpmCuenta value) {
        em.merge(value);
        return value;
    }

    public SpmTransaccion crearTransaccion(SpmTransaccion value) {
        em.persist(value);
        return value;
    }
    
    public List<SpmTransaccion> listaTransaccion (Long idCuenta) {
        List<SpmTransaccion> list = new ArrayList<>();
        Query q = em.createQuery("SELECT o FROM SpmTransaccion o WHERE o.spmCuenta.idCuenta = :idCuenta").setParameter("idCuenta", idCuenta);
        list = q.getResultList();
        return list;
    }

}
