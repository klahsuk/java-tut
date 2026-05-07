package Collections;


import java.util.ArrayList;

//coding exercise 44
public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            return false;
        }

        myContacts.add(contact);
        return true;
    }

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    public boolean removeContact(Contact contact){
        return myContacts.remove(contact);
    }

//    public boolean removeContact(Contact contact){
//        if (myContacts.contains(contact)) {
//            return myContacts.remove(contact);
//        } else return false;
//    }

    public int findContact(Contact contact){
        return myContacts.indexOf(contact);
    }

    public int findContact(String contactName) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);

            if (contact.getName().equals(contactName)) {
                return i;
            }
        }

        return -1;
    }

    public boolean updateContact(Contact contact, Contact newContact){
        int index = findContact(contact);
        if(index != -1){
            myContacts.set(index, newContact);
            return true;
        } else return false;
    }

    public Contact queryContact(String name){
        int index = findContact(name);
        if(index != -1) {
            return myContacts.get(index);
        }
        else return null;
    }

    public void printContacts(){
        System.out.println("Contact List:");
        for (int i = 0; i < myContacts.toArray().length; i++) {
            Contact c = myContacts.get(i);
            System.out.printf("%d. %s -> %s", i + 1, c.getName(), c.getPhoneNumber());
        }
    }

}

