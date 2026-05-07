package Collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MobilePhoneTest {

    MobilePhone phone = new MobilePhone("0");
    Contact c1 = new Contact("test1", "12345");
    Contact c2 = new Contact("test2", "23456");


    @Test
    void addNewContact() {
        //when
        phone.addNewContact(c1);
        //then
        assertNotEquals(-1, phone.findContact(c1));
        assertEquals(-1, phone.findContact(c2));
    }

    //should not work
    @Test
    void addExisitingContact() {
        phone.addNewContact(c1);
        assertFalse(phone.addNewContact(c1));
    }

    @Test
    void removeContact() {
    }

    @Test
    void findContact() {
    }

    @Test
    void testFindContact() {
    }

    @Test
    void updateContact() {
    }

    @Test
    void queryContact() {
    }

}