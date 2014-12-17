/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.persistencia;

import org.hibernate.Session;

/**
 *
 * @author Xande
 */
public class DB {
        public static Session session;
    
    public static Session getSession(){
    if (session==null || !(session.isOpen()))
        return NewHibernateUtil.getSessionFactory().getCurrentSession();    
    else return session;
    }
    
}
