/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.frameworkGerenciaTela.ControlledScreen;
import controller.frameworkGerenciaTela.ScreensController;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import model.BLL.BLLCaixa;
import view.ScreensFramework;

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
    
    @FXML
    private Button btnVoltar;    
    
    ScreensController myController;
    
    @FXML
    void btnVoltar_Click(ActionEvent event) {
        myController.setScreen(ScreensFramework.telaPrincipal);
    }
    
@FXML
    void btnAbrirCaixa_Click(ActionEvent event) {
        BLLCaixa.AbrirCaixa();        
    }

    @FXML
    void btnFecharCaixa_Click(ActionEvent event) {

    }

    @FXML
    void btnSuprimento_Click(ActionEvent event) {

    }

    @FXML
    void btnSangria_Click(ActionEvent event) {

    }    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Date date = new Date();
        if(BLLCaixa.temCaixaAberto(date))
        {
            btnAbrirCaixa.setDisable(true);
        }
    }    

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }
    
}
