
package models;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;



public class CEO implements  PropertyChangeListener {

    private String name;

    public CEO() {
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("🔔 Notification for CEO 🔔: " + evt.getNewValue());
    }



}
