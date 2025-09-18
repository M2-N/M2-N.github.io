package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Departamentos implements Serializable {
	@Id
	@Column(nullable=false)
	private Integer IdDepartamento ;
	
	@Column(length=50)
	private String Nombre;

	public Departamentos(Integer idDepartamento, String nombre) {
		super();
		IdDepartamento = idDepartamento;
		Nombre = nombre;
	}

	public Departamentos() {
		super();
	}

	public Integer getIdDepartamento() {
		return IdDepartamento;
	}

	public void setIdDepartamento(Integer idDepartamento) {
		IdDepartamento = idDepartamento;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	@Override
	public String toString() {
		return "Departamento [IdDepartamento=" + IdDepartamento + ", Nombre=" + Nombre + "]";
	}

	
}
