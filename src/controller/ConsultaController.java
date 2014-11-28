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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Jailton
 */
public class ConsultaController implements Initializable, ControlledScreen {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TableView<?> tableConsulta;
    
    @FXML
    private TableColumn<?, ?> columID;
    
    @FXML
    private TableColumn<?, ?> columDesc;
    
    @FXML
    private TableColumn<?, ?> columTam;
    
    @FXML
    private TableColumn<?, ?> columCor;
    
    @FXML
    private TableColumn<?, ?> columQtde;
    
    @FXML
    private TableColumn<?, ?> columPreco;

    @FXML
    private TextField txtBuscaCod;
    
    @FXML
    private Button botBuscaCod;
    
    @FXML
    private TextField txtBuscaDesc;

    @FXML
    private Button botBuscaDesc;

   
    ScreensController myController;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override    
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }
    
    
    @FXML
    void buscarCodProduto(ActionEvent event) {

    }

    @FXML
    void buscarDescProduto(ActionEvent event) {

    }
}
