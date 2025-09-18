package modelo;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Entity
public class Participantes implements Serializable {

	@EmbeddedId
	private ParticipantesID id;

	@ManyToOne
	@JoinColumn(name = "Alumno", referencedColumnName = "Expediente", insertable = false, updatable = false)
	private Alumnos Alumno;

	@ManyToOne
	@JoinColumn(name = "ParticipanteActividad", referencedColumnName = "IdActividad", insertable = false, updatable = false)

	private Actividades ParticipanteActividad;

	@ManyToOne
	@JoinColumn(name = "ParticipanteEquipo", referencedColumnName = "IdEquipo", insertable = false, updatable = false)
	private Equipos ParticipanteEquipo;

	public Participantes() {
		super();
	}

	public Participantes(ParticipantesID id) {
		super();
		this.id = id;
	}

	public ParticipantesID getId() {
		return id;
	}

	public void setId(ParticipantesID id) {
		this.id = id;
	}

	public Alumnos getAlumno() {
		return Alumno;
	}

	public void setAlumno(Alumnos alumno) {
		Alumno = alumno;
	}

	public Actividades getParticipanteActividad() {
		return ParticipanteActividad;
	}

	public void setParticipanteActividad(Actividades participanteActividad) {
		ParticipanteActividad = participanteActividad;
	}

	public Equipos getParticipanteEquipo() {
		return ParticipanteEquipo;
	}

	public void setParticipanteEquipo(Equipos participanteEquipo) {
		ParticipanteEquipo = participanteEquipo;
	}

	@Override
	public String toString() {
		return "Participantes [id=" + id + ", Alumno=" + Alumno + ", ParticipanteActividad=" + ParticipanteActividad
				+ ", ParticipanteEquipo=" + ParticipanteEquipo + "]";
	}

}