/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.BLL;

import java.util.List;
import model.Feature;
import model.persistencia.DAOFeature;

/**
 *
 * @author Xande
 */
public class BLLFeatureManager {
    
    public static List<Feature> listaFeatures;
    
    public BLLFeatureManager(){
        
    }
    
    public BLLFeatureManager(List<Feature> pFeatures){
        listaFeatures = pFeatures;
    }
    
    public static boolean featureEstaAtiva(String pDescricaoFeature){
        DAOFeature dao = new DAOFeature();        
        Feature feature = dao.buscar(pDescricaoFeature);
        return feature != null && feature.getStatus()=='A'; //se encontrar a feature e ela estiver ativa
    }
    
}
