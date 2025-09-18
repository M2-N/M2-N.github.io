
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class CalendarioId implements Serializable {

	@Column(nullable = false)
	private Integer Actividad;
	@Temporal(TemporalType.DATE)
	@Column(name="Fecha", nullable = false)
	private Date Fecha;
	@Column(length = 8, nullable = false)
	private String Hora;
	@Column(length = 50, nullable = false)
	private String Lugar;
	
	public CalendarioId(Integer actividad, Date fechaevento, String hora, String lugar) {
		super();
		Actividad = actividad;
		Fecha = fechaevento;
		Hora = hora;
		Lugar = lugar;
	}

	public CalendarioId() {
		super();
	}

	public Integer getActividad() {
		return Actividad;
	}

	public void setActividad(Integer actividad) {
		Actividad = actividad;
	}

	public Date getFechaevento() {
		return Fecha;
	}

	public void setFechaevento(Date fechaevento) {
		Fecha = fechaevento;
	}

	public String getHora() {
		return Hora;
	}

	public void setHora(String hora) {
		Hora = hora;
	}

	public String getLugar() {
		return Lugar;
	}

	public void setLugar(String lugar) {
		Lugar = lugar;
	}

	@Override
	public String toString() {
		return "CalendarioId [Actividad=" + Actividad + ", Fechaevento=" + Fecha + ", Hora=" + Hora + ", Lugar="
				+ Lugar + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Actividad, Fecha, Hora, Lugar);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CalendarioId other = (CalendarioId) obj;
		return Objects.equals(Actividad, other.Actividad) && Objects.equals(Fecha, other.Fecha)
				&& Objects.equals(Hora, other.Hora) && Objects.equals(Lugar, other.Lugar);
	}
	
	

	
	
}
