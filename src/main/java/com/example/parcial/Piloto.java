package com.example.parcial;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.parcial.interfaces.ISponsoreable;

public class Piloto 
            extends Persona 
            implements ISponsoreable{

    private Equipo equipo;
    private List<SponsorContrato> sponsors = new ArrayList<>();
    private List<SponsorContrato> sponsorsHabilitados = new ArrayList<>();

    public Piloto(String nombre, String nacionalidad) {
        super(nombre, nacionalidad);
    }

    public Equipo getEquipo() {
        return equipo;
    } 
    
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

////////////////////////////////////////////////////////////////
    @Override
    public List<SponsorContrato> getSponsors() {
        return sponsors;
    }

    @Override
    public void agregar(SponsorContrato sponsorContrato) {
        sponsors.add(sponsorContrato);
    }

    @Override
    public void agregar(Sponsor sponsor, String ubicacion, LocalDate fechaDesde) {
        var sc1 = new SponsorContrato(sponsor, ubicacion, fechaDesde, null);
        this.agregar(sc1);
    }

    @Override
    public void remover(Sponsor sponsor) {
        sponsors.removeIf(sponsorContrato -> sponsorContrato.getSponsor().equals(sponsor));
    }

    @Override
    public void remover(Sponsor sponsor, String ubicacion) {
        sponsors.removeIf(sponsorContrato -> 
            sponsorContrato.getSponsor().equals(sponsor) && 
            sponsorContrato.getUbicacion().equals(ubicacion)
        );
    }


    @Override
    public void remover(String nombreSponsor) {
        sponsors.removeIf(sponsorContrato -> sponsorContrato.getSponsor().getNombre().equals(nombreSponsor));
    }

    @Override
    public List<SponsorContrato> getSponsorHabilitados() {
        for (SponsorContrato sponsorContrato : sponsors) {
            if (sponsorContrato.getFechaHasta() != null) {
                sponsorsHabilitados.add(sponsorContrato);
            }
        }

        return sponsorsHabilitados;
    }

   

}

