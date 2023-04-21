package test;

import contact.Contact;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
	
	// Create a contact with valid inputs
    @Test
    void testCreateContactWithValidInputs() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5555555555", "123 Main St");
        assertEquals("1234567890", contact.getId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("5555555555", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }
    
    @Test
    void testSetters() {
        Contact contact = new Contact("1234567890", "John", "Doe", "1234567890", "123 Main St");
        // Sets a new first name, last name, phone number, and address
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());

        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());

        contact.setPhone("9876543210");
        assertEquals("9876543210", contact.getPhone());

        contact.setAddress("456 Elm St");
        assertEquals("456 Elm St", contact.getAddress());
    }
    
    // All remaining tests will test that the applied field is not null or not within the size range, else throws an exception
    @Test
    void testCreateContactWithInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> new Contact(null, "John", "Doe", "5555555555", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("12345678901", "John", "Doe", "5555555555", "123 Main St"));
    }

    @Test
    void testCreateContactWithInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", null, "Doe", "5555555555", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "ThisIsALongFirstName", "Doe", "5555555555", "123 Main St"));
    }

    @Test
    void testCreateContactWithInvalidLastName() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "John", null, "5555555555", "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "John", "ThisIsALongLastName", "5555555555", "123 Main St"));
    }

    @Test
    void testCreateContactWithInvalidPhone() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "John", "Doe", null, "123 Main St"));
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "John", "Doe", "123", "123 Main St"));
    }

    @Test
    void testCreateContactWithInvalidAddress() {
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "John", "Doe", "5555555555", null));
        assertThrows(IllegalArgumentException.class, () -> new Contact("1234567890", "John", "Doe", "5555555555", "ThisIsALongAddressThatIsInvalid"));
    }
}
   
