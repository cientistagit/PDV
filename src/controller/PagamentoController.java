/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.frameworkGerenciaTela.ControlledScreen;
import controller.frameworkGerenciaTela.ScreensController;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import model.BLL.BLLFeatureManager;
import model.BLL.BLLVenda;
import model.Pagamentovenda;
import model.Tipopagamento;
import model.Venda;
import view.ScreensFramework;

/**
 * FXML Controller class
 *
 * @author Ikaro
 */
public class PagamentoController implements Initializable, ControlledScreen {
    
    ScreensController myController;
    
    public Venda venda = null;
    
    @FXML private ResourceBundle resources;
    @FXML private URL location;   
    @FXML private Button btnCartao;
    @FXML private Button btnDinheiro;
    @FXML private Button btnCheque;   
    @FXML private Button btnVoltar;
    @FXML private Button btnTroca;
    @FXML private Button btnValePresente;
    @FXML private Label lblTotalPagar;
    @FXML private Label lblTotalPago;    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        initListeners();
        this.venda = BLLVenda.ultimaVenda;
        lblTotalPagar.setText(NumberFormat.getCurrencyInstance().format(venda.getValorTotal()));
        lblTotalPago.setText(NumberFormat.getCurrencyInstance().format(0)); //total de pagamentos parciais.    
        
        //controle da feature cadastro de clientes
        if(!BLLFeatureManager.featureEstaAtiva("Pagamento com Troca"))
        {
            btnTroca.setVisible(false);
        }
        //controle da feature Orçamentos
        if(!BLLFeatureManager.featureEstaAtiva("Pagamento com Vale Presente"))
        {
            btnValePresente.setVisible(false);
        }
        //COLOCAR O COMANDO SQL NA AÇÂO DE CADA BOTÂO CLICADO.
    }    


    @FXML
    void btnVoltar_click(ActionEvent event) {
        myController.setScreen(ScreensFramework.telaVenda);
    }
    
    public void setVenda(Venda venda){
        this.venda = venda; 
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
                if(n==1){
                    tipo.setDescricao("Cartão de Débito");
                    pagamento.setTipopagamento(tipo);
                    pagamento.setNumeroParcelas(0);
                }
    }
    
    @FXML protected void btnTrocaClicked(ActionEvent event) {
        
        
    }
    
    @FXML protected void btnValePresenteClicked(ActionEvent event) {
        
        
    }
    
    public void initListeners(){
        btnDinheiro.setOnMouseClicked(new EventHandler<MouseEvent>() {
           @Override
            public void handle(MouseEvent event) {
                Pagamentovenda pagamento = new Pagamentovenda();
                Tipopagamento tipo = new Tipopagamento();
                tipo.setDescricao("Dinheiro");
                pagamento.setTipopagamento(tipo);
                pagamento.setNumeroParcelas(0);
                JOptionPane.showMessageDialog(null, "Pagamento efetuado com dinheiro.");
                myController.setScreen(ScreensFramework.telaCaixa);
                
            }
        });
        
       
        
        btnCheque.setOnMouseClicked(new EventHandler<MouseEvent>() {
           @Override
            public void handle(MouseEvent event) {
                Pagamentovenda pagamento = new Pagamentovenda();
                Tipopagamento tipo = new Tipopagamento();
                tipo.setDescricao("Cheque");
                pagamento.setTipopagamento(tipo);
                pagamento.setNumeroParcelas(0);
                JOptionPane.showMessageDialog(null, "Pagamento efetuado com cheque.");
                myController.setScreen(ScreensFramework.telaCaixa);
            }
        });
        
 
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
                if(n==1){
                String numero = JOptionPane.showInputDialog("Qual o número do cartão?");
                JOptionPane.showMessageDialog(null, "Pagamento efetuado com cartão de débito.");
                myController.setScreen(ScreensFramework.telaCaixa);
                }
            }
        });
        
        btnTroca.setOnMouseClicked(new EventHandler<MouseEvent>() {
           @Override
            public void handle(MouseEvent event) {
                
                
            }
        });
        
        btnValePresente.setOnMouseClicked(new EventHandler<MouseEvent>() {
           @Override
            public void handle(MouseEvent event) {
                
                
            }
        });
        
        /*btnCartao.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                System.out.println("entrei3");
                Pagamentovenda pagamento = new Pagamentovenda();
                Tipopagamento tipo = new Tipopagamento();
                Object[] opcoes = {"Cartão de crédito", "Cartão de débito"};
                int n = JOptionPane.showOptionDialog(null, "Qual o tipo de cartão", "Escolha o tipo de cartão:", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[1]);
                myController.setScreen(ScreensFramework.telaPagamentoCartao);
            }
        });*/
    }
    
    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;    
    }
    
}
