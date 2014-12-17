/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.persistencia;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Jailton
 */
public class NewHibernateUtil {
    
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
 
  private static SessionFactory configureSessionFactory() throws HibernateException {
      Configuration configuration = new Configuration();
      configuration.configure();
      serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();        
      sessionFactory = configuration.buildSessionFactory(serviceRegistry);
      return sessionFactory;
  }  
 
    public static SessionFactory getSessionFactory() {
        return configureSessionFactory();               
    }
        
}
