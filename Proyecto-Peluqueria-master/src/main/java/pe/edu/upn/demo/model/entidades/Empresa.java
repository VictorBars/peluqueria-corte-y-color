package pe.edu.upn.demo.model.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Empresa {
	
	@Id
	@Column(name = "cod_empresa", length = 4, nullable = false)
	private Integer codigo;
	
	@Column(name = "nom_empresa", length = 30, nullable = false)
	private String nombre;
	
	@OneToMany(mappedBy = "Empresa", fetch = FetchType.LAZY)
	private List<Tarjeta> ListaTarjeta;
	
	public Empresa() {
		this.ListaTarjeta = new ArrayList<Tarjeta>();
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

	public List<Tarjeta> getListaTarjeta() {
		return ListaTarjeta;
	}

	public void setListaTarjeta(List<Tarjeta> listaTarjeta) {
		ListaTarjeta = listaTarjeta;
	}
	
}
