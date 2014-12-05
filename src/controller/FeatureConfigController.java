/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.frameworkGerenciaTela.ControlledScreen;
import controller.frameworkGerenciaTela.ScreensController;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Feature;
import model.persistencia.DAOFeature;

/**
 * FXML Controller class
 *
 * @author Xande
 */
public class FeatureConfigController implements Initializable, ControlledScreen {
    
    @FXML
    private TableView<Feature> tableFeature;
        

    ScreensController myController;      
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        List<Feature> listaFeatures = null;
        DAOFeature dao = new DAOFeature();
        
        //obtenho a lista de features
        listaFeatures = dao.listar();
        
        // Inicialização das colunas da tabela de features
        tableFeature.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("idFeature"));
        tableFeature.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tableFeature.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("status"));
                
        //adiciona as features na tabela
        for (Feature feature : listaFeatures) {
            tableFeature.getItems().add(feature);
        }
        
                
        
        
    }    
    
    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }    
    
}
