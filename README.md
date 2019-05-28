### Source: 

# Getting Started

## Guides

   ### 1. Postgres
       
        steps:
        
           enter database: psql
           
           create db:      "CREATE DATABASE netbooktest;"
           
           quit database:  "\q"
           
           go to '/dataset' folder and edit 'script.sql' - change the relative path to all csv files
           
           in terminal (stay in '/dataset' folder) execute: "psql -d netbooktest -f script.sql"
               
   ### 2. Setting up Content-Service
        steps:
            
            edit /resources/application.properties: set up your 'username' and 'password' for postgresql 
            
   ### 3. Run
        Intellij - steps: File -> New -> Project From Existing Sources, then click next..
        
        
        Terminal
            steps:
                terminal: "mvn clean install", or "mvn install"
                terminal: "mvn spring-boot:run"
            
   ### 4. Testing with Postman
            
            https://app.getpostman.com/join-team?invite_code=11dfeb0a09decf1d9d37fec6a4509f2d

## References

### Project Structure References Docs:
https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-structuring-your-code.html
