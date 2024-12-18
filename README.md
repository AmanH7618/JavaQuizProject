# JavaQuizProject
 Here are the API's
 This API is used to create a user session. All the details regarding several question answer correct and incorrect answers are inside it.
 [POST](http://localhost:8080) /quiz/start?userId=12345

 This API is used to get the question. Key component if earlier there is question not answered then it will give an error also without a session you can't get a question.
 [GET](http://localhost:8080) /quiz/question/12345

 This API allows the user to answer the question. Also allows the user to answer the correct question of the current session. 
 [POST](http://localhost:8080) /quiz/answer/12345?questionId=1&answer=4 bytes

 This API is used to get the final result of the session.
 [GET](http://localhost:8080) /quiz/result/12345

 # Points not able to cover due to time constraints and health issues-
 -> Mapper class for the question to get the required data set only.
 -> If there is any active session you need to end this before starting a new session
 -> Creating Admin using Spring security to add new questions.
 -> Adding further features like topics of the question to get the summary at the end, to mark the topics the user needs to study.
 -> If user get the result than the sessions get over and can see result only and cant be changed.
 
 
