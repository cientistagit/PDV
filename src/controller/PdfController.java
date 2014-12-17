package controller;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Produto;
import model.persistencia.DAOPdf;
import model.persistencia.DAOVenda;

/**
 *
 * @author Victor
 */
public class PdfController {

    /*
     * This class is part of the book "iText in Action - 2nd Edition"
     * written by Bruno Lowagie (ISBN: 9781935182610)
     * For more info, go to: http://itextpdf.com/examples/
     * This example only works with the AGPL version of iText.
     */
    /**
     * The resulting PDF file.
     */
    public static final String ESTOQUE_PATH = "PDFs/estoque.pdf";

    public static final String PRODUTOS_PATH = "PDFs/produtos.pdf";

    public static final int ESTOQUE_TYPE = 1;

    public static final int PRODUTOS_TYPE = 2;

    public static final String ENTRADA_PATH = "PDFs/entrada.pdf";

    public static final String SAIDA_PATH = "PDFs/saida.pdf";

    public static final int ENTRADA_TYPE = 3;

    public static final int SAIDA_TYPE = 4;

    public static final String VENDA_PATH = "PDFs/venda.pdf";

    public static final String CAIXA_PATH = "PDFs/caixa.pdf";

    public static final int VENDA_TYPE = 5;

    public static final int CAIXA_TYPE = 6;

    /**
     * Main method.
     *
     * @param args no arguments needed
     * @throws DocumentException
     * @throws IOException
     */
    public static void main(String[] args)
            throws IOException, DocumentException {
        File f = new File("PDFs");
        f.mkdir();

        new PdfController().createPdf(ESTOQUE_TYPE);
        new PdfController().createPdf(PRODUTOS_TYPE);
    }

    /**
     * Creates a PDF with information about the movies
     *
     * @param filename the name of the PDF file that will be created.
     * @throws DocumentException
     * @throws IOException
     */
    public void createPdf(int type)
            throws IOException, DocumentException {
        // step 1
        Document document = new Document();
        // step 2
        if (type == CAIXA_TYPE) {
            PdfWriter.getInstance(document, new FileOutputStream(CAIXA_PATH));
            // step 3
            document.open();
            // step 4
            //document.add(produtos());

        } else if (type == ENTRADA_TYPE) {
            PdfWriter.getInstance(document, new FileOutputStream(ENTRADA_PATH));
            // step 3
            document.open();
            // step 4
            //document.add(produtos());

        } else if (type == ESTOQUE_TYPE) {
            File f = new File("PDFs");
            f.mkdir();
            PdfWriter.getInstance(document, new FileOutputStream(ESTOQUE_PATH));
            // step 3
            document.open();
            // step 4
            document.add(estoque());

        } else if (type == PRODUTOS_TYPE) {
            PdfWriter.getInstance(document, new FileOutputStream(PRODUTOS_PATH));
            // step 3
            document.open();
            // step 4
            document.add(produtos());

        } else if (type == SAIDA_TYPE) {
            PdfWriter.getInstance(document, new FileOutputStream(SAIDA_PATH));
            // step 3
            document.open();
            // step 4
            //document.add(produtos());

        } else if (type == VENDA_TYPE) {
            PdfWriter.getInstance(document, new FileOutputStream(VENDA_PATH));
            // step 3
            document.open();
            // step 4
            //document.add(produtos());
        }

        // step 5
        document.close();
    }

    /**
     * Creates our first table
     *
     * @return our first table
     */
    public static PdfPTable produtos() {
        // a table with three columns
        PdfPTable table = new PdfPTable(3);
        //        
        ArrayList<Produto> p = new DAOPdf().allProduct();
        // the cell object
        PdfPCell cell;
        // we add a cell with colspan 3
        Phrase title = new Phrase("PRODUTOS");
        //
        cell = new PdfPCell(title);
        cell.setColspan(3);
        table.addCell(cell);
        // now we add a cell with rowspan 2
        //cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
        //cell.setRowspan(2);
        //table.addCell(cell);
        // we add the four remaining cells with addCell()
        //
        table.addCell("ID");
        table.addCell("Descrição");
        table.addCell("Valor");

        //
        while (!p.isEmpty()) {
            Produto po = p.remove(0);
            table.addCell("" + po.getIdProduto());
            table.addCell(po.getDescricao());
            table.addCell("" + po.getValorVenda());
        }

        table.addCell("");
        table.addCell("");

        //
        return table;
    }

    public static PdfPTable estoque() {
        // a table with three columns
        PdfPTable table = new PdfPTable(4);
        //        
        ArrayList<Produto> p = new DAOPdf().allProduct();
        // the cell object
        PdfPCell cell;
        // we add a cell with colspan 3
        cell = new PdfPCell(new Phrase("ESTOQUE"));
        cell.setColspan(4);
        table.addCell(cell);
        // now we add a cell with rowspan 2
        //cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
        //cell.setRowspan(2);
        //table.addCell(cell);
        // we add the four remaining cells with addCell()
        //
        table.addCell("ID");
        table.addCell("Descrição");
        table.addCell("Valor");
        table.addCell("Quantidade");

        //        

        while (!p.isEmpty()) {
            Produto po = p.remove(0);
            table.addCell("" + po.getIdProduto());
            table.addCell(po.getDescricao());
            table.addCell("" + po.getValorVenda());
            table.addCell("" + po.getQuantidade());
        }

        //
        return table;
    }
}
