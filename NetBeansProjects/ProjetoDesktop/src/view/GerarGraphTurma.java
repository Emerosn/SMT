package view;

import java.awt.Color;
import model.ConnectionFactory;
import java.sql.*;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class GerarGraphTurma {

    private static final long serialVersionUID = 1L;
    private ChartPanel chartPanel;
    
    public ChartPanel getPanel(){
        return this.chartPanel;
    }
    
    public GerarGraphTurma(String chartTitle) {
        CategoryDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset, chartTitle);
        chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(1059, 421));   
        chartPanel.setBackground(Color.DARK_GRAY);
    }

    private CategoryDataset createDataset() {
        Connection con = new ConnectionFactory().getConnection();
        DefaultCategoryDataset result = null;

        try {
            String query = "SELECT strDscTurma, intVagasOcupadas FROM turma";
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            result = new DefaultCategoryDataset();
            while (rs.next()) {
                result.addValue(rs.getInt("intVagasOcupadas"), rs.getString("strDscTurma"), "Geral");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Aviso", JOptionPane.ERROR_MESSAGE);
        }

        return result;
    }

    private JFreeChart createChart(CategoryDataset dataset, String title) {
        JFreeChart chart = ChartFactory.createBarChart3D(title, "Turmas", "Quantidade", dataset, PlotOrientation.VERTICAL, true, true, false);

        return chart;
    }
}
