public class DoorLock {

    // Constant.
    public static final int MAX_NUMBER_OF_ATTEMPTS = 3;

    // Instance variables.
    private Combination combination;
    private boolean open;
    private boolean activated;
    private int numberOfAttempts;

    // Constructor.
    public DoorLock( Combination combination ) {
        this.combination = combination;
        this.open = false;
        this.activated = true;
        this.numberOfAttempts = 0;
    }

    // Access methods.

    public boolean isOpen() {
        return open;
    }

    public boolean isActivated() {
        return activated;
    }

    // Notice that numberOfAttempts is compared to
    // MAX_NUMBER_OF_ATTEMPTS only when its value has been
    // incremented, Also, numberOfAttempts should be set to zero when
    // activated is false.  Problems related to the combined action of
    // these two variables have caused problems for some students.

    public boolean open( Combination combination ) {

        if (!activated){
            return false;
        }
        if(this.combination.equals(combination)){
            open = true;
            numberOfAttempts = 0;
            return true;
        }
        else{
            numberOfAttempts++;
            if(numberOfAttempts >= MAX_NUMBER_OF_ATTEMPTS){
                activated = false;
            }
            return false;
        }

    }

    public void activate( Combination c ) {
        if(this.combination.equals(c)){
            activated = true;
            numberOfAttempts = 0;
        }
    }
    public static void main(String[] args) {
        DoorLock lock = new DoorLock(new Combination(1, 2, 3)); // Utilisez la combinaison appropriée
        lock.activate(new Combination(1, 2, 3)); // Activez avec la bonne combinaison
        System.out.println("Le verrou fonctionne correctement: " + lock.open(new Combination(1, 2, 3)));
    }

}