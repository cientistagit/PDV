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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
    @FXML private ComboBox<String> combo;  
    
    @FXML
    void btnVoltar_click(ActionEvent event) {
        myController.setScreen(ScreensFramework.telaPagamento);
    }

    
    /**
     * Initializes the controller class.
     */
    
    ScreensController myController;
    
    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb) {        
        combo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                // COLOCAR O COMANDO SQL

            }
        });
    }    

    @Override
    public void setScreenParent(ScreensController screenPage) {
         myController = screenPage;
    }
    
}
