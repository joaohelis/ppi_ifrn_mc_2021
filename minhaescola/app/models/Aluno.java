package models;

import java.util.Date;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Aluno extends Model {
	
	public String nome;
	public String cpf;
	public String matricula;
	public Date dataNascimento;
	public boolean ativo;
	
	public Aluno() {
		this.ativo = true;
	}
	
	public int calcularIdade() {		
		Date dataAtual = new Date();
		return 10;
	}

}
