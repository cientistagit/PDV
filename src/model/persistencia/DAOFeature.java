/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.persistencia;


import java.util.Iterator;
import java.util.List;
import model.Feature;
import org.hibernate.Session;

/**
 *
 * @author Xande
 */
public class DAOFeature {
    
    public List<Feature> listar() {
 
        // VAMOS listar OS usuarios do BD
        // ASSIM, CRIA-SE UMA SESSÃO PARA ISTO
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
 
        try {
 
            session.beginTransaction(); // Abre-se uma transação
            // Cria-se uma lista de usuarios a partir do BD
            List listaFeatures = session.createQuery("from feature").list();
            return listaFeatures;           
 
            //JOptionPane.showMessageDialog(null, "Usuarios listados com sucesso");
 
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex);
            return null;
        }
    }
    
}
