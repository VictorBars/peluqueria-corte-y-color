package pe.edu.upn.demo.model.entidades;


import java.sql.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Cita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cod_cita", length = 4, nullable = false)
	private Integer codigo;
	
	@Column(name = "fecha_cita", length = 30, nullable = false)
	private Date fecha;
	
	@Column(name = "est_cita", length = 30, nullable = false)
	private String est_cita = "no";

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_servicio")
	private Servicio Servicio;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_hora")
	private Horario Horario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_pe")
	private Trabajador Trabajador;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_u")
	private  Usuario Usuario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_t")
	private  Tarjeta Tarjeta;
	
	public Cita() {	
		
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	public String getEst_cita() {
		return est_cita;
	}

	public void setEst_cita(String est_cita) {
		this.est_cita = est_cita;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Servicio getServicio() {
		return Servicio;
	}

	public void setServicio(Servicio servicio) {
		Servicio = servicio;
	}

	public Horario getHorario() {
		return Horario;
	}

	public void setHorario(Horario horario) {
		Horario = horario;
	}

	public Trabajador getTrabajador() {
		return Trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		Trabajador = trabajador;
	}

	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}

	public Tarjeta getTarjeta() {
		return Tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		Tarjeta = tarjeta;
	}
	
	
	



	
	


	

	
	


	






	
	
	
}
