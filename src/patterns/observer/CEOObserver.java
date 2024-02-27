package patterns.observer;

public class CEOObserver implements Observer {

    @Override
    public void update(Event event) {
        System.out.println("CEO received event: " + event.getEventType() + " " + event.getEventMessage());
    }
}
