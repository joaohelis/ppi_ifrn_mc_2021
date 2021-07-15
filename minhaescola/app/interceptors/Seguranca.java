package interceptors;

import controllers.Application;
import play.mvc.Before;
import play.mvc.Controller;

public class Seguranca extends Controller{
	
	@Before(unless= {"Application.login", "Application.autenticar"})
	public static void checarAutenticacao() {
		if(session.get("emailUsuarioAutenticado") == null) {
			Application.login();			
		}
	}

}
