/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.hibernate.annotations.Type;


/**
 *
 * @author Xande
 */

public class Feature implements java.io.Serializable {

    private Integer idFeature;
    private String descricao;
        
    @Type(type = "numeric_boolean")
    private boolean status;

    public Feature() {
    }

    public Feature(Integer idFeature) {
        this.idFeature = idFeature;
    }

    public Feature(Integer idFeature, String descricao, boolean status) {
        this.idFeature = idFeature;
        this.descricao = descricao;
        this.status = status;
    }

    public Integer getIdFeature() {
        return idFeature;
    }

    public void setIdFeature(Integer idFeature) {
        this.idFeature = idFeature;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }   
    
}
