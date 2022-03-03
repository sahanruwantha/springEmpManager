package com.sahan.springempmanager.service;

import com.sahan.springempmanager.exeption.UserNotFoundExeption;
import com.sahan.springempmanager.model.Employee;
import com.sahan.springempmanager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeSevice
{
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeSevice(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    public Employee addEmployee(Employee employee)
    {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees()
    {
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee)
    {
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id)
    {
        return employeeRepo.findEmployeeById(id).orElseThrow
                (()-> new UserNotFoundExeption("User by Id " + id + " was not found"));
    }

    public void deleteEmployee(Long id)
    {
        employeeRepo.deleteEmployeeById(id);
    }
}
