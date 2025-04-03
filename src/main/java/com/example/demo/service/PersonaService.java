package com.example.demo.service;

import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {
    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {

        this.personaRepository = personaRepository;
    }

    public List<Persona> ObtenerPersonas(){

        return personaRepository.findAll();
    }

    // Guardar nueva persona
    public Persona guardarPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    // Modificar persona existente
    public Persona modificarPersona(Long id, Persona personaDetalles) {
        Optional<Persona> optionalPersona = personaRepository.findById(id);
        if (optionalPersona.isPresent()) {
            Persona persona = optionalPersona.get();
            persona.setNombre(personaDetalles.getNombre());
            persona.setEmail(personaDetalles.getEmail());
            persona.setPassword(personaDetalles.getPassword());
            return personaRepository.save(persona);
        } else {
            throw new RuntimeException("Persona no encontrada con el ID: " + id);
        }
    }

    // Eliminar persona
    public void eliminarPersona(Long id) {
        personaRepository.deleteById(id);
    }
}
