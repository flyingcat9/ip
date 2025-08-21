/**
 * This class represents an event. In other words, there is a
 * starting and an ending time.
 *
 * @author: Ong Li Min
 */
public class Events extends Task{
    String startingTime;
    String endingTime;

    public Events(String description, String sT, String eT) {
        super(description);
        this.startingTime = sT;
        this.endingTime = eT;
    }

    public String toString() {
        return "[Events]" + super.toString() + "from: " + startingTime + "to: " + endingTime;
    }
}