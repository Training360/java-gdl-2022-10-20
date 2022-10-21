package employees.meter;

import employees.EmployeeCreatedEvent;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@AllArgsConstructor
public class MeterService {

    public static final String EMPLOYEES_CREATED_METER = "employees.created";

    private MeterRegistry meterRegistry;

    @PostConstruct
    public void init() {
        Counter.builder(EMPLOYEES_CREATED_METER)
                .description("The number of the created employees")
                .baseUnit("number")
                .register(meterRegistry);
    }

    @EventListener
    public void handleEvent(EmployeeCreatedEvent event) {
        meterRegistry.counter(EMPLOYEES_CREATED_METER).increment();
    }

}
