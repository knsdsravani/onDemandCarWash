package com.onDemandCarWash.reportManagement.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.onDemandCarWash.reportManagement.model.Washer;
import com.onDemandCarWash.reportManagement.service.ReportService;

@RestController
@RequestMapping("/generateReport")
public class ReportGenerateController {
	
	@Autowired
	private ReportService reportService;
	@Autowired
	private ServletContext context;
	
	
	@Autowired
	private RestTemplate template;
	
	@GetMapping("/createExcel")
	public void createExcel(HttpServletRequest request, HttpServletResponse response){
		ResponseEntity<Washer[]> restApiResponse = template.getForEntity("http://API-GATEWAY-SERVICE/washer/getAllWashers", Washer[].class);
		List<Washer> washers = Arrays.asList(restApiResponse.getBody());
		boolean isFlag = reportService.createExcel(washers, context, request);
		if(isFlag) {
			String fullPath = request.getServletContext().getRealPath("/resources/reports/"+"washerReport"+".xls");
			fileDownload(fullPath, response, "washerReport.xls");
		}
	}

	private void fileDownload(String fullPath, HttpServletResponse response, String fileName) {
		File file = new File(fullPath);
		final int BUFFER_SIZE = 4096;
		if(file.exists()) {
			try {
				FileInputStream inputStream = new FileInputStream(file);
				String mimeType = context.getMimeType(fullPath);
				response.setContentType(mimeType);
				response.setHeader("content-description", "attachment; + filename" + fileName);
				OutputStream outputStream = response.getOutputStream();
				byte[] buffer = new byte[BUFFER_SIZE];
				int bytesRead = -1;
				while((bytesRead = inputStream.read(buffer))!= -1){
					outputStream.write(buffer,0, bytesRead);					
				}
				inputStream.close();
				outputStream.close();
				file.delete();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
