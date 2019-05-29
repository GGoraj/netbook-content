#### Creating database:

- log in to psql account
- run: 'CREATE DATABASE netbook_content;'
- run: '\c netbook' to connect to database
- run: '\ir ../script.sql' where you should use relative path ie. ../..netbook-content/database/script.sql

##### another way:

- log in to psql account
- run: 'CREATE DATABASE netbook-content;'
- '\q'
- enter 'database' folder
- (from console) 'psql -d netbook_content -f script.sql'