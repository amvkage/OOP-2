// Base class representing a general staff member
class StaffMember:
    def __init__(self, name, staff_id):
        self.name = name  # Staff member's name
        self.staff_id = staff_id  # Unique staff ID
        self.departments = []  # List of associated departments (Association)

    def add_department(self, department):
        """Associates this staff member with a department"""
        self.departments.append(department)

    def get_role_details(self):
        """Returns general role information. To be overridden."""
        return f"Staff Member: {self.name}, ID: {self.staff_id}"


// Subclass representing a Lecturer (inherits from StaffMember)
class Lecturer(StaffMember):
    def __init__(self, name, staff_id, field):
        super().__init__(name, staff_id)  # Call parent constructor
        self.field = field  # Lecturer's academic specialization

    def get_role_details(self):
        """Polymorphic method for Lecturer details"""
        return f"Lecturer: {self.name}, Field: {self.field}"


// Subclass representing an Administrator (inherits from StaffMember)
class Administrator(StaffMember):
    def __init__(self, name, staff_id, position):
        super().__init__(name, staff_id)
        self.position = position  # Administrative position

    def get_role_details(self):
        """Polymorphic method for Administrator details"""
        return f"Administrator: {self.name}, Position: {self.position}"


// Class representing an Office (used in Composition)
class Office:
    def __init__(self, room_number, phone_extension, working_hours):
        self.room_number = room_number
        self.phone_extension = phone_extension
        self.working_hours = working_hours


// Department class that has-a Office (Composition)
class Department:
    def __init__(self, dept_name, office: Office):
        self.dept_name = dept_name  # Name of the department
        self.office = office  # Office object is part of department (Composition)


// Course class that aggregates Lecturers (Aggregation)
class Course:
    def __init__(self, course_code, title):
        self.course_code = course_code
        self.title = title
        self.lecturers = []  # Aggregated lecturers (not owned)

    def add_lecturer(self, lecturer: Lecturer):
        """Adds a lecturer to the course (Aggregation)"""
        self.lecturers.append(lecturer)

    def show_lecturers(self):
        """Returns names of lecturers for this course"""
        return [lect.name for lect in self.lecturers]


//---------- DEMONSTRATION / USAGE ----------

// Create office objects (used in Composition)
office_cs = Office("CS201", "101", "8AM - 4PM")
office_math = Office("MTH105", "102", "9AM - 5PM")

// Create departments with embedded Office objects (Composition)
dept_cs = Department("Computer Science", office_cs)
dept_math = Department("Mathematics", office_math)

// Create staff members (Inheritance + Polymorphism)
lect1 = Lecturer("Dr. Rose", "L001", "Machine Learning")
lect2 = Lecturer("Dr. Ken", "L002", "Calculus")
admin1 = Administrator("Mrs. Leah", "A010", "Faculty Secretary")

// Associate lecturers with departments (Association)
lect1.add_department(dept_cs)
lect2.add_department(dept_math)
lect2.add_department(dept_cs)  # Lecturer belongs to multiple departments

// Create course and add lecturers (Aggregation)
course_ml = Course("CSC301", "Intro to ML")
course_ml.add_lecturer(lect1)
course_ml.add_lecturer(lect2)

// ----------- OUTPUT / TESTING SECTION ------------

// Polymorphism: Print role-specific details
print(lect1.get_role_details())
print(admin1.get_role_details())

//Aggregation: Print course lecturers
print(f"\nLecturers for course {course_ml.title}:")
for name in course_ml.show_lecturers():
    print(f"- {name}")

//Association: List departments for a lecturer
print(f"\nDepartments associated with {lect2.name}:")
for dept in lect2.departments:
    print(f"- {dept.dept_name} (Office: {dept.office.room_number}, Ext: {dept.office.phone_extension}, Hours: {dept.office.working_hours})")
