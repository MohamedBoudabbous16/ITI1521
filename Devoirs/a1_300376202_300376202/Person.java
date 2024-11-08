import java.util.Arrays;
import java.util.stream.Collectors;

import java.time.LocalDate;
import java.time.Period;

/**
 * la classe Personne qui garde les informations d une personne
 * 
 * @author Livaniaina Rakotomalala (lrakotom@uottawa.ca)
 * @version 01/24/2024
 */
public class Person {
    //le format du nas, ici en bloc de 3 chiffres e.g. 123 456 789.  Si NASGROUPFORMAT=2, alors on aurait 12 34 56 78 9
    public static int NASGROUPFORMAT = 3;

    //la longueur du nas, au canada le nas est compose de 9 chiffres
    public static final int NASLENGTH = 9;

    //variable d'instance
    private String name;
    private int[] dateOfBirth;
    private Integer[] nas; // declarer nas comme un Integer[]
    

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
     * retourne le numero d assurance en social en fomrat NASGROUPFORMAT e.g. "123 456 789"
     * 
     * @return le nas 
     */
    public String getNas() {
        if (nas == null) {
            return null;
        }

        String nasString = "";
        for (int i = 0; i < nas.length; i++) {
            nasString += nas[i].toString();
            if ((i + 1) % NASGROUPFORMAT == 0 && (i + 1) < nas.length) {
                nasString += " ";
            }
        }

        return nasString;
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
        if (isNasValid(nas)){
            this.nas = parseNas(nas, NASGROUPFORMAT);
        }

    }
    //Hint: verifier que le parametre nas est valide et utiliser la methode de classe parseNas
    
    // Methodes d'instance

    /**
     * retourne l age actuel de la personne
     * 
     * @return l age 
     */
    public int getCurrentAge() {

        return calculateAgeAtDate(this, LocalDate.now());
        //Hint: utiliser la methode de classe calculateAgeAtDate
        
    }

    /**
     * retourne la version String de la personne en format "Nom ... , Date de naissance: [...], Nas: ... (si le nas existe) " 
     * e.g Nom: Michael Jordan, Date de naissance: [17 février 1963]
     * e.g Nom: Marie Tremblay, Date de naissance: [1 juillet 1980], Nas: (123 456 789)
     * @return la version string de l objet Person
     */
    @Override
    public String toString() {
        String[] monthNames = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };

        String dobString = "Not provided";
        if (dateOfBirth != null && dateOfBirth.length == 3) {
            String month = dateOfBirth[1] >= 1 && dateOfBirth[1] <= 12 ? monthNames[dateOfBirth[1] - 1] : "Invalid month";
            dobString = dateOfBirth[2] + " " + month + " " + dateOfBirth[0];

        }

        String nasString = nas == null ? "" : ", Nas: (" + getNas().replaceAll("\\s","") + ")";
        return "Nom: " + name + ", Date de naissance: [" + dobString + "]" + nasString;
    }


    //Methodes de classe
    
    /**
     * Méthode Helper pour calculer l'âge  par rapport a la date envoye en parametre
     * @param person la personne dont l age est a calculer
     * @param date la date de reference (e.g. date d aujourhui ou une date quelconque)
     * @return l age 
     */
    public static int calculateAgeAtDate(Person person, LocalDate date) {
        LocalDate birthDate = LocalDate.of(person.getDateOfBirth()[0], person.getDateOfBirth()[1], person.getDateOfBirth()[2]);
        Period period = Period.between(birthDate, date);
        return period.getYears();
        //Hint: inspirez vous des methodes utilitaires de la classe java.Time.LocalDate et java.Time.Period
    }

    /**
     * Méthode Helper pour verifier si un nas est valide
     * @param input le nas 
     * @return vrai si le nas est valide
     */
    public static boolean isNasValid(String input) {
        input = input.replace(" ", "");

        // Check if the length is exactly NASLENGTH and if all characters are digits.
        return input.length() == NASLENGTH && input.matches("\\d{" + NASLENGTH + "}");
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
    private static Integer[] parseNas (String nasString, int format) {
        String streamlinedNas = nasString.replace(" ", "");
        int totalGroups = (int) Math.ceil((double)streamlinedNas.length() / format);
        Integer[] nasGroups = new Integer[totalGroups];
        for (int index = 0; index < totalGroups; index++) {
            int groupStart = index * format;
            int groupEnd = Math.min(groupStart + format, streamlinedNas.length());
            nasGroups[index] = Integer.parseInt(streamlinedNas.substring(groupStart, groupEnd));
        }

        return nasGroups;
    }
        //Hint: la methode java.lang.Math.ceil et la methode d instance substring de String  pourraientt vous aider


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
