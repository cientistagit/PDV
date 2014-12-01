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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author comum
 */
public class PagamentoCartaoController implements Initializable, ControlledScreen {

    @FXML
    private Button btnMaster;

    @FXML
    private Button btnVisa;
    
    @FXML
    private ComboBox<String> combo;  
    
    /**
     * Initializes the controller class.
     */
    
    ScreensController myController;
    
    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        assert btnMaster != null : "fx:id=\"btnMaster\" was not injected: check your FXML file 'PagamentoCartao.fxml'.";
        assert btnVisa != null : "fx:id=\"btnVisa\" was not injected: check your FXML file 'PagamentoCartao.fxml'.";
        assert combo != null : "fx:id=\"combo\" was not injected: check your FXML file 'PagamentoCartao.fxml'.";
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
