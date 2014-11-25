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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import model.Pagamentovenda;
import model.Tipopagamento;
import model.Usuario;
import view.ScreensFramework;

/**
 * FXML Controller class
 *
 * @author Ikaro
 */
public class PagamentoController implements Initializable, ControlledScreen {
    
    ScreensController myController;
    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private Button btnCartao;

    @FXML
    private Button btnDinheiro;

    @FXML
    private Button btnCheque;

    @FXML
    void initialize() {
        
    }
    
    @FXML protected void btnDinheiroClicked(ActionEvent event) {
        Pagamentovenda pagamento = new Pagamentovenda();
        Tipopagamento tipo = new Tipopagamento();
        
    }
    
    @FXML protected void btnChequeClicked(ActionEvent event) {
        Pagamentovenda pagamento = new Pagamentovenda();
        Tipopagamento tipo = new Tipopagamento();
        
    }
    
    @FXML protected void btnCartaoClicked(ActionEvent event) {
        Pagamentovenda pagamento = new Pagamentovenda();
        Tipopagamento tipo = new Tipopagamento();
        
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
