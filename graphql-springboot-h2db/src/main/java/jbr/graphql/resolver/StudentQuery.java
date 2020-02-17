package jbr.graphql.resolver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import jbr.graphql.dao.AddressRepository;
import jbr.graphql.dao.StudentRepository;
import jbr.graphql.model.Address;
import jbr.graphql.model.Student;

public class StudentQuery implements GraphQLQueryResolver {

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private AddressRepository addressRepository;

  public List<Student> findAllStudents() {
    List<Student> students = new ArrayList<>();
    studentRepository.findAll()
        .forEach(e ->
          {
            Student student = new Student();
            student.setId(e.getId());
            student.setName(e.getName());
            student.setDepartment(e.getDepartment());
            student.setAddress(getAddress(e.getId()));
            student.setPhone(e.getPhone());
            students.add(student);
          });
    return students;
  }

  public Address getAddress(Long studId) {
    return addressRepository.findById(studId)
        .get();
  }
}
