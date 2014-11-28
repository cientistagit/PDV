/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.frameworkGerenciaTela.ControlledScreen;
import controller.frameworkGerenciaTela.ScreensController;
import java.math.BigDecimal;
import model.Produto;
import java.net.URL;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import model.Colaborador;
import model.TabelaVenda;
import model.Usuario;
import model.Venda;
import model.Vendaitem;
import view.ScreensFramework;

/**
 * FXML Controller class
 *
 * @author Victor
 */
public class VendaController implements Initializable, ControlledScreen {

    @FXML
    private TableView<TabelaVenda> tableVenda;
    @FXML
    private Label total;
    @FXML
    private TextField idProduto;
    @FXML
    private TextField desconto;
    @FXML
    private TextField valor;
    @FXML
    private TextField quantidade;
    @FXML
    private TextField descricao;
    @FXML
    private CheckBox checkDesconto;
    @FXML
    private Button addBt;
    @FXML
    private Button delBt;
    @FXML
    private Button search;
    @FXML
    private Button btnVoltar;

    //
    //

    private Venda venda = new Venda();
    private Produto p;
    private ScreensController myController;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO                
        tableVenda.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tableVenda.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("produto"));
        tableVenda.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        tableVenda.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<> ("valorTotal") );
        //
        venda.setDataVenda(new Date(System.currentTimeMillis()));
        venda.setNumeroCupomFiscal(Integer.toString(new Random().nextInt(99999)));
        venda.setUsuario(new Usuario(new Colaborador(null, "0000", "<STANDARD>"), null, null));
        venda.setVendaitems(new LinkedHashSet<Vendaitem>());

    }
    
    @FXML
    void btnVoltar_Click(ActionEvent event) {
        myController.setScreen(ScreensFramework.telaPrincipal);
    }

    @FXML
    private void handleCheckDesconto() {
        if (checkDesconto.isSelected()) {
            desconto.setEditable(true);
        } else {
            desconto.setText("0.0");
            desconto.setEditable(false);
        }
    }

    @FXML
    private void handleAddItem() {
        if (p != null) {
            //                        
            //
            p.setValorVenda(p.getValorVenda().multiply(BigDecimal.valueOf(Integer.parseInt(quantidade.getText().trim()))));
            //            
            float d = (p.getValorVenda().floatValue() * Float.parseFloat(desconto.getText())) / 100;            
            p.setValorVenda(p.getValorVenda().subtract(BigDecimal.valueOf(d)));
            //
            float valor = Float.parseFloat(total.getText().trim());
            valor += p.getValorVenda().floatValue();
            total.setText(String.valueOf(convertValue(valor)));
            //
            saveItem(p, Integer.parseInt(quantidade.getText().trim()), d);
            //
            clear();
        }
    }

    @FXML
    private void handleDelItem() {
        TabelaVenda it = tableVenda.getSelectionModel().getSelectedItem();
        if (it != null) {
            tableVenda.getItems().remove(it);
            float valor = Float.parseFloat(total.getText().trim());
            valor -= Float.parseFloat(it.getValorTotal());
            total.setText(String.valueOf(convertValue(valor)));
            clear();
        }
    }

    @FXML
    private void handleSearchProduto() {
        p = new Produto();
        //
        //
        if (!idProduto.getText().trim().equals("")) {
            p.setIdProduto(Integer.parseInt(idProduto.getText().trim()));
            p = p.search(p);
            if (p != null) {
                descricao.setText(p.getDescricao());
                valor.setText(String.valueOf(p.getValorVenda()));
                quantidade.setText("1");
                desconto.setText("0");
            } else {
                JOptionPane.showMessageDialog(null, "Produto não existe!");
            }
        }
    }

    public void clear() {
        idProduto.clear();
        descricao.clear();
        valor.clear();
        idProduto.requestFocus();
        desconto.clear();
        quantidade.clear();
        checkDesconto.setSelected(false);
        desconto.setText("0");
        p = null;
    }

    @Override
    public void setScreenParent(ScreensController screenPage) {
        myController = screenPage;
    }

    public float convertValue(Float val) {
        float v = val;
        v = Math.round(v * 100) / 100f;        

        return v;
    }

    public void saveItem(Produto p, int qtd, float desc) {
        BigDecimal tot = p.getValorVenda();
        BigDecimal valDesc = (BigDecimal.valueOf(desc));
        //        
        //
        TabelaVenda var = new TabelaVenda(p.getIdProduto(), p.getDescricao(), String.valueOf(convertValue(tot.floatValue())), qtd);
        //
        Vendaitem vItem = new Vendaitem(p, this.venda, qtd, tot, valDesc);
        venda.getVendaitems().add(vItem);
        tableVenda.getItems().add(var);
    }

}
