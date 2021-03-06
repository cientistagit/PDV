package model;
// Generated 12/11/2014 11:53:29 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Cargo generated by hbm2java
 */
public class Cargo  implements java.io.Serializable {


     private Integer idCargo;
     private String descricao;
     private Set colaboradors = new HashSet(0);

    public Cargo() {
    }

	
    public Cargo(String descricao) {
        this.descricao = descricao;
    }
    public Cargo(String descricao, Set colaboradors) {
       this.descricao = descricao;
       this.colaboradors = colaboradors;
    }
   
    public Integer getIdCargo() {
        return this.idCargo;
    }
    
    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Set getColaboradors() {
        return this.colaboradors;
    }
    
    public void setColaboradors(Set colaboradors) {
        this.colaboradors = colaboradors;
    }




}


