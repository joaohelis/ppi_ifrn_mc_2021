package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import play.db.jpa.Blob;
import play.db.jpa.Model;

@Entity
public class Aluno extends Model {
	
	public String nome;
	public String cpf;
	public String matricula;
	public Date dataNascimento;
	public boolean ativo;
	
	public Blob foto;
	
	@ManyToOne
	@JoinColumn(name="curso_id")
	public Curso curso; 
	
	public Aluno() {
		this.ativo = true;
	}
	
	public int calcularIdade() {		
		Date dataAtual = new Date();
		return 10;
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + "]";
	}
}
