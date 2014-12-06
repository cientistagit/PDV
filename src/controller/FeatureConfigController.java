/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.util.CheckBoxTableCell;
import controller.frameworkGerenciaTela.ControlledScreen;
import controller.frameworkGerenciaTela.ScreensController;
import java.net.URL;
import java.time.Clock;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import model.Feature;
import model.persistencia.DAOFeature;
import view.ScreensFramework;

/**
 * FXML Controller class
 *
 * @author Xande
 */
public class FeatureConfigController implements Initializable, ControlledScreen {
    
    @FXML
    private TableView<Feature> tableFeature;    
    @FXML
    private TableColumn<Feature, Boolean> colunaCheck;   
    @FXML
    private Button btnDesativar;
    @FXML
    private Button btnAtivar;    
    @FXML
    private Button btnVoltar;
        
    ScreensController myController;     
    
    @FXML
    void btnVoltar_click(ActionEvent event) {
        myController.setScreen(ScreensFramework.telaLogin);
    }    
    
    @FXML
    void btnAtivar_click(ActionEvent event) {
        //List<Feature> features = tableFeature.getItems();
        List<Feature> features = tableFeature.getSelectionModel().getSelectedItems();
        for(Feature feature : features)
        {   
            
            System.out.println(feature.isAtiva());
        }

    }

    @FXML
    void btnDesativar_click(ActionEvent event) {

    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        List<Feature> listaFeatures = null;
        DAOFeature dao = new DAOFeature();
        
        //obtenho a lista de features
        listaFeatures = dao.listar();
        
        // Inicialização das colunas da tabela de features
        tableFeature.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("ativa"));        
        tableFeature.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("idFeature"));
        tableFeature.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("descricao"));
        tableFeature.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("statusString"));
        colunaCheck.setCellFactory((new Callback<TableColumn<Feature, Boolean>, TableCell<Feature, Boolean>>() {
            @Override
            public TableCell<Feature, Boolean> call(TableColumn<Feature, Boolean> p) {
                return new CheckBoxTableCell<Feature, Boolean>();
            }
        }));
        colunaCheck.setEditable(true);
        tableFeature.setEditable(true);
        
        /*
        ObservableList<Feature> data = FXCollections.observableArrayList();
        data.add(new Feature());
        data.add(new Feature());
        tableFeature.setItems(data);
                */
        //adiciona as features na tabela
        for (Feature feature : listaFeatures) {
            tableFeature.getItems().add(feature);
        }        
    }    
    
    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }        
}
