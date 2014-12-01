/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.persistencia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.lang.String;
import model.TabelaConsulta;
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
 * @author Jailton
 */
public class DAOConsulta {
    
    
    public List buscaPorCodigo(Integer cod) {
        
        List lista = new ArrayList<>();
        
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction(); // Abre-se uma transação

            String sql = "select prodg.produto_id as id, prod.descricao as descricao, tam.descricao as tamanho, cor.descricao as cor, prod.valor_venda as preco" +
                            " from PRODUTOGRADE prodg, PRODUTO prod, TAMANHO tam, COR cor " +
                            " where prodg.produto_id = prod.id_produto " +
                                " and prodg.tamanho_id = tam.id_tamanho " +
                                " and prodg.cor_id = cor.id_cor " +
                            " and prodg.produto_id = :cod " +
                            "order by id, descricao, cor, tamanho asc";
          
            Query query = session.createSQLQuery(sql)   
                    .addScalar("id", IntegerType.INSTANCE)
                    .addScalar("descricao", StringType.INSTANCE)
                    .addScalar("tamanho", StringType.INSTANCE)
                    .addScalar("cor", StringType.INSTANCE)
                    .addScalar("preco", BigDecimalType.INSTANCE)
                    .setInteger("cod", cod)
                    .setResultTransformer(Transformers.aliasToBean(TabelaConsulta.class));
            
                    
            lista = query.list();

            //session.getTransaction().commit();      // Realiza definitivamente todas as operações pendentes na transação
            tx.commit();
            //session.disconnect();
            //session.close();            
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

        return lista;
    }
    
    
    
    public List buscaPorDescricao(String desc) {
        //Concatenando String para uso do comando sql LIKE 
        String descr = "%"+desc+"%";
        List lista = new ArrayList<>();
        
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction(); // Abre-se uma transação

            String sql = "select prodg.produto_id as id, prod.descricao as descricao, tam.descricao as tamanho, cor.descricao as cor, prod.valor_venda as preco" +
                            " from PRODUTOGRADE prodg, PRODUTO prod, TAMANHO tam, COR cor " +
                            " where prodg.produto_id = prod.id_produto " +
                                " and prodg.tamanho_id = tam.id_tamanho " +
                                " and prodg.cor_id = cor.id_cor " +
                            " and prod.descricao like :desc " +
                            " order by descricao, cor, tamanho asc";
          
            Query query = session.createSQLQuery(sql)   
                    .addScalar("id", IntegerType.INSTANCE)
                    .addScalar("descricao", StringType.INSTANCE)
                    .addScalar("tamanho", StringType.INSTANCE)
                    .addScalar("cor", StringType.INSTANCE)
                    .addScalar("preco", BigDecimalType.INSTANCE)
                    .setString("desc", descr)
                    .setResultTransformer(Transformers.aliasToBean(TabelaConsulta.class));
            
                    
            lista = query.list();

            //session.getTransaction().commit();      // Realiza definitivamente todas as operações pendentes na transação
            tx.commit();
            //session.disconnect();
            //session.close();            
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

        return lista;
    }
}
