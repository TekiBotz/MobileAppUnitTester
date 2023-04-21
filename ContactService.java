package contact;


import java.util.HashMap;
import java.util.Map;

public class ContactService {
    
    private Map<String, Contact> contacts;
    
    public ContactService() {
        contacts = new HashMap<>();
    }
    
    // This method will be used to add a contact
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getId())) {
            throw new IllegalArgumentException("Contact with ID " + contact.getId() + " already exists");
        }
        contacts.put(contact.getId(), contact);
    }
    
    // This method will be used to delete a contact
    public void deleteContact(String id) {
        contacts.remove(id);
    }
    
    // This method will be used to update a contact
    public void updateContact(String id, String firstName, String lastName, String phone, String address) {
        Contact contact = contacts.get(id);
        if (contact == null) {
            throw new IllegalArgumentException("Contact with ID " + id + " does not exist");
        }
        if (firstName != null) {
            contact.setFirstName(firstName);
        }
        if (lastName != null) {
            contact.setLastName(lastName);
        }
        if (phone != null) {
            contact.setPhone(phone);
        }
        if (address != null) {
            contact.setAddress(address);
        }
    }
    
    // This method is used to retrieve a contact by its ID
    public Contact getContact(String id) {
        return contacts.get(id);
    }
}
