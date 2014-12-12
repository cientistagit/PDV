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
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import model.BLL.BLLCaixa;
import model.BLL.BLLUsuario;
import model.Caixa;
import view.ScreensFramework;

/**
 * FXML Controller class
 *
 * @author Xande
 */
public class CaixaController implements Initializable, ControlledScreen {

    /**
     * Initializes the controller class.
     */
    
    @FXML private Button btnSuprimento;
    @FXML private Button btnFecharCaixa;
    @FXML private Button btnAbrirCaixa;
    @FXML private Button btnSangria;    
    @FXML private Button btnVoltar;   
    @FXML private Label lblCaixa;   
    @FXML private Label lblValorCaixa;    
    @FXML private Label lblUsuario;
    @FXML private Button btnConferenciaCaixa;        
    @FXML private Label label1;
    @FXML private Label lblValor;
    
    ScreensController myController;
    
    @FXML
    void btnVoltar_Click(ActionEvent event) {
        myController.setScreen(ScreensFramework.telaPrincipal);
    }
    
@FXML
    void btnAbrirCaixa_Click(ActionEvent event) {        
        if(BLLCaixa.abrirCaixa())
        {
            btnAbrirCaixa.setDisable(true);
            lblCaixa.setText("CAIXA ABERTO ");
            this.setExibicaoCaixaAberto(true);
            lblUsuario.setText(BLLUsuario.usuarioLogin.getColaborador().getNome());
        }
    }

    @FXML
    void btnFecharCaixa_Click(ActionEvent event) {
        
        if(BLLCaixa.fecharCaixa())
        {
            btnAbrirCaixa.setDisable(false);
            lblCaixa.setText("CAIXA FECHADO ");
            this.setExibicaoCaixaAberto(false);            
        }

    }

    @FXML
    void btnSuprimento_Click(ActionEvent event) {
        double valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Insira o valor ADICIONADO ao caixa. (R$)").replace(',', '.'));
        //lógica
        
        //confirmação
        JOptionPane.showMessageDialog(null, "Suprimento registrado com sucesso!","Confirmação", INFORMATION_MESSAGE);
    }

    @FXML
    void btnSangria_Click(ActionEvent event) {
        double valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Insira o valor RETIRADO do caixa. (R$)").replace(',', '.'));
        //lógica
        
        //confirmação
        JOptionPane.showMessageDialog(null, "Sangria registrada com sucesso!","Confirmação", INFORMATION_MESSAGE);
    }    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Date data = new Date();
        Caixa caixa = BLLCaixa.temCaixaAberto(data);
        if(caixa != null)
        {            
            btnAbrirCaixa.setDisable(true);
            lblCaixa.setText("CAIXA ABERTO ");
            this.setExibicaoCaixaAberto(true);
            lblUsuario.setText(caixa.getUsuario().getColaborador().getNome());
            lblValorCaixa.setText(NumberFormat.getCurrencyInstance().format(BLLCaixa.obterValorCaixa(data)));
        }
        else
        {
            btnFecharCaixa.setDisable(true);
            lblCaixa.setText("CAIXA FECHADO");
            this.setExibicaoCaixaAberto(false);
        }
    }    
    
    private void setExibicaoCaixaAberto(boolean pExibir)
    {
        lblValor.setVisible(pExibir);
        lblValorCaixa.setVisible(pExibir);
        lblUsuario.setVisible(pExibir);
        label1.setVisible(pExibir);
        btnConferenciaCaixa.setVisible(pExibir);
        
    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }
    
}
