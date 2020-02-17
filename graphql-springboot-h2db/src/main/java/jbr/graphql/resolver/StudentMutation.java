package jbr.graphql.resolver;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import jbr.graphql.dao.AddressRepository;
import jbr.graphql.dao.StudentRepository;
import jbr.graphql.model.Address;
import jbr.graphql.model.Student;

public class StudentMutation implements GraphQLMutationResolver {

  @Autowired
  private AddressRepository addressRepository;

  @Autowired
  private StudentRepository studenttRepository;

  public Student addStudent(String name, String department, Address address, Long phone) {

    Student student = new Student();
    student.setName(name);
    student.setDepartment(department);
    student.setAddress(address);
    student.setPhone(phone);

    studenttRepository.save(student);

    return student;
  }

 public Address addAddress(Long studId, String street, String city, Long pincode) {
   Address address = new Address(studId, street, city, pincode);
   addressRepository.save(address);
   
   return address;
 }
}
