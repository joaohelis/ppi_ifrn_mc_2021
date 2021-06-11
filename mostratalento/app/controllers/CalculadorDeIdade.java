package controllers;

import play.mvc.Controller;

public class CalculadorDeIdade extends Controller {
	
	public static void formularioDeCalculoIdade() {
		renderTemplate("CalculadorDeIdade/form.html");
	}
	
	public static void calcularIdade(Integer anoNascimento) {		
		Integer anoAtual = 2021;
		int idade = anoAtual - anoNascimento;
		render(idade);
	}

}
