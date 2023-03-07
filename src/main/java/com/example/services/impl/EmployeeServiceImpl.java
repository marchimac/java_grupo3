package com.example.services.impl;

import com.example.entities.Employee;
import com.example.entities.Task;
import com.example.repositories.EmployeeRepository;
import com.example.services.EmployeeService;
import com.example.services.TaskService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final TaskService taskService;

    @Override
    public List<Employee> findAll() {
        log.info("findAll");
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        log.info("findById {}", id);
        if (id == null || id <= 0)
            return Optional.empty();

        return employeeRepository.findById(id);
    }

    @Override
    public Optional<Employee> findByName(String name) {
        log.info("findByName {}", name);
        return employeeRepository.findByName(name);
    }

    @Override
    public Optional<Employee> findByDni(String dni) {
        log.info("findByDni {}", dni);
        return employeeRepository.findByDni(dni);
    }

    @Override
    public Optional<Employee> findByEmail(String email) {
        log.info("findByEmail {}", email);
        return employeeRepository.findByEmail(email);
    }

    @Override
    public Optional<Employee> findByPhone(String phone) {
        log.info("findByPhone {}", phone);
        return employeeRepository.findByPhone(phone);
    }

    @Override
    public Optional<Employee> findByPosition(String position) {
        log.info("findByPosition {}", position);
        return employeeRepository.findByPhone(position);
    }

    @Override
    public Employee save(Employee employee) {
        log.info("save employee {}", employee);

        try {
            this.employeeRepository.save(employee);
        } catch (Exception e) {
            log.error("Error saving employee {}", employee);
        }
        return employee;
    }

    @Override
    public void deleteById(Long id) {

        log.info("deleteById {}", id);

        List<Task> tasks = taskService.findAllByEmployeeId(id);
        for (Task task : tasks) {
            task.setEmployee(null);
        }
        taskService.saveAll(tasks);

        try {
            this.employeeRepository.deleteById(id);
        } catch (Exception e) {
            log.error("Error deleting employee {}", id);
        }
    }

    @Override
    public List<Employee> findAllByCompanyId(Long id) {
        return employeeRepository.findAllByCompanyId(id);
    }

    @Override
    public void saveAll(List<Employee> employees) {
        employeeRepository.saveAll(employees);
    }

}
