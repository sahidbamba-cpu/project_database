import java.util.LinkedList;
public class CheckoutLine {


    private LinkedList<Customer> customers;

    public CheckoutLine(){
        customers = new LinkedList<>();
    }

    public void addToBack(Customer c) {
        customers.add(c);
    }

    public void addToFront(Customer c) {
        customers.add(0, c);
    }

    public Customer removeFromFront() {
        return customers.remove(0);
    }

    public Customer removeFromBack() {
        return customers.remove(customers.size() - 1);
    }

    public int size() {
        return customers.size();
    }
}

