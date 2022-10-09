
package com.propuesta.spm.manager.data;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author spm
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Cuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @XmlElement
    private Long idCuenta;
    @XmlElement
    private String titular;
    @XmlElement
    private Long saldo;
    @XmlElement
    private String numeroCuenta;
    @XmlElement
    private String moneda;
    @XmlElement
    private String estado;
    @XmlElement
    private String retiroMontoSuperior;
    @XmlElement
    private List<Transaccion> listTransaccion;

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

    public Long getSaldo() {
        return saldo;
    }

    public void setSaldo(Long saldo) {
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
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

    public List<Transaccion> getListTransaccion() {
        return listTransaccion;
    }

    public void setListTransaccion(List<Transaccion> listTransaccion) {
        this.listTransaccion = listTransaccion;
    }

}
