
package com.propuesta.spm.model.entity;

import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author sipaco
 */
@Entity
@Table(name = "SPM_CUENTA")
@Cacheable(false)
public class SpmCuenta implements Serializable {

    @Id
    @GeneratedValue(generator = "SPM_SEC_CUENTA", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SPM_SEC_CUENTA", sequenceName = "SPM_SEC_CUENTA")
    @Column(name = "ID_CUENTA")
    private Long idCuenta;
    @Basic
    @Column(name = "TITULAR")
    private String titular;
    @Basic
    @Column(name = "NUMERO_CUENTA")
    private String numeroCuenta;
    @Basic
    @Column(name = "SALDO")
    private Long saldo;
    @Basic
    @Column(name = "MONEDA")
    private String moneda;
    @Basic
    @Column(name = "ESTADO")
    private String estado;
    @Basic
    @Column(name = "RETIRO_MONTO_SUPERIOR")
    private String retiroMontoSuperior;

    public Long getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Long idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Long getSaldo() {
        return saldo;
    }

    public void setSaldo(Long saldo) {
        this.saldo = saldo;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRetiroMontoSuperior() {
        return retiroMontoSuperior;
    }

    public void setRetiroMontoSuperior(String retiroMontoSuperior) {
        this.retiroMontoSuperior = retiroMontoSuperior;
    }

}
