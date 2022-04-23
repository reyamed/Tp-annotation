package com.ensa.gi4;

import com.ensa.gi4.controller.GestionMaterielController;
import com.ensa.gi4.datatabase.api.MaterielDao;
import com.ensa.gi4.datatabase.impl.ListMateriel;
import com.ensa.gi4.datatabase.impl.ListMaterielImpl;
import com.ensa.gi4.datatabase.impl.MaterielDaoImpl;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.AllocationMaterielService;
import com.ensa.gi4.service.api.GestionMaterielService;
import com.ensa.gi4.service.impl.AllocationMaterielServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class AppConfig {
  

    @Bean
    public AllocationMaterielService AllocationMaterielServiceBean(){
        return new AllocationMaterielServiceImpl();
    }
    
//    @Bean 
//    ListMateriel listMaterielBean() {
//    	return new ListMaterielImpl();
//    }
//    
//    @Bean 
//    //@Lazy
//    MaterielDao MaterielDaoBean(ListMateriel listMaterielBean) {
//    	return new MaterielDaoImpl(listMaterielBean);
//    }
    
    @Bean
    //@Lazy
    public GestionMaterielController gestionMaterielControllerBean(GestionMaterielService gestionMaterielServiceBean, AllocationMaterielService AllocationMaterielServiceBean){
        return new GestionMaterielController(gestionMaterielServiceBean, AllocationMaterielServiceBean);
   }
      
}
