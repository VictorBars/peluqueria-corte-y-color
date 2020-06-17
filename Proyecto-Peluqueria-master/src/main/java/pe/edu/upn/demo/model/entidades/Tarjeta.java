package pe.edu.upn.demo.model.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Tarjeta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_tar")
	private Integer codigo;

	@Column(name = "num_tar", length = 30, nullable = false)
	private String numero;

	@Column(name = "nom_tar", length = 100, nullable = false)
	private String nombre;

	@Column(name = "dire_tar", length = 100, nullable = false)
	private String direccion;
	
	@Column(name = "ciudad_tar", length = 50, nullable = false)
	private String Ciudad;
	
	@Column(name = "pais_tar", length = 30, nullable = false)
	private String Pais;
	
	@Column(name = "cod_p_tar", length = 10, nullable = false)
	private String CodigoPostal;
	
	@Column(name = "fechaVencimiento_tar", length = 10, nullable = false)
	private String FechaVencimiento;

	@Column(name = "cvv_tar", length = 3, nullable = false)
	private String CVV;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_u")
	private Usuario Usuario;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_empresa")
	private Empresa Empresa;

	
	@OneToMany(mappedBy = "Tarjeta", fetch = FetchType.LAZY)
	private List<Cita> ListaCita;
	
	
	public Tarjeta() {
		this.ListaCita = new ArrayList<>();
	}
	
	
	

	public Integer getCodigo() {
		return codigo;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getCiudad() {
		return Ciudad;
	}


	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}


	public String getPais() {
		return Pais;
	}


	public void setPais(String pais) {
		Pais = pais;
	}


	public String getCodigoPostal() {
		return CodigoPostal;
	}


	public void setCodigoPostal(String codigoPostal) {
		CodigoPostal = codigoPostal;
	}


	public String getFechaVencimiento() {
		return FechaVencimiento;
	}


	public void setFechaVencimiento(String fechaVencimiento) {
		FechaVencimiento = fechaVencimiento;
	}


	public String getCVV() {
		return CVV;
	}


	public void setCVV(String cVV) {
		CVV = cVV;
	}


	public Usuario getUsuario() {
		return Usuario;
	}


	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}


	public Empresa getEmpresa() {
		return Empresa;
	}


	public void setEmpresa(Empresa empresa) {
		Empresa = empresa;
	}

	public List<Cita> getListaCita() {
		return ListaCita;
	}

	public void setListaCita(List<Cita> listaCita) {
		ListaCita = listaCita;
	}
	

	

	
	
	
	
	
	



}