/**
 * Imaginez une classe qui s'occupe des fractions. Oui, ces choses avec un numérateur en haut
 * et un dénominateur en bas. C'est exactement ce que fait notre classe Rational. Elle vous aide
 * à manipuler ces fractions, que ce soit pour les additionner, les comparer, ou juste les afficher
 * de manière sympa. Et ne vous inquiétez pas pour les réduire à leur forme la plus simple,
 * Rational s'en occupe tout seul comme un grand.
 * cette classe est là pour rendre les fractions un peu moins intimidantes.
 *@author Mohamed Boudabbous
 */
public class Rational {
    /**
     * Vous avez juste un nombre entier et vous voulez le transformer en fraction ?
     * Pas de problème, ce constructeur prend votre entier et le met sur 1.
     * Comme transformer 5 en 5/1, simple et efficace.
     *
     * @param numerator Votre entier, prêt à devenir le haut de la fraction.
     */
    private int numerator;
    private int denominator;

    // constructors

    public Rational(int numerator) {
        this(numerator, 1);
    }

    /**
     * Constructeur qui initialise le nombre rationnel avec un numérateur et un dénominateur donnés.
     * Le nombre est réduit à sa forme la plus simple.
     *
     * @param numerator   Le numérateur du nombre rationnel.
     * @param denominator Le dénominateur du nombre rationnel. Ne doit pas être 0.
     */
    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        if (denominator < 0) {
            numerator = -1 * numerator;
            denominator = -1 * denominator;

        }
        reduce();
    }

    // getters

    public int getNumerator() {
	     return numerator;
    }

    public int getDenominator() {
	     return denominator;
    }

    // instance methods

    // Les getters, setters, et autres méthodes sont commentés de manière similaire.

    // Exemple pour la méthode plus
    // Exemple pour la méthode plus
    /**
     * Additionner des fractions ? Laissez faire Rational. Donnez-lui une autre fraction,
     * et il l'additionne à celle-ci. Le résultat ? Une nouvelle fraction, propre et nette.
     *
     * @param other La fraction que vous voulez additionner à celle-ci.
     * @return Une nouvelle fraction, qui est la somme des deux.
     */
    public Rational plus(Rational other) {

        int Numerateur1ajuste = this.numerator * other.denominator, Numerator2ajuste = other.numerator * this.denominator;
        int Denominateurcommun = this.denominator * other.denominator, SommeDesNumerateurs = Numerateur1ajuste + Numerator2ajuste;
        return new Rational(SommeDesNumerateurs,Denominateurcommun);
    }

    public static Rational plus(Rational a, Rational b) {
        Rational resultat = a.plus(b);
        return resultat;
    }

    // Transforms this number into its reduced form

    private void reduce() {
        // S'assurer que le dénominateur est positif
        if (this.denominator < 0) {
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;
        }
        int gcdValue = gcd(Math.abs(this.numerator), this.denominator);
        this.numerator /= gcdValue;
        this.denominator /= gcdValue;
    }

    // Euclid's algorithm for calculating the greatest common divisor
    private int gcd(int a, int b) {
      // Note that the loop below, as-is, will time out on negative inputs.
      // The gcd should always be a positive number.
      // Add code here to pre-process the inputs so this doesn't happen.
        a = Math.abs(a);
        b = Math.abs(b);
        if (a!=0 || b != 0) {
            if (a == 0) return b;
            if (b == 0) return a;
            return gcd(b, a % b);
        }else {
            return 0;
        }
    }

    public int compareTo(Rational other) {
        if (this.numerator * other.denominator < other.numerator * this.denominator) {
            return -1;
        }
        else if (this.numerator * other.denominator == other.numerator * this.denominator) {
            return 0;
        }
        else {
            return 1;
        }

    }

    public boolean equals(Rational other) {
        if (other == null) {
            return false;
        }
        this.reduce();
        other.reduce();
        boolean numeratorsEqual = this.numerator == other.numerator;
        boolean denominatorsEqual = this.denominator == other.denominator;
        return numeratorsEqual && denominatorsEqual;
    }


    public String toString() {
        String result = String.valueOf(numerator);
        if (denominator != 1) result += "/" + denominator;
        return result;
    }

    public static void main(String[] args) {

        Rational r1 = new Rational(3, 4);
        Rational r2 = new Rational(1, 2);

        System.out.println(r1); // affiche 3/4
        System.out.println(r2); // affiche 1/2

        Rational sum = r1.plus(r2);
        System.out.println(sum); // affiche 7/4

    }
}


