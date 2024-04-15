import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InventoryManagementSystem {

    private static Map<String, Integer> inventory = new HashMap<>();
    private static int totalItems = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Inventory Management System");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Display Items");
            System.out.println("4. Edit Quantity");
            System.out.println("5. Get Item Information by ID");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    removeItem();
                    break;
                case 3:
                    displayItems();
                    break;
                case 4:
                    editQuantity();
                    break;
                case 5:
                    getItemInformation();
                    break;
                case 6:
                    System.out.println("Exiting Inventory Management System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 6);
    }

    private static void addItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter item ID: ");
        String itemId = scanner.next();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        if (inventory.containsKey(itemId)) {
            inventory.put(itemId, inventory.get(itemId) + quantity);
        } else {
            inventory.put(itemId, quantity);
            totalItems++;
        }

        System.out.println("Item added successfully.");
    }

    private static void removeItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter item ID: ");
        String itemId = scanner.next();

        if (inventory.containsKey(itemId)) {
            System.out.print("Enter quantity to remove: ");
            int quantityToRemove = scanner.nextInt();
            int currentQuantity = inventory.get(itemId);

            if (quantityToRemove >= currentQuantity) {
                inventory.remove(itemId);
                totalItems--;
            } else {
                inventory.put(itemId, currentQuantity - quantityToRemove);
            }

            System.out.println("Item removed successfully.");
        } else {
            System.out.println("Item not found in the inventory.");
        }
    }

    private static void displayItems() {
        System.out.println("Inventory Items:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println("Item ID: " + entry.getKey() + ", Quantity: " + entry.getValue());
        }
        System.out.println("Total number of items: " + totalItems);
    }

    private static void editQuantity() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter item ID: ");
        String itemId = scanner.next();

        if (inventory.containsKey(itemId)) {
            System.out.print("Enter new quantity: ");
            int newQuantity = scanner.nextInt();
            inventory.put(itemId, newQuantity);
            System.out.println("Quantity updated successfully.");
        } else {
            System.out.println("Item not found in the inventory.");
        }
    }

    private static void getItemInformation() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter item ID: ");
        String itemId = scanner.next();

        if (inventory.containsKey(itemId)) {
            System.out.println("Item ID: " + itemId + ", Quantity: " + inventory.get(itemId));
        } else {
            System.out.println("Item not found in the inventory.");
        }
    }
}
