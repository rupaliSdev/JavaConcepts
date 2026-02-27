
domain Entities

User
Exam
Questions
Answer
Attempt
ProctorEvent
EvalResult


Exam -> User
1:M

Exam -> Questions
M:M

ques can be of diff marks in diff exam



User-> Attempt
1:M


Question <->  Option
1:M

Attempt -> Answer
1:M

Attempt -> Result
1:1

Attempt -> Proctor event
1:1

Attempt -> cheating Report
1:1

There can by types of questions:

MCQ
Subjective
Coding

abstact Question{


   evalStrategies();
}


Exam{

List<Question> questions;

}

Attempt{


}


https://chatgpt.com/c/699dc295-cd98-8323-b3d3-08c7319281e4