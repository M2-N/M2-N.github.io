package modelo;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(
			name="AlumnosOrdenados",
			query="Select a from Alumnos a ORDER BY a.Expediente"
			),

	@NamedQuery(
			name="Alumnosparamtrizados",
			query="SELECT a FROM Alumnos a WHERE a.Apellidos LIKE :apellidoPattern"
			)
})


public class Alumnos implements Serializable {
	@Id
	@Column(name = "Expediente", nullable = false)
	private Integer Expediente;
	@Column(length = 50)
	private String Nombre;
	@Column(length = 50)
	private String Apellidos;
	@Column
	private Date FechaNacimiento;

	 @ManyToOne
	@JoinColumn(name ="Grupo", referencedColumnName = "IdCurso", insertable = false, updatable = false)   
	private Cursos Grupo ;

	public Alumnos(Integer expediente, String nombre, String apellidos,  Date fechaNacimiento) {
		super();
		Expediente = expediente;
		Nombre = nombre;
		Apellidos = apellidos;
		FechaNacimiento = fechaNacimiento;
	}

	public Alumnos() {
		super();
	}

	public Integer getExpediente() {
		return Expediente;
	}

	public void setExpediente(Integer expediente) {
		Expediente = expediente;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}



	public Date getFechaNacimiento() {
		return FechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}

	public Cursos getCursos() {
		return Grupo;
	}

	public void setCursos(Cursos cursos) {
		this.Grupo = cursos;
	}

	@Override
	public String toString() {
		return "Alumno [Expediente=" + Expediente + ", Nombre=" + Nombre + ", Apellidos=" + Apellidos + ", Grupo="
				+ Grupo + ", FechaNacimiento=" + FechaNacimiento + "]";
	}
	
	
	
}
