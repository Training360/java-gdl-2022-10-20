package employees.audit;

import auditing.AuditService;
import employees.EmployeeCreatedEvent;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeAuditService {

    private AuditService auditService;

    @EventListener
    public void handleEvent(EmployeeCreatedEvent event) {
        auditService.audit(event);
    }
}
