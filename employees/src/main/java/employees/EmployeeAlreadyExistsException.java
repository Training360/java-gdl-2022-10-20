package employees;

import lombok.Getter;

public class EmployeeAlreadyExistsException extends RuntimeException {

    @Getter
    private String name;
    public EmployeeAlreadyExistsException(String name) {
        super("Employee exist with name " + name);
        this.name = name;
    }
}
