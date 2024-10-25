package com.example.parcial;

import com.example.parcial.interfaces.INombreParaLED;

public class Persona implements INombreParaLED {
    private String nombre;
    private String nacionalidad;

    public Persona(String nombre, String nacionalidad) {
        setNombre(nombre);
        setNacionalidad(nacionalidad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String getNombreParaLED() {
        return "Piloto: " + nombre;
    }


}
