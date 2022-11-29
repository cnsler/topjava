### REST controllers curl tests
> for Windows terminal
***
1. **Meal**
   - get all meals
     ```
     curl -X GET "http://localhost:8080/topjava/rest/meals"
     ```
   - get meal with id 100003
     ```
     curl -X GET "http://localhost:8080/topjava/rest/meals/100003"
     ```
   - get meals filtered by date/time
     ```
     curl -X GET "http://localhost:8080/topjava/rest/meals/getBetween?startDate=2020-01-30&startTime=10:00&endDate=2020-01-31&endTime=13:00"
     ```
   - get meals filtered by endTime
     ```
     curl -X GET "http://localhost:8080/topjava/rest/meals/getBetween?endTime=13:00"
     ```
     *or*
     ```
     curl -X GET "http://localhost:8080/topjava/rest/meals/getBetween?startDate=&startTime=&endDate=&endTime=13:00"
     ```
   - update meal with id 100003
     ```
     curl -X PUT "http://localhost:8080/topjava/rest/meals/100003" -H "Content-Type: application/json; charset=Windows-1251" --data-raw "{\"dateTime\":\"2020-01-30T10:15\",\"description\":\"Плотный завтрак\",\"calories\":600}"
     ```
   - delete meal with id 100003
     ```
     curl -X DELETE "http://localhost:8080/topjava/rest/meals/100003"
     ```
   - create meal
     ```
     curl -X POST "http://localhost:8080/topjava/rest/meals" -H "Content-Type: application/json; charset=Windows-1251" --data-raw "{\"dateTime\":\"2020-01-30T10:00\",\"description\":\"Восстановленный завтрак\",\"calories\":500}"
     ```
1. **User**
   - get current user
     ```
     curl -X GET "http://localhost:8080/topjava/rest/profile"
     ```
   - update current user
     ```
     curl -X PUT "http://localhost:8080/topjava/rest/profile" -H "Content-Type: application/json" --data-raw "{\"name\":\"UpdUser\",\"email\":\"upduser@ya.ru\",\"password\":\"updUserPass\",\"roles\":[\"USER\"]}"
     ```
   - test UTF-8
     ```
     curl -X GET "http://localhost:8080/topjava/rest/profile/text"
     ```
   - delete current user
     ```
     curl -X DELETE "http://localhost:8080/topjava/rest/profile"
     ```
1. **Admin**
   - get all users
     ```
     curl -X GET "http://localhost:8080/topjava/rest/admin/users"
     ```
   - get user with id 100002
     ```
     curl -X GET "http://localhost:8080/topjava/rest/admin/users/100002"
     ```
   - get user by email
     ```
     curl -X GET "http://localhost:8080/topjava/rest/admin/users/by-email?email=user@yandex.ru"
     ```
   - update user with id 100002
     ```
     curl -X PUT "http://localhost:8080/topjava/rest/admin/users/100002" -H "Content-Type: application/json" --data-raw "{\"name\":\"Updated\",\"email\":\"upd@ya.ru\",\"password\":\"updPassword\",\"roles\":[\"USER\"]}"
     ```
   - delete user with id 100002
     ```
     curl -X DELETE "http://localhost:8080/topjava/rest/admin/users/100002"
     ```
   - create user
     ```
     curl -X POST "http://localhost:8080/topjava/rest/admin/users" -H "Content-Type: application/json" --data-raw "{\"name\":\"New\",\"email\":\"new@ya.ru\",\"password\":\"newPassword\",\"roles\":[\"USER\"]}"
     ```