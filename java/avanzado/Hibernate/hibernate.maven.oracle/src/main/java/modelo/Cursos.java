package modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Cursos implements Serializable {
	@Id
	@Column(nullable = false)
	private Integer IdCurso;
	@Column(length = 50)
	private String Curso;
	
	@ManyToMany(mappedBy="cursos")
	List<Profesores>Profesor;
	
	@OneToMany(mappedBy ="Grupo")
    private List<Alumnos> Grupo;
	public Cursos(Integer idCurso, String curso) {
		super();
		IdCurso = idCurso;
		Curso = curso;
	}


	public Cursos() {
		super();
	}


	public Integer getIdCurso() {
		return IdCurso;
	}


	public void setIdCurso(Integer idCurso) {
		IdCurso = idCurso;
	}


	public String getCurso() {
		return Curso;
	}


	public void setCurso(String curso) {
		Curso = curso;
	}


	@Override
	public String toString() {
		return "Cursos [IdCurso=" + IdCurso + ", Curso=" + Curso + "]";
	}


	public List<Profesores> getProfesor() {
		return Profesor;
	}


	public void setProfesor(List<Profesores> profesor) {
		this.Profesor = profesor;
	}


	public List<Alumnos> getGrupo() {
		return Grupo;
	}


	public void setGrupo(List<Alumnos> grupo) {
		Grupo = grupo;
	}
	
	
	

}
