/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.math.BigDecimal;

/**
 *
 * @author Victor
 */
public class TabelaVenda {
    
    private Integer id;
    private String produto;
    private String valorTotal;
    private Integer quantidade;
    
    //valorTotal = new BigDecimal

    public TabelaVenda() {
    }

    public Integer getId() {
        return id;
    }

    public String getProduto() {
        return produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }

    public TabelaVenda(Integer id, String produto, String valorTotal, Integer quantidade) {
        this.id = id;
        this.produto = produto;
        this.valorTotal = valorTotal;
        this.quantidade = quantidade;
    }
    
    
    
}
