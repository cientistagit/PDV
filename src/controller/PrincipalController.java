/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.frameworkGerenciaTela.ControlledScreen;
import controller.frameworkGerenciaTela.ScreensController;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import model.BLL.BLLCaixa;
import model.BLL.BLLFeatureManager;
import view.ScreensFramework;


/**
 * FXML Controller class
 *
 * @author Xande
 */
public class PrincipalController implements Initializable, ControlledScreen {

    ScreensController myController;
    
    @FXML private Button btnCaixa;
    @FXML private Button btnConsultaProduto;
    @FXML private Button btnVenda;
    @FXML private Button btnRelatorios;
    @FXML private Button btnClientes;
    @FXML private Button btnSair;
    @FXML private Button btnOrcamentos;    

    @FXML
    void btnCaixa_Click(ActionEvent event) {
        //carregando a tela caixa
        ScreensFramework.mainContainer.loadScreen(ScreensFramework.telaCaixa, ScreensFramework.telaCaixaFile);
        myController.setScreen(ScreensFramework.telaCaixa);                        
    }

    @FXML
    void btnVenda_Click(ActionEvent event) {
        myController.setScreen(ScreensFramework.telaVenda);
    }

    @FXML
    void btnConsultaProduto_Click(ActionEvent event) {
        myController.setScreen(ScreensFramework.telaConsulta);
    }

    @FXML
    void btnRelatorios_Click(ActionEvent event) {
        myController.setScreen(ScreensFramework.telaRelatorios);
    }

    @FXML
    void btnClientes_Click(ActionEvent event) {

    }
    
    @FXML
    void btnOrcamentos_click(ActionEvent event) {

    }    
    
    @FXML
    void btnSair_click(ActionEvent event) {
        myController.setScreen(ScreensFramework.telaLogin);
    }    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            //carregar lista de features do arquivo
            BLLFeatureManager.carregarFeatures();
        } catch (IOException ex) {
            System.out.println("Erro na leitra do arquivo de features");
        }

        //controle da feature cadastro de clientes
        if(!BLLFeatureManager.featureEstaAtiva("Cadastro de Clientes"))
        {
            btnClientes.setVisible(false);
        }
        //controle da feature Orçamentos
        if(!BLLFeatureManager.featureEstaAtiva("Orçamentos"))
        {
            btnOrcamentos.setVisible(false);
        }
        
            
    }    
    
    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }
    
}
