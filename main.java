public class main {
    public static void main(String[] args) {

        // ---- Sample data to load into the Purchase Log ----
        PurchaseItem[] sampleItems = {
                new PurchaseItem("Bread", 3.49),
                new PurchaseItem("Milk", 2.99),
                new PurchaseItem("Eggs", 4.29),
                new PurchaseItem("Coffee", 8.99),
                new PurchaseItem("Bananas", 1.29),
                new PurchaseItem("Cereal", 4.79),
                new PurchaseItem("Chicken Breast", 9.99),
                new PurchaseItem("Paper Towels", 6.49)
        };

        PurchaseLog log = new PurchaseLog();

        // TODO: write a loop that adds every item in sampleItems to log using addItem().
        for (PurchaseItem item : sampleItems) {
            log.addItem(item);
        }
        System.out.println("Purchase Log loaded with " + log.itemCount() + " items.");

        // Example test call — findItemByName. Do the same for every other required method.
        PurchaseItem found = log.findItemByName("Coffee");
        System.out.println("Looked up 'Coffee', found: " +
                (found != null ? found.getName() + " $" + found.getPrice() : "NOT FOUND"));

        // TODO: test updatePrice() — update a price, then look it up again and print the new value.
        log.updatePrice("Coffee", 10.99);
        found = log.findItemByName("Coffee");
        System.out.println("New Coffee price: $" + found.getPrice());
        // TODO: test printDailyReport() — call it and confirm the totals look correct against sampleItems.
        log.printDailyReport();

        // ---- Sample data to load into the Checkout Line ----
        Customer[] sampleCustomers = {
                new Customer("Alvarez", 12),
                new Customer("Chen", 3),
                new Customer("Patel", 27),
                new Customer("O'Brien", 1)
        };

        CheckoutLine line = new CheckoutLine();

        for (Customer customer : sampleCustomers) {
            line.addToBack(customer);
        }
        System.out.println("Checkout Line loaded, size = " + line.size());

        // Example test call — addToFront (O'Brien has 1 item, gets waved to the front).
        Customer express = new Customer("Nguyen", 1);
        System.out.println("Waving " + express.getName() + " to the front...");
        line.addToFront(express);

        // TODO: test removeFromFront() — remove and print who gets served first. Should it be Nguyen?
        Customer served = line.removeFromFront();
        System.out.println("Served first: " + served.getName());

        // TODO: test removeFromBack() — remove and print who leaves from the back of the line.
        Customer left = line.removeFromBack();
        System.out.println("Left from back: " + left.getName());
        // TODO: after your test calls above, print line.size() again and confirm it changed correctly.
        System.out.println("New line size: " + line.size());



// Add sample items to ArrayList version
        for (PurchaseItem item : sampleItems) {
            log.addItem(item);
        }


// Create the LinkedList version
        PurchaseLogLinked linkedLog = new PurchaseLogLinked();

// Add the SAME sample items to LinkedList version
        for (PurchaseItem item : sampleItems) {
            linkedLog.addItem(item);
        }


// -------------------------------
// ArrayList - 1,000 lookups
// -------------------------------

        long startArrayLog = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            log.findItemByName("Coffee");
        }

        long endArrayLog = System.nanoTime();

        long arrayLogTime = endArrayLog - startArrayLog;


// -------------------------------
// LinkedList - 1,000 lookups
// -------------------------------

        long startLinkedLog = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            linkedLog.findItemByName("Coffee");
        }

        long endLinkedLog = System.nanoTime();

        long linkedLogTime = endLinkedLog - startLinkedLog;


// Print Purchase Log results

        System.out.println("\n--- Purchase Log Performance ---");

        System.out.println(
                "ArrayList (1000 lookups): " +
                        arrayLogTime + " ns"
        );

        System.out.println(
                "LinkedList (1000 lookups): " +
                        linkedLogTime + " ns"
        );


// =====================================================
// CHECKOUT LINE PERFORMANCE TEST
// LinkedList vs ArrayList
// =====================================================

// Create both versions
        CheckoutLine linkedLine = new CheckoutLine();

        CheckoutLineArray arrayLine = new CheckoutLineArray();

// Customer used for testing
        Customer testCustomer = new Customer("Test", 1);


// -------------------------------
// LinkedList - 1,000 addToFront
// -------------------------------

        long startLinkedLine = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            linkedLine.addToFront(testCustomer);
        }

        long endLinkedLine = System.nanoTime();

        long linkedLineTime =
                endLinkedLine - startLinkedLine;


// -------------------------------
// ArrayList - 1,000 addToFront
// -------------------------------

        long startArrayLine = System.nanoTime();

        for (int i = 0; i < 1000; i++) {
            arrayLine.addToFront(testCustomer);
        }

        long endArrayLine = System.nanoTime();

        long arrayLineTime =
                endArrayLine - startArrayLine;


// Print Checkout Line results

        System.out.println("\n--- Checkout Line Performance ---");

        System.out.println(
                "LinkedList (1000 addToFront): " +
                        linkedLineTime + " ns"
        );

        System.out.println(
                "ArrayList (1000 addToFront): " +
                        arrayLineTime + " ns"
        );


// =====================================================
// FINAL RESULTS
// =====================================================

        System.out.println("\n--- Final Performance Results ---");

        System.out.println(
                "PurchaseLog ArrayList: " +
                        arrayLogTime + " ns"
        );

        System.out.println(
                "PurchaseLog LinkedList: " +
                        linkedLogTime + " ns"
        );

        System.out.println(
                "CheckoutLine ArrayList: " +
                        arrayLineTime + " ns"
        );

        System.out.println(
                "CheckoutLine LinkedList: " +
                        linkedLineTime + " ns"
        );

    }
}
