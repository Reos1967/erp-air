package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name="persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_persona")
    private Long idPersona;
    private String nombre;
    private String email;
    private String password;

    public Long getIdPersona() {

        return idPersona;
    }

    public void setIdPersona(Long idPersona) {

        this.idPersona = idPersona;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }
}
