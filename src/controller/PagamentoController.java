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
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import model.Pagamentovenda;
import model.Tipopagamento;
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
        tipo.setDescricao("Dinheiro");
        pagamento.setTipopagamento(tipo);
        pagamento.setNumeroParcelas(0);
    }
    
    
    
    @FXML protected void btnChequeClicked(ActionEvent event) {
        Pagamentovenda pagamento = new Pagamentovenda();
        Tipopagamento tipo = new Tipopagamento();
        tipo.setDescricao("Cheque");
        pagamento.setTipopagamento(tipo);
        pagamento.setNumeroParcelas(0);
        
    }
    
    @FXML 
    protected void btnCartaoClicked(ActionEvent event) {
        Pagamentovenda pagamento = new Pagamentovenda();
        Tipopagamento tipo = new Tipopagamento();
        myController.setScreen(ScreensFramework.telaCaixa);
        Object[] opcoes = {"Cartão de crédito", "Cartão de débito"};
                int n = JOptionPane.showOptionDialog(null, "Qual o tipo de cartão", "Escolha o tipo de cartão:", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[1]);
                if(n==0)
                    myController.setScreen(ScreensFramework.telaPagamentoCartao);
    }
    
    private void initListeners(){
        btnDinheiro.setOnMouseClicked(new EventHandler<MouseEvent>() {
           @Override
            public void handle(MouseEvent event) {
                Pagamentovenda pagamento = new Pagamentovenda();
                Tipopagamento tipo = new Tipopagamento();
                tipo.setDescricao("Dinheiro");
                pagamento.setTipopagamento(tipo);
                pagamento.setNumeroParcelas(0);
            }
        });
        
        /*btnDinheiro.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                Pagamentovenda pagamento = new Pagamentovenda();
                Tipopagamento tipo = new Tipopagamento();
                tipo.setDescricao("Dinheiro");
                pagamento.setTipopagamento(tipo);
                pagamento.setNumeroParcelas(0);
            }
        });*/
        
        btnCheque.setOnMouseClicked(new EventHandler<MouseEvent>() {
           @Override
            public void handle(MouseEvent event) {
                Pagamentovenda pagamento = new Pagamentovenda();
                Tipopagamento tipo = new Tipopagamento();
                tipo.setDescricao("Cheque");
                pagamento.setTipopagamento(tipo);
                pagamento.setNumeroParcelas(0);
            }
        });
        
        /*btnCheque.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                Pagamentovenda pagamento = new Pagamentovenda();
                Tipopagamento tipo = new Tipopagamento();
                tipo.setDescricao("Cheque");
                pagamento.setTipopagamento(tipo);
                pagamento.setNumeroParcelas(0);
            }
        });*/
        
        btnCartao.setOnMouseClicked(new EventHandler<MouseEvent>() {
           @Override
            public void handle(MouseEvent event) {
                Pagamentovenda pagamento = new Pagamentovenda();
                Tipopagamento tipo = new Tipopagamento();
                Object[] opcoes = {"Cartão de crédito", "Cartão de débito"};
                int n = JOptionPane.showOptionDialog(null, "Qual o tipo de cartão", "Escolha o tipo de cartão:", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
                if(n == 0){
                    myController.setScreen(ScreensFramework.telaPagamentoCartao);
                }
            }
        });
        
        /*btnCartao.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                Pagamentovenda pagamento = new Pagamentovenda();
                Tipopagamento tipo = new Tipopagamento();
                Object[] opcoes = {"Cartão de crédito", "Cartão de débito"};
                int n = JOptionPane.showOptionDialog(null, "Qual o tipo de cartão", "Escolha o tipo de cartão:", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[1]);
                myController.setScreen(ScreensFramework.telaPagamentoCartao);
            }
        });*/
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initListeners();
        
        //COLOCAR O COMANDO SQL NA AÇÂO DE CADA BOTÂO CLICADO.
    }    

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }
    
}
