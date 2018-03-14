package com.themepark;

/**
 * @author Bharath P
 * @createdOn 14-Mar-2018
 */
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;

public class ReportGenerator {
	public File generatePdfReport(ReportBeanClass beanClass) throws Exception {
		final List<ReportBeanClass> list = new ArrayList<ReportBeanClass>() {{
			add(beanClass);
		}};
		final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		FileOutputStream fos = null;
		try {
			final byte[] bytes = new ReportGenerator().generateJasperReportPDF("BookingConfirmation", outputStream,
					list);
			if (bytes.length > 1) {
				final File someFile = new File("src/"+beanClass.guestName+".pdf");
				fos = new FileOutputStream(someFile);
				fos.write(bytes);
				fos.flush();
				fos.close();
				System.out.println("<<<<<<<<<<<<Report Created>>>>>>>>");
				return someFile;
			}
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (final IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}

	public byte[] generateJasperReportPDF(final String jasperReportName, final ByteArrayOutputStream outputStream,
			final List reportList) {
		final JRPdfExporter exporter = new JRPdfExporter();
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			final String reportLocation = "jrxml/" + jasperReportName + ".jrxml";
			File file = new File(classLoader.getResource(reportLocation).getFile());
			Map<String, Object> paramPath = new HashMap<>();
			paramPath.put("imagePath",
					new File(classLoader.getResource("static/images/mcm-studio.png").getFile()).getAbsolutePath());
			System.out.println("======" + paramPath);
			final JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
			final JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, paramPath,
					new JRBeanCollectionDataSource(reportList));
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outputStream);
			exporter.exportReport();
		} catch (final Exception e) {
			e.printStackTrace();
			System.out.println("Error in generate Report..." + e);
		} finally {
		}
		return outputStream.toByteArray();
	}
}
