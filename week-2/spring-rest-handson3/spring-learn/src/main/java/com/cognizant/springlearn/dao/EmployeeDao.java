package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDao.class);
    
    // Static variable for employee list
    private static ArrayList<Employee> EMPLOYEE_LIST;

    @SuppressWarnings("unchecked")
    public EmployeeDao() {
        LOGGER.info("Initializing EmployeeDao. Loading employee list from employee.xml...");
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        List<Employee> list = context.getBean("employees", List.class);
        EMPLOYEE_LIST = new ArrayList<>(list);
        LOGGER.info("EmployeeDao initialized successfully. Loaded {} employees.", EMPLOYEE_LIST.size());
    }

    public ArrayList<Employee> getAllEmployees() {
        LOGGER.info("Retrieving all employees from static EMPLOYEE_LIST");
        return EMPLOYEE_LIST;
    }
}
