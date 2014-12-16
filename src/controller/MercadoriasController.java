/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.itextpdf.text.DocumentException;
import controller.frameworkGerenciaTela.ControlledScreen;
import controller.frameworkGerenciaTela.ScreensController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javax.swing.JOptionPane;
import view.ScreensFramework;

/**
 * FXML Controller class
 *
 * @author Xande
 */
public class MercadoriasController implements Initializable, ControlledScreen {

    ScreensController myController;
    PdfController pdf = new PdfController();
    
    @FXML private Button btnRelEntradas;
    @FXML private Button btnRelSaidas;
    @FXML private Button btnVoltar;
    @FXML private Button btnRelEstoque;
    
    @FXML 
    void btnRelEstoque_click(ActionEvent event) {
        try {
            pdf.createPdf(pdf.ESTOQUE_TYPE);
            JOptionPane.showMessageDialog(null, "Relatorio de Estoque Gerado com Sucesso");
        } catch (Exception ex) {
            Logger.getLogger(MercadoriasController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Gerar Relatorio de Estoque");
        }
    }

    @FXML
    void btnRelEntradas_click(ActionEvent event) {

    }

    @FXML
    void btnRelSaidas_click(ActionEvent event) {

    }

    @FXML
    void btnVoltar_click(ActionEvent event) {
        myController.setScreen(ScreensFramework.telaRelatorios);
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
