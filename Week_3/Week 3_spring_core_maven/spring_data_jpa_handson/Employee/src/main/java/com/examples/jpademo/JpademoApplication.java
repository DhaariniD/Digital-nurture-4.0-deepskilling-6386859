package com.examples.jpademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.examples.jpademo.model.Employee;
import com.examples.jpademo.service.EmployeeService;
import java.util.List;

@SpringBootApplication
public class JpademoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(JpademoApplication.class, args);
        EmployeeService service = context.getBean(EmployeeService.class);

        // Save an employee
        Employee emp = new Employee();
        emp.setName("John Doe");
        service.addEmployee(emp);
        emp.setName("John ");
        service.addEmployee(emp);

        // Fetch all employees
        List<Employee> employees = service.getAllEmployees();
        employees.forEach(System.out::println);
    }
}
