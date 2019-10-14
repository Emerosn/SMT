package model;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GerarComprovante{
    private String Cpf;
    private Connection con = null;
    
    public GerarComprovante(String Cpf){
        this.Cpf =  Cpf;
        this.con = new ConnectionFactory().getConnection();
    }
    
    public void gerarPDF() throws SQLException, DocumentException, FileNotFoundException{         
        
        String nome=null, cpf=null, turno=null, curso=null, text=null, dataf=null;
        Image img = null;
        int cod=0;
        
        String query = "SELECT p.intPessoaId, p.strNomePessoa, p.strCpfPessoa, p.strEnderecoPessoa, p.strCidadePessoa, a.strMatricula, m.datDataMatricula, c.strNomeCurso, c.strTurno, c.strAnoLetivo FROM pessoa AS p INNER JOIN aluno AS a ON a.intPessoaId = p.intPessoaId INNER JOIN matricula AS m ON m.intAlunoId = a.intAlunoId INNER JOIN turma AS t ON t.intTurmaId = m.intTurmaId INNER JOIN curso AS c ON c.intCursoId = t.intCursoId WHERE p.strCpfPessoa = ?";
        PreparedStatement stmt = this.con.prepareStatement(query);
        stmt.setString(1, this.Cpf);
        ResultSet rs = stmt.executeQuery();
        
        SimpleDateFormat df = new SimpleDateFormat("YYYY");
        
        while(rs.next()){
            nome = rs.getString("strNomePessoa");
            cpf = rs.getString("strCpfPessoa");
            turno = rs.getString("strTurno");
            curso = rs.getString("strNomeCurso");
            dataf = df.format(rs.getDate("strAnoLetivo"));
            cod = rs.getInt("intPessoaId");
        }

        try {
            img = Image.getInstance("LOGO.png");
        } catch (BadElementException ex) {
            Logger.getLogger(GerarComprovante.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GerarComprovante.class.getName()).log(Level.SEVERE, null, ex);
        }
        Document doc = new Document(PageSize.A5);
        PdfWriter.getInstance(doc, new FileOutputStream("comprovante"+cod+".pdf"));
        doc.open();
        img.setAlignment(Image.ALIGN_CENTER);
        img.scaleToFit(100f, 100f);
     
        doc.add(img);
        Font font = new Font(FontFamily.TIMES_ROMAN, 24, Font.BOLD);
        Paragraph title = new Paragraph("Comprovante de Matrícula", font);
        title.setAlignment(Element.ALIGN_CENTER);
        doc.add(title);
        
        text = "\n\n\n Atesto, atendendo o requerimento do(a) interessado, que "+nome+", inscrito(a) no CPF sob o n°"+cpf+", é aluno(a) regularmente matrículado(a) no "+curso+", na Escola Municipal de Canindé, cursando no Ano letivo de "+dataf+" no périodo "+turno+".";
        
        Paragraph p1 = new Paragraph(text);
        p1.setAlignment(Element.ALIGN_JUSTIFIED);
        doc.add(p1);
        doc.add(new Paragraph("\n\n        Assinatura do Responsável:"));
        doc.add(new Paragraph("\n  Assinatura do Diretor/Sercretário:"));
        doc.close();
      
        rs.close();
        stmt.close();
        this.con.close();
    }
}
