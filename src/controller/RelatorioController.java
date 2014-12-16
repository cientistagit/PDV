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
import model.BLL.BLLFeatureManager;
import view.ScreensFramework;

/**
 * FXML Controller class
 *
 * @author Xande
 */
public class RelatorioController implements Initializable, ControlledScreen{
    
     ScreensController myController;
    
    @FXML private Button btnRelComissao;
    @FXML private Button btnRelMercadorias;
    @FXML private Button btnRelAtendiemntos;
    @FXML private Button btnRelConferenciaCaixa;
    @FXML private Button btnVoltar;

    @FXML
    void btnRelAtendiemntos_click(ActionEvent event) {

    }

    @FXML
    void btnRelComissao_click(ActionEvent event) {

    }

    @FXML
    void btnRelMercadorias_click(ActionEvent event) {
        myController.setScreen(ScreensFramework.telaRelMercadorias);
    }

    @FXML
    void btnRelConferenciaCaixa_click(ActionEvent event) {

    }    
    
    @FXML
    void btnVoltar_click(ActionEvent event) {
        myController.setScreen(ScreensFramework.telaPrincipal);
    }    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //controle da feature Orçamentos
        //Relatório de Comissão de Vendedores
        if(!BLLFeatureManager.featureEstaAtiva("Relatório de Comissão de Vendedores"))
        {
            btnRelComissao.setVisible(false);
        }
        //Relatório de Mercadorias
        if(!BLLFeatureManager.featureEstaAtiva("Relatório de Mercadorias"))
        {
            btnRelMercadorias.setVisible(false);
        }
        //Relatório de Caixa        
        if(!BLLFeatureManager.featureEstaAtiva("Relatório de Caixa"))
        {
            btnRelConferenciaCaixa.setVisible(false);
        }
    }    
    
    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }    
    
}

