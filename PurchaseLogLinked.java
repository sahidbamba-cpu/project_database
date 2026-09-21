import java.util.LinkedList;
public class PurchaseLogLinked {

    private LinkedList<PurchaseItem> items;

    public PurchaseLogLinked() {
        items = new LinkedList<>();
    }

    public void addItem(PurchaseItem item) {
        items.add(item);
    }

    public PurchaseItem findItemByName(String name) {
        for (PurchaseItem item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }

        return null;
    }

    public int itemCount() {
        return items.size();
    }

}


