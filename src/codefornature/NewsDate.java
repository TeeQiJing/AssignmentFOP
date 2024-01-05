package codefornature;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class NewsDate {
    public static String DateFormatter(String newsDate) throws ParseException{
        if(newsDate.contains("ago"))
            return "";
        else if(newsDate.split(" ").length == 2){
            // Get the current year
            Calendar cal = Calendar.getInstance();
            int currentYear = cal.get(Calendar.YEAR);
            // Create a SimpleDateFormat object for parsing the input date
            SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd MMMM");
            // Create a SimpleDateFormat object for formatting the output date
            SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd MMM yyyy");
            // Parse the input date string to obtain a Date object (without the year)
            Date date = inputDateFormat.parse(newsDate);
            // Set the year to the current year
            Calendar parsedDateCal = Calendar.getInstance();
            parsedDateCal.setTime(date);
            parsedDateCal.set(Calendar.YEAR, currentYear);
            // Format the date to the desired output format
            String formattedDate = outputDateFormat.format(parsedDateCal.getTime());
            return formattedDate;
        }else if(newsDate.split(" ").length == 3){
            // Create a SimpleDateFormat object for parsing the input date
            SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd MMMM yyyy");
            // Create a SimpleDateFormat object for formatting the output date
            SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd MMM yyyy");
            // Parse the input date string to obtain a Date object
            Date date = inputDateFormat.parse(newsDate);
            // Format the date to the desired output format
            String formattedDate = outputDateFormat.format(date);
            return formattedDate;
        }else
            return ""; 
    }
    public static Date parseDateString(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
