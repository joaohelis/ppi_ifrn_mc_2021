package controllers;

import java.util.Date;
import java.util.List;

import models.Aluno;
import play.mvc.Controller;

public class Alunos extends Controller{
	
	public static void form() {
		render();
	}
	
	public static void listar() {
		List<Aluno> alunos = Aluno.findAll();
		render(alunos);
	}
	
	public static void salvar(String nome, String matricula, 
			String cpf, Date dataNascimento) {		
		Aluno aluno = new Aluno();
		aluno.nome = nome;
		aluno.cpf = cpf;
		aluno.matricula = matricula;
		aluno.dataNascimento = dataNascimento;
		aluno.save();
		listar();
	}

}
