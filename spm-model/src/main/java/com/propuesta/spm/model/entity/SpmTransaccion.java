
package com.propuesta.spm.model.entity;

import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * @author sipaco
 */
@Entity
@Table(name = "SPM_TRANSACCION")
@Cacheable(false)
public class SpmTransaccion implements Serializable {

    @Id
    @GeneratedValue(generator = "SPM_SEC_TRANSACCION", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SPM_SEC_TRANSACCION", sequenceName = "SPM_SEC_TRANSACCION")
    @Column(name = "ID_TRANSACCION")
    private Long idTransaccion;
    @Basic
    @Column(name = "MONTO")
    private Long monto;
    @Basic
    @Column(name = "MONEDA")
    private String moneda;
    @Basic
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic
    @Column(name = "TIPO_TRANSACCION")
    private String tipoTransaccion;
    @ManyToOne
    @JoinColumn(name = "ID_CUENTA")
    private SpmCuenta spmCuenta;

    public Long getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(Long idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Long getMonto() {
        return monto;
    }

    public void setMonto(Long monto) {
        this.monto = monto;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public SpmCuenta getSpmCuenta() {
        return spmCuenta;
    }

    public void setSpmCuenta(SpmCuenta spmCuenta) {
        this.spmCuenta = spmCuenta;
    }

}