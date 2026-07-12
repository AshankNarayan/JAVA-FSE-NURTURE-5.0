package com.cognizant.ormlearn;

import com.cognizant.ormlearn.entity.*;
import com.cognizant.ormlearn.service.AttemptService;
import com.cognizant.ormlearn.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static EmployeeService employeeService;
    private static AttemptService attemptService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        
        employeeService = context.getBean(EmployeeService.class);
        attemptService = context.getBean(AttemptService.class);

        System.out.println("\n=======================================================");
        System.out.println("            STARTING ALL HANDS-ON TESTS                ");
        System.out.println("=======================================================\n");

        // Hands-on 2: HQL Permanent Employees with Join Fetch
        testGetAllPermanentEmployees();

        // Hands-on 3: Fetch Quiz Attempt details using HQL
        testFetchQuizAttemptDetails();

        // Hands-on 4: Get average salary using HQL
        testGetAverageSalary();

        // Hands-on 5: Get all employees using Native Query
        testGetAllEmployeesNative();

        // Hands-on 6: Criteria Query Demo
        testCriteriaQueryDemo();
    }

    private static void testGetAllPermanentEmployees() {
        LOGGER.info("Start testGetAllPermanentEmployees");
        System.out.println("\n--- Hands-on 2: Get All Permanent Employees using Optimized HQL Join Fetch ---");
        List<Employee> employees = employeeService.getAllPermanentEmployees();
        LOGGER.debug("Permanent Employees: {}", employees);
        employees.forEach(e -> {
            System.out.println("Employee: " + e.getName() + " | Dept: " + e.getDepartment().getName());
            System.out.println("  Skills: " + e.getSkillList());
        });
        LOGGER.info("End testGetAllPermanentEmployees");
    }

    private static void testFetchQuizAttemptDetails() {
        System.out.println("\n--- Hands-on 3: Fetch Quiz Attempt Details using HQL ---");
        Attempt attempt = attemptService.getAttempt(1, 1);
        if (attempt != null) {
            System.out.println("User Name: " + attempt.getUser().getName());
            System.out.println("Attempt Date: " + attempt.getDate());
            System.out.println("====================================================");
            
            for (AttemptQuestion aq : attempt.getAttemptQuestions()) {
                Question q = aq.getQuestion();
                System.out.println(q.getText());
                
                List<QuizOption> options = q.getOptions();
                for (int i = 0; i < options.size(); i++) {
                    QuizOption o = options.get(i);
                    boolean isSelected = false;
                    
                    // Match option ID to find if selected in this attempt
                    for (AttemptOption ao : aq.getAttemptOptions()) {
                        if (ao.getQuizOption().getId() == o.getId()) {
                            isSelected = ao.isSelected();
                            break;
                        }
                    }
                    System.out.printf(" %d) %-12s %3.1f     %s%n", 
                        (i + 1), o.getText(), o.getScore(), isSelected);
                }
                System.out.println();
            }
        } else {
            System.out.println("Quiz attempt details not found for User 1 and Attempt 1!");
        }
    }

    private static void testGetAverageSalary() {
        System.out.println("\n--- Hands-on 4: Get Average Salary using HQL ---");
        // Get average salary for Department ID 1 (IT)
        double avgSalary = employeeService.getAverageSalary(1);
        System.out.printf("Average Salary of Department 1 (IT): $%.2f%n", avgSalary);
    }

    private static void testGetAllEmployeesNative() {
        System.out.println("\n--- Hands-on 5: Get All Employees using Native Query ---");
        List<Employee> employees = employeeService.getAllEmployeesNative();
        employees.forEach(System.out::println);
    }

    private static void testCriteriaQueryDemo() {
        System.out.println("\n--- Hands-on 6: Criteria Query Demo (Dynamic Filtering) ---");
        System.out.println("1. Filtering for Permanent Employees:");
        List<Employee> permanent = employeeService.getEmployeesByCriteria(null, true);
        permanent.forEach(System.out::println);

        System.out.println("\n2. Filtering for Employees with Salary >= 60000:");
        List<Employee> richEmps = employeeService.getEmployeesByCriteria(60000.0, null);
        richEmps.forEach(System.out::println);
    }
}
