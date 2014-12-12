/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.frameworkGerenciaTela.ControlledScreen;
import controller.frameworkGerenciaTela.ScreensController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import view.ScreensFramework;

/**
 * FXML Controller class
 *
 * @author Xande
 */
public class MercadoriasController implements Initializable, ControlledScreen {

    ScreensController myController;
    
    @FXML private Button btnRelEntradas;
    @FXML private Button btnRelSaidas;
    @FXML private Button btnVoltar;
    @FXML private Button btnRelEstoque;
    
    @FXML 
    void btnRelEstoque_click(ActionEvent event) {

    }

    @FXML
    void btnRelEntradas_click(ActionEvent event) {

    }

    @FXML
    void btnRelSaidas_click(ActionEvent event) {

    }

    @FXML
    void btnVoltar_click(ActionEvent event) {
        myController.setScreen(ScreensFramework.telaRelatorios);
    }

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }  
    
}
