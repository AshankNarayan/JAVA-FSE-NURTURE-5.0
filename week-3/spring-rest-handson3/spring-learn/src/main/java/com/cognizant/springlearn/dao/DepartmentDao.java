package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.Department;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentDao.class);
    
    // Static variable for department list
    private static ArrayList<Department> DEPARTMENT_LIST;

    @SuppressWarnings("unchecked")
    public DepartmentDao() {
        LOGGER.info("Initializing DepartmentDao. Loading department list from employee.xml...");
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        List<Department> list = context.getBean("departments", List.class);
        DEPARTMENT_LIST = new ArrayList<>(list);
        LOGGER.info("DepartmentDao initialized successfully. Loaded {} departments.", DEPARTMENT_LIST.size());
    }

    public ArrayList<Department> getAllDepartments() {
        LOGGER.info("Retrieving all departments from static DEPARTMENT_LIST");
        return DEPARTMENT_LIST;
    }
}
