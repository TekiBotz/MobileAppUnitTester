package test;

import contact.ContactService;
import contact.Contact;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ContactServiceTest {
	
    @Test
    void testAddContact() {
        ContactService service = new ContactService();

        // Add a contact with a unique ID
        Contact contact = new Contact("1234567890", "John", "Doe", "5555555555", "123 Main St");
        service.addContact(contact);
        assertEquals(contact, service.getContact("1234567890"));

        // Adding a contact with the same ID should throw an exception
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact));
    }

    @Test
    void testDeleteContact() {
        ContactService service = new ContactService();

        // Add a contact and delete it
        Contact contact = new Contact("1234567890", "John", "Doe", "5555555555", "123 Main St");
        service.addContact(contact);
        service.deleteContact("1234567890");
        assertNull(service.getContact("1234567890"));

        // Deleting a non-existent contact should not throw an exception
        assertDoesNotThrow(() -> service.deleteContact("1234567890"));
    }

    @Test
    void testUpdateContact() {
        ContactService service = new ContactService();

        // Add a contact
        Contact contact = new Contact("1234567890", "John", "Doe", "5555555555", "123 Main St");
        service.addContact(contact);

        // Update the contact's first name and phone number
        service.updateContact("1234567890", "Jane", "Doe", "4444444444", null);
        Contact updatedContact = service.getContact("1234567890");
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Doe", updatedContact.getLastName());
        assertEquals("4444444444", updatedContact.getPhone());
        assertEquals("123 Main St", updatedContact.getAddress());

        // Updating a non-existent contact should throw an exception
        assertThrows(IllegalArgumentException.class, () -> service.updateContact("0987654321", null, null, null, null));
    }
}
