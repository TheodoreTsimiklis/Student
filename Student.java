/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
static: belongs to the class, you can only put static var and static method in
        a static method. You should only call a static method through a class Xxxxx.method()
    examples:
            String.format
            math methods
            character methods

non-static: belongs to the object, you can put anything(static var, static method,
            non-static var, non-static method) in a non-static method. You can
            only call a non-static method through the object xxxx.method()
*/

package student;

/**
 *
 * @author 15148
 */
public final class Student {
    
    private String name;
    private int age;
    private String gender;
    private String id;
    private static int nextId = 1;
    private String email;       //000001@vaniercollege.qc.ca
    private Address address;    //  user defined class in another user defined class
    private final static String SCHOOL_NAME = "Vanier College"; 
    
    public Student() {
        this.name = null;
        this.age = 0;
        this.gender = null;
        this.id = null;
        this.address = null;
    }

    public Student(String name, int age, String gender, Address address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.id = null;
        generateEmail();
        this.address = address;
    }
    public Student(Student student) {
        this.name = student.name;
        this.age = student.age;
        this.gender = student.gender;
        this.id = student.id;
        this.email = student.email;
     // this.address = student.address; // shallow copy
        this.address = new  Address(student.address);
    }
    public Student(String name, String gender) {
        this.name = name;
        this.age = 0;
        this.gender = gender;
        this.id = String.format("%06d", nextId++);
        generateEmail();
        this.address = null;
    }

    public void generateEmail() {
        email = String.format("%s@vaniercollege.qc.ca", name);
    }
    
    public static boolean isNameValid(String name) { // static method
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (!Character.isLetter(c) && c != ' ' && c != '-' && c != '\'')
            return false;
        }
        return true;
    }
    public void checkDistance() {
        if (this.address.getCity().equalsIgnoreCase("montreal"))
            System.out.println("You live near school");
        else if (this.address.getProvince().equalsIgnoreCase("qc"))
            System.out.println("You live far from school but not too far");
        else 
            System.out.println("You live very far form school");
    }
    
    public boolean equals(Student student) {
        return this.name.equals(student.name) 
                && this.age == student.age
                && this.gender.equals(student.gender) 
                && this.id.equals(student.id)
                && this.email.equals(student.email) 
                && this.address.equals(student.address);
    }

    @Override
    public String toString() {
        String str = "";
        
        str += String.format("Student from %s\n", SCHOOL_NAME); // static var
        str += String.format("%-10s: %s\n", "Name", name);
        str += String.format("%-10s: %s\n", "Gender", gender);
        str += String.format("%-10s: %d\n", "Age", age);
        str += String.format("%-10s: %s\n", "Id", id);
        str += String.format("%-10s: %s\n", "Email", email);
        str += String.format("%-10s:\n", "Address");
        str += String.format("%s\n", address);
        return str;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void setName(String name) {
        this.name = name;
        email = String.format("%s@vaniercollege.qc.ca", name);
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
        
    }

    public void setEmail(String email) {
        this.email = email;
        int atIdx = email.indexOf('@');
        name = email.substring(0, atIdx);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
}
