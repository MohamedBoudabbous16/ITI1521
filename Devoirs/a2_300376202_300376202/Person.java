import java.time.LocalDate;
import java.time.Period;

/**
 * la classe Personne qui garde les informations d une personne
 * 
 * @author Livaniaina Rakotomalala (lrakotom@uottawa.ca)
 * @version 01/24/2024
 */
public class Person {
    //le format du nas, ici en bloc de 3 chiffres e.g. 123 456 789 , si NASGROUPFORMAT=2, alors on aurait 12 34 56 78 9
    public static int NASGROUPFORMAT = 3;

    //la longueur du nas, au canada le nas est compose de 9 chiffres
    public static final int NASLENGTH = 9;

    //variable d'instance
    private String name;
    private int[] dateOfBirth;
    private Integer[] nas;

    // Constructor
    /**
     * 
     * <p>Construit un object Person </p>
     * 
     * @param name le nom de la personne
     */
    public Person (String name) {
        this.name = name;
    }

     /**
     * 
     * <p>Construit un object Person </p>
     * 
     * @param name le nom de la personne
     * @param dateOfBirthString la date de naissance en format AAAA-MM-JJ
     */
     public Person (String name, String dateOfBirthString) {
        this.name = name;
        this.dateOfBirth = parseDateOfBirth(dateOfBirthString);
    }

    //getters method

    /**
     * retourne le nom
     * 
     * @return le nom de la personne
     */
    public String getName() {
        return this.name;
    }

    /**
     * retourne la date de naissance
     * 
     * @return la date de naissance en tableau de int
     */
    public int[] getDateOfBirth() {
        return this.dateOfBirth;
    }


    /**
     * retourne le numero d assurance en social en fomrat NASGROUPFORMAT i.e. 000 000 000
     * 
     * @return le nas 
     */
    public String getNas() {
        if (this.nas != null) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < this.nas.length; i++) {
                stringBuilder.append(this.nas[i]);

                // Ajouter un espace après chaque élément (sauf le dernier)
                if (i < this.nas.length - 1) {
                    stringBuilder.append(" ");
                }
            }

            return stringBuilder.toString();
        }
        else {
            return "";
        }
    }

     // Setter methods

     /**
     * 
     * <p>met en place le nom de la personne</p>
     * @param  name le nom
     */ 
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * <p>met en place le date de naissance de la personne</p>
     * @param  dateOfBirthString en format AAAA-MM-JJ
     */
    public void setDateOfBirth(String dateOfBirthString) {
        this.dateOfBirth = parseDateOfBirth(dateOfBirthString);
    }

    /**
     * 
     * <p>met en place le numero d assurance sociale de la personne s il est valide</p>
     * @param nas compose uniquement de 9 chiffres (123456789 ou 123 456 789 etc)
     */
    public void setNas(String nas) {
        if (isNasValid(nas)) {
            this.nas = parseNas(nas, NASGROUPFORMAT);
        }
    }
    
    // Methodes d'instance

    /**
     * retourne l age actuel de la personne
     * 
     * @return l age 
     */
    public int getCurrentAge() {
        return calculateAgeAtDate(this, LocalDate.now());
    }

    /**
     * retourne la version string de la personne en format "Nom ... , Date de naissance: [...], Nas: ... (si le nas existe) " 
     * e.g Nom: Michael Jordan, Date de naissance: [17 février 1963]
     * e.g Nom: Marie Tremblay, Date de naissance: [1 juillet 1980], Nas: (123 456 789)
     * @return la version string de l objet Person
     */
    public String toString() {
        String result = ""; 
        
        result = result +  "Nom: " + this.getName() + ", ";
        result +=  "Date de naissance: ";

        int[] dob = this.getDateOfBirth();

        result += "[";
        for (int i = dob.length-1; i>=0 ; i--) {  
            if (i==1) {
                result += Utils.convertMonthToFrenchString(dob[i]);
            }
            else {
                result += dob[i];
            }
            if (i!=0) {
                result += " ";
            }
        }
        result += "]";

        if (this.nas!=null) {
            result += (", Nas: (" + this.getNas() + ")");
        }

        return result;
    }

    //Methodes de classe
    
    /**
     * Méthode Helper pour calculer l'âge  par rapport a la date envoye en parametre
     * @param person la personne dont l age est a calculer
     * @param date la date de reference (e.g. date d aujourhui ou une date quelconque)
     * @return l age 
     */
    public static int calculateAgeAtDate(Person person, LocalDate date) {
        LocalDate dateEnd = date;
        LocalDate birthday = LocalDate.of(person.getDateOfBirth()[0], person.getDateOfBirth()[1], person.getDateOfBirth()[2]);

        Period period = Period.between(birthday, dateEnd);
        return period.getYears();
    }

    /**
     * Méthode Helper pour verifier si un nas est valide
     * @param input le nas 
     * @return vrai si le nas est valide
     */
    public static boolean isNasValid(String input) {
        //on enleve les espaces vides
        input = input.replace(" ", "");

        // Vérifiez si la chaîne contient exactement 9 caractères
        if (input.length() != NASLENGTH) {
            return false;
        }

        // Vérifiez si le premier caractère est un chiffre supérieur à 0
        char firstChar = input.charAt(0);
        if (!Character.isDigit(firstChar) || firstChar == '0') {
            return false;
        }

        // Vérifiez si le reste des caractères sont des chiffres
        for (int i = 1; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }

        // Si toutes les conditions sont remplies, la chaîne est valide
        return true;
    }

    /**
     * Méthode Helper pour mettre la chaîne de caractere  date de naissance dans un tableau d'entiers
     * @param dateOfBirthString le  date de naissance en format AAAA-MM-JJ 
     * @return un tableau de int 
     */
    private static int[] parseDateOfBirth(String dateOfBirthString) {
        // En supposant que la chaîne de date de naissance soit au format « AAAA-MM-JJ »
        String[] parts = dateOfBirthString.split("-");

        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        // Créer un tableau pour représenter la date de naissance
        int[] dateOfBirthArray = {year, month, day};

        return dateOfBirthArray;
    }

    /**
     *  Méthode Helper pour mettre la chaîne de caractere nas dans un tableau d'entiers
     * @param nas le  numero d assurance social
     * @param format la longueur de chaque bloc 
     * @return un tableau de Integer
     */
    private static Integer[] parseNas (String nas, int format) {
        int length = nas.length();
        int arrayLength = (int) Math.ceil( (double) length / format);  // Déterminer la longueur du tableau résultant
        Integer[] result = new Integer[arrayLength];

        for (int i = 0; i < arrayLength; i++) {
            // Extrayez chaque sous-chaîne à <format (ici 3)> chiffres et le transformer en un entier
            int debutPosition = i * format;
            int finPosition = (i + 1) * format;
            if (finPosition > length) { // au cas ou length n est pas divisible par format (length/format n est pas un nombre entier)
                finPosition = length;
            }
            String substring = nas.substring(debutPosition, finPosition);
            result[i] = Integer.parseInt(substring);
        }

        return result;
    }

    /**
     * Méthode principale 
     * @param args parametres de la ligne de commande
     */    
    public static void main(String[] args) {
        // Creating a Person object
        Person am = new Person("Mozart", "1756-01-27");
        Person jd = new Person("Jeanne D'arc", "1412-01-06");
        Person jesus = new Person("Jesus Christ", "0-12-25");
        Person mj = new Person("Michael Jordan");
        mj.setDateOfBirth("1963-02-17");
        Person mt = new Person("Marie Tremblay", "1980-7-1");
        mt.setNas("123456789");

        StudentInfo.display();

        System.out.println(am.toString() + ", Age: " + am.getCurrentAge()); 
        LocalDate dateDecesJd = LocalDate.of(1431, 5,30);
        System.out.println(jd.toString() + ", Age au decès: " + Person.calculateAgeAtDate(jd, dateDecesJd));
        System.out.println(jesus.toString() + ", Age: " + jesus.getCurrentAge());
        System.out.println(mj.toString() + ", Age: " + Person.calculateAgeAtDate(mj, LocalDate.now())); // une autre alternative de chercher l age
        System.out.println(mt.toString());
        System.out.println();
    }
}
