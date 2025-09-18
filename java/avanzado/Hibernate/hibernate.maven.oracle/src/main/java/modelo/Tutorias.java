package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Entity
public class Tutorias implements Serializable {
	@Id
	private Integer IdTutoria;
	@Column(length = 10)
	private String DiaSemana;
	@Column(length = 8)
	private String HoraTutoria;
	@ManyToOne
	@JoinColumn(name = "Curso", referencedColumnName = "IdCurso", insertable = false, updatable = false)
	private Cursos curso_id;

	@ManyToOne
	@JoinColumn(name = "Profesor", referencedColumnName = "IDProfesor", insertable = false, updatable = false)
	private Profesores Profesor;

	public Tutorias(Integer idTutoria, String diaSemana, String horaTutoria) {
		super();
		IdTutoria = idTutoria;
		DiaSemana = diaSemana;
		HoraTutoria = horaTutoria;
	}

	public Tutorias() {
		super();
	}

	public Integer getIdTutoria() {
		return IdTutoria;
	}

	public void setIdTutoria(Integer idTutoria) {
		IdTutoria = idTutoria;
	}

	public String getDiaSemana() {
		return DiaSemana;
	}

	public void setDiaSemana(String diaSemana) {
		DiaSemana = diaSemana;
	}

	public String getHoraTutoria() {
		return HoraTutoria;
	}

	public void setHoraTutoria(String horaTutoria) {
		HoraTutoria = horaTutoria;
	}

	public Cursos getCurso_id() {
		return curso_id;
	}

	public void setCurso_id(Cursos curso_id) {
		this.curso_id = curso_id;
	}

	public Profesores getProfesor_id() {
		return Profesor;
	}

	public void setProfesor_id(Profesores profesor_id) {
		Profesor = profesor_id;
	}

	@Override
	public String toString() {
		return "Tutorias [IdTutoria=" + IdTutoria + ", DiaSemana=" + DiaSemana + ", HoraTutoria=" + HoraTutoria + "]";
	}

}
