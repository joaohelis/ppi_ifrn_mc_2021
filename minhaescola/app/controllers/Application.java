package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {
	
	@Before(unless= {"login", "autenticar"})
	public static void checarAutenticacao() {
		if(session.get("emailUsuarioAutenticado") == null)
			login();
	}
	
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