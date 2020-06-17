package pe.edu.upn.demo.model.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Peluquero")
public class Trabajador {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="cod_pe", length = 4 , nullable = false)
	private Integer codigo;
	
	@Column(name ="nom_pe", length = 40, nullable = false)
	private String nombre;
	
	@Column(name ="sexo_pe", length = 1, nullable = false)
	private String sexo;
	
	@Column(name ="dir_pe", length = 20, nullable = false)
	private String direccion;
	
	@Column(name ="dni_pe", length = 8, nullable = false)
	private String dni;
	
	@Column(name ="telf_pe", length = 9, nullable = false)
	private String telefono;
	
	
	@OneToMany(mappedBy = "Trabajador" , fetch = FetchType.LAZY)
	private List<Cita> listacita;
	
	public Trabajador() {
		this.listacita = new ArrayList<Cita>();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Cita> getListacita() {
		return listacita;
	}

	public void setListacita(List<Cita> listacita) {
		this.listacita = listacita;
	}
	
	
	
}
