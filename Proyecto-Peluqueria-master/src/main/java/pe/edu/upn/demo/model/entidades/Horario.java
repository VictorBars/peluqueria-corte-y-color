package pe.edu.upn.demo.model.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;



import javax.persistence.OneToMany;

@Entity
public class Horario {
	@Id
	@Column(name ="cod_hora", length = 4 , nullable = false)
	private Integer codigo;
	
	@Column(name ="nom_hora", length = 30 , nullable = false)
	private String descripcion;
	
	@OneToMany(mappedBy = "Horario", fetch = FetchType.LAZY)
	private List<Cita> listacita;

	
	public Horario() {
		this.listacita = new ArrayList<Cita>();
		
	}

	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public List<Cita> getListacita() {
		return listacita;
	}


	public void setListacita(List<Cita> listacita) {
		this.listacita = listacita;
	}

	
	


	
}
