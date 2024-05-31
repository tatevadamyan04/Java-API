import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PhoneBook {
    private HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();

    
    public void add(String name, String phoneNum) {
        phoneBook.computeIfAbsent(name, k -> new ArrayList<>()).add(phoneNum);
    }

    public List<Map.Entry<String, ArrayList<String>>> getSortedPhoneBook() {
        List<Map.Entry<String, ArrayList<String>>> entries = new ArrayList<>(phoneBook.entrySet());
        entries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));
        return entries;
    }

    
    public void showPhoneBook() {
        List<Map.Entry<String, ArrayList<String>>> sortedEntries = getSortedPhoneBook();
        for (Map.Entry<String, ArrayList<String>> entry : sortedEntries) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}


public class Printer {
    public static void main(String[] args) {
        PhoneBook myPhoneBook = new PhoneBook();
        myPhoneBook.add("Alice", "123456");
        myPhoneBook.add("Alice", "789012");
        myPhoneBook.add("Bob", "789012");
        myPhoneBook.add("Alice", "345678");
        myPhoneBook.add("Bob", "123123");
        myPhoneBook.add("Charlie", "456456");
        myPhoneBook.add("Charlie", "789789");
        myPhoneBook.add("Charlie", "456789");
        myPhoneBook.add("Charlie", "123789");

        myPhoneBook.showPhoneBook();
    }
}