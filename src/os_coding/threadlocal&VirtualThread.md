ThreadLocal and Virtual Threads – Notes (10 Points)
1. ThreadLocal Concept

ThreadLocal provides thread-specific storage, meaning each thread has its own isolated copy of a variable even if the same ThreadLocal object is shared.

2. Internal Working of ThreadLocal

Each Thread maintains an internal structure:

Thread
 └── ThreadLocalMap
        ├── ThreadLocal → value
        ├── ThreadLocal → value

This ensures data isolation across threads.

3. Common Use Cases

ThreadLocal is used to store request-scoped or thread-scoped data such as:

Authentication context

Transaction context

Request ID / Trace ID

Database session

Frameworks like Spring Framework and Hibernate ORM rely on ThreadLocal internally.

4. ThreadLocal Issue with Thread Pools

Thread pools reuse threads. If ThreadLocal values are not cleared:

Task1 → sets value
Task2 → same thread reused → old value remains

This leads to data leakage between requests.

5. Correct ThreadLocal Usage

Always remove values after execution to avoid memory leaks.

try {
    threadLocal.set(value);
    // business logic
} finally {
    threadLocal.remove();
}
Virtual Threads
6. What are Virtual Threads

Virtual threads are lightweight JVM-managed threads introduced through Project Loom and made stable in Java SE 21.

They enable applications to run millions of concurrent tasks efficiently.

7. Platform Threads vs Virtual Threads
Feature	Platform Thread	Virtual Thread
Managed by	OS	JVM Scheduler
Memory per thread	~1 MB	few KB
Max concurrency	~1000 threads	millions
Best use case	CPU intensive tasks	I/O intensive tasks
8. Carrier Threads and Scheduling

Virtual threads do not run directly on the CPU.
They run on carrier threads (OS threads) managed by the JVM scheduler.

Virtual Threads
      ↓
JVM Scheduler
      ↓
Carrier Threads (OS threads)

When a virtual thread blocks on I/O:

it parks

the carrier thread is released

another virtual thread runs

This improves CPU utilization.

9. Creating Virtual Threads

Example:

Thread.startVirtualThread(() -> {
    System.out.println("Running in virtual thread");
});

Using executor:

ExecutorService executor =
    Executors.newVirtualThreadPerTaskExecutor();

This creates one virtual thread per task.

10. ThreadLocal with Virtual Threads

ThreadLocal works normally with virtual threads because it is attached to the Java Thread object, not OS threads.

However:

virtual threads are usually not reused

ThreadLocal leaks are less common

cleanup is still recommended for good practice.