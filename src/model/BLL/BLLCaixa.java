/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.BLL;

import java.math.BigDecimal;
import java.util.Date;
import model.Caixa;
import model.persistencia.DAOCaixa;

/**
 *
 * @author Xande
 */
public class BLLCaixa {
    
    public static boolean AbrirCaixa() {
        //confirmar data, usuario e valor do fundo de caixa.      
        
        Date date = new Date();
        
        Caixa caixa = new Caixa();
        caixa.setUsuario(BLLUsuario.usuarioLogin);
        caixa.setDataAbertura(date);
        caixa.setValorInicial(BigDecimal.ZERO);

        //gravar no banco        
       
        DAOCaixa daoCaixa = new DAOCaixa();
        daoCaixa.GravarAbertura(caixa);
    
        return false;
    }
    
    public static boolean temCaixaAberto(Date data){
        DAOCaixa daoCaixa = new DAOCaixa();
        Caixa caixa = null;
        
        caixa = daoCaixa.buscarPorData(data);
        
        if(caixa!=null)
            return true;
        else
            return false;
    }
    
}
