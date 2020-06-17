package pe.edu.upn.demo.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upn.demo.model.entidades.Cita;
import pe.edu.upn.demo.model.repository.CitaRepository;
import pe.edu.upn.demo.service.CitaService;
@Service
public class CitaServiceImpl implements CitaService{
	
	@Autowired
	private CitaRepository citarepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Cita> findAll() throws Exception {
		return citarepository.findAll();
	}
	@Transactional(readOnly = true)
	@Override
	public Optional<Cita> findById(Integer id) throws Exception {
		return citarepository.findById(id);
	}
	@Transactional
	@Override
	public Cita save(Cita entity) throws Exception {
		return citarepository.save(entity);
	}
	@Transactional
	@Override
	public Cita update(Cita entity) throws Exception {
		return citarepository.save(entity);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		this.citarepository.deleteById(id);
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
		this.citarepository.deleteAll();
	}
	@Override
	public List<Cita> fecha() throws Exception {
		return citarepository.fecha();
	}
	@Override
	public List<Cita> getAll() {
		List<Cita> returnList = new ArrayList<>();
		citarepository.findAll().forEach(obj -> returnList.add(obj));
		return returnList;
	}
	@Override
	public ByteArrayInputStream exportAllData() throws Exception {
		
		String[] columns = {"#","Codigo", "Servicio" ,"Asistidor por", "Fecha" ,"Hora" ,"Duracion","Nombre Cliente", "Total"};
		
		Workbook workbook = new HSSFWorkbook();
		ByteArrayOutputStream stream  = new ByteArrayOutputStream();
		
		Sheet sheet = workbook.createSheet("Citas");
		
		Row row = sheet.createRow(1);
		
		for(int i=1 ; i < columns.length ; i++) {
			Cell cell = row.createCell(i);
			cell.setCellValue(columns[i]);
		}
		
		List<Cita> citas = this.getAll();
		
		int initRow = 2;
		
		for (Cita cita : citas) {
			row = sheet.createRow(initRow);
			row.createCell(1).setCellValue(cita.getCodigo());
			row.createCell(2).setCellValue(cita.getServicio().getNombre());
			row.createCell(3).setCellValue(cita.getTrabajador().getNombre());
			row.createCell(4).setCellValue(cita.getFecha());
			row.createCell(5).setCellValue(cita.getHorario().getDescripcion());
			row.createCell(6).setCellValue(cita.getServicio().getDuracion());
			row.createCell(7).setCellValue(cita.getUsuario().getNombres());
			row.createCell(8).setCellValue(cita.getServicio().getPrecio());
			
			initRow++;
		}

		workbook.write(stream);
		workbook.close();
		return new ByteArrayInputStream(stream.toByteArray());
	}
	

}
