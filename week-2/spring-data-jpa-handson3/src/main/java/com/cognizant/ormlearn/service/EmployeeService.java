package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.entity.Employee;
import com.cognizant.ormlearn.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Employee> getAllPermanentEmployees() {
        LOGGER.info("Start getAllPermanentEmployees");
        return employeeRepository.getAllPermanentEmployees();
    }

    @Transactional
    public double getAverageSalary(int id) {
        LOGGER.info("Start getAverageSalary for department: {}", id);
        return employeeRepository.getAverageSalary(id);
    }

    @Transactional
    public List<Employee> getAllEmployeesNative() {
        LOGGER.info("Start getAllEmployeesNative");
        return employeeRepository.getAllEmployeesNative();
    }

    /**
     * Hands-on 6: Criteria Query Implementation.
     * Demonstrates dynamic filtering of employee records.
     */
    @Transactional
    public List<Employee> getEmployeesByCriteria(Double minSalary, Boolean permanent) {
        LOGGER.info("Start getEmployeesByCriteria");
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> employee = cq.from(Employee.class);
        List<Predicate> predicates = new ArrayList<>();

        if (minSalary != null) {
            predicates.add(cb.greaterThanOrEqualTo(employee.get("salary"), minSalary));
        }
        if (permanent != null) {
            predicates.add(cb.equal(employee.get("permanent"), permanent));
        }

        cq.where(predicates.toArray(new Predicate[0]));
        TypedQuery<Employee> query = entityManager.createQuery(cq);
        return query.getResultList();
    }
}
