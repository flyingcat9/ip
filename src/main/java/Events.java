/**
 * This class represents an event. In other words, there is a
 * starting and an ending time.
 *
 * @author: Ong Li Min
 */
public class Events {
    String startingTime;
    String endingTime;

    public Events(String description, String sT, String eT) {
        this.startingTime = sT;
        this.endingTime = eT;
    }
}