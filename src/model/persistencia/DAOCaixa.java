/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.persistencia;


import java.util.Calendar;
import java.util.Date;
import model.Caixa;
import org.hibernate.Query;
import org.hibernate.Session;


/**
 *
 * @author Xande
 */
public class DAOCaixa {

    public void GravarAbertura(Caixa caixa) {        

       // AGORA É PRECISO ENVIAR O caia PARA o BD
        // ASSIM, CRIA-SE UMA SESSÃO PARA ISTO
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
 
        try {
 
            session.beginTransaction(); // Abre-se uma transação
            session.save(caixa);      // Gravar abertura no banco        
            session.getTransaction().commit();   // Realiza definitivamente todas as operações pendentes na transação            
            
            //exibir mensagem de confirmação
 
        } catch (Exception ex) {
            System.out.println(ex);
            //JOptionPane.showMessageDialog(null, ex);
            //mensagem de erro
 
        }       
    }
    
    public void fecharCaixa(Caixa caixa) {        
               
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Date dataFechamento = new Date();
        try {
            caixa.setDataFechamento(dataFechamento);            
            session.beginTransaction();
            session.saveOrUpdate(caixa);      
            session.getTransaction().commit();   // Realiza definitivamente todas as operações pendentes na transação                                    
 
        } catch (Exception ex) {            
            //System.out.println(ex);
            session.getTransaction().rollback();
            throw ex;
            //JOptionPane.showMessageDialog(null, ex);
            //mensagem de erro
 
        }       
    }        
    
    public Caixa buscarPorData(Date pData){
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        
        //problema: como o campo do banco datetime é dd/mm/aaaa hh:mm:ss e eu quero comparar apenas a data eu coloco um between
        Calendar calendar = Calendar.getInstance();      
        calendar.setTime(pData);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);        
        Date fromDate = calendar.getTime();

        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        Date toDate = calendar.getTime();
        
        try { 
            session.beginTransaction(); // Abre-se uma transação                 
            //String hql = "from Caixa c where c.dataAbertura between :from and :to and c.dataFechamento is null";            
            String hql = "from Caixa c where c.dataAbertura between :from and :to and c.dataFechamento is null";
            Query query = session.createQuery(hql);   
            query.setParameter("from", fromDate);
            query.setParameter("to", toDate);
           
            Caixa caixa = (Caixa) query.uniqueResult();  
            session.close();
            return caixa;
        } catch (Exception ex) {
            System.out.println(ex);
        }                
        return null;   
    }

}
