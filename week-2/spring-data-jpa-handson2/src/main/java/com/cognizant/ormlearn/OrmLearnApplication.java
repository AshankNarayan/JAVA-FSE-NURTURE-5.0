package com.cognizant.ormlearn;

import com.cognizant.ormlearn.entity.*;
import com.cognizant.ormlearn.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;
    private static StockService stockService;
    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        
        countryService = context.getBean(CountryService.class);
        stockService = context.getBean(StockService.class);
        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);

        System.out.println("\n=======================================================");
        System.out.println("            STARTING ALL HANDS-ON TESTS                ");
        System.out.println("=======================================================\n");

        // 1. Hands-on 1: Country Query Methods
        testCountryQueryMethods();

        // 2. Hands-on 2: Stock Query Methods
        testStockQueryMethods();

        // 3. Hands-on 4: Many-To-One Mapping
        testGetEmployee();
        testAddEmployee();
        testUpdateEmployee();

        // 4. Hands-on 5: One-To-Many Mapping
        testGetDepartment();

        // 5. Hands-on 6: Many-To-Many Mapping
        testAddSkillToEmployee();
    }

    private static void testCountryQueryMethods() {
        System.out.println("\n--- Hands-on 1: Country Query Methods ---");
        
        System.out.println("1. Countries containing 'ou':");
        List<Country> ouCountries = countryService.findCountriesContaining("ou");
        ouCountries.forEach(System.out::println);

        System.out.println("\n2. Countries containing 'ou' sorted alphabetically:");
        List<Country> ouCountriesSorted = countryService.findCountriesContainingSorted("ou");
        ouCountriesSorted.forEach(System.out::println);

        System.out.println("\n3. Countries starting with 'Z':");
        List<Country> zCountries = countryService.findCountriesStartingWith("Z");
        zCountries.forEach(System.out::println);
    }

    private static void testStockQueryMethods() {
        System.out.println("\n--- Hands-on 2: Stock Query Methods ---");
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date start = sdf.parse("2019-09-01");
            Date end = sdf.parse("2019-09-30");

            System.out.println("1. FB Stocks in September 2019:");
            System.out.println("+---------+------------+---------+----------+-----------+");
            System.out.println("| st_code | st_date    | st_open | st_close | st_volume |");
            System.out.println("+---------+------------+---------+----------+-----------+");
            List<Stock> fbSep = stockService.getFBStocksInSeptember2019(start, end);
            fbSep.forEach(System.out::println);
            System.out.println("+---------+------------+---------+----------+-----------+");

            System.out.println("\n2. Google Stocks > 1250:");
            System.out.println("+---------+------------+---------+----------+-----------+");
            System.out.println("| st_code | st_date    | st_open | st_close | st_volume |");
            System.out.println("+---------+------------+---------+----------+-----------+");
            List<Stock> googleGt = stockService.getGoogleStocksGreaterThan(new BigDecimal("1250.00"));
            googleGt.forEach(System.out::println);
            System.out.println("+---------+------------+---------+----------+-----------+");

            System.out.println("\n3. Top 3 highest volume transactions:");
            System.out.println("+---------+------------+---------+----------+-----------+");
            System.out.println("| st_code | st_date    | st_open | st_close | st_volume |");
            System.out.println("+---------+------------+---------+----------+-----------+");
            List<Stock> top3Vol = stockService.getTop3HighestVolumeStocks();
            top3Vol.forEach(System.out::println);
            System.out.println("+---------+------------+---------+----------+-----------+");

            System.out.println("\n4. Top 3 lowest Netflix stocks:");
            System.out.println("+---------+------------+---------+----------+-----------+");
            System.out.println("| st_code | st_date    | st_open | st_close | st_volume |");
            System.out.println("+---------+------------+---------+----------+-----------+");
            List<Stock> lowNflx = stockService.getTop3LowestNetflixStocks();
            lowNflx.forEach(System.out::println);
            System.out.println("+---------+------------+---------+----------+-----------+");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testGetEmployee() {
        LOGGER.info("Start testGetEmployee");
        System.out.println("\n--- Hands-on 4: Fetch Employee and ManyToOne Department & ManyToMany Skills ---");
        Employee employee = employeeService.get(1);
        if (employee != null) {
            System.out.println("Employee fetched: " + employee);
            System.out.println("Department details: " + employee.getDepartment());
            System.out.println("Skills details: " + employee.getSkillList());
        } else {
            System.out.println("Employee with ID 1 not found!");
        }
        LOGGER.info("End testGetEmployee");
    }

    private static void testAddEmployee() {
        LOGGER.info("Start testAddEmployee");
        System.out.println("\n--- Hands-on 4: Add Employee ---");
        Employee newEmp = new Employee();
        newEmp.setName("Rachel Green");
        newEmp.setSalary(45000.00);
        newEmp.setPermanent(false);
        newEmp.setDateOfBirth(new GregorianCalendar(1994, Calendar.MAY, 5).getTime());

        // Associate with IT department (ID 1)
        Department itDept = departmentService.get(1);
        newEmp.setDepartment(itDept);

        employeeService.save(newEmp);
        System.out.println("Saved new employee: " + newEmp);
        LOGGER.info("End testAddEmployee");
    }

    private static void testUpdateEmployee() {
        LOGGER.info("Start testUpdateEmployee");
        System.out.println("\n--- Hands-on 4: Update Employee Department ---");
        Employee employee = employeeService.get(2);
        if (employee != null) {
            System.out.println("Before update: " + employee + ", Department: " + employee.getDepartment());
            
            // Move from HR (ID 2) to IT (ID 1)
            Department itDept = departmentService.get(1);
            employee.setDepartment(itDept);
            
            employeeService.save(employee);
            
            // Re-fetch to verify
            Employee updatedEmp = employeeService.get(2);
            System.out.println("After update: " + updatedEmp + ", Department: " + updatedEmp.getDepartment());
        }
        LOGGER.info("End testUpdateEmployee");
    }

    private static void testGetDepartment() {
        LOGGER.info("Start testGetDepartment");
        System.out.println("\n--- Hands-on 5: One-To-Many Department with Eager Employee List ---");
        Department dept = departmentService.get(1);
        if (dept != null) {
            System.out.println("Department fetched: " + dept);
            System.out.println("Associated Employees in department: ");
            dept.getEmployeeList().forEach(emp -> System.out.println("  * " + emp));
        }
        LOGGER.info("End testGetDepartment");
    }

    private static void testAddSkillToEmployee() {
        LOGGER.info("Start testAddSkillToEmployee");
        System.out.println("\n--- Hands-on 6: Add Skill to Employee (Many-to-Many) ---");
        // Get Employee 2 (Jane Smith) and Skill 3 (SQL)
        Employee employee = employeeService.get(2);
        Skill sqlSkill = skillService.get(3);

        if (employee != null && sqlSkill != null) {
            System.out.println("Employee before adding skill: " + employee.getName() + ", Skills: " + employee.getSkillList());
            
            Set<Skill> skillList = employee.getSkillList();
            if (skillList == null) {
                skillList = new HashSet<>();
            }
            skillList.add(sqlSkill);
            employee.setSkillList(skillList);

            employeeService.save(employee);

            // Re-fetch to verify
            Employee updated = employeeService.get(2);
            System.out.println("Employee after adding skill: " + updated.getName() + ", Skills: " + updated.getSkillList());
        }
        LOGGER.info("End testAddSkillToEmployee");
    }
}
