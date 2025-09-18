package modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
@Entity
@NamedQueries({
@NamedQuery(
		name="ProfesoresOrdenados",
		query="Select a from Profesores  a ORDER BY a.IDProfesor"
		),

@NamedQuery(name="ProfesorParametrizados",
query="SELECT a FROM Profesores a WHERE a.Apellido LIKE :apellidoPattern"
)

})
public class Profesores implements Serializable {
    @Id
	private Integer IDProfesor;
	@Column(length = 50)
	private String Nombre;
	@Column(length = 50)
	private String Apellido;
	@Column(length = 200)
	private String Direccion;
	@Column(length = 50)
	private String Ciudad;
	@Column(length = 50)
	private String Provincia;
	@Column(length = 20)
	private String CodPostal;

	 
	@ManyToOne
	@JoinColumn(name = "Departamento", referencedColumnName = "IdDepartamento") 
	private Departamentos Departamento;
	
	@ManyToMany
	@JoinTable(name = "ProfesoresCursos",
	           joinColumns = @JoinColumn(name = "Profesor"),
	           inverseJoinColumns = @JoinColumn(name ="Curso "))
	private List<Cursos> cursos;

	
	@OneToMany(mappedBy ="Profesor")
    private List<Tutorias> Profesor;

	public Profesores(Integer iDProfesor, String nombre, String apellido, String direccion, String ciudad,
			String provincia, String codPostal) {
		super();
		IDProfesor = iDProfesor;
		Nombre = nombre;
		Apellido = apellido;
		Direccion = direccion;
		Ciudad = ciudad;
		Provincia = provincia;
		CodPostal = codPostal;
	}

	public Profesores() {
		super();
	}

	public Integer getIDProfesor() {
		return IDProfesor;
	}

	public void setIDProfesor(Integer iDProfesor) {
		IDProfesor = iDProfesor;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getCiudad() {
		return Ciudad;
	}

	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}

	public String getProvincia() {
		return Provincia;
	}

	public void setProvincia(String provincia) {
		Provincia = provincia;
	}

	public String getCodPostal() {
		return CodPostal;
	}

	public void setCodPostal(String codPostal) {
		CodPostal = codPostal;
	}

	public Departamentos getDepartamento_id() {
		return Departamento;
	}

	public void setDepartamento_id(Departamentos departamento_id) {
		Departamento = departamento_id;
	}

	@Override
	public String toString() {
		return "Profesor [IDProfesor=" + IDProfesor + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", Direccion="
				+ Direccion + ", Ciudad=" + Ciudad + ", Provincia=" + Provincia + ", CodPostal=" + CodPostal + "]";
	}

	public Departamentos getDepartamento() {
		return Departamento;
	}

	public void setDepartamento(Departamentos departamento) {
		Departamento = departamento;
	}



	

	public List<Tutorias> getProfesor() {
		return Profesor;
	}

	public void setProfesor(List<Tutorias> profesor) {
		Profesor = profesor;
	}

	public List<Cursos> getCursos() {
		return cursos;
	}

	public void setCursos(List<Cursos> cursos) {
		this.cursos = cursos;
	}
	
	

}
