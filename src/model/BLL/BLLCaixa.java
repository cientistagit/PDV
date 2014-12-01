/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.BLL;

import java.math.BigDecimal;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Caixa;
import model.persistencia.DAOCaixa;

/**
 *
 * @author Xande
 */
public class BLLCaixa {
    
    public static boolean abrirCaixa() {
        //confirmar data, usuario e valor do fundo de caixa.   
        Date date = new Date();
        
        Caixa caixa = new Caixa();
        caixa.setUsuario(BLLUsuario.usuarioLogin);
        caixa.setDataAbertura(date);
        caixa.setValorInicial(BigDecimal.ZERO);

        //gravar no banco        
       
        DAOCaixa daoCaixa = new DAOCaixa();
        try{
            daoCaixa.GravarAbertura(caixa);
            //mostrar mensagem de confirmação
            JOptionPane.showMessageDialog(null, "Caixa aberto com sucesso!");
            return true;
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            return false;
        }
        
    }
    
    public static boolean fecharCaixa()
    {
        Date data = new Date();
        DAOCaixa daoCaixa = new DAOCaixa();
        Caixa caixa = null;
        caixa = daoCaixa.buscarPorData(data);
         try{
            daoCaixa.fecharCaixa(caixa);
            //mostrar mensagem de confirmação
            JOptionPane.showMessageDialog(null, "Caixa fechado com sucesso!");
            return true;
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Caixa nao foi fechado!");
            return false;
        }
    }
    
    public static Caixa temCaixaAberto(Date data){
        DAOCaixa daoCaixa = new DAOCaixa();
        Caixa caixa = null;
        
        caixa = daoCaixa.buscarPorData(data);
        
        if(caixa!=null)
            return caixa;
        else
            return null;
    }
    
    public static double obterValorCaixa(Date data)
    {
        return 0;
    }
    
}
