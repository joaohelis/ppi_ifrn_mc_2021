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
    	long totalAlunos = Aluno.count();
    	long totalCursos = Curso.count();    	    	    	
        render(totalAlunos, totalCursos);
    }
    
    public static void login() {
    	render();
    }
    
    public static void autenticar(String email, String senha) {
    	
    	Usuario usuario = Usuario.find("email=? and senha=?", email, senha).first();
    	    	
    	if(usuario != null && usuario instanceof Aluno) {
    		
    		session.put("usuarioID", usuario.id);
    		session.put("emailUsuarioAutenticado", usuario.email);
    		session.put("tipoUsuario", "ALUNO");  
    		session.put("nomeArquivoMain", "main-aluno.html");
    		
    		Aluno aluno = (Aluno) usuario;    		    		
    		
    		if(aluno.foto.exists()) {
    			session.put("alunoTemFoto", true);
    		}    		
    		
    		Alunos.paginaInicial();
    	}else if (usuario != null && usuario instanceof Admin) {
    		session.put("emailUsuarioAutenticado", usuario.email);
    		session.put("tipoUsuario", "ADMIN");  
    		session.put("nomeArquivoMain", "main-admin.html");
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