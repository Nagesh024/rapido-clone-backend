# Java Coding Standards

## Java Version

Java 17 Mandatory

---

## Package Naming

Correct:

com.rapido.rideservice

com.rapido.paymentservice

Incorrect:

com.Rapido

com.company

---

## Class Naming

Correct:

RideService

PaymentController

DriverRepository

Incorrect:

rideService

payment_controller

---

## Constants

Use:

public static final String RIDE_CREATED = "RIDE_CREATED";

Do Not Use:

String event = "RIDE_CREATED";

---

## Constructor Injection Only

Correct:

@RequiredArgsConstructor
@Service
public class RideService {
    private final RideRepository repository;
}

Do Not Use:

@Autowired
private RideRepository repository;

---

## Logging

Use SLF4J

private static final Logger log =
LoggerFactory.getLogger(RideService.class);

Never Use:

System.out.println();

---

## Exception Handling

Use Global Exception Handler

@RestControllerAdvice

Never Catch Generic Exception

catch(Exception ex)