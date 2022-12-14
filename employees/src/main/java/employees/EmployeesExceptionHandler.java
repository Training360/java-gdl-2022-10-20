package employees;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.NativeWebRequest;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;
import org.zalando.problem.spring.web.advice.ProblemHandling;

import java.net.URI;
import java.util.UUID;

@ControllerAdvice
public class EmployeesExceptionHandler implements ProblemHandling {

    @ExceptionHandler
    public ResponseEntity<Problem> handleException(EmployeeNotFoundException exception, NativeWebRequest request) {
        Problem problem =
                Problem.builder()
                        .withType(URI.create("employees/employee-not-found"))
                        .withTitle("Not found")
                        .withStatus(Status.NOT_FOUND)
                        .withDetail(exception.getMessage())
                        .with("employeeId", exception.getEmployeeId())
                        .with("exceptionId", UUID.randomUUID().toString())
                        .build();
        return this.create(exception, problem, request);

    }

    @ExceptionHandler
    public ResponseEntity<Problem> handleException(EmployeeAlreadyExistsException exception, NativeWebRequest request) {
        Problem problem =
                Problem.builder()
                        .withType(URI.create("employees/employee-already-exists"))
                        .withTitle("Already exists")
                        .withStatus(Status.BAD_REQUEST)
                        .withDetail(exception.getMessage())
                        .with("employeeName", exception.getName())
                        .with("exceptionId", UUID.randomUUID().toString())
                        .build();
        return this.create(exception, problem, request);

    }
}
