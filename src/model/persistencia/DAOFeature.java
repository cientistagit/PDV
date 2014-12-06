/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.persistencia;


import java.util.Iterator;
import java.util.List;
import model.Feature;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Xande
 */
public class DAOFeature {
    
    public List<Feature> listar() {
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession(); 
        try { 
            session.beginTransaction(); // Abre-se uma transação                      
            String hql = "from Feature";
            Query query = session.createQuery(hql);             
            return (List<Feature>)query.list();           
 
        } catch (Exception ex) {            
            System.out.println(ex);
            return null;
        }
    }
    
    public Feature buscar(String pDescricao){
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession(); 
        try { 
            session.beginTransaction(); // Abre-se uma transação                      
            String hql = "from Feature where descricao = :pDescricao";
            Query query = session.createQuery(hql);   
            query.setParameter("pDescricao", pDescricao);
            return (Feature) query.uniqueResult();
 
        } catch (Exception ex) {            
            System.out.println(ex);
            return null;
        }
    }
    
}
