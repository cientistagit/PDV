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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Xande
 */
public class CaixaController implements Initializable, ControlledScreen {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button btnSuprimento;

    @FXML
    private Button btnFecharCaixa;

    @FXML
    private Button btnAbrirCaixa;

    @FXML
    private Button btnSangria;
    
    ScreensController myController;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }
    
}
