import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;


public class DateConverter{

    protected LocalDate date;

    public DateConverter(String date) {
        try {
            this.date = LocalDate.parse(date);
        } catch (DateTimeParseException e) {
            System.out.println("Please format your date properly");
        }
    }




    public String toString() {
        return this.date.format(DateTimeFormatter.ofPattern("MMM d yyyy"));

    }
}