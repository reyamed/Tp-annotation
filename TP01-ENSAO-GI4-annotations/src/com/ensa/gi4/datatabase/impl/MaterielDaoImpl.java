package com.ensa.gi4.datatabase.impl;

import com.ensa.gi4.datatabase.api.MaterielDao;
import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MaterielDaoImpl implements MaterielDao {
	
	@Autowired
    private ListMateriel materielsClass;

    
    public MaterielDaoImpl(ListMateriel listMateriel) {
        this.materielsClass = listMateriel;
        this.materielsAlloue = new ArrayList<>();
        

       
    }


    List<Materiel> materiels = this.materielsClass.list();
    List<Materiel> materielsAlloue;

 
    @Override
    public void addToMaterielAlloue(String nom)
    {
        Materiel materielToAdd = null;
        for (Materiel materiel:
                materiels) {
            if (materiel.getName().equals(nom))
            {
                System.out.println("the content of our materiel.getName() is : "+materiel.getName());
                materielToAdd = materiel;
                break;
            }
        }
        this.materielsAlloue.add(materielToAdd);
    }
    @Override
    public void removeFromMaterielAlloue(String nom)
    {
        Materiel materielToDelete = null;
        for (Materiel materiel:
                materielsAlloue) {
            if (materiel.getName().equals(nom))
            {
                materielToDelete = materiel;
                break;
            }


        }
        this.materielsAlloue.remove(materielToDelete);
    }
    @Override
    public Materiel getFromMaterielAlloue(String nom)
    {
        Materiel materielToGet = null;
        for (Materiel materiel:
                materielsAlloue) {
            if (materiel.getName().equals(nom))
            {
                materielToGet = materiel;
                break;
            }


        }
        return materielToGet;
    }
    @Override
    public List<Materiel> getMaterielsAlloue()
    {
        return this.materielsAlloue;
    }

    @Override
    public List<Materiel> getAllMateriels() {
        return this.materiels;
    }

    @Override
    public void addMateriel(Materiel materiel) {
        this.materiels.add(materiel);
    }

    @Override
    public void deleteMateriel(String nom) {

        Materiel materielToDelete = null;
        for (Materiel materiel:
                materiels) {
            if (materiel.getName().equals(nom))
            {
                materielToDelete = materiel;
                break;
            }


        }

        this.materiels.remove(materielToDelete);

    }

    @Override
    public Materiel getMateriel(String nom) {
        Materiel materielToGet = null;
        for (Materiel materiel:
                materiels) {
            if (materiel.getName().equals(nom))
            {
                materielToGet = materiel;
                break;
            }

        }
        return materielToGet;
    }

    @Override
    public void updateMateriel(String nom, Materiel materiel) {
        Materiel materielToUpdate = null;
        for (Materiel m:
                materiels) {
            if (m.getName().equals(nom))
            {
                materielToUpdate = m;
                break;
            }

        }
        materielToUpdate.setName(materiel.getName());
    }
}
