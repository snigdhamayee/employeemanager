package tech.grtarrays.employeemanager.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.grtarrays.employeemanager.exception.UserPrincipalNotFoundException;
import tech.grtarrays.employeemanager.model.Employee;
import tech.grtarrays.employeemanager.repo.EmployeeRepo;


import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;

    }
    public Employee addEmployee(Employee employee){
        System.out.println("inside add call in service -before repo call");
       // employee.setEmployeeCode(UUID.randomUUID().toString());
        return  employeeRepo.save(employee);
    }
    public List<Employee> findAllEmployees(){
       return employeeRepo.findAll();
    }
    public Employee findEmployeeById(Long id)  {
        return employeeRepo.findEmployeeById(id).orElseThrow(() -> new UserPrincipalNotFoundException("User by id" + id +"was not found"));
    }
    public Employee updateEmployee(Employee employee){
        return  employeeRepo.save(employee);

    }
    public void deleteEmployee(Long id){
        employeeRepo.deleteById(id);//deleteEmployeeById(id);
    }
}
