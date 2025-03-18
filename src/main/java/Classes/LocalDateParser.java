package Classes;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

// used for parsing dates 
public class LocalDateParser {
    public static LocalDate parseDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Adjust the pattern as needed
        try {
            return LocalDate.parse(dateStr, formatter); // Convert String to LocalDate
        } catch (DateTimeParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}