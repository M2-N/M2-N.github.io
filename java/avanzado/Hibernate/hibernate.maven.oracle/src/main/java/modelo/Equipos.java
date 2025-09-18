package modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Equipos implements Serializable {
	@Id
	@Column(nullable = false)
	private Integer IdEquipo;
	@Column
	private String Nombre;
	
	@OneToMany(mappedBy ="ParticipanteEquipo")
    private List<Participantes> ParticipanteEquipo;
	
	
	public Equipos(Integer idEquipo, String nombre) {
		super();
		IdEquipo = idEquipo;
		Nombre = nombre;
	}


	public Equipos() {
		super();
	}


	public Integer getIdEquipo() {
		return IdEquipo;
	}


	public void setIdEquipo(Integer idEquipo) {
		IdEquipo = idEquipo;
	}


	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public List<Participantes> getParticipantes() {
		return ParticipanteEquipo;
	}


	public void setParticipantes(List<Participantes> participantes) {
		this.ParticipanteEquipo = participantes;
	}


	@Override
	public String toString() {
		return "Equipos [IdEquipo=" + IdEquipo + ", Nombre=" + Nombre + "]";
	}

	
}
