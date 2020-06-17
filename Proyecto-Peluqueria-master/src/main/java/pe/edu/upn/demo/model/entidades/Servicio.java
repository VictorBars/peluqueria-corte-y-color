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

@Entity
public class Servicio {
	@Id
	
	@Column(name = "cod_servicio", length = 4, nullable = false)
	private Integer codigo;
	
	@Column(name = "nom_servicio", length = 30, nullable = false)
	private String nombre;
	
	@GeneratedValue(strategy =  GenerationType.AUTO)
	@Column(name = "pre_servicio", nullable = false)
	private double precio;

	@Column(name ="duracion_servicio", length = 30 , nullable = false)
	private String duracion;
	
	@OneToMany(mappedBy = "Servicio", fetch = FetchType.LAZY)
	private List<Cita> listacita;
	

	public Servicio(){
	 
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public List<Cita> getListacita() {
		return listacita;
	}

	public void setListacita(List<Cita> listacita) {
		this.listacita = listacita;
	}
	
	
}
