import java.time.Month;
import java.util.Locale;

/**
 * classe utilitaire
 * @author Livaniaina Rakotomalala (lrakotom@uottawa.ca)
 * @version 01/24/2024
 */
public class Utils {
    public static String convertMonthToFrenchString(int monthNumber) {
        if (monthNumber < 1 || monthNumber > 12) {
            return ""; // pour le moment, on n a pas besoin de se soucier ce cas. On verra le traitement des exceptions plus tard. 
        }

        Month month = Month.of(monthNumber);
        Locale frenchLocale = Locale.FRENCH;
        return month.getDisplayName(java.time.format.TextStyle.FULL, frenchLocale);
    }
}