package com.example.parcial;

import java.util.ArrayList;
import java.util.List;

import com.example.parcial.interfaces.ISponsoreable;

public class Circuito implements ISponsoreable{
    private String nombre;
    private String longitud;
    private int vueltasCantidad;
    private List<SponsorContrato> sponsors;


    public Circuito(String nombre, String longitud, int vueltasCantidad) {
        this.nombre = nombre;
        this.longitud = longitud;
        this.vueltasCantidad = vueltasCantidad;
        this.sponsors = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getLongitud() {
        return longitud;
    }

    public int getVueltasCantidad() {
        return vueltasCantidad;
    }

    public List<SponsorContrato> getSponsors() {
        return sponsors;
    }

    
}
