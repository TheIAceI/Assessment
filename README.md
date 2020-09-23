# Assessment
 
Integrations Developer Remote Assessment

The goal of this assessment project is to develop a simple RESTful API to retrieve and display data
residing in an Oracle database.

Requirements
- Develop a RESTful API with endpoints matching the below format
- Build API using one of Java, NodeJS or Python
- API to use basic authentication
- API to return JSON Arrays in all successful responses
- Submission to include a github link or a zip file containing all relevant parts
- Include simple document outlining steps to run application locally
- Include simple document, if applicable, outlining any issues with completing the assessment

## How to run the application.

1. Download or clone this repository.

2. Open the project with Eclipse.

3. Right click the project and select 

4. Run As -> Java Application

5. Select the project main class: AssessmentApplication - com.tds.assessment.


To test the requests use the application Postman.

You can download from. 

[Postman](https://www.postman.com/)


## Authentication.

To use this application you must first authenticate and generate a JWT (Json Web Token).

### How to Authenticate:

    Open Postman and create a new post request with the following information.

    http://localhost:8080/authenticate

    Body: Type Json
   
    {"username":"tds", "password":"password"}

    This post request will return a JWT that is used to access the API controllers.

    return:
    {
       "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZHMiLCJleHAiOjE2MDA3ODg2MjAsImlhdCI6MTYwMDc3MDYyMH0.nTZ_qj468jDlUbaz1LALLMgm05EJ5_vH2n-9ynhRYNrypC6s6YeelzfJH_oLdIPQZyx-J-m5_P0Lj8NyZzXANA"
    }

![auth_with_postman](https://i.ibb.co/VVM9Jr6/postman-authenticate.png)


### Send a Request

    To send a GET request to the API you need to set the Headers first.

    Use the token genereated for the authenticated user.

    Create a GET request with the Headers on Postman like the example.

    http://localhost:8080/employees/active

    Headers:

    Key: Authorization

    Value: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZHMiLCJleHAiOjE2MDA3ODg2MjAsImlhdCI6MTYwMDc3MDYyMH0.nTZ_qj468jDlUbaz1LALLMgm05EJ5_vH2n-9ynhRYNrypC6s6YeelzfJH_oLdIPQZyx-J-m5_P0Lj8NyZzXANA

    This should return a list of active employees like this:

    [{"id":1,"firstName":"John","lastName":"Smith","badge_number":101,"country":"irl","job_title_name":"Software Engineer","department":"Software","start_date":"2020-06-07","leave_date":null},{"id":2,"firstName":"James","lastName":"Dunne","badge_number":102,"country":"irl","job_title_name":"Software Support","department":"Software","start_date":"2020-06-07","leave_date":null}]


![request_with_postman](https://i.ibb.co/jVqZmNW/postman-using-token.png)



### Available Endpoints

    For all the endpoints available the user must set the Authentication token like the example on "Send Request"
    
## Badges
   
    Get All badges
    http://localhost:8080/badges    
    Return a list of all badges available, status 200 OK.
    Return status 400 Bad Request if no badges are found.   
    
    Get Active Badges
    Ex: http://localhost:8080/badges/active
    Return a list of all badges active, status 200 OK.
    Return status 404 Not Found if no badges are active.   
        
    Get Single Badge
    Param: badge_number
    Ex: http://localhost:8080/badges?badge_number=111
    Return a badge, status 200 OK.
    Return 422 Unprocessable Entity if is not a numeric parameter.
    Return status 404 Not Found if no badges are found.   
    

## Employee

    Get All Employees
    http://localhost:8080/employees
    Return a list of all employees available, status 200 OK.
    Return status 400 Bad Request if no available are found.      
    
    Get Active Employees
    http://localhost:8080/employees/active
    Return a list of all employees active, status 200 OK.
    Return status 404 Not Found if no employees are active.
    
    Get Employee by Department Name
    Param: department_name
    Ex: http://localhost:8080/employees?department_name=Software
    Return a list of employee, status 200 OK.
    Return status 400 Bad Request no employees are found.    
    
## Department

    Get all the departments
    http://localhost:8080/department
    Return a list of all departments, status 200 OK.
    Return status 400 Bad Request if no departments are found.      
    
 ## Job Titles   
 
    Get All Job Titles   
    http://localhost:8080/job_titles
    Return a list of all job titles, status 200 OK.
    Return status 404 Not Found if no job titles are found.
    
    Get All Job Titles by Department 
    http://localhost:8080/job_titles?department_name=Software 
    Param: department_name
    Return a list of all job titles, status 200 OK.
    Return status 404 Not Found if no job titles are found.
    Return status 422 Unprocessable Entit if the department is invalid.

