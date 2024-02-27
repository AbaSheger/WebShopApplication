package patterns.observer;

public class Garment implements Event {

    private String eventType;
    private String eventMessage;


    public Garment(String eventType, String eventMessage) {
        this.eventType = eventType;
        this.eventMessage = eventMessage;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public void setEventMessage(String eventMessage) {
        this.eventMessage = eventMessage;
    }

    @Override
    public String getEventType() {
        return null;
    }

    @Override
    public String getEventMessage() {
        return eventMessage;
    }
}
