

Many parameters are optional

Constructor has too many arguments

Multiple constructors become confusing
```
new User("Rupali", "Sahu", "rupali@gmail.com", 27, "India", null, null, true);

User user = User.builder()
.firstName("Rupali")
.lastName("Sahu")
.email("rupali@gmail.com")
.age(27)
.country("India")
.active(true)
.build();
```

Object Creation Is Complex

Use Builder when:

Object creation involves multiple steps

Validation or transformation is required

Dependencies between fields exist

📌 Example:

```
Order order = Order.builder()
.withItems(items)
.calculateTotal()
.applyDiscount()
.validate()
.build();

```

Perfect for:

Order systems

Payment objects

Config-heavy services

3️⃣ You Want Immutable Objects

Builder allows:

Fields to be set during construction

Object becomes immutable after build()

📌 Common in:

Domain models

Event objects (Kafka events)

DTOs

`
public class PaymentEvent {
private final String orderId;
private final BigDecimal amount;
private final String currency;
}
`


👉 Very useful in concurrent systems and event-driven architectures

Need Different Representations of Same Object

Same object, different variations:

📌 Example:

Report summaryReport = Report.builder().summary().build();
Report detailedReport = Report.builder().detailed().build();


Useful when:

Same entity is used across multiple flows

APIs require different representations

5️⃣ Avoid Telescoping Constructors

❌ Telescoping:

User(String name)
User(String name, String email)
User(String name, String email, String phone)


✅ Builder removes this problem entirely.

🚫 When NOT to Use Builder Pattern

❌ Object is simple (1–3 fields)
❌ No optional fields
❌ Performance-critical hot paths (extra object creation)
❌ Temporary or throwaway objects

🧠 Backend / System Design Use Cases (Interview Gold)
Scenario	Why Builder
Kafka Event Models	Immutability + clarity
API Request/Response DTOs	Optional fields
Configuration Objects	Multiple flags
Complex Domain Objects	Validation during creation
Test Data Setup	Clean & readable test code