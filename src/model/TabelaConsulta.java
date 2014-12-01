/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import model.persistencia.DAOConsulta;

/**
 *
 * @author Jailton
 */
public class TabelaConsulta {

    private Integer id;
    private String descricao;
    private String tamanho;
    private String cor;
    private BigDecimal preco;

    
    
    public TabelaConsulta(Integer id, String descricao, String tamanho, String cor, BigDecimal preco) {
        this.id = id;
        this.descricao = descricao;
        this.tamanho = tamanho;
        this.cor = cor;
        this.preco = preco;
    }

    public TabelaConsulta() {
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
    
    
    
    public List<TabelaConsulta> buscaPorCodigo(Integer cod){
        
        DAOConsulta dAOConsulta = new DAOConsulta();
        return dAOConsulta.buscaPorCodigo(cod);
    }
    
    
    
    public List<TabelaConsulta> buscaPorDescricao(String desc){
        
        DAOConsulta dAOConsulta = new DAOConsulta();
        return dAOConsulta.buscaPorDescricao(desc);
    }
    
}
