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
import javafx.scene.control.Label;

/**
 *
 * @author Jailton
 */
public class LoginController implements Initializable, ControlledScreen {
    
    @FXML
    private Label labelMsg;
    
    @FXML
    private Button btnLogin;
    
    ScreensController myController;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
    
        // Teste de Conexão, GitHub
        // Teste 2
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }
    
}
