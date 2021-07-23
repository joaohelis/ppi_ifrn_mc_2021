package controllers;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import interceptors.Seguranca;
import models.Aluno;
import models.Curso;
import play.mvc.Controller;
import play.mvc.With;

@With(Seguranca.class)
public class Cursos extends Controller {
	
	public static void form() {
		List<Aluno> alunos = Aluno.findAll();	
		render(alunos);
	}
	
	public static void editar(Long id) {
		Curso curso = Curso.findById(id);
		List<Aluno> alunos = Aluno.findAll();
		renderTemplate("Cursos/form.html", curso, alunos);
	}
	
	public static void remover(Long id) {
		Curso curso = Curso.findById(id);
		curso.delete();	
		listar();
	}
	
	public static void detalhes(Long id) {
		Curso curso = Curso.findById(id);
		render(curso);
	}
	
	public static void listar() {
		List<Curso> cursos = Curso.findAll();
		render(cursos);
	}
	
	public static void salvar(Curso curso) {
		curso.save();
		listar();
	}

}
