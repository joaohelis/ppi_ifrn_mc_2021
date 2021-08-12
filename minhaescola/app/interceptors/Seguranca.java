package interceptors;

import annotations.Administrador;
import controllers.Application;
import play.mvc.Before;
import play.mvc.Controller;

public class Seguranca extends Controller {

//	@Before(unless = { "Application.login", "Application.autenticar" })
//	public static void checarAutenticacao() {
//		if (session.get("emailUsuarioAutenticado") == null) {
//			Application.login();
//		}
//	}

	@Before
	static void checarAdministrador() {
		String tipoUsuario = session.get("tipoUsuario");
		Administrador adminAnnotation = getActionAnnotation(Administrador.class);
		if (adminAnnotation != null && !tipoUsuario.equals("ADMIN")) {
			flash.error("Acesso restrito aos administradores do sistema");
			Application.login();
		}
	}

}
