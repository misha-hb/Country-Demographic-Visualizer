package main;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import analysis.Selection;
import userinterface.AddButton;
import userinterface.AnalysisMenu;
import userinterface.Button;
import userinterface.CountryMenu;
import userinterface.DropDownMenu;
import userinterface.EndYearMenu;
import userinterface.RecalculateButton;
import userinterface.RemoveButton;
import userinterface.StartYearMenu;
import userinterface.ViewersMenu;

/**
 * JFrame user interface for Country Statistics window
 */
public class MainUI extends JFrame {

	private static MainUI instance;
	private static JPanel west;
	
	private Selection selectionObj;
	
	/**
	 * @return Singleton MainUI object
	 */
	public static MainUI getInstance() {
		if (instance == null)
			instance = new MainUI();

		return instance;
	}

	/**
	 * JPanel for viewers to be added to
	 * @return JPanel where viewers are displayed
	 */
	public static JPanel getPanel() {
		return west;
	}
	
	/**
	 * Constructor initiates drop-down menus and buttons
	 */
	private MainUI() {
				
		super("Country Statistics");
		
		selectionObj = new Selection();
		
		// Create country menu
		DropDownMenu countryDropDown = new CountryMenu("Choose a country: ", selectionObj);
		
		// Create year menus
		DropDownMenu startDropDown = new StartYearMenu("From", selectionObj);
		DropDownMenu endDropDown = new EndYearMenu("To", selectionObj);

		// Add north JPanel components
		JPanel north = new JPanel();
		north.add(countryDropDown.getLabel());
		north.add(countryDropDown.getList());
		north.add(startDropDown.getLabel());
		north.add(startDropDown.getList());
		north.add(endDropDown.getLabel());
		north.add(endDropDown.getList());
	

		// Create recalculate button
		Button recalculateButton = new RecalculateButton("Recalculate", selectionObj);
		
		// Create viewer selection components
		DropDownMenu viewersDropDown = new ViewersMenu("Available Views: ", selectionObj);
		Button addButton = new AddButton("+", selectionObj, viewersDropDown.getList());
		Button removeButton = new RemoveButton("-", selectionObj, viewersDropDown.getList());

		// Create analysis menu
		DropDownMenu analysisDropDown = new AnalysisMenu("Choose analysis method: ", selectionObj);

		// Add south JPanel components
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

	/**
	 * Display error message
	 * @param msg - Message to display to user
	 */
	public void displayError(String msg) {
    	javax.swing.JFrame errorWindow = new javax.swing.JFrame();
    	JOptionPane.showMessageDialog(errorWindow, msg);
    	errorWindow.dispose();
	}


}