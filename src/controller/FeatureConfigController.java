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
import model.Feature;
import model.persistencia.DAOFeature;

/**
 * FXML Controller class
 *
 * @author Xande
 */
public class FeatureConfigController implements Initializable, ControlledScreen {
    
    @FXML
    private TableView<?> tableFeature;
        

    ScreensController myController;      
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        List<Feature> listaFeatures = null;
        DAOFeature dao = new DAOFeature();
        
        listaFeatures = dao.listar();
        
    }    
    
    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }    
    
}
