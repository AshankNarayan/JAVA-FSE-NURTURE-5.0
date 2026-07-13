package com.cognizant.springlearn.controller;

import com.cognizant.springlearn.model.Department;
import com.cognizant.springlearn.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    /**
     * REST Service to get all departments.
     * URL: /departments
     */
    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        LOGGER.info("START: getAllDepartments() endpoint hit");
        List<Department> list = departmentService.getAllDepartments();
        LOGGER.info("END: getAllDepartments() endpoint responding. Total count: {}", list.size());
        return list;
    }
}
