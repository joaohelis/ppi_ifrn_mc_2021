package controllers;

import java.util.List;

import models.Aluno;
import models.Curso;
import play.cache.Cache;
import play.data.validation.Valid;
import play.mvc.Controller;

public class Alunos extends Controller{
	
	public static void paginaInicial() {
		renderTemplate("Alunos/index.html");
	}
	
	public static void form() {
		
		Aluno aluno = (Aluno) Cache.get("alu");
		Cache.clear();
		
		List<Curso> cursos = Curso.findAll();			
		render(cursos, aluno);
	}
	
	public static void listar() {
		List<Aluno> alunos = Aluno.findAll();
		render(alunos);
	}
	
	public static void editar(Long id) {
		Aluno aluno = Aluno.findById(id);
		List<Curso> cursos = Curso.findAll();
		renderTemplate("Alunos/form.html", aluno, cursos);
	}
	
//  EXEMPLO DE LISTAGEM COM ENTIDADES UTILIZANDO EXCLUSÃO LÓGICA
//	public static void listar() {
//		List<Aluno> alunos = Aluno.find("ativo", true).fetch();
//		render(alunos);
//	}
	
	public static void remover(Long id) {
		Aluno aluno = Aluno.findById(id);
		aluno.delete();
		listar();
	}
	
	// EXEMPLO DE EXCLUSÃO LÓGICA
//	public static void remover(Long id) {
//		Aluno aluno = Aluno.findById(id);
//		aluno.ativo = false;
//		aluno.save();
//		listar();
//	}
	
//	public static void salvar(String nome, String matricula, 
//			String cpf, Date dataNascimento, Long id) {
//		Aluno aluno;
//		if(id == null)
//			aluno = new Aluno();
//		else
//			aluno = Aluno.findById(id);		
//		aluno.id = id;
//		aluno.nome = nome;
//		aluno.cpf = cpf;
//		aluno.matricula = matricula;
//		aluno.dataNascimento = dataNascimento;
//		aluno.save();
//		listar();
//	}
	
	public static void salvar(@Valid Aluno aluno) {
		
		if(validation.hasErrors()) {
			Cache.add("alu", aluno);
			validation.keep();
			form();
		}		
		aluno.save();
		listar();
	}
	
	public static void renderFotoAluno(Long idAluno) {
		Aluno aluno = Aluno.findById(idAluno);
		response.setContentTypeIfNotSet(aluno.foto.type());
		renderBinary(aluno.foto.get());		
	}
	
}