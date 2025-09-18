package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
@Entity
public class ProfesoresCursos implements Serializable {

	@EmbeddedId
	private ProfesoresCursosId profesoresCursosId;
	@Column(length = 5)
	private String Tutor;

	@ManyToOne

	@JoinColumn(name = "profesor", referencedColumnName = "IDProfesor", insertable = false, updatable = false)

	private Profesores profesor;

	@ManyToOne
	@JoinColumn(name = "Curso", referencedColumnName = "IdCurso", insertable = false, updatable = false)
	private Cursos curso;

	public ProfesoresCursos() {
		super();
	}

	public ProfesoresCursosId getProfesoresCursosId() {
		return profesoresCursosId;
	}

	public void setProfesoresCursosId(ProfesoresCursosId profesoresCursosId) {
		this.profesoresCursosId = profesoresCursosId;
	}

	public String getTutor() {
		return Tutor;
	}

	public void setTutor(String tutor) {
		Tutor = tutor;
	}

	public Profesores getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesores profesor) {
		this.profesor = profesor;
	}

	public Cursos getCurso() {
		return curso;
	}

	public void setCurso(Cursos curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "ProfesoresCursos [profesoresCursosId=" + profesoresCursosId + ", Tutor=" + Tutor + "]";
	}

}
