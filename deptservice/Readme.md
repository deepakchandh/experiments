Curls to execute

POST 
```

curl --location 'http://localhost:8080/api/departments' \
--header 'Content-Type: application/json' \
--data '{
    "departmentName" : "Computer",
    "departmentDescription": "Electronics Engg",
    "departmentCode": "CSE"
}'
```

GET
```
curl --location 'http://localhost:8080/api/departments/{code}' \
--data ''
```
