/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.BLL;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
    
    public static boolean featureEstaAtiva(String pDescricaoFeature){
        /*
        DAOFeature dao = new DAOFeature();        
        Feature feature = dao.buscar(pDescricaoFeature);
        return feature != null && feature.getStatus()=='A'; //se encontrar a feature e ela estiver ativa
        */
        for(Feature feature : listaFeatures)
        {
            if(feature.getDescricao().equals(pDescricaoFeature) && feature.getStatus()=='A')
                return true;
        }
        return false;
    }
    
    public static boolean carregarFeatures() throws FileNotFoundException, IOException{

    /**
     *
     */
        File arquivoFeatures = null;
        listaFeatures = new ArrayList();
        try
        {
            arquivoFeatures = new File( "features.txt" );
        }
        catch(Exception ex)
        {
            System.out.println("Não foi possível abrir o arquivo de features");
        }
        if(arquivoFeatures.exists())
        {
            //construtor que recebe o objeto do tipo arquivo
            FileReader fr = new FileReader(arquivoFeatures);
            //construtor que recebe o objeto do tipo FileReader
            BufferedReader br = new BufferedReader( fr );            
            //equanto houver mais linhas
            while( br.ready() ){
            //lê a proxima linha
            String linha = br.readLine();
                String[] split = linha.split(";");
            listaFeatures.add(new Feature(Integer.parseInt(split[0]),split[1],split[2].charAt(0)));            
            }
            
            br.close();
            fr.close();
            return true;
        }
        else{
            return false;
        }
    }
    
}
