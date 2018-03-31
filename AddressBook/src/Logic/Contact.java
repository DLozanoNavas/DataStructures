package Logic;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Contact {

    private String name;
    private String lastName;
    private String adress;
    private long phone;
    private String mail;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String val) {
        this.lastName = val;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String val) {
        this.mail = val;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String val) {
        this.adress = val;
    }

    public String getName() {
        return name;
    }

    public void setName(String val) {
        this.name = val;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long val) {
        this.phone = val;
    }

    public void writeFile(ArrayList<Contact> AddressBook) throws FileNotFoundException, UnsupportedEncodingException {
        for (int i = 0; i < AddressBook.size(); i++) {
            Contact WriteContact = AddressBook.get(i);
            try {
                FileWriter writer = new FileWriter("AddressBook.txt");
                PrintWriter pw = new PrintWriter(writer);
                for (Contact contact : AddressBook) {
                    pw.println(WriteContact.getName());
                    pw.println(WriteContact.getLastName());
                    pw.println(WriteContact.getMail());
                    pw.println(WriteContact.getPhone());
                    pw.println(";");
                }
            } catch (IOException e) {
                e.getMessage();
            }
        }
    }

    /**
     *
     * @param AddressBook
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void readFile(ArrayList<Contact> AddressBook) throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(new FileReader("AddressBook.txt"));
        FileReader fr = new FileReader("AddressBook.txt");
        BufferedReader br = new BufferedReader(fr);
        String Line;
        try {
            for (Contact contact : AddressBook) {
                while ((br.readLine()) != null) {
                    Line = br.readLine();
                }
            }

        } finally {
            sc.close();
            fr.close();
            sc.close();
        }

    }

    public int searchContact(long phone, ArrayList<Contact> studentList) {
        int indexOf = 0;
        int query = -1;
        for (Contact contact : studentList) {
            long PhoneComparison = contact.getPhone();
            long PhoneSearch = phone;
            if (PhoneComparison == PhoneSearch) {
                query = indexOf;
            }
            indexOf++;
        }
        return query;
    }

    public String modifyContact() {
        return null;
    }

    public char displayContact() {
        return 'a';
    }

    public Boolean deleteContact() {
        return true;
    }
    
    

}
