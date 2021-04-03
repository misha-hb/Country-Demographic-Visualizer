package main;

import javax.swing.JPanel;

import analysis.Subject;

public interface Viewer {
	
	public void update(Subject subject);
	public void drawViewer();
}
