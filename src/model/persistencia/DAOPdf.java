/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.persistencia;

import java.util.ArrayList;
import model.*;
import model.Produto;
import model.Venda;
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
            tx = session.getTransaction(); // Abre-se uma transação
            tx.begin();

            String hql = "from Produto";
            Query query = session.createQuery(hql);

            //session.getTransaction().commit();      // Realiza definitivamente todas as operações pendentes na transação
            tx.commit();
            //session.disconnect();
            //session.close();                        
            prod = (ArrayList<Produto>) (query.list());
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

    public ArrayList<Colaborador> allFuncionario() {
        ArrayList<Colaborador> col = null;
        //Session session = NovoHibernateUtil.getSessionFactory().getCurrentSession();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction(); // Abre-se uma transação

            String hql = "from Colaborador";
            Query query = session.createQuery(hql);

            //session.getTransaction().commit();      // Realiza definitivamente todas as operações pendentes na transação
            tx.commit();
            //session.disconnect();
            //session.close();                        
            col = (ArrayList<Colaborador>) query.list();
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

        return col;
    }

    //////
    //////
    public ArrayList<Caixa> allCaixa() {
        ArrayList<Caixa> cx = null;
        //Session session = NovoHibernateUtil.getSessionFactory().getCurrentSession();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction(); // Abre-se uma transação

            String hql = "from Caixa";
            Query query = session.createQuery(hql);

            //session.getTransaction().commit();      // Realiza definitivamente todas as operações pendentes na transação
            tx.commit();
            //session.disconnect();
            //session.close();            
            cx = (ArrayList<Caixa>) (query.list());
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

        return cx;
    }

    public ArrayList<Venda> allVendaVendedor(int idVendedor) {
        ArrayList<Venda> vd = null;
        //Session session = NovoHibernateUtil.getSessionFactory().getCurrentSession();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction(); // Abre-se uma transação

            String hql = "from Venda v where v.usuario_id = :x";
            Query query = session.createQuery(hql).setInteger("x", idVendedor);

            //session.getTransaction().commit();      // Realiza definitivamente todas as operações pendentes na transação
            tx.commit();
            //session.disconnect();
            //session.close();            
            vd = (ArrayList<Venda>) (query.list());
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

        return vd;
    }

    public ArrayList<Venda> allVendaCaixa(int idCaixa) {
        ArrayList<Venda> vd = null;
        //Session session = NovoHibernateUtil.getSessionFactory().getCurrentSession();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction(); // Abre-se uma transação

            String hql = "from Venda v where v.caixa_id = :x";
            Query query = session.createQuery(hql).setInteger("x", idCaixa);

            //session.getTransaction().commit();      // Realiza definitivamente todas as operações pendentes na transação
            tx.commit();
            //session.disconnect();
            //session.close();            
            vd = (ArrayList<Venda>) (query.list());
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

        return vd;
    }

}
