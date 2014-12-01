/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.frameworkGerenciaTela.ControlledScreen;
import controller.frameworkGerenciaTela.ScreensController;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import model.TabelaConsulta;
import view.ScreensFramework;

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
    private TableView<TabelaConsulta> tableConsulta;
    
    @FXML
    private TableColumn<TabelaConsulta, Integer> columID;
    
    @FXML
    private TableColumn<TabelaConsulta, String> columDesc;
    
    @FXML
    private TableColumn<TabelaConsulta, String> columTam;
    
    @FXML
    private TableColumn<TabelaConsulta, String> columCor;
    
    @FXML
    private TableColumn<TabelaConsulta, BigDecimal> columPreco;

    @FXML
    private TextField txtBuscaCod;
    
    @FXML
    private Button botBuscaCod;
    
    @FXML
    private TextField txtBuscaDesc;

    @FXML
    private Button botBuscaDesc;
    
    @FXML
    private Button botVoltar;

   
    ScreensController myController;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.columID.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.columDesc.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        this.columTam.setCellValueFactory(new PropertyValueFactory<>("tamanho"));
        this.columCor.setCellValueFactory(new PropertyValueFactory<>("cor"));
        this.columPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
    }    

    @Override    
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }
    
    
    
    @FXML
    void buscarCodProduto(ActionEvent event) {
        
        Integer codigo; 
        TabelaConsulta tbConsulta = new TabelaConsulta();
        ArrayList<TabelaConsulta> listaProdutos = new ArrayList<TabelaConsulta>(); 
        
        // "Pegando" o código digitado pelo usuário
        codigo = Integer.parseInt(this.txtBuscaCod.getText());
        
        //Preenchendo a lista com os registros vindos do BD
        listaProdutos = (ArrayList<TabelaConsulta>) tbConsulta.buscaPorCodigo(codigo);
        
        // Verificando se a lista está vazia
        if(listaProdutos.isEmpty())
            JOptionPane.showMessageDialog(null, "Não foram encontrados produtos com este código!");
        else
            // Preenchendo a tabela que é exibida
            this.tableConsulta.setItems(FXCollections.observableArrayList(listaProdutos));
        
        // Limpando as opções de busca
        this.txtBuscaCod.clear();
        this.txtBuscaDesc.clear();
    }

    
    
    @FXML
    void buscarDescProduto(ActionEvent event) {
        
        String desc; 
        TabelaConsulta tbConsulta = new TabelaConsulta();
        ArrayList<TabelaConsulta> listaProdutos = new ArrayList<TabelaConsulta>(); 
        
        // "Pegando" a descrição digitada pelo usuário
        desc = this.txtBuscaDesc.getText();
        
        //Preenchendo a lista com os registros vindos do BD
        listaProdutos = (ArrayList<TabelaConsulta>) tbConsulta.buscaPorDescricao(desc);
        
        // Verificando se a lista está vazia
        if(listaProdutos.isEmpty())
            JOptionPane.showMessageDialog(null, "Não foram encontrados produtos com este código!");
        else
            // Preenchendo a tabela que é exibida
            this.tableConsulta.setItems(FXCollections.observableArrayList(listaProdutos));
        
        // Limpando as opções de busca
        this.txtBuscaCod.clear();
        this.txtBuscaDesc.clear();

    }
    
    
    @FXML
    void voltarTela(ActionEvent event) {
        myController.setScreen(ScreensFramework.telaPrincipal);
    }
}
