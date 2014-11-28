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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Usuario;
import view.ScreensFramework;

/**
 *
 * @author Jailton
 */
public class LoginController implements Initializable, ControlledScreen {
    
    @FXML
    private Label labelMsg;
    
    @FXML
    private Button btnLogin;
    
    @FXML
    private TextField txtLogin;
    
    @FXML
    private PasswordField txtSenha;
    
    ScreensController myController;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
       //evento login -  added by Marcus Alexandre 13/11/2014
       // Teste 2
        Usuario usuario = new Usuario();
        usuario.setLogin(txtLogin.getText());
        usuario.setSenha(txtSenha.getText());
        if (usuario.validarLogin())
        {
            myController.setScreen(ScreensFramework.telaPrincipal);
        }
        else
        {
            labelMsg.setVisible(true);
            txtLogin.clear();
            txtSenha.clear();
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }
    
}
