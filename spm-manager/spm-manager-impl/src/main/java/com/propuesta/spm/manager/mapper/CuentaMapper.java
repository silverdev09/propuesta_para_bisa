
package com.propuesta.spm.manager.mapper;

import com.propuesta.spm.manager.data.Cuenta;
import com.propuesta.spm.model.entity.SpmCuenta;
import java.util.ArrayList;
import java.util.List;

public final class CuentaMapper {

    private static void mapperToSpmCuenta(Cuenta from, SpmCuenta to) {
        to.setIdCuenta(from.getIdCuenta());
        to.setTitular(from.getTitular());
        to.setSaldo(from.getSaldo());
        to.setNumeroCuenta(from.getNumeroCuenta());
        to.setMoneda(from.getMoneda());
        to.setEstado(from.getEstado());
        to.setRetiroMontoSuperior(from.getRetiroMontoSuperior());
    }

    private static void mapperToCuenta(SpmCuenta from, Cuenta to) {
        to.setIdCuenta(from.getIdCuenta());
        to.setTitular(from.getTitular());
        to.setSaldo(from.getSaldo());
        to.setNumeroCuenta(from.getNumeroCuenta());
        to.setMoneda(from.getMoneda());
        to.setEstado(from.getEstado());
        to.setRetiroMontoSuperior(from.getRetiroMontoSuperior());
    }

    public static Cuenta mapperToCuenta(SpmCuenta from) {
        if (from == null) {
            return null;
        }
        Cuenta to = new Cuenta();
        mapperToCuenta(from, to);
        return to;
    }

    public static List<SpmCuenta> mapperToSpmCuentaList(List<Cuenta> fromList) {
        if (fromList == null) {
            return null;
        }
        List<SpmCuenta> toList = new ArrayList();
        fromList.stream().forEach(from -> {
            SpmCuenta to = mapperToSpmCuenta(from);
            toList.add(to);
        });
        return toList;
    }

    public static SpmCuenta mapperToSpmCuenta(Cuenta from) {
        if (from == null) {
            return null;
        }
        SpmCuenta to = new SpmCuenta();
        mapperToSpmCuenta(from, to);
        return to;
    }

    public static List<Cuenta> mapperToCuentaList(List<SpmCuenta> fromList) {
        if (fromList == null) {
            return null;
        }
        List<Cuenta> toList = new ArrayList();
        fromList.stream().forEach(from -> {
            Cuenta to = mapperToCuenta(from);
            toList.add(to);
        });
        return toList;
    }
}
