package jobs;

import models.Aluno;
import models.Curso;
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
		
		Curso curso = null;
		Curso curso2 = null;

		if(Curso.count() == 0) {
			curso = new Curso("Informática");
			curso.save();
			
			curso2 = new Curso("Química");
			curso2.save();
		}
		
		if(Aluno.count() == 0) {
			Aluno aluno = new Aluno();
			aluno.nome = "Fulano";
			aluno.curso = curso;
			aluno.save();
			
			Aluno aluno2 = new Aluno();
			aluno2.nome = "Sicrano";
			aluno2.curso = curso2;
			aluno2.save();
		}
	}
}
