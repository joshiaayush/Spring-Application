//package com.codekul.java21febspring.jpa;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDate;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//@RestController
//public class StudentController {
//
//    @Autowired
//    private StudentRepository studentRepository;
//
//    @PostMapping("save")
//    public String saveStudent(@RequestBody Student student) {
//        studentRepository.save(student);
//        return "student saved.";
//    }
//
//    @PutMapping("update")
//    public String updateStudent(@RequestBody Student student) {
//        Student st = studentRepository.getReferenceById(student.getId());
//        st.setAddress(student.getAddress());
//        st.setName(student.getName());
//        st.setDob(student.getDob());
//        studentRepository.save(st);
//
//        return "student updated";
//    }
//
//    @GetMapping("list")
//    public List<Student> getStudentList() {
//        return studentRepository.findAll();
//    }
////
////    @GetMapping("getStudent/{id}")
////    public Student getStudent(@PathVariable("id") Long id) {
////        return studentRepository.getReferenceById(id);
////    }
//
//    @GetMapping("getStudent/{id}")
//    public Optional<Student> getStudent1(@PathVariable("id") Long id) {
//        return studentRepository.findById(id);
//    }
//
//    @DeleteMapping("delete/{id}")
//    public String deleteStudent(@PathVariable("id") Long id) {
//        studentRepository.deleteById(id);
//        return "record deleted..";
//    }
//
//    @DeleteMapping("delete1/{id}")
//    public String deleteStudent1(@PathVariable("id") Long id) {
//        Optional<Student> student = studentRepository.findById(id);
//        studentRepository.delete(student.get());
//        return "record deleted..";
//    }
//
//    @DeleteMapping("delete2/{id}")
//    public String deleteStudent2() {
//        studentRepository.deleteAll();
//        return "all record deleted..";
//    }
//
//    @DeleteMapping("deleteAll/{ids}")
//    public String deleteStudent2(@PathVariable("ids") List<Long> ids) {
//        studentRepository.deleteAllById(ids);
//        return "all record deleted..";
//    }
//
//    @GetMapping("getStudentByName/{name}")
//    public Map<String, Object> deleteStudent2(@PathVariable("name") String name) {
//        Student student = studentRepository.findByName(name);
//        Map<String, Object> map = new HashMap<>();
//        if (student != null) {
//            map.put("message", "record found");
//            map.put("stud", student);
//        } else {
//            map.put("message", "record not found");
//
//        }
//        return map;
//    }
//  @GetMapping("getStudentByNameAndAddress/{name}/{address}")
//  public Map<String, Object> getStudentByName1(@PathVariable("name") String name,
//                                               @PathVariable("address") String address) {
//      List<Student> student = studentRepository.findByNameAndAddress(name, address);
//      Map<String, Object> map = new HashMap<>();
//      if (student != null) {
//          map.put("message", "record found");
//          map.put("stud", student);
//      } else {
//          map.put("message", "record not found");
//
//      }
//      return map;
//  }
//
//    @GetMapping("getStudentByDate/{date}")
//    public Map<String, Object> getStudentByDate(@PathVariable("date") LocalDate date) {
//        List<Student> student = studentRepository.findByDobLessThanEqual(date);
//        Map<String, Object> map = new HashMap<>();
//        if (!student.isEmpty()) {
//            map.put("message", "record found");
//            map.put("stud", student);
//        } else {
//            map.put("message", "record not found");
//
//        }
//        return map;
//    }
//
//    @GetMapping("getStudentBetweenDate/{firstDate}/{secondDate}")
//    public Map<String, Object> getStudentBetweenDate(@PathVariable("firstDate") LocalDate firstDate,
//                                                     @PathVariable("secondDate") LocalDate secondDate) {
//        List<Student> student = studentRepository.findByDobBetween(firstDate, secondDate);
//        Map<String, Object> map = new HashMap<>();
//        if (!student.isEmpty()) {
//            map.put("message", "record found");
//            map.put("stud", student);
//        } else {
//            map.put("message", "record not found");
//
//        }
//        return map;
//    }
//
//
//}
