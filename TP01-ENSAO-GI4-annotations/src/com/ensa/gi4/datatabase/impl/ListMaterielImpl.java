package com.ensa.gi4.datatabase.impl;

import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ListMaterielImpl implements ListMateriel {
    @Override
    public List<Materiel> list() {
        ArrayList<Materiel> materiels = new ArrayList<>();
        Materiel livre1  = new Livre();
        materiels.add(livre1);
        return materiels;
    }
}
