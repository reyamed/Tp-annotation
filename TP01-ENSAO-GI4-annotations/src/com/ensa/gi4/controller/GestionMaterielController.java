package com.ensa.gi4.controller;

import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.AllocationMaterielService;
import com.ensa.gi4.service.api.GestionMaterielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component("controllerPricipal")
public class GestionMaterielController {

    
    @Autowired
    private AllocationMaterielService allocationMaterielService;

    @Autowired
    private GestionMaterielService gestionMaterielService;

    public void listerMateriel() {
    	 for (Materiel m:
             gestionMaterielService.getAllMateriels()) {
         System.out.println(m.getName());
     }
    }
    
    //la liste du materiel allou� 
    public void listerMaterielAlloue()
    {
        for (Materiel m:
                allocationMaterielService.listerMateriel()) {
            System.out.println(m.getName());
        }
    }


    public GestionMaterielController() {
    }

    public GestionMaterielController(GestionMaterielService materielService, AllocationMaterielService allocationMaterielService) {
        this.gestionMaterielService = materielService;
        this.allocationMaterielService = allocationMaterielService;
    }
    
    //ajouter un materiel selon son type (Livre ou Chaise)
    public void ajouterMateriel() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pour ajouter un Livre entrer : 1, pour un Chaise entrer : 2");
        int saisir = scanner.nextInt();

        if(saisir == 1)
        {
            System.out.println("nom : ");
            String nom = scanner.next();
            Livre l = new Livre();
            l.setName(nom);
            gestionMaterielService.addMateriel(l);
        }
        else if(saisir == 2)
        {
            System.out.println("nom : ");
            String nom = scanner.next();
            Chaise c = new Chaise();
            c.setName(nom);
            gestionMaterielService.addMateriel(c);
        }

    }

    //pour supprimer un materiel de la BDD on se basent sur son nom
    public void supprimerMateriel() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrer le nom de materiel a supprimer : ");
        String nom = scanner.next();

        System.out.println("Materiel " + gestionMaterielService.getMateriel(nom).getName() + " Supprimé");
        gestionMaterielService.deleteMateriel(nom);
    }

    //pour modifier un materiel dans la BDD , on se basent sur son nom
    public void modifierMateriel()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrer le nom de materiel a modifier : ");
        String nom = scanner.next();
        Materiel mat = gestionMaterielService.getMateriel(nom);

        if(mat instanceof Livre)
        {
            System.out.println("nom : ");
            String nouveauNomLivre = scanner.next();
            Livre l = new Livre();
            l.setName(nouveauNomLivre);
            gestionMaterielService.updateMateriel(nom,l);
        }
        else if(mat instanceof Chaise)
        {
            System.out.println("nom : ");
            String nouveauNomChaise = scanner.next();

            Chaise c = new Chaise();
            c.setName(nouveauNomChaise);
            gestionMaterielService.updateMateriel(nom,c);
        }
    }

    //pour allouer un materiel pour quelle que jours ==> supprimer de la BDD temporairement
    public void allouerMateriel() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrer le nom de materiel a allouer : ");
        String  nom = scanner.next();
        System.out.println("Entrer le nombre de jours : ");
        int jrs = scanner.nextInt();
        allocationMaterielService.allouerMateriel(nom,jrs);}

    //si on veut rendre le materiel avant que la duree fini on se basent sur le nom
    public void rendreMateriel() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrer nom de materiel a rendre : ");
        String  nom = scanner.next();
        allocationMaterielService.rendreMateriel(nom);}

    public void afficherMenu() {
        System.out.println("1- pour lister le matériel, entrer 1");
        System.out.println("2- pour ajouter un nouveau matériel, entrer 2");
        System.out.println("3- pour supprimer un matériel, entrer 3");
        System.out.println("4- pour allouer un matériel, entrer 4");
        System.out.println("5- pour rendre un matériel, entrer 5");
        System.out.println("6- pour modifier un matériel, entrer 6");
        System.out.println("7- pour lister materiels alloués 7");
        System.out.println("0- pour sortir de l'application, entrer 0");
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        if ("0".equals(next)) {
            sortirDeLApplication();
        } else if ("1".equals(next)) {
            listerMateriel();
        } else if ("2".equals(next)) {
            ajouterMateriel();
        } else if ("3".equals(next)) {
            supprimerMateriel();
        } else if ("4".equals(next)) {
            allouerMateriel();
        }
        else if ("5".equals(next)) {
            rendreMateriel();
        }
        else if ("6".equals(next)) {
            modifierMateriel();
        }
        else if ("7".equals(next)) {
            listerMaterielAlloue();
        }else {
            System.out.println("choix invalide");
        }
    }


    private void sortirDeLApplication() {
        System.exit(0);
    }

}
