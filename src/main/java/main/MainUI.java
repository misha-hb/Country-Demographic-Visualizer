package main;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.util.TableOrder;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import analysis.Selection;

import userinterface.*;

public class MainUI extends JFrame {

	private static final long serialVersionUID = 1L;

	private static MainUI instance;
	private static JPanel west;
	
	private Selection selectionObj;
	
	
	public static MainUI getInstance() {
		if (instance == null)
			instance = new MainUI();

		return instance;
	}

	public static JPanel getPanel() {
		return west;
	}
	
	private MainUI() {
				
		// Set window title
		super("Country Statistics");
		
		selectionObj = new Selection();
		
		DropDownMenu countryDropDown = new CountryMenu("Choose a country: ", selectionObj);
		
		//YearsMenu yearsDropDown = new YearsMenu(selectionObj);
		DropDownMenu startDropDown = new StartYearMenu("From", selectionObj);
		DropDownMenu endDropDown = new EndYearMenu("To", selectionObj);

		JPanel north = new JPanel();
		north.add(countryDropDown.getLabel());
		north.add(countryDropDown.getList());
		north.add(startDropDown.getLabel());
		north.add(startDropDown.getList());
		north.add(endDropDown.getLabel());
		north.add(endDropDown.getList());

		
		Button recalculateButton = new RecalculateButton("Recalculate", selectionObj);
		
		DropDownMenu viewersDropDown = new ViewersMenu("Available Views: ", selectionObj);
		Button addButton = new AddButton("+", selectionObj, viewersDropDown.getList());
		Button removeButton = new RemoveButton("-", selectionObj, viewersDropDown.getList());

		DropDownMenu analysisDropDown = new AnalysisMenu("        Choose analysis method: ", selectionObj);

		JPanel south = new JPanel();
		south.add(viewersDropDown.getLabel());
		south.add(viewersDropDown.getList());
		south.add(addButton.getButton());
		south.add(removeButton.getButton());

		south.add(analysisDropDown.getLabel());
		south.add(analysisDropDown.getList());
		south.add(recalculateButton.getButton());

		JPanel east = new JPanel();

		// Set charts region
		west = new JPanel();
		west.setLayout(new GridLayout(2, 0));

		getContentPane().add(north, BorderLayout.NORTH);
		getContentPane().add(east, BorderLayout.EAST);
		getContentPane().add(south, BorderLayout.SOUTH);
		getContentPane().add(west, BorderLayout.WEST);
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}


	public void displayError(String msg) {
    	javax.swing.JFrame errorWindow = new javax.swing.JFrame();
    	JOptionPane.showMessageDialog(errorWindow, msg);
    	errorWindow.dispose();
	}

	public static void main(String[] args) {
		JFrame frame = MainUI.getInstance();
		//frame.setSize(900, 600);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.pack();
		frame.setVisible(true);
	}

}