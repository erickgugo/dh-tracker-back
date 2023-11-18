package com.example.tracker.controller;

import com.example.tracker.entity.Actividad;
import com.example.tracker.services.ActividadService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@Log4j2
@CrossOrigin(origins = "http://localhost:4422", maxAge = 3600, allowCredentials = "true")
public class TrackerController {

    private ActividadService actividadService;

    @Autowired
    public TrackerController(ActividadService actividadService) {
        this.actividadService = actividadService;
    }
    @GetMapping("/test")
    public ResponseEntity<?> test() {
        return new ResponseEntity<>("Entrando a test", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> listar() {

        List<Actividad> list =  actividadService.listar();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Actividad actividad) {
        System.out.println(actividad);
        Actividad _actividad = actividadService.guardar(actividad);
        return new ResponseEntity<>(_actividad, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Actividad> actividadOptional = actividadService.porId(id);
        if (actividadOptional.isPresent()) {
            actividadService.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
