package pe.edu.upn.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import pe.edu.upn.demo.model.entidades.Cita;
import pe.edu.upn.demo.model.entidades.Usuario;

@Service
public class NotificacionServiceImpl {
	private JavaMailSender javaMailSender;
	
	@Autowired
	public NotificacionServiceImpl(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	public void sendNotificacionRegistro(Usuario usuario) throws MailException{
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(usuario.getCorreo());
		mail.setFrom("estilosvilma@gmail.com");
		mail.setSubject("REGISTRO CORRECTO");
		mail.setText("Se registro correctamente en Estilos & Belleza Integral Vilma");
		javaMailSender.send(mail);
	}
	
	public void sendNotificacionCita(Usuario usuario, Cita cita) throws MailException{
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(usuario.getCorreo());
		mail.setFrom("estilosvilma@gmail.com");
		mail.setSubject("CITA REGISTRADA CORRECTAMENTE");
		mail.setText("Se registro cita correctamente en Estilos & Belleza Integral Vilma\n"
				+ "Fecha: " + cita.getFecha() +"\n"
				+ "Servicio: " + cita.getServicio().getNombre() +"\n"
				+ "Peluquero: " + cita.getTrabajador().getNombre()+"\n"
				+ "Horario: " + cita.getHorario().getDescripcion()+"\n"
				+ "Precio: " + cita.getServicio().getPrecio()+" soles\n\n"
				+ "¡MUCHAS GRACIAS!");
		javaMailSender.send(mail);
	}
}
