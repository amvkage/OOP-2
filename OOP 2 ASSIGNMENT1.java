import java.UniversitySystem;

// Base class representing a general staff member
abstract class Staff {
    protected String name;
    protected String staffId;
    protected List<Department> departments = new ArrayList<>(); // Association (multiple departments)

    public Staff(String name, String staffId) {
        this.name = name;
        this.staffId = staffId;
    }

    // Associate a staff member with a department
    public void addDepartment(Department department) {
        departments.add(department);
    }

    // Abstract method to be overridden by subclasses
    public abstract String getroledetails();
}

// Subclass representing a Lecturer (inherits StaffMember)
class Lecturer extends StaffMember {
    private String specialization;

    public Lecturer(String name, String staffId, String specialization) {
        super(name, staffId);
        this.specialization = specialization;
    }

    // Overriding getdetails() to provide lecturer-specific info
    @Override
    public String getdetails() {
        return "Lecturer Name: " + name + ", Specialization: " + specialization;
    }
}

// Subclass representing an Administrator (inherits StaffMember)
class Administrator extends StaffMember {
    private String position;

    public Administrator(String name, String staffId, String position) {
        super(name, staffId);
        this.position = position;
    }

    // Overriding getdetails() to provide administrator-specific info
    @Override
    public String getdetails() {
        return "Administrator Name: " + name + ", Position: " + position;
    }
}

// Class representing an office
class Office {
    private String roomNumber;
    private String phoneExtension;

    public Office(String roomNumber, String phoneExtension) {
        this.roomNumber = roomNumber;
        this.phoneExtension = phoneExtension;
    }

    public String getofficeDetails() {
        return "Room: " + roomNumber + ", Phone Ext: " + phoneExtension;
    }
}

// Department class that has a Office (Composition)
class Department {
    private String deptName;
    private Office office;    // Composition

    public Department(String deptName, Office office) {
        this.deptName = deptName;
        this.office = office;
    }

    public String getdeptName() {
        return deptName;
    }

    public String getofficeinfo() {
        return office.getofficeDetails();
    }
}

// Course class that aggregates Lecturer objects (Aggregation)
class Course {
    private String courseCode;
    private String courseTitle;
    private List<Lecturer> lecturers = new ArrayList<>(); // Aggregation

    public Course(String courseCode, String courseTitle) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
    }

    // Add lecturer to the course
    public void addLecturer(Lecturer lecturer) {
        lecturers.add(lecturer);
    }

    // List lecturers teaching the course
    public void showLecturers() {
        System.out.println("Lecturers for " + courseTitle + ":");
        for (Lecturer lecturer : lecturers) {
            System.out.println("- " + lecturer.name);
        }
    }
}

// Main class to test the system
public class UniversitySystem {
    public static void main(String[] args) {
        // Composition: Creating Office and Department
        Office office1 = new Office("B101", "221");
        Office office2 = new Office("C203", "305");

        Department csDept = new Department("Computer Science", office1);
        Department mathDept = new Department("Mathematics", office2);
    }
}
