package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProfesoresCursosId implements Serializable {
	@Column
	private Profesores profesor;
	@Column
	private Cursos Curso;
	public ProfesoresCursosId() {
		super();
	}
	public Profesores getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesores profesor) {
		this.profesor = profesor;
	}
	public Cursos getCurso() {
		return Curso;
	}
	public void setCurso(Cursos curso) {
		this.Curso = curso;
	}
	@Override
	public String toString() {
		return "ProfesoresCursosId [profesor=" + profesor + ", curso=" + Curso + "]";
	}
	
	

}
