package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Actividades implements Serializable {
	@Id
	@Column(nullable = false)
	private Integer IdActividad ;
	@Column(length = 50)
	private String Actividad;

	public Actividades(Integer idActividad, String actividad) {
		super();
		IdActividad = idActividad;
		Actividad = actividad;
	}

	public Actividades() {
		super();
	}

	public Integer getIdActividad() {
		return IdActividad;
	}

	public void setIdActividad(Integer idActividad) {
		IdActividad = idActividad;
	}

	public String getActividad() {
		return Actividad;
	}

	public void setActividad(String actividad) {
		Actividad = actividad;
	}

	@Override
	public String toString() {
		return "Actividades [IdActividad=" + IdActividad + ", Actividad=" + Actividad + "]";
	}

}
