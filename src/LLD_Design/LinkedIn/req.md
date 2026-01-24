Linkedin

NonFunctional Requirement




Functional Requirement


user should be able to login and logout
user should be able to create a profile update profile, search for jobs
Search results should be ranked based on relevance and user preferences.
Employer should be able to create jobs and also search for users

user should be able to apply for the jobs
Can send/accept connection request can view connection request
can send/receive message can view the messages

Users should receive notifications for events such as connection requests, messages, and job postings. 
Notifications should be delivered in real-time.


Non funct:
- Results should be quick low latency API Latency

-The system is highly available.
  The system is partition tolerant. Even if there is a partial failure of the system or temporary message loss,
the system continues to operate and serve requests uninterruptedly.
  Since consistency cannot be achieved alongside the above two requirements according to the CAP theorem, 
LinkedIn operates with eventual consistency (or near real-time experience) for many of its features. 
When a user creates a post, it will be available to their connections ‘eventually’ or in ‘near’ real-time instead of ‘real-time’

scale:
100 M users

20 % DAU - 20 M users

Linkedin is read heavy system 
search profile view ,feeds messaging,connection 
avg request per user per day 50 

so total request per day -> 20 M * 50 = 1 B req/day -> 1B req / 86400 ~ 11.5 k QPS
peak day -> 3 * 11.5 = 35k qps

search 30% profileviews 25% messaging 20% notification 15% jobs 10%

messaging ->
Avg messages/user/day → 10
Total messages/day → ~200M
Avg message size → ~1 KB
so total size ->200 GB /day -> 70 TB/year

cassandra/dyanmo db

Profile ->
20KB data per user
20 KB  * 100 M = 2 TB 

connections avg connection 500
total edges = 500 * 100M = 50 B
Stored in sharded DB / graph-like structure


Job Postings

“Jobs are read-heavy and need good search.”

Total jobs → ~10M

Avg job size → ~5 KB

👉 Stored in DB + indexed in Elasticsearch


 Caching Assumptions

“To keep latency under 200ms.”

Cache hot profiles, connections, notifications

Redis size → ~50–70 GB

Cache hit ratio → 70–80%

Notification Throughput

“Everything generates events.”

Messages, connections, job alerts

Total events/day → ~200–250M

👉 Kafka handles async processing

**API**
GET
search/jobs

Request params: Location ,JOB Role

output :
list of jobs 
[{},{}]
status code:

pagination can be included

we should also provide authentication JWT tokens
we can provide rate limiters


![img.png](img.png)


“For job search listing pages, we return results directly from Elasticsearch without hitting Cassandra. Cassandra is only queried when the user opens a job detail page or performs an action like apply, since it’s the source of truth.” 