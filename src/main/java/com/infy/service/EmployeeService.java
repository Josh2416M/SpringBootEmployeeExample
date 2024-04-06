package com.infy.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.infy.entity.Employee;
import com.infy.repo.EmployeeRepo;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeService {
	
	
	@Autowired
	private EmployeeRepo repo;
	
	public List<Employee> getAllEmployees(){
		return repo.findAll();
		
	}
	
	public Optional<Employee> getById(Integer employeeId){
		
		return repo.findById(employeeId);
		
		
		
	}
	
	
	public Employee getByName(String employeeName)
	{
		return repo.findByEmployeeName(employeeName);
		
	}
	
	
	public Employee createEmployee(Employee emp)
	{
		return repo.save(emp);	
	}
	
	
	public void updateEmployee(Employee emp) {
		if(repo.existsById(emp.getEmployeeId())) {
			repo.save(emp);
		}
		else {
            throw new EntityNotFoundException("Employee with ID " + emp.getEmployeeId() + " not found");
		}
		
		
	}
	
	
	public String deleteEmployee(Integer empId) throws Exception
	{
		if(repo.existsById(empId) ) {
			repo.deleteById(empId);
		}
		else {
			throw new EntityNotFoundException("Employee details not found "+empId);
		}
		
		return "Employee ID:"+empId;
		
	}
	
	
	
	public ByteArrayInputStream generatePdf() throws IOException{
		
			
		Document document = new Document();
		
        ByteArrayOutputStream out = new ByteArrayOutputStream();

	        try {
	        	
	            PdfWriter.getInstance(document, out);
	            
	            document.open();

	            // Add Title
	            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16, BaseColor.BLACK);
	            
	            Chunk titleChunk = new Chunk("Employee Details Report  ", titleFont);
	            
	            document.add(new Paragraph(titleChunk));

	            // Create a table with the necessary columns
	            
	            PdfPTable table = new PdfPTable(5); // 5 columns for em_name, em_id, doj, technology, experience
	            
	            Stream.of("Employee Name", "Employee ID", "Date of Joining", "Technology", "Experience")
	                    .forEach(headerTitle -> {
	                        PdfPCell header = new PdfPCell();
	                        Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	                        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
	                        header.setHorizontalAlignment(Element.ALIGN_CENTER);
	                        header.setBorderWidth(1);
	                        header.setPhrase(new Phrase(headerTitle, headFont));
	                        table.addCell(header);
	                    });

	            // Fetch data from the database and add rows to the table
	            List<Employee> employeeDetailsList = repo.findAll();
	            
	            
	            
	            for (Employee employee : employeeDetailsList) {
	            	
	                PdfPCell nameCell = new PdfPCell(new Phrase(employee.getEmployeeName()));
	                nameCell.setPaddingLeft(4);
	                System.out.println(nameCell);
	                nameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                nameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                table.addCell(nameCell);
	                

	                PdfPCell idCell = new PdfPCell(new Phrase(String.valueOf(employee.getEmployeeId())));
	                idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                idCell.setPaddingRight(4);
	                table.addCell(idCell);

	                PdfPCell dojCell = new PdfPCell(new Phrase(employee.getDoj().toString()));
	                dojCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                dojCell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                dojCell.setPaddingRight(4);
	                table.addCell(dojCell);

	                PdfPCell techCell = new PdfPCell(new Phrase(employee.getTechnology()));
	                techCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                techCell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                techCell.setPaddingRight(4);
	                table.addCell(techCell);

	                PdfPCell expCell = new PdfPCell(new Phrase(String.valueOf(employee.getExperience())));
	                expCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	                expCell.setHorizontalAlignment(Element.ALIGN_CENTER);
	                expCell.setPaddingRight(4);
	                table.addCell(expCell);
	            }

	            document.add(table);
	            document.close();
	        } catch (DocumentException ex) {
	            Logger.getLogger(EmployeeService.class.getName()).log(Level.SEVERE, null, ex);
	        }

	        return new ByteArrayInputStream(out.toByteArray());
	    }


		
	}


