/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.persistencia;

import model.Caixaaberturafechamento;
import model.Colaborador;
import model.Usuario;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 *
 * @author Xande
 */
public class DAOCaixa {

    public void GravarAbertura(Caixaaberturafechamento caixa) {        

       // AGORA É PRECISO ENVIAR O caia PARA o BD
        // ASSIM, CRIA-SE UMA SESSÃO PARA ISTO
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
 
        try {
 
            session.beginTransaction(); // Abre-se uma transação
            session.save(caixa);      // Acumula a operação de gravação do objeto cliente no BD, na transação
            session.getTransaction().commit();   // Realiza definitivamente todas as operações pendentes na transação
            //exibir mensagem de confirmação
 
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ex);
            //mensagem de erro
 
        }

        //gravar abertura no banco
        
    }

}
