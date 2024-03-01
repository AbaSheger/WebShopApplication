package patterns.obsever;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class Notification {

    private PropertyChangeSupport support;

    public Notification() {
        support = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public void notifyOrderPlaced() {
        support.firePropertyChange("orderStatus", "", "plagg tillverkas");
    }

    public void notifyOrderReady() {
        support.firePropertyChange("orderStatus", "", "plagg klar");
    }

}
