package analysis;

import main.Viewer;

import java.util.ArrayList;
import java.util.List;

/**
 * will notify viewers, attach or detach viewers
 */
public abstract class Subject {
	private List<Viewer> viewers = new ArrayList<Viewer>();
	
	/**
	 * adds viewer
	 * @param viewer
	 */
	public void attach(Viewer viewer) {
		viewers.add(viewer);
	}

	/**
	 * removes viewer
	 * @param viewer
	 */
	public void detach(Viewer viewer) {
		viewers.remove(viewer);
	}

	/**
	 * notifies viewers to be displayed
	 */
	public void notifyViewers() {
		for (Viewer viewer : viewers) {
			viewer.update(this);
		}
	}
}
