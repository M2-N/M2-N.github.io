package modelo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class ParticipantesID implements Serializable {
	@Column
	private Integer ParticipanteActividad;
	@Column
	private Integer ParticipanteEquipo;
	@Column
	private Integer  Alumno;
	public ParticipantesID() {
		super();
	}
	public Integer getParticipanteActividad() {
		return ParticipanteActividad;
	}
	public void setParticipanteActividad(Integer participanteActividad) {
		ParticipanteActividad = participanteActividad;
	}
	public Integer getParticipanteEquipo() {
		return ParticipanteEquipo;
	}
	public void setParticipanteEquipo(Integer participanteEquipo) {
		ParticipanteEquipo = participanteEquipo;
	}
	public Integer getAlumno() {
		return Alumno;
	}
	public void setAlumno(Integer alumno) {
		Alumno = alumno;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Alumno, ParticipanteActividad, ParticipanteEquipo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParticipantesID other = (ParticipantesID) obj;
		return Objects.equals(Alumno, other.Alumno)
				&& Objects.equals(ParticipanteActividad, other.ParticipanteActividad)
				&& Objects.equals(ParticipanteEquipo, other.ParticipanteEquipo);
	}
	
	
	
	
	

}
