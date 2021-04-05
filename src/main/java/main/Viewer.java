package main;

import javax.swing.JPanel;

import analysis.Subject;

/**
 * viewer interface
 */
public interface Viewer {
	
	public void update(Subject subject);
	public void drawViewer();
}
