/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.persistencia;

import java.util.ArrayList;
import model.Produto;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Victor
 */
public class DAOPdf {

    public ArrayList<Produto> allProduct() {
        ArrayList<Produto> prod = null;
        //Session session = NovoHibernateUtil.getSessionFactory().getCurrentSession();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction(); // Abre-se uma transação

            String hql = "from Produto";
            Query query = session.createQuery(hql);            

            //session.getTransaction().commit();      // Realiza definitivamente todas as operações pendentes na transação
            tx.commit();
            //session.disconnect();
            //session.close();            
            prod.addAll(query.list());            
            //
        } catch (HibernateException ex) {
            tx.rollback();
            ex.printStackTrace();
        }
        /*
         finally{
         session.close();
         }
         */

        return prod;
    }
    ///
    ///
    //Venda...
    ////Item Venda...
    //////Produto...

}
