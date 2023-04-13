package lib;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Employee {

    private String employeeId;
    private String firstName;
    private String lastName;
    private String idNumber;
    private String address;
    private LocalDate dateJoined;
    private boolean isForeigner;
    public enum Gender {
        MALE,
        FEMALE
    }
    private List<String> childIdNumbers;
    private Gender gender;
    private String spouseIdNumber;

    public Employee(String employeeId, String firstName, String lastName, String idNumber, String address, LocalDate dateJoined, boolean isForeigner, Gender gender) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.address = address;
        this.dateJoined = dateJoined;
        this.isForeigner = isForeigner;
        this.gender = gender;
        childIdNumbers = new LinkedList<String>();
    }

    public void setSpouse(String spouseIdNumber) {
        this.spouseIdNumber = idNumber;
    }

    public void addChild(String childName, String childIdNumber) {
        childIdNumbers.add(childIdNumber);
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getDateJoined() {
        return dateJoined;
    }

    public boolean isForeigner() {
        return isForeigner;
    }

    public List<String> getChildIdNumbers() {
        return childIdNumbers;
    }

    public Gender getGender() {
        return gender;
    }

    public String getSpouseIdNumber() {
        return spouseIdNumber;
    }
}
