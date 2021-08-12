package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Curso extends Model{
	
	@Required
	public String nome;
	
	@OneToMany(mappedBy="curso")
	public List<Aluno> alunos;
	
	@ManyToMany(mappedBy="cursos")
	public List<Categoria> categorias;	
	
	public Curso(String nome) {
		this.nome = nome;
	}
}