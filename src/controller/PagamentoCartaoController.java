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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javax.swing.JOptionPane;
import view.ScreensFramework;

/**
 * FXML Controller class
 *
 * @author comum
 */
public class PagamentoCartaoController implements Initializable, ControlledScreen {

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
                JOptionPane.showMessageDialog(null, "Pagamento efetuado com cartão de crédito.");
                myController.setScreen(ScreensFramework.telaCaixa); 
                combo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

                @Override
                public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                    // COLOCAR O COMANDO SQL

                }
                });
            }
        });
        
        btnVisa.setOnMouseClicked(new EventHandler<MouseEvent>() {
           @Override
            public void handle(MouseEvent event) {
                btnVisa.setStyle(null);
                }
        });
        
        btnMaster.setOnMouseClicked(new EventHandler<MouseEvent>() {
           @Override
            public void handle(MouseEvent event) {
                btnMaster.setStyle(null);
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
         myController = screenPage;
    }
    
}
