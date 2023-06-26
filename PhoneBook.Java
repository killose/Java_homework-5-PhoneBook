import java.util.*;

public class PhoneBook {
    private Map<String, Set<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void addContact(String name, String phone) {
        Set<String> phones = phoneBook.get(name);
        if (phones == null) {
            phones = new HashSet<>();
            phoneBook.put(name, phones);
        }
        phones.add(phone);
    }

    public void removeContact(String name) {
        phoneBook.remove(name);
    }

    public void printContacts() {
        List<Map.Entry<String, Set<String>>> entries = new ArrayList<>(phoneBook.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<String, Set<String>>>() {
            @Override
            public int compare(Map.Entry<String, Set<String>> e1, Map.Entry<String, Set<String>> e2) {
                return e2.getValue().size() - e1.getValue().size();
            }
        });
        for (Map.Entry<String, Set<String>> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneBook phoneBook = new PhoneBook();

        while (true) {
            System.out.println("Enter 1 to add contact");
            System.out.println("Enter 2 to remove contact");
            System.out.println("Enter 3 to print contacts");
            System.out.println("Enter 4 to exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = scanner.nextLine();
                    phoneBook.addContact(name, phone);
                    System.out.println("Contact added successfully!");
                    break;
                case 2:
                    System.out.print("Enter name: ");
                    name = scanner.nextLine();
                    phoneBook.removeContact(name);
                    System.out.println("Contact removed successfully!");
                    break;
                case 3:
                    System.out.println("Contacts:");
                    phoneBook.printContacts();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
                    break;
            }
        }
    }
}