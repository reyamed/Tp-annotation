package com.ensa.gi4.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ensa.gi4.datatabase.impl.MaterielDaoImpl;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.AllocationMaterielService;

public class AllocationMaterielServiceImpl implements AllocationMaterielService{
	@Autowired
	private MaterielDaoImpl materiel;

	    @Override
	    public void allouerMateriel(String nom, int nbreJrs) {
	        this.materiel.addToMaterielAlloue(nom);
	        this.materiel.deleteMateriel(nom);
	        String data = "Materiel Alloué pour " + nbreJrs + " Jours";
	        System.out.println(data);
	    }

	    @Override
	    public void rendreMateriel(String nom) {
	        Materiel m =  this.materiel.getFromMaterielAlloue(nom);
	        this.materiel.removeFromMaterielAlloue(nom);
	        this.materiel.addMateriel(m);
	    }

	    @Override
	    public List<Materiel> listerMateriel() {
	        return materiel.getMaterielsAlloue();
	    }

	    @Autowired
	    public void setMaterielDao(MaterielDaoImpl materiel) {
	        // injection par accesseur
	        this.materiel = materiel;
	    }
}
