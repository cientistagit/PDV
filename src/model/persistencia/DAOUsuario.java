/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.persistencia;

import model.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Jailton
 */
public class DAOUsuario {
    
    
    public boolean validarLogin(Usuario usuario){
        boolean result;
        result = false;
        
        //Session session = NovoHibernateUtil.getSessionFactory().getCurrentSession();
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        
        try {
            tx = session.beginTransaction(); // Abre-se uma transação
            
            String hql = "from Usuario u where u.login = :login and u.senha = :senha";
            Query query = session.createQuery(hql);
            query.setParameter("login", usuario.getLogin());
            query.setParameter("senha", usuario.getSenha());
            
            
            if(query.uniqueResult() == null)
                result = false;
            else
                result = true;
            
            //session.getTransaction().commit();      // Realiza definitivamente todas as operações pendentes na transação
            tx.commit();
            //session.disconnect();
            //session.close();
        } catch (HibernateException ex) {
            tx.rollback();
            ex.printStackTrace();
        }
        /*
        finally{
            session.close();
        }
        */
        
        return result;
    }
    
    
    /*
    public void armazenar(Usuario usuario) {
 
        // AGORA É PRECISO ENVIAR O usuario PARA o BD
        // ASSIM, CRIA-SE UMA SESSÃO PARA ISTO
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
 
        try {
            session.beginTransaction(); // Abre-se uma transação
            session.save(usuario);      // Acumula a operação de gravação do objeto usuario no BD, na transação
            session.getTransaction().commit();   // Realiza definitivamente todas as operações pendentes na transação
            //JOptionPane.showMessageDialog(null, "Usuario armazenado com sucesso");
 
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ex);
 
        }
    }
    */
    
    /*
    public void alterar(Usuario usuario) {
 
        // VAMOS ATUALIZAR O usuario PARA o BD
        // ASSIM, CRIA-SE UMA SESSÃO PARA ISTO
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
 
        try {
            session.beginTransaction(); // Abre-se uma transação
            session.merge(usuario);      // Acumula a operação de alteração do objeto usuario no BD, na transação
            session.getTransaction().commit();   // Realiza definitivamente todas as operações pendentes na transação
            //JOptionPane.showMessageDialog(null, "Usuario alterado com sucesso");
 
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ex);
 
        }
    }
    */
    
    /*
    public void excluir(Usuario usuario) {
 
        // VAMOS EXCLUIR O usuario do BD
        // ASSIM, CRIA-SE UMA SESSÃO PARA ISTO
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
 
        try {
            session.beginTransaction(); // Abre-se uma transação
            session.delete(usuario);    // Acumula a operação de exclusão do objeto usuario no BD, na transação
            session.getTransaction().commit();   // Realiza definitivamente todas as operações pendentes na transação
            //JOptionPane.showMessageDialog(null, "Usuario excluído com sucesso");
 
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ex);
 
        }
    }
    */
    
    /*
    public void listar() {
 
        // VAMOS listar OS usuarios do BD
        // ASSIM, CRIA-SE UMA SESSÃO PARA ISTO
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
 
        try {
 
            session.beginTransaction(); // Abre-se uma transação
            // Cria-se uma lista de usuarios a partir do BD
            List listaUsuarios = session.createQuery("From Usuario").list();
            
            for (Iterator it = listaUsuarios.iterator(); it.hasNext();) {
                Usuario usuario = (Usuario) it.next();
                System.out.println("Nome do usuario: " + usuario.getNome());
                //System.out.println("CPF do usuario: " + usuario.getCpf());
                //System.out.println("Endereço do usuario: " + usuario.getEndereco());
            }
 
            //JOptionPane.showMessageDialog(null, "Usuarios listados com sucesso");
 
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ex);
 
        }
    }
    */
    
}
