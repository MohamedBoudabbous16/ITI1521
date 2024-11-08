import java.util.Random;
public class Customer {
    private int arrivalTime;
    private int initialNumberOfItems;
    private int numberOfItems;
    private static final int MAX_NUMBER_OF_ITEMS = 28;
    private static final Random generator = new Random();

    public Customer(int arrivalTime) {
        this.arrivalTime = arrivalTime;
        this.initialNumberOfItems = generator.nextInt(MAX_NUMBER_OF_ITEMS - 1) + 1;
        this.numberOfItems = this.initialNumberOfItems;
    }
        public int getArrivalTime() {
            return arrivalTime;
        }
        public int getNumberOfItems() {
            return numberOfItems;
        }
        public int getNumberOfServedItems(){
            return initialNumberOfItems - numberOfItems;
        }
        public void serve(){
            if (numberOfItems > 0) {
                numberOfItems--;
            }
        }
    }

