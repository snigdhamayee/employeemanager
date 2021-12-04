package tech.grtarrays.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.grtarrays.employeemanager.model.Employee;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee,Long>{

   Optional<Employee> findEmployeeById(Long id);

    Employee deleteEmployeeById(Long id);
}
