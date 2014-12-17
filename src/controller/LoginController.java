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
import model.BLL.BLLUsuario;
import model.persistencia.DB;
import model.persistencia.NewHibernateUtil;
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
    
    @FXML
    private Button btnConfiguracoes;    
    
    ScreensController myController;    
    
    @FXML
    void btnConfiguracoes_click(ActionEvent event) {
        //caregar a tela
        ScreensFramework.mainContainer.loadScreen(ScreensFramework.telaFeaturesConfig, ScreensFramework.telaFeaturesConfigFile);
        //mudar de tela
        myController.setScreen(ScreensFramework.telaFeaturesConfig);
    }
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
       //evento login -  added by Marcus Alexandre 13/11/2014

        if(BLLUsuario.validarLogin(txtLogin.getText(),txtSenha.getText()))
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
        // inicializo a sessão do banco
        //DB.session = NewHibernateUtil.getSessionFactory().getCurrentSession();
    }    

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }
    
}
