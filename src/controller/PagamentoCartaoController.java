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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javax.swing.JOptionPane;
import model.BLL.BLLVenda;
import model.Pagamentovenda;
import model.Tipopagamento;
import view.ScreensFramework;

/**
 * FXML Controller class
 *
 * @author comum
 */
public class PagamentoCartaoController implements Initializable, ControlledScreen {
    Pagamentovenda pagamento = new Pagamentovenda();
    Tipopagamento tipo = new Tipopagamento();
   
    @FXML private Button btnMaster;
    @FXML private Button btnVisa;   
    @FXML private Button btnVoltar;   
    @FXML private Button btnPagar;
    @FXML private ComboBox<String> combo;  
    
    @FXML
    void btnVoltar_click(ActionEvent event) {
        myController.setScreen(ScreensFramework.telaPagamento);
    }
    
    void btnPagar_click(ActionEvent event) {
                    if(combo.getValue() != null && !combo.getValue().toString().isEmpty()){
                        if(combo.getValue().toString().equals("à vista"))
                             pagamento.setNumeroParcelas(0);
                        if(combo.getValue().toString().equals("2x"))
                             pagamento.setNumeroParcelas(2);
                        if(combo.getValue().toString().equals("4x"))
                             pagamento.setNumeroParcelas(4);
                        if(combo.getValue().toString().equals("6x"))
                             pagamento.setNumeroParcelas(6);
                        if(combo.getValue().toString().equals("8x"))
                             pagamento.setNumeroParcelas(8);
                        if(combo.getValue().toString().equals("10x"))
                             pagamento.setNumeroParcelas(10);
                        if(combo.getValue().toString().equals("12x"))
                             pagamento.setNumeroParcelas(12);
                    }
                    String valor = null;
                    Double total = BLLVenda.ultimaVenda.getValorTotal();
                    valor = JOptionPane.showInputDialog("Qual o valor a ser pago por Cartão de Crédito?");     
                    BLLVenda.valorPago += Double.parseDouble(valor);
                    tipo.setDescricao(tipo.getDescricao() + "/Pagamento com Cartão de Crédito/");
                    pagamento.setTipopagamento(tipo);
                    pagamento.setNumeroParcelas(0);
                    if(total == BLLVenda.valorPago){
                        JOptionPane.showMessageDialog(null, "Pagamento total efetuado.");
                        myController.setScreen(ScreensFramework.telaCaixa);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, valor +" reais pagos por Cartão de Crédito");
                        myController.setScreen(ScreensFramework.telaPagamento);
                    }
        JOptionPane.showMessageDialog(null, "Pagamento efetuado com cartão de crédito.");
        myController.setScreen(ScreensFramework.telaCaixa);
    }

    
    /**
     * Initializes the controller class.
     */
    
    ScreensController myController;
    
    public void initListeners(){
        btnPagar.setOnMouseClicked(new EventHandler<MouseEvent>() {
           @Override
            public void handle(MouseEvent event) {
                pagamento.setTipopagamento(tipo);
                    if(combo.getValue() != null && !combo.getValue().toString().isEmpty()){
                        if(combo.getValue().toString().equals("à vista"))
                             pagamento.setNumeroParcelas(0);
                        if(combo.getValue().toString().equals("2x"))
                             pagamento.setNumeroParcelas(2);
                        if(combo.getValue().toString().equals("4x"))
                             pagamento.setNumeroParcelas(4);
                        if(combo.getValue().toString().equals("6x"))
                             pagamento.setNumeroParcelas(6);
                        if(combo.getValue().toString().equals("8x"))
                             pagamento.setNumeroParcelas(8);
                        if(combo.getValue().toString().equals("10x"))
                             pagamento.setNumeroParcelas(10);
                        if(combo.getValue().toString().equals("12x"))
                             pagamento.setNumeroParcelas(12);
                    }
                JOptionPane.showMessageDialog(null, "Pagamento efetuado com cartão de crédito.");
                myController.setScreen(ScreensFramework.telaCaixa); 
               /* combo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

                @Override
                public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                    // COLOCAR O COMANDO SQL

                }
                });*/
            }
        });
        
        btnVisa.setOnMouseClicked(new EventHandler<MouseEvent>() {
           @Override
            public void handle(MouseEvent event) {
                JOptionPane.showMessageDialog(null, "Visa selecionado.");
                tipo.setDescricao("Cartão de Crédito - Visa");
                }
        });
        
        btnMaster.setOnMouseClicked(new EventHandler<MouseEvent>() {
           @Override
            public void handle(MouseEvent event) {
                JOptionPane.showMessageDialog(null, "MasterCard selecionado.");
                tipo.setDescricao("Cartão de Crédito - MasterCard");
                }
        });
    }
    
    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        initListeners();
    }    

    @Override
    public void setScreenParent(ScreensController screenPage) {
        //screenPage.getStylesheets().add("/view.css/button.css");
        myController = screenPage;
    }
    
}
