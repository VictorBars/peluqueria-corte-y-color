package pe.edu.upn.demo.model.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Usuario {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="cod_u", nullable = false)
    private long id;

    @Column(length = 30, nullable = false)
    private String username;

    @Column(length = 60, nullable = false)
    private String password;

    private boolean enable;
    
    @Column(length = 40, nullable = false)
    private String apellidos;
    
    @Column(length = 40, nullable = false)
    private String nombres;
    
    
    @Column(length = 60, nullable = false)
    private String correo;
    
    @Column(length = 8, nullable = false)
    private String dni;
    
    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER, cascade = CascadeType.ALL)    
    private List<Authority> authorities;
    
    @OneToMany(mappedBy = "Usuario", fetch = FetchType.LAZY)
	private List<Cita> listacita;
    
    @OneToMany(mappedBy = "Usuario", fetch = FetchType.LAZY)
	private List<Tarjeta> ListaTarjeta;

    
	public Usuario() {
		this.enable = true;
		this.authorities = new ArrayList<>();
		this.listacita = new ArrayList<>();
		
	}
	public Usuario( String username, String password ) {
		this.username = username;
		this.password = password;
		this.enable = true;
		this.authorities = new ArrayList<>();
	}
	
	public void addAuthority( String _authority ) {
		Authority authority = new Authority();
		authority.setAuthority( _authority );
		authority.setUsuario(this);
		this.authorities.add(authority);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public List<Cita> getListacita() {
		return listacita;
	}
	public void setListacita(List<Cita> listacita) {
		this.listacita = listacita;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public List<Tarjeta> getListaTarjeta() {
		return ListaTarjeta;
	}
	public void setListaTarjeta(List<Tarjeta> listaTarjeta) {
		ListaTarjeta = listaTarjeta;
	}
	

	
	
	

	
    
    
}
