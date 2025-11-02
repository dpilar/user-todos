**Tasks:**

1. Build and run the application.
2. Using a REST API client (like Postman):
    * Retrieve all users (`GET /ven-api/ven-users`).
    * Retrieve the user with ID 5 (`GET /ven-api/ven-users/5`).
    * Retrieve all todos (`GET /ven-api/ven-todos`).
3. Implement an endpoint to retrieve all todos for users filtered by username (`GET /ven-api/ven-todos/filter?username=karianne`).
4. Write unit tests.
5. Create pull request to `users/<your-github-username>` branch.

Alternatives for point 3:
- Implement an endpoint to retrieve all posts for user (`GET /ven-api/ven-posts?userId=2`); the client will use https://jsonplaceholder.typicode.com/posts
   * if userId not provided, return all posts (`GET /ven-api/ven-posts`)


- Implement an endpoint to retrieve all albums for a user (`GET /ven-api/ven-albums?userId=4`); the client will use https://jsonplaceholder.typicode.com/albums
   * if userId is not provided, return all albums (`GET /ven-api/ven-albums`)


- Implement an endpoint to retrieve all comments ordered by `email/name/body` with specified direction `asc/desc` (`GET /ven-api/ven-comments?orderBy=email&direction=asc`); the client will use https://jsonplaceholder.typicode.com/comments


- Extend GET /ven-api/ven-users endpoint with ordering by `email/name/username` with specified direction `asc/desc` (`GET /ven-api/ven-users?orderBy=email&direction=asc`)