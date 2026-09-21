import java.util.ArrayList;
public class CheckoutLineArray{

    private ArrayList<Customer> customers;

    public CheckoutLineArray() {
        customers = new ArrayList<>();
    }

    public void addToFront(Customer customer) {
        customers.add(0, customer);
    }

    public void addToBack(Customer customer) {
        customers.add(customer);
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
