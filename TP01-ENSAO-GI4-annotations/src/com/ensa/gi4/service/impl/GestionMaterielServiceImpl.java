package com.ensa.gi4.service.impl;

import com.ensa.gi4.datatabase.impl.MaterielDaoImpl;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionMaterielService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("materielService")
public class GestionMaterielServiceImpl implements GestionMaterielService {
    // bd goes here

    private MaterielDaoImpl materiel;

    @Override
    public void init() {
        System.out.println("inititialisation du service");
    }

    @Override
    public List<Materiel> getAllMateriels() {
        return materiel.getAllMateriels();
    }

    @Override
    public void addMateriel(Materiel materiel) {
        this.materiel.addMateriel(materiel);
    }

    @Override
    public void deleteMateriel(String nom) {
        this.materiel.deleteMateriel(nom);
    }

    @Override
    public Materiel getMateriel(String nom) {
        return materiel.getMateriel(nom);
    }

    @Override
    public void updateMateriel(String nom, Materiel materiel) {
        this.materiel.updateMateriel(nom,materiel);
    }

    @Autowired
    public void setMaterielDao(MaterielDaoImpl materiel) {
        // injection par accesseur
        this.materiel = materiel;
    }
}
