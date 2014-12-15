/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.persistencia;

import java.util.ArrayList;
import java.util.List;
import model.Pagamentovenda;
import model.TabelaConsulta;
import model.Tipopagamento;
import model.Venda;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;
import org.hibernate.type.BigDecimalType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;

/**
 *
 * @author comum
 */
public class DAOPagamento {
    public void pagar(Venda venda, Pagamentovenda pagvenda, Tipopagamento tipopag) {
        
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction(); // Abre-se uma transação
            
            //tutorial: http://howtodoinjava.com/2013/06/28/hibernate-insert-query-tutorial/
            session.save(tipopag);
            session.save(pagvenda);
            session.save(venda);

            //session.getTransaction().commit();      // Realiza definitivamente todas as operações pendentes na transação
            tx.commit();
            //session.disconnect();
            //session.close();            
            //
        } catch (HibernateException ex) {
            tx.rollback();
            ex.printStackTrace();
        }
    }
}
