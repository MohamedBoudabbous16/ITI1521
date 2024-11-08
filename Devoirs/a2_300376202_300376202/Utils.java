import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

/**
 * classe utilitaire
 * @author Livaniaina Rakotomalala (lrakotom@uottawa.ca)
 * @version 02/10/2024
 */
public class Utils {

    /**
     * traduit un mois en version nombre en francais.
    * @param monthNumber le mois en nombre
    * @return la valeur du mois en francais.
    */
    public static String convertMonthToFrenchString(int monthNumber) {
        if (monthNumber < 1 || monthNumber > 12) {
            return ""; // pour le moment, on n a pas besoin de se soucier ce cas. On verra le traitement des exceptions plus tard. 
        }

        Month month = Month.of(monthNumber);
        Locale frenchLocale = Locale.FRENCH;
        return month.getDisplayName(java.time.format.TextStyle.FULL, frenchLocale);
    }

    /**
     * retourne la valeur LocalDateTime d un string
    * @param dateTimeString le String version de la date
    * @return la valeur LocalDateTime.
    */
    public static LocalDateTime convertStringToDateTime(String dateTimeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        //System.out.println("date=" + dateTimeString);
        return LocalDateTime.parse(dateTimeString, formatter);
    }

    /**
     * retourne la valeur int d un string sinon retourne la valeur par defaut si une erreur arrive pendant la conversion
    * @param number le int en String
    * @param defaultVal la valeur par defaut retournee si erreur
    * @return la valeur int.
    */
    public static int parseIntWithDefault(String number, int defaultVal) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return defaultVal;
        }
    }

    /**
     * * retourne la valeur Double d un string sinon retourne la valeur par defaut si une erreur arrive pendant la conversion
    * @param number le Double en String
    * @param defaultVal la valeur par defaut retournee si erreur
    * @return la valeur Double
    */
    public static Double parseDoubleWithDefault(String number, Double defaultVal) {
        try {
            return Double.parseDouble(number);
        } catch (NumberFormatException e) {
            return defaultVal;
        }
    }

    /**
     * * genere un nombre entier pair entre 0 et 9
    * @return le nombre pair
    */
    public static int generateRandomEvenNumber() {
        Random random = new Random();
        int randomNum = random.nextInt(5) * 2 ;  // Multiply by 2 to get even numbers,
        return randomNum;
    }
}