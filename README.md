Project Overview📚

The Library Management System is a Java-based application designed to manage a library's users and books efficiently. It uses SQLite as the backend database for data persistence, ensuring that all data (like user registrations and book information) is stored permanently and can be retrieved or modified when needed. The system includes features like user account management, book addition, and book search functionalities, making it a simple yet effective solution for small-scale libraries or personal use.

Key Features✒️:

✨User Management:

✅Registration: Allows new users to create an account by providing a username and password.

✅Login: Enables registered users to log in and access additional features like adding books.

✨Book Management:

✅Add Books: Authorized users can add new books to the library database by entering the book title and author.

✅Search Books: Users can search for books by entering keywords (title or author) to retrieve matching results.

✅Database Persistence:The system uses SQLite for storing user and book data persistently.

Tables include:
✅users: Stores user credentials (id, username, password).

✅books: Stores book details (id, title, author).

Error Handling:

✅Validates user inputs for registration and login.
✅Handles database errors such as missing tables or duplicate entries gracefully.

Technologies Used✒️:

Programming Language: Java

Database: SQLite (with JDBC for database connectivity)

IDE: NetBeans

Libraries:
SQLite JDBC Driver for database interaction.
