package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Curso extends Model{
	
	public String nome;
	
	@OneToMany(mappedBy="curso")
	public List<Aluno> alunos;
	
	public Curso(String nome) {
		this.nome = nome;
	}
}