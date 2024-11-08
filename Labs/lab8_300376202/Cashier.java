public class Cashier {
    private Queue<Customer> queue;
    private Customer currentCustomer;
    private int totalCustomerWaitTime;
    private int customersServed;
    private int totalItemsServed;


    public Cashier() {
        queue = new ArrayQueue<Customer>();
        totalCustomerWaitTime = 0;
        customersServed = 0;
        totalItemsServed = 0;
    }

    public int getQueueSize() {
        return queue.size();
    }

    public int getTotalCustomerWaitTime() {
        return totalCustomerWaitTime;
    }

    public int getTotalCustomersServed() {
        return customersServed;
    }

    public int getTotalItemsServed() {
        return totalItemsServed;
    }

    public void addCustomer(Customer c) {
        queue.enqueue(c);
    }


    public void serveCustomers(int currentTime) {
        if (currentCustomer == null && !queue.isEmpty()) {
            currentCustomer = queue.dequeue();
            totalCustomerWaitTime += currentTime - currentCustomer.getArrivalTime();
        }

        if (currentCustomer != null) {
            currentCustomer.serve();
            totalItemsServed++;

            if (currentCustomer.getNumberOfItems() == 0) {
                customersServed++;
                currentCustomer = null;
            }
        }
    }


    @Override
    public String toString() {
        String result = "";
        double averageItems = customersServed > 0 ? (double) totalItemsServed / customersServed : 0;
        double averageWaitTime = customersServed > 0 ? (double) totalCustomerWaitTime / customersServed : 0;

        result += "The total number of customers served is " + customersServed + "\n";
        result += "The average number of items per customer was " + String.format("%.0f", averageItems) + "\n";
        result += "The average waiting time (in seconds) was " + String.format("%.0f", averageWaitTime);

        return result;
    }
}



