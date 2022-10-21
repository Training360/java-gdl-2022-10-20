package employees;

import lombok.Getter;

public class EmployeeNotFoundException extends RuntimeException {

    @Getter
    private long employeeId;
    public EmployeeNotFoundException(long employeeId) {
        super("Employee not found with id: " + employeeId);
        this.employeeId = employeeId;
    }
}
