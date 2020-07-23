package com.onDemandCarWash.reportManagement.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.stereotype.Service;

import com.onDemandCarWash.reportManagement.model.Washer;

@Service
public class ReportService {
	
	public boolean createExcel(List<Washer> washers,ServletContext context, HttpServletRequest request) {
		String filePath = context.getRealPath("/resources/reports");
		File file = new File(filePath);
		boolean exists = file.exists();
		if(!exists) {
			new File(filePath).mkdirs();
		}
		try {
			FileOutputStream outpuStream = new FileOutputStream(file+"/"+"washerReport"+".xls");
			HSSFWorkbook workBook = new HSSFWorkbook();
			HSSFSheet workSheet = workBook.createSheet("washers");
			workSheet.setDefaultColumnWidth(30);
			
			HSSFCellStyle headerCellStyle = workBook.createCellStyle();
			headerCellStyle.setFillBackgroundColor(HSSFColor.LIGHT_YELLOW.index);
			headerCellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			
			HSSFRow headerRow = workSheet.createRow(0);
			
			HSSFCell id = headerRow.createCell(0);
			id.setCellValue("Washer Id");
			id.setCellStyle(headerCellStyle);
			
			HSSFCell name = headerRow.createCell(1);
			name.setCellValue("Washer Name");
			name.setCellStyle(headerCellStyle);
			
			HSSFCell ratings = headerRow.createCell(2);
			ratings.setCellValue("Ratings");
			ratings.setCellStyle(headerCellStyle);
			
			HSSFCell reviews = headerRow.createCell(3);
			reviews.setCellValue("Reviews");
			reviews.setCellStyle(headerCellStyle);
			
			HSSFCell status = headerRow.createCell(4);
			status.setCellValue("status(Active/InActive");
			status.setCellStyle(headerCellStyle);
			
			int i = 1;
			for(Washer washer: washers) {
				HSSFRow row = workSheet.createRow(i);
				
				HSSFCellStyle bodycellStyle = workBook.createCellStyle();
				bodycellStyle.setFillForegroundColor(HSSFColor.WHITE.index);
				
				HSSFCell idValue = row.createCell(0);
				idValue.setCellValue(washer.getWId());
				idValue.setCellStyle(bodycellStyle);
				
				HSSFCell washerNameValue = row.createCell(1);
				washerNameValue.setCellValue(washer.getName());
				washerNameValue.setCellStyle(bodycellStyle);
				
				HSSFCell ratingsValue = row.createCell(2);
				ratingsValue.setCellValue(washer.getRatings());
				ratingsValue.setCellStyle(bodycellStyle);
				
				HSSFCell reviewsValue = row.createCell(3);
				reviewsValue.setCellValue(washer.getReviews());
				reviewsValue.setCellStyle(bodycellStyle);
				
				HSSFCell statusValue = row.createCell(4);
				statusValue.setCellValue(washer.getStatus());
				statusValue.setCellStyle(bodycellStyle);
				
				i++;				
			}
		workBook.write(outpuStream);
		outpuStream.flush();
		outpuStream.close();
		return true;	
		} catch (Exception e) {
		return false;
		}
		
	}
	
}
