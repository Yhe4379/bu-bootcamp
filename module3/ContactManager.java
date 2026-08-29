import java.util.*;

public class ContactManager {

    public static void main(String[] args) {

        HashMap<String, Contact> contacts = new HashMap<>();

        // Step 4: add contacts here
        contacts.put("Ada Lovelace", new Contact("Ada Lovelace", "+1 617 555 0101"));
        contacts.put("Alan Turing", new Contact("Alan Turing", "+1 617 555 0102"));
        contacts.put("Grace Hopper", new Contact("Grace Hopper", "+1 617 555 0103"));
        contacts.put("Katherine Johnson", new Contact("Katherine Johnson", "+1 617 555 0104"));
        contacts.put("Linus Torvalds", new Contact("Linus Torvalds", "+1 617 555 0105"));

        // Step 5: look up a contact
        Contact found = contacts.get("Ada Lovelace");
        if (found == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println("Lookup result: " + found);
        }

        // 再查一个不存在的名字,验证 not-found 逻辑
        Contact missing = contacts.get("Bill Gates");
        if (missing == null) {
            System.out.println("Contact not found.");
        } else {
            System.out.println("Lookup result: " + missing);
        }

        // Step 6: print sorted list
        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());

        // 按名字字母顺序排序
        sorted.sort((a, b) -> a.getName().compareTo(b.getName()));

        // 打印表头和整个列表
        System.out.println("=== All Contacts ===");
        for (Contact c : sorted) {
            System.out.println(c);
        }
    }
}