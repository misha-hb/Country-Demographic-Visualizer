package analysis;

import main.Viewer;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
	private List<Viewer> viewers = new ArrayList<Viewer>();
	
	public void attach(Viewer viewer) {
		viewers.add(viewer);
	}

	public void detach(Viewer viewer) {
		viewers.remove(viewer);
	}

	public void notifyViewers() {
		for (Viewer viewer : viewers) {
			viewer.update(this);
		}
	}
}
