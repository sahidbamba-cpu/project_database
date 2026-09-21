import java.util.ArrayList;
public class PurchaseLog {

    private ArrayList<PurchaseItem> items;

    public PurchaseLog() {
        items = new ArrayList<>();
    }
    public void addItem(PurchaseItem item) {
        items.add(item);
    }

    public PurchaseItem findItemByName(String name) {
        for(PurchaseItem item: items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public void updatePrice(String name, double newPrice) {
        for (PurchaseItem item : items) {
            if (item.getName().equals(name)) {
                item.setPrice(newPrice);
            }
        }
    }

    public void printDailyReport() {
        // TODO: loop through every item — total count, total revenue, best seller
        double totalRevenue = 0;
        int totalCount= 0;
        for (PurchaseItem item : items) {
            totalRevenue += item.getPrice();
            totalCount += 1;
        }
        System.out.println("The total count is " + totalCount + "The total Revenue is $" + totalRevenue);
    }

    public int itemCount() {
        return items.size();
    }
}
