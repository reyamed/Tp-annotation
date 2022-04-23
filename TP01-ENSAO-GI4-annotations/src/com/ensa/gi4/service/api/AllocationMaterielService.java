package com.ensa.gi4.service.api;

import java.util.List;

import com.ensa.gi4.modele.Materiel;

public interface AllocationMaterielService {
	void allouerMateriel(String nom, int nbreJrs);
    void rendreMateriel(String nom);
    List<Materiel> listerMateriel();
}
