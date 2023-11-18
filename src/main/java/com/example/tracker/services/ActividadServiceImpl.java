package com.example.tracker.services;

import com.example.tracker.entity.Actividad;
import com.example.tracker.repositories.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ActividadServiceImpl implements ActividadService {

    private ActividadRepository actividadRepository;

    @Autowired
    public ActividadServiceImpl(ActividadRepository actividadRepository) {
        this.actividadRepository = actividadRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Actividad> listar() {
        return (List<Actividad>) actividadRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Actividad> porId(Long id) {
        return actividadRepository.findById(id);
    }

    @Override
    @Transactional
    public Actividad guardar(Actividad usuario) {
        return actividadRepository.save(usuario);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        actividadRepository.deleteById(id);
    }




}
