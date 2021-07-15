package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import interceptors.Seguranca;
import models.*;

@With(Seguranca.class)
public class Application extends Controller {
		
	// página inicial do sistema
    public static void index() {    	
        render();
    }
    
    public static void login() {
    	render();
    }
    
    public static void autenticar(String email, String senha) {
    	
    	Usuario usuario = Usuario.find("email=? and senha=?", email, senha).first();
    	
    	if(usuario != null) {
    		session.put("emailUsuarioAutenticado", usuario.email);
    		index();
    	}else {
    		flash.error("Usuário ou senha inválidos!");
    		login();
    	}    	
    }
    
    public static void logout() {
    	session.clear();
    	login();
    }
    
}