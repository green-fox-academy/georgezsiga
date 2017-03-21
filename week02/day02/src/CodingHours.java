/**
 * Created by georgezsiga on 3/21/17.
 */
public class CodingHours {
    public static void main(String[] args) {
        // An average Green Fox attendee codes 6 hours daily
        // The semester is 17 weeks long
        //
        // Print how many hours is spent with coding in a semester by an attendee,
        // if the attendee only codes on workdays.
        //
        // Print the percentage of the coding hours in the semester if the average
        // work hours weekly is 52

        float a = ((17 * 5) * 6);
        float b = (17*52);
        float c = (a / b) * 100;
        System.out.println( a + " hours spent with coding by an attendee during the semester");
        System.out.println("The attendee spent: " + c + "% with coding from the avaiable time.");
    }
}
