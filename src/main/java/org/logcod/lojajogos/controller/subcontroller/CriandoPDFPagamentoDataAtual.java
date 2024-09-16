package org.logcod.lojajogos.controller.subcontroller;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.logcod.lojajogos.config.util.DataSourceUtil;
import org.logcod.lojajogos.model.entity.Compra;
import org.logcod.lojajogos.service.CompraService;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class CriandoPDFPagamentoDataAtual implements InvokeSubControllers {

	@Override
	public String invokePage(HttpServletRequest request, HttpServletResponse response) {
		try {
			CompraService cs = new CompraService();
			Document document = new Document(PageSize.A4);
		//	document.setMargins(15, 15, 0, 0);
		//	document.setMarginMirroring(true);
			PdfWriter.getInstance(document, response.getOutputStream());
			document.open();

			Paragraph pth = new Paragraph(new Phrase("Sistema de Cobrança de Rifas - BDA"));
			pth.setAlignment(1);
			pth.setSpacingBefore(10);
			Paragraph texto1 = new Paragraph(new Phrase("Lista de pagamentos realizado no dia - Bolão de Acupe"));
			texto1.setAlignment(1);
			texto1.setSpacingAfter(10);
			texto1.setIndentationLeft(20);

			Paragraph pth3 = new Paragraph(new Phrase(""));
			pth3.setAlignment(1);

			Paragraph texto2 = new Paragraph(
					new Phrase("Data de criação do documento:" + DataSourceUtil.formatarDataViewCalendar(Calendar.getInstance())));
			texto2.setSpacingAfter(10);
			@SuppressWarnings("deprecation")
			String path = request.getRealPath("/img/imgBda.jpeg");
			Image image = Image.getInstance(path);
			image.setAlignment(1);
			image.setBorder(Rectangle.BOX);
			image.setBorderColor(BaseColor.BLUE);
			image.setBorderWidth(1f);
			image.setSpacingAfter(20);
			image.setBorderWidth(2);
			image.scaleToFit(50, 50);
			document.add(image);
			document.add(pth);	
			document.add(texto1);
			document.add(pth3);
			document.add(criarTableModificada2(cs.vizualizarPagamentosDoDia()));
			document.add(texto2);
			document.close();
		} catch (Exception e) {
			return "controller?operacao=ConsultarPagamentosDoDia";
		}
		return "controller?operacao=ConsultarPagamentosDoDia";
	}

	private void bordarTo(PdfPCell cell1, PdfPCell cell2, PdfPCell cell3, PdfPCell cell4, PdfPCell cell5) {
		cell1.setBorderWidthLeft(0);
		cell1.setBorderWidthRight(0);
		cell1.setBorderWidthTop(0);
		cell1.setBorderWidthBottom(0);
	
		cell2.setBorderWidthLeft(0);
		cell2.setBorderWidthRight(0);
		cell2.setBorderWidthTop(0);
		cell2.setBorderWidthBottom(1);
		
		cell3.setBorderWidthLeft(0);
		cell3.setBorderWidthRight(0);
		cell3.setBorderWidthTop(0);
		cell3.setBorderWidthBottom(0);
    
		cell4.setBorderWidthLeft(0);
		cell4.setBorderWidthRight(0);
		cell4.setBorderWidthTop(0);
		cell4.setBorderWidthBottom(0);

		cell5.setBorderWidthLeft(0);
		cell5.setBorderWidthRight(0);
		cell5.setBorderWidthTop(0);
		cell5.setBorderWidthBottom(0);

	}

	public PdfPTable criarTableModificada2(List<Compra> listaOrdenadas) throws DocumentException {
		PdfPTable table = new PdfPTable(5);
		table.setWidths(new int[] { 3, 10, 5, 5, 5 });
		Font f = FontFactory.getFont(FontFactory.TIMES_ROMAN, 11, Font.BOLD, new BaseColor(BaseColor.WHITE.getRGB()));

		table.setWidthPercentage(100);
		table.getDefaultCell().setUseAscender(true);
		table.getDefaultCell().setUseDescender(true);

		PdfPCell cellIdenf = new PdfPCell(new Phrase("Chave".toUpperCase(), f));
		cellIdenf.setBackgroundColor(BaseColor.BLUE);
		cellIdenf.setBorderColor(BaseColor.BLUE);
		PdfPCell cellNome = new PdfPCell(new Phrase("Pessoa".toUpperCase(), f));
		cellNome.setBackgroundColor(BaseColor.BLUE);
		cellNome.setBorderColor(BaseColor.BLUE);
		PdfPCell cellValor = new PdfPCell(new Phrase("R$ Valor".toUpperCase(), f));
		cellValor.setBackgroundColor(BaseColor.BLUE);
		cellValor.setBorderColor(BaseColor.BLUE);
		PdfPCell cellFunc = new PdfPCell(new Phrase("Funcionário".toUpperCase(), f));
		cellFunc.setBackgroundColor(BaseColor.BLUE);
		cellFunc.setBorderColor(BaseColor.BLUE);
		PdfPCell cellPagou = new PdfPCell(new Phrase("Situação".toUpperCase(), f));
		cellPagou.setBackgroundColor(BaseColor.BLUE);
		cellPagou.setBorderColor(BaseColor.BLUE);
		//bordarTo(cellIdenf, cellNome, cellValor, cellFunc, cellPagou);
		table.addCell(cellIdenf);
		table.addCell(cellNome);
		table.addCell(cellValor);
		table.addCell(cellFunc);
		table.addCell(cellPagou);

		for (Compra venda : listaOrdenadas) {
			PdfPCell item0 = new PdfPCell(new Phrase(venda.getNumero_cartela()));
			item0.setBorderColor(BaseColor.BLUE);
			PdfPCell item1 = new PdfPCell(new Phrase(venda.getPessoa().getNome()));
			item1.setBorderColor(BaseColor.BLUE);
			PdfPCell item2 = new PdfPCell(new Phrase("" + NumberFormat.getCurrencyInstance().format(+venda.getValor())));
			item2.setBorderColor(BaseColor.BLUE);
			PdfPCell item3 = new PdfPCell(new Phrase(venda.getFuncionario().getNome()));
			item3.setBorderColor(BaseColor.BLUE);
			PdfPCell item4 = new PdfPCell(new Phrase((venda.isPagou()) ? "CONCLUÍDO" : "EM ABERTO "));
			item4.setBorderColor(BaseColor.BLUE);
			table.addCell(item0);
			table.addCell(item1);
			table.addCell(item2);
			table.addCell(item3);
			table.addCell(item4);

		}

		return table;

	}

}
