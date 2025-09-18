package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "prueba", query = "SELECT a.Actividad, eqa.Nombre, eqb.Nombre, c.id.Fecha, c.id.Hora, c.id.Lugar "
		+ "FROM Calendario c " + "JOIN Actividades a ON c.Actividad = a.IdActividad "
		+ "JOIN Equipos eqa ON c.EquipoA = eqa.IdEquipo " + "JOIN Equipos eqb ON c.EquipoB = eqb.IdEquipo "
		+ "ORDER BY a.Actividad, c.id.Fecha, c.id.Hora")

public class Calendario implements Serializable {
	@EmbeddedId
	private CalendarioId calendario;
	@Column
	private Integer Jornada;
	@Column
	private Integer ResultadoEquipoA;
	@Column(length = 50)
	private String ResultadoEquipoB;

	@ManyToOne
	@JoinColumns({
			@JoinColumn(name = "EquipoA", referencedColumnName = "IdEquipo", insertable = false, updatable = false) })

	private Equipos EquipoA;

	@ManyToOne
	@JoinColumn(name = "EquipoB", referencedColumnName = "IdEquipo", insertable = false, updatable = false)

	private Equipos EquipoB;

	@ManyToOne
	@JoinColumn(name = "Actividad", referencedColumnName = "IdActividad", insertable = false, updatable = false)

	private Actividades Actividad;

	public Calendario(CalendarioId calendario, Integer jornada, Integer resultadoEquipoA, String resultadoEquipoB) {
		super();
		this.calendario = calendario;
		Jornada = jornada;
		ResultadoEquipoA = resultadoEquipoA;
		ResultadoEquipoB = resultadoEquipoB;
	}

	public Calendario() {
		super();
	}

	public CalendarioId getCalendario() {
		return calendario;
	}

	public void setCalendario(CalendarioId calendario) {
		this.calendario = calendario;
	}

	public Integer getJornada() {
		return Jornada;
	}

	public void setJornada(Integer jornada) {
		Jornada = jornada;
	}

	public Integer getResultadoEquipoA() {
		return ResultadoEquipoA;
	}

	public void setResultadoEquipoA(Integer resultadoEquipoA) {
		ResultadoEquipoA = resultadoEquipoA;
	}

	public String getResultadoEquipoB() {
		return ResultadoEquipoB;
	}

	public void setResultadoEquipoB(String resultadoEquipoB) {
		ResultadoEquipoB = resultadoEquipoB;
	}

	public Equipos getEquipoA() {
		return EquipoA;
	}

	public void setEquipoA(Equipos equipoA) {
		EquipoA = equipoA;
	}

	public Equipos getEquipoB() {
		return EquipoB;
	}

	public void setEquipoB(Equipos equipoB) {
		EquipoB = equipoB;
	}

	public Actividades getActividad() {
		return Actividad;
	}

	public void setActividad(Actividades actividad) {
		Actividad = actividad;
	}

	@Override
	public String toString() {
		return "Calendario [calendario=" + calendario + ", Jornada=" + Jornada + ", ResultadoEquipoA="
				+ ResultadoEquipoA + ", ResultadoEquipoB=" + ResultadoEquipoB + "]";
	}

}
