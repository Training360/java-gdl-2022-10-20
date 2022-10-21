package employees.eventsgateway;

import employees.EmployeeCreatedEvent;
import employees.Gateway;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.jms.core.JmsTemplate;

@Gateway
@AllArgsConstructor
public class EventsGateway {

    private JmsTemplate jmsTemplate;

    @EventListener
    public void handleEvent(EmployeeCreatedEvent event) {
        sendMessage("Employee has been created with name: " + event.getName());
    }

    public void sendMessage(String message) {
        var event = new MessageEvent(message);

        jmsTemplate.convertAndSend("eventsQueue", event);
    }
}
