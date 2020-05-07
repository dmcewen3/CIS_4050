Drop Database if exists Tutoring_App;
Create Database Tutoring_App;
use Tutoring_App;

Create Table Tutor (
	TutorID int auto_increment primary key,
	FirstName varchar(20),
	LastName varchar(20),
	year varchar(10)
);

Create Table Availability (
	SlotID int auto_increment primary key,
	DayOfWeek char (2),
	StartTime time,
	EndTime time,
    TutorID int,
	foreign key (TutorID) references Tutor(TutorID)
);

Create Table Class (
	Code int primary key,
	Major varchar(3),
	Name varchar(30), 
	Credits int
);

Create Table Student(
	StudentID int auto_increment primary key,
	FirstName varchar(20),
	LastName varchar(20),
	Major varchar(3),
	Year varchar(10)
);

Create Table Employee (
	EmployeeID int auto_increment primary key,
	FirstName varchar(20),
	LastName varchar(20),
	Department varchar(3)
);

Create Table Section (
	CRN int primary key,
	TimeOfDay time,
	Format varchar(10),
    Code int,
    EmployeeID int,
	foreign key (Code) references Class(Code),
	foreign key (EmployeeID) references Employee(EmployeeID)
);

Create Table Session (
	SessionID int auto_increment primary key,
	StartTime time, 
	EndTime time,
	Topic varchar(50),
    TutorID int,
    StudentID int,
    CRN int,
	foreign key (TutorID) references Tutor(TutorID),
	foreign key (StudentID) references Student(StudentID),
	foreign key (CRN) references Section(CRN)
);

Create Table Tutor_Class (
	CombinationID int auto_increment primary key,
    TutorID int,
    Code int,
	foreign key (TutorID) references Tutor(TutorID),
	foreign key (Code) references Class(Code)
);

Create Table Student_Section (
	StudentID int,
    CRN int,
	foreign key (StudentID) references Student(StudentID),
	foreign key (CRN) references Section(CRN)
);




