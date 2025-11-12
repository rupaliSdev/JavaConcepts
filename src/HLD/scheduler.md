What problem is being solved?

The author wants to build a system that can:

Let users schedule tasks/jobs (either one-time or recurring)

Handle millions of such tasks per day

Support retry logic, history tracking, and so on

Work in a distributed environment (i.e. scalable, no single point of failure)

In the example numbers, he expects ~50 million tasks a day, which is about 34,722 tasks per minute on average.


why cassandra

“I’d choose Cassandra for the distributed job scheduler because it’s optimized for massive write throughput, horizontal scalability, and fault tolerance.
It uses a peer-to-peer model, so there’s no single point of failure — perfect for a system that must keep running continuously.
Unlike MySQL or PostgreSQL, Cassandra can handle millions of time-based inserts and queries efficiently and lets us partition data by time and segment.
Since our scheduler doesn’t require strict ACID transactions, Cassandra’s eventual consistency is an acceptable trade-off for availability and performance.”

“Cassandra uses a Peer-to-Peer (P2P) architecture where all nodes are equal — there’s no master.
Each node can handle reads and writes, and data is replicated across multiple nodes.
They communicate via a gossip protocol to stay in sync.
This design provides high availability, fault tolerance, and easy horizontal scaling, which is why it’s ideal for a distributed job scheduler handling millions of tasks daily.”



Data design (Database / Schemas)

You need to store:

Jobs — the user’s definition of a scheduled job (e.g. “run this at interval X, max retries, recurring or not”).

Task schedule — for each job, when the next execution should happen.

Execution history — when a task was run, what status (success/failure), retry count, etc.

He chooses a NoSQL database (Cassandra or similar) so that it can scale horizontally, deal with many writes/reads, and be fault tolerant.
Medium

Some key design decisions:

The jobs table is partitioned by user_id (so all a user’s jobs are together).

The task_schedule table needs a way to efficiently query “which jobs are due right now”. Initially, putting next_execution_time as a sort key had issues because you’d have to scan many partitions. So he proposes making next_execution_time the partition key (with minute-level granularity) plus “segment” (see below) to split work.
Medium

The execution history table is partitioned by job_id, sorted by execution_time. That way, you can look up all runs of a particular job quickly.
Medium

Services / Flow of work

Here’s how tasks move through the system.

Job Service (User-facing API)

Users call APIs to create, delete, or list jobs.

When creating a job, the service:

Generates a job ID

Stores job metadata in the jobs table

Computes the first next_execution_time

Adds an entry into the task_schedule table

This is distributed (multiple instances behind a load balancer), so it can scale.

Scheduling Service (polling / dispatch)

This is the core “scheduler” logic that runs every minute (or at whatever granularity).

It polls the task_schedule table to find jobs whose next_execution_time = now.

It publishes those tasks into a queue (e.g. Kafka topic) so that execution services can pick them up.

It also writes a “scheduled” entry into the execution history table.

If a job is recurring, it computes and updates the next execution time in task_schedule.

But there are challenges:

If you run just one scheduler instance, it becomes a bottleneck or a single point of failure.

If you run multiple scheduler instances, they might duplicate work (i.e. two instances pick the same job).

To solve this, the author suggests:

Introduce a “segment” field. Say you define segments 1 to k (where k ≥ number of scheduler workers).

Each task_schedule row gets one segment assigned randomly.

The partition key becomes (next_execution_time, segment).

Each scheduler worker is assigned certain segments to handle. That way, they only query for “my segments” and there’s no overlap.

There is a master/coordinator that assigns segments to workers, monitors their health, and reassigns segments if workers die.
Medium

Thus, division of labor is deterministic and avoids race conditions.

https://chatgpt.com/c/68f1ca6e-eb40-8323-83be-d8879504d2f6

https://medium.com/@mayilb77/design-a-distributed-job-scheduler-for-millions-of-tasks-in-daily-operations-4132dc6d645f