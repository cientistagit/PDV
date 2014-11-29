/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.BLL;

import model.Usuario;
import model.persistencia.DAOUsuario;

/**
 *
 * @author Xande
 * Classe que contém toda a lógica de negócio relacionada a usuário
 */
public class BLLUsuario {
    public static Usuario usuarioLogin = null;
    
    public static boolean validarLogin(String pLogin, String pSenha){

        //busco usuário utilizando login e senha
        DAOUsuario dAOUsuario = new DAOUsuario();
        Usuario usuario  = dAOUsuario.buscar(pLogin, pSenha);
        usuarioLogin = usuario;

        return usuario!=null;
    }    
    
}
