# Assessment
 
 
 
 
## Authentication.
Used the Jwt (JsonWebToken).

How to Authenticate:
Open Postman and create a new post request with the following information.

http://localhost:8080/authenticate
   Body: Type Json
   {"username":"tds", "password":"password"}

   This post request will return an JWT that is used to access the API controllers.

   return:
   {
       "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZHMiLCJleHAiOjE2MDA3ODg2MjAsImlhdCI6MTYwMDc3MDYyMH0.nTZ_qj468jDlUbaz1LALLMgm05EJ5_vH2n-9ynhRYNrypC6s6YeelzfJH_oLdIPQZyx-J-m5_P0Lj8NyZzXANA"
   }

## Send a Request
   To send a GET request to the API you need to set the Headers first.
   Use the token genereated for the authenticated user.

   Create a GET request with the Headers on Postman like the example.

   http://localhost:8080/employees/active
   Headers:
   Key: Authorization
   Value: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZHMiLCJleHAiOjE2MDA3ODg2MjAsImlhdCI6MTYwMDc3MDYyMH0.nTZ_qj468jDlUbaz1LALLMgm05EJ5_vH2n-9ynhRYNrypC6s6YeelzfJH_oLdIPQZyx-J-m5_P0Lj8NyZzXANA


   This should return a list of active employees like this:
   [{"id":1,"firstName":"John","lastName":"Smith","badge_number":101,"country":"irl","job_title_name":"Software Engineer","department":"Software","start_date":"2020-06-07","leave_date":null},{"id":2,"firstName":"James","lastName":"Dunne","badge_number":102,"country":"irl","job_title_name":"Software Support","department":"Software","start_date":"2020-06-07","leave_date":null}]








