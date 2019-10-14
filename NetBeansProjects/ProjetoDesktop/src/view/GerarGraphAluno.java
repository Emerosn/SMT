package view;

import model.ConnectionFactory;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class GerarGraphAluno extends JFrame{
    private static final long serialVersionUID = 1L;
 
	public GerarGraphAluno(String chartTitle) {
	    CategoryDataset dataset = createDataset(); 
	    JFreeChart chart = createChart(dataset, chartTitle);
	    ChartPanel chartPanel = new ChartPanel(chart); 
	    chartPanel.setPreferredSize(new java.awt.Dimension(760, 400));
            setContentPane(chartPanel);
            setTitle("Quantitativo Alunos ( Matrículados/Pendentes )");
        }	
	private CategoryDataset createDataset() {
            Connection con = new ConnectionFactory().getConnection();
            DefaultCategoryDataset result=null;
            
            try{
                String query = "SELECT COUNT(CASE WHEN strStatusMatricula = 'Matriculado' THEN intMatriculaId END) AS matriculado, COUNT(CASE WHEN strStatusMatricula = 'Pendente' THEN intMatriculaId END) AS pendente FROM matricula";
                PreparedStatement stmt = con.prepareStatement(query);
                ResultSet rs = stmt.executeQuery();
                
                result = new DefaultCategoryDataset();
                while(rs.next()){
                    result.addValue(rs.getInt("matriculado"),"Matriculado","Alunos");
	            result.addValue(rs.getInt("pendente"), "Pendente", "Alunos");
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.ERROR_MESSAGE);
            }
	    
	    return result;
	}
  
	private JFreeChart createChart(CategoryDataset dataset, String title) {
	    JFreeChart chart = ChartFactory.createBarChart3D(title,"Status", "Quantidade",dataset, PlotOrientation.VERTICAL,true, true, false);
 
	    return chart;
	}
}
