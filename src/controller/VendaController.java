/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.frameworkGerenciaTela.ControlledScreen;
import controller.frameworkGerenciaTela.ScreensController;
import java.math.BigDecimal;
import java.math.RoundingMode;
import model.Produto;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;
import model.Colaborador;
import model.TabelaConsulta;
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

    // ##########   Atributos da Tela de Venda  ##########
    
    @FXML
    private AnchorPane paneVenda;
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
    @FXML
    private Button btnPagar;
    @FXML
    private Button botConsultar;
    @FXML
    private Button botSelecionar;

    
    
    // ##########   Atributos da Tela de Consulta  ##########
    
    @FXML
    private AnchorPane paneConsulta;
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
    
        
    private Venda venda = new Venda();
    private Produto p;
    private TabelaConsulta tbConsulta = new TabelaConsulta();
    private ArrayList<TabelaConsulta> listaProdutos = new ArrayList<TabelaConsulta>();
    
    private ScreensController myController;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // Inicialização das colunas da tabela de consulta
        this.columID.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.columDesc.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        this.columTam.setCellValueFactory(new PropertyValueFactory<>("tamanho"));
        this.columCor.setCellValueFactory(new PropertyValueFactory<>("cor"));
        this.columPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        
        // Inicialização das colunas da tabela de venda
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
    void btnPagar_Click(ActionEvent event) {
        myController.setScreen(ScreensFramework.telaPagamento);
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
            p.setValorVenda(p.getValorVenda().setScale(2, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(Integer.parseInt(quantidade.getText().trim()))));
            //            
            float d = (p.getValorVenda().floatValue() * Float.parseFloat(desconto.getText())) / 100;  
            p.setValorVenda(p.getValorVenda().subtract(BigDecimal.valueOf(d)));
            //
            float valor = Float.parseFloat(total.getText());
            valor += p.getValorVenda().setScale(2, RoundingMode.HALF_UP).floatValue();
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
                valor.setText(String.valueOf(p.getValorVenda().setScale(2, RoundingMode.HALF_UP)));
                quantidade.setText("1");
                desconto.setText("0");
            } else {
                JOptionPane.showMessageDialog(null, "Produto não existe!");
            }
        }
    }
    
    @FXML
    void consultarProduto(ActionEvent event) {

        // Deixa de exibir a tela de venda e passa a exibir a tela de consulta
        this.paneVenda.setVisible(false);
        this.paneConsulta.setVisible(true);
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
    
    
    
    
    
    // ##########   Implementação dos métodos da Tela de Venda  ##########
    
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
        
        // "Pegando" a descrição digitada pelo usuário
        desc = this.txtBuscaDesc.getText();
        
        // Verificando se a descrição é válida
        if(desc.length() < 4)
            JOptionPane.showMessageDialog(null, "Descrição inválida. Digite pelo menos 4 caracteres.");
        
        else{
                    
            //Preenchendo a lista com os registros vindos do BD
            listaProdutos = (ArrayList<TabelaConsulta>) tbConsulta.buscaPorDescricao(desc);

            // Verificando se a lista está vazia
            if(listaProdutos.isEmpty())
                JOptionPane.showMessageDialog(null, "Não foram encontrados produtos com esta descrição!");
            else
                // Preenchendo a tabela que é exibida
                this.tableConsulta.setItems(FXCollections.observableArrayList(listaProdutos));
             
        }
        
        // Limpando as opções de busca
        this.txtBuscaCod.clear();
        this.txtBuscaDesc.clear();

    }
          
    
    @FXML
    void selecionarProduto(ActionEvent event) {
        
        this.tbConsulta = tableConsulta.getSelectionModel().getSelectedItem();
        this.quantidade.setText("1");
        this.descricao.setText(this.tbConsulta.getDescricao());
        this.idProduto.setText(Integer.toString(this.tbConsulta.getId()));
        this.valor.setText(this.tbConsulta.getPreco().setScale(2, RoundingMode.HALF_UP).toString());
        this.checkDesconto.setSelected(false);
        this.desconto.setText("0.0");
        
        p = new Produto();
        p.setIdProduto(this.tbConsulta.getId());
        p.setDescricao(this.tbConsulta.getDescricao());
        p.setValorVenda(this.tbConsulta.getPreco().setScale(2, RoundingMode.HALF_UP));
        
        this.paneVenda.setVisible(true);
        this.paneConsulta.setVisible(false);
        
    }
    
    
    @FXML
    void voltarTela(ActionEvent event) {
        
        // Deixa de exibir a tela de venda e passa a exibir a tela de consulta
        this.paneVenda.setVisible(true);
        this.paneConsulta.setVisible(false);
    }

}
