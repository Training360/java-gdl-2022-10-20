package employees;

import employees.addressesgateway.AddressesGateway;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class EmployeesService {

    private EmployeesRepository repository;

    private EmployeesMapper employeesMapper;

    private AddressesGateway addressesGateway;

    private ApplicationEventPublisher publisher;

    public EmployeeDto createEmployee(CreateEmployeeCommand command) {
        log.info("Create employee");
        log.debug("Create employee with name {}", command.getName());

        if (repository.findEmployeeByNameIgnoreCase(command.getName()).isPresent()) {
            throw new EmployeeAlreadyExistsException(command.getName());
        }

        var employee = new Employee(command.getName());
        repository.save(employee);

        // TODO Mapper
        publisher.publishEvent(new EmployeeCreatedEvent(employee.getId(), employee.getName()));

        return employeesMapper.toDto(employee);
    }

    public EmployeeDetailsDto findEmployeeById(long id) {
        var employee = repository.findDtoById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
        var address = addressesGateway.getAddressForEmployee(employee.getName());

        return employeesMapper.toDto(employee, address);
    }

    public List<EmployeeDto> listEmployees() {
        return repository.findAllDto();
    }

}
