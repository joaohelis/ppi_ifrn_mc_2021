package jobs;

import models.Usuario;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class Inicializador extends Job {
	
	@Override
	public void doJob() throws Exception {
		if(Usuario.count() == 0) {
			Usuario usuario = new Usuario();
			usuario.email = "joao.helis@ifrn.edu.br";
			usuario.senha = "123";
			usuario.save();
			
			Usuario usuario2 = new Usuario();
			usuario2.email = "felipe@ifrn.edu.br";
			usuario2.senha = "123";
			usuario2.save();
		}		
	}
}