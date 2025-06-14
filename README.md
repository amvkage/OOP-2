# OOP-2
# 🎓 University Management System in Java

## 📘 Overview

This Java application models a simple university system using **Object-Oriented Programming (OOP)** principles. It manages **departments**, **courses**, and **staff** including **lecturers** and **administrators**. The system demonstrates key OOP concepts: **inheritance**, **polymorphism**, **composition**, **aggregation**, and **association**.

---

## ✅ Objectives

- Model real-world university structures using OOP.
- Uses class relationships such as:
  - **Composition**: Department has-an Office
  - **Aggregation**: Course has-many Lecturers
  - **Association**: Staff members belong to multiple Departments
  - **Inheritance & Polymorphism**: Common StaffMember superclass

---

## 🧩 Class Descriptions

### `StaffMember` (Abstract Base Class)
- Fields: `name`, `staffId`, `departments`
- Methods: 
  - `addDepartment(Department)`
  - `getRoleDetails()` *(abstract – must be implemented by subclasses)*

### `Lecturer` (Subclass of StaffMember)
- Additional field: `specialization`
- Overrides `getRoleDetails()` to return lecturer-specific info

### `Administrator` (Subclass of StaffMember)
- Additional field: `position`
- Overrides `getRoleDetails()` to return administrator-specific info

### `Office`
- Fields: `roomNumber`, `phoneExtension`
- Used by Department to show office info
- Demonstrates **composition**

### `Department`
- Fields: `deptName`, `office`
- Contains an `Office` object (composition)

### `Course`
- Fields: `courseCode`, `courseTitle`, `lecturers`
- Can have multiple lecturers (aggregation)

---

## 🧪 Example Run

### Code Snippet:
```java
Lecturer lecturer1 = new Lecturer("Dr. Susan", "L101", "Artificial Intelligence");
Administrator admin1 = new Administrator("Mrs. Grace", "A201", "Head of Admin");

Department csDept = new Department("Computer Science", new Office("B101", "221"));
lecturer1.addDepartment(csDept);

Course aiCourse = new Course("CSC401", "Advanced AI");
aiCourse.addLecturer(lecturer1);

System.out.println(lecturer1.getRoleDetails());
aiCourse.showLecturers();
