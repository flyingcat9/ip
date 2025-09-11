package date;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

import exceptions.InvalidDateInput;

/**
 * Class meant to convert the date into a better format.
 *
 * Okay for now.
 */
public class DateConverter {

    protected LocalDate date;
    protected int year;
    protected int currentDate;
    protected int month;

    /**
     * Constructor to create a new date.
     * @param date date that is meant to be converted.
     */
    public DateConverter(String date) throws InvalidDateInput {
        assert date != null : "the date is null";
        try {
            this.date = LocalDate.parse(date);
            year = this.date.getYear();
            month = this.date.getMonthValue();
            currentDate = this.date.getDayOfMonth();
        } catch (DateTimeParseException e) {
            throw new InvalidDateInput();
        }
    }

    /**
     * Returns the error message
     * @return the string formatted
     */
    public String toString() {
        return this.date.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
    }

    /**
     * @return year
     */
    public int getYear() {
        return this.year;
    }

    /**
     * @return month
     */
    public int getMonth() {
        return this.month;
    }

    /**
     * @return date
     */
    public int getDay() {
        return this.currentDate;
    }

}

