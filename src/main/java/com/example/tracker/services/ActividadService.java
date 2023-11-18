package com.example.tracker.services;

import com.example.tracker.entity.Actividad;

import java.util.List;
import java.util.Optional;

public interface ActividadService {
    List<Actividad> listar();

    Optional<Actividad> porId(Long id);

    Actividad guardar(Actividad usuario);

    void eliminar(Long id);
}
