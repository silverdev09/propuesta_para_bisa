
package com.propuesta.spm.manager.mapper;

import com.propuesta.spm.manager.data.Transaccion;
import com.propuesta.spm.model.entity.SpmTransaccion;
import java.util.ArrayList;
import java.util.List;

public final class TransaccionMapper {

    private static void mapperToSpmTransaccion(Transaccion from, SpmTransaccion to) {
        to.setIdTransaccion(from.getIdTransaccion());
        to.setFecha(from.getFecha());
        to.setTipoTransaccion(from.getTipoTransaccion());
        to.setMonto(from.getMonto());
        to.setMoneda(from.getMoneda());
    }

    private static void mapperToTransaccion(SpmTransaccion from, Transaccion to) {
        to.setIdTransaccion(from.getIdTransaccion());
        to.setFecha(from.getFecha());
        to.setTipoTransaccion(from.getTipoTransaccion());
        to.setMonto(from.getMonto());
        to.setMoneda(from.getMoneda());
    }

    public static Transaccion mapperToTransaccion(SpmTransaccion from) {
        if (from == null) {
            return null;
        }
        Transaccion to = new Transaccion();
        mapperToTransaccion(from, to);
        return to;
    }

    public static List<SpmTransaccion> mapperToSpmTransaccionList(List<Transaccion> fromList) {
        if (fromList == null) {
            return null;
        }
        List<SpmTransaccion> toList = new ArrayList();
        fromList.stream().forEach(from -> {
            SpmTransaccion to = mapperToSpmTransaccion(from);
            toList.add(to);
        });
        return toList;
    }

    public static SpmTransaccion mapperToSpmTransaccion(Transaccion from) {
        if (from == null) {
            return null;
        }
        SpmTransaccion to = new SpmTransaccion();
        mapperToSpmTransaccion(from, to);
        return to;
    }

    public static List<Transaccion> mapperToTransaccionList(List<SpmTransaccion> fromList) {
        if (fromList == null) {
            return null;
        }
        List<Transaccion> toList = new ArrayList();
        fromList.stream().forEach(from -> {
            Transaccion to = mapperToTransaccion(from);
            toList.add(to);
        });
        return toList;
    }
}
