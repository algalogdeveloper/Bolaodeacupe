package org.logcod.lojajogos.relatorio;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Locale;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.service.CompraService;
import org.logcod.lojajogos.service.LocalService;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class FabricaRelatorios {

	public static void carregarRelatorioDisplayView(HttpServletResponse response, HttpServletRequest req, String endereco) {
		try {
			LocalService localService = new LocalService();
			Document document = new Document(PageSize.A4);
			PdfWriter.getInstance(document, response.getOutputStream());
			document.open();
			String uri = req.getRealPath("img/imgBda.jpeg");
			Image image = Image.getInstance(uri);	
			image.scaleToFit(50, 50);
			image.setBorder(Rectangle.BOX);
			image.setBorderColor(BaseColor.BLUE);
			image.setBorderWidth(1f);
			image.setAlignment(1);
			if (Objects.nonNull(image))
				document.add(image);
			Font font = new Font(FontFamily.UNDEFINED, 13, 1, BaseColor.BLUE);
			Paragraph title = new Paragraph(new Phrase("Plataforma Bolão de Acupe".toUpperCase(),font));
			title.setAlignment(1);
			document.add(title);
			Paragraph pix = new Paragraph(new Phrase("PIX: 71996835988 \n Nome: Renato Reis Borges Cerqueira".toUpperCase()));
			pix.setAlignment(1);
			document.add(pix);
			document.addAuthor("leandro de Souza");
			document.addTitle("Plataforma de Gestão de Rifas");
			document.addSubject("Bolao de Acupe");
			Paragraph subTitle = new Paragraph(new Phrase("Lista de cobrança em aberto do(a) Rua:".toUpperCase()
					+ localService.get(Integer.parseInt(endereco)).getDescricao().toUpperCase(), font));
			subTitle.setAlignment(1);
			subTitle.setSpacingBefore(5);
			subTitle.setSpacingAfter(5);
			document.add(subTitle);

			document.add(createTable(endereco));
			Font fontI = new Font(FontFamily.TIMES_ROMAN, 11, 1, BaseColor.DARK_GRAY);
			
			Paragraph dataHoje = new Paragraph(new Paragraph("Data de criação do documento :"
					+ new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime()),fontI));
			dataHoje.setSpacingAfter(5);
			dataHoje.setAlignment(2);
			document.add(dataHoje);

			document.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static String formatarValor(double valor) {
		Locale localeBR = new Locale("pt", "BR");
		NumberFormat format = NumberFormat.getCurrencyInstance(localeBR);
		return format.format(valor);
	}

	public static PdfPTable createTable(String endereco) throws DocumentException {
		float[] pointColumnWidths = { 120F, 150F, 150F };
		PdfPTable pdfPTable = new PdfPTable(pointColumnWidths);
		pdfPTable.setWidths(new int[] { 10, 2, 5 });
		pdfPTable.setWidthPercentage(105);
		Font fo = new Font(FontFamily.UNDEFINED, 11, Font.BOLD, BaseColor.WHITE);

		PdfPCell column = new PdfPCell(new Paragraph("Anotações".toUpperCase(), fo));
		column.setBackgroundColor(BaseColor.BLUE);
		column.setBorderWidthBottom(1);
		column.setBorderWidthTop(1);
		column.setBorderWidthLeft(1);
		column.setBorderWidthRight(1);
		column.setBorderColor(BaseColor.BLUE);
		column.setPadding(3);
		PdfPCell column2 = new PdfPCell(new Paragraph("R$ Valor".toUpperCase(), fo));
		column2.setBackgroundColor(BaseColor.BLUE);
		column2.setBorderWidthBottom(1);
		column2.setBorderWidthTop(1);
		column2.setBorderWidthLeft(0);
		column2.setBorderWidthRight(0);
		column2.setBorderColor(BaseColor.BLUE);
		column2.setPadding(3);

		PdfPCell column3 = new PdfPCell(new Paragraph("Cliente".toUpperCase(), fo));
		column3.setBackgroundColor(BaseColor.BLUE);
		column3.setBorderColor(BaseColor.BLUE);
		column3.setBorderWidthBottom(1);
		column3.setBorderWidthTop(1);
		column3.setBorderWidthLeft(1);
		column3.setBorderWidthRight(1);
		column3.setPadding(3);
		// add colunm
		pdfPTable.addCell(column3);
		pdfPTable.addCell(column2);
		pdfPTable.addCell(column);
		CompraService compraService = new CompraService();
		Collection<Compra> compras = compraService.selecionarComprasPeloSeuEnderecoDeCadastro(endereco);
		for (Compra c : compras) {
			PdfPCell columnadd = new PdfPCell(new Paragraph(""));
			columnadd.setBorderWidthBottom(1);
			columnadd.setBorderWidthTop(0);
			columnadd.setBorderWidthLeft(1);
			columnadd.setBorderWidthRight(1);
			columnadd.setBorderColor(BaseColor.BLUE);
			columnadd.setPadding(3);
			PdfPCell columnadd2 = new PdfPCell(new Paragraph(formatarValor(c.getValor())));
			columnadd2.setBorderWidthBottom(1);
			columnadd2.setBorderWidthTop(0);
			columnadd2.setBorderWidthLeft(0);
			columnadd2.setBorderWidthRight(0);
			columnadd2.setBorderColor(BaseColor.BLUE);
			columnadd2.setPadding(3);
			PdfPCell columnadd3 = new PdfPCell(new Paragraph(c.getPessoa().getNome().toUpperCase()));
			columnadd3.setBorderWidthBottom(1);
			columnadd3.setBorderWidthTop(0);
			columnadd3.setBorderWidthLeft(1);
			columnadd3.setBorderWidthRight(1);
			columnadd3.setBorderColor(BaseColor.BLUE);
			columnadd3.setPadding(3);
			// add colunm
			pdfPTable.addCell(columnadd3);
			pdfPTable.addCell(columnadd2);
			pdfPTable.addCell(columnadd);
		}
		return pdfPTable;
	}

}
