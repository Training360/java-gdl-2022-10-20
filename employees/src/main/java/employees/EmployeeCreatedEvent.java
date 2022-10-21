package employees;

import auditing.Auditable;
import lombok.Data;
import lombok.Value;

@Value
public class EmployeeCreatedEvent implements Auditable {

    private long id;

    private String name;
}
