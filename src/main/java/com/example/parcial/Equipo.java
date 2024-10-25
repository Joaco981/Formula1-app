package com.example.parcial;

import com.example.parcial.interfaces.ISponsoreable;
import com.example.parcial.interfaces.INombreParaLED;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Equipo 
            implements ISponsoreable, INombreParaLED {

    private String nombre;
    private List<Piloto> pilotos;
    private List<Mecanico> mecanicos;
    private Ingeniero ingenieroPrincipal;
    private List<SponsorContrato> sponsors;
    private List<SponsorContrato> sponsorsHabilitados;


    public Equipo(String nombre, Ingeniero ingenieroPrincipal) {
        setNombre(nombre);
        setIngenieroPrincipal(ingenieroPrincipal);
        setPilotos(new ArrayList<>());
        setMecanicos(new ArrayList<>());
        setSponsors(new ArrayList<>());
        setSponsorsHabilitados(new ArrayList<>());
    }

    public void agregarPiloto(Piloto piloto) {
        piloto.setEquipo(this);
        pilotos.add(piloto);
    }

    public void agregarMecanico(Mecanico mecanico) {
        mecanicos.add(mecanico);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Piloto> getPilotos() {
        return pilotos;
    }

    public void setPilotos(List<Piloto> pilotos) {
        this.pilotos = pilotos;
    }

    public List<Mecanico> getMecanicos() {
        return mecanicos;
    }

    public void setMecanicos(List<Mecanico> mecanicos) {
        this.mecanicos = mecanicos;
    }

    public Ingeniero getIngenieroPrincipal() {
        return ingenieroPrincipal;
    }

    public void setIngenieroPrincipal(Ingeniero ingenieroPrincipal) {
        this.ingenieroPrincipal = ingenieroPrincipal;
    } 

    public void setSponsors(List<SponsorContrato> sponsors) {
        this.sponsors = sponsors;
    }

    public void setSponsorsHabilitados(List<SponsorContrato> sponsorsHabilitados) {
        this.sponsorsHabilitados = sponsorsHabilitados;
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

    @Override
    public String getNombreParaLED() {
        return getNombre();
    }

}
