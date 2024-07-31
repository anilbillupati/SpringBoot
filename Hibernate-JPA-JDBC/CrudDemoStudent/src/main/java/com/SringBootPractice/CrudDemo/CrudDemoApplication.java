package com.SringBootPractice.CrudDemo;

import com.SringBootPractice.CrudDemo.dao.StudentDAO;
import com.SringBootPractice.CrudDemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(CrudDemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			//createStudent(studentDAO );
			//readStudent(studentDAO);
		    // queryStudents(studentDAO);
			//queryByLastName(studentDAO);
			//updateStudent(studentDAO);
			deleteStudent(studentDAO);

		};
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int theid=3;
		System.out.println("Delete the row based on the id :"+theid);
		studentDAO.delete(theid);
	}

	private void updateStudent(StudentDAO studentDAO) {
		//Retrieve the student based on id
		int studentId=1;
		System.out.println("the student id is "+studentId);
		Student myStudent= studentDAO.findById(studentId);

		//update the value
		System.out.println("updating the value based on the value");
		myStudent.setFirstName("Nani");
		//update the value
		studentDAO.update(myStudent);
		System.out.println(myStudent);

	}

	private void queryByLastName(StudentDAO studentDAO) {
		//getting the students ny last name
		List<Student> lastnameStudents=studentDAO.findByLastName("billupati");


		for(Student displayStudent : lastnameStudents){
			System.out.println(displayStudent);
		}
	}

	private void queryStudents(StudentDAO studentDAO) {
   // query the students

		List<Student> thestudents=studentDAO.findAll();

		//display the students
		for(Student stud:thestudents){

			System.out.println(stud+" ");

		}



	}

	private void readStudent(StudentDAO studentDAO) {

		//create student
		System.out.println("Creating the student ");
		Student tempStudent=new Student("Venaktesh","Beeraka","venkateshbeeraka@gmail.com");
		//save student object
		System.out.println("saving the student object ");
		studentDAO.save(tempStudent);
		//display id onf the student
		int theId= tempStudent.getId();
		System.out.println("the student id is : "+theId);
		//retrieve  the student id by primary key (id)
		Student mystudent=studentDAO.findById(theId);
		//display the student

		System.out.println("displaying the student "+mystudent);

	}

	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		Student theStudent =new Student("anil","billupati","billuppatianil@gmail.com") ;
		Student theStudent1 =new Student("Krishna","Tirumuru","tirumurukrishna1@gmail.com") ;
		Student theStudent2 =new Student("Kavya","Patrangi","Kavyap@gmail.com") ;
		Student theStudent3 =new Student("Sunil","bheemisetty","sunilBheemisetty@gmail.com") ;
		//save the student
		//studentDAO.save(theStudent);
		//studentDAO.save(theStudent1);
		studentDAO.save(theStudent2);
		studentDAO.save(theStudent3);

		//retrieving the saved object id

    System.out.println("the student id is : "+theStudent.getId());

	}

}

