package com.uce.ordenes.Logica;

import com.uce.ordenes.Datos.Orden;
import com.uce.ordenes.Datos.OrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdenService {

    @Autowired
    private OrdenRepository ordenRepository;

    public List<Orden> obtenerOrdenes() {
        return ordenRepository.findAll();
    }

    public Orden crearOrden(Orden orden) {
        return ordenRepository.save(orden);
    }
}