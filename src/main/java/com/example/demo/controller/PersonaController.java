package com.example.demo.controller;

import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaRepository;
import com.example.demo.service.PersonaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personas1")
public class PersonaController {

    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }
    // 1️⃣ Obtener todas las personas (GET)
    @GetMapping
    public List<Persona> ObtenerPersonas(){
        return personaService.ObtenerPersonas();
    }
    // 2️⃣ Agregar una nueva persona (POST)
    @PostMapping
    public ResponseEntity<Persona> agregarPersona(@RequestBody Persona persona) {
        Persona nuevaPersona = personaService.guardarPersona(persona);
        return ResponseEntity.ok(nuevaPersona);
    }

    // 3️⃣ Modificar persona por ID (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Persona> modificarPersona(@PathVariable Long id, @RequestBody Persona personaDetalles) {
        Persona personaActualizada = personaService.modificarPersona(id, personaDetalles);
        return ResponseEntity.ok(personaActualizada);
    }

    // 4️⃣ Eliminar persona por ID (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPersona(@PathVariable Long id) {
        personaService.eliminarPersona(id);
        return ResponseEntity.ok("Persona eliminada correctamente.");
    }
}
