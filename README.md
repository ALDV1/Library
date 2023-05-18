# Library Management System

This project is a library management system that allows users to manage books and people in a library. It provides functionality for adding, editing, and deleting book and people records. The system also supports book assignments to people and book searches.

## Books Controller

The `BooksController` handles requests related to books in the library.

### Endpoints

- `GET /books`: Retrieves all books from the library. Optionally, accepts a query parameter `sort_by_year` to sort the books by year. Renders the `books/show` view.

- `GET /books/{id}`: Retrieves a specific book by its ID. Renders the `books/showById` view, displaying the book details and the book owner (if assigned) or the list of available people to assign the book.

- `GET /books/new`: Renders the `books/new` view to create a new book.

- `POST /books`: Creates a new book based on the submitted form data. If there are validation errors, renders the `books/new` view with the error messages. Otherwise, redirects to the book list page (`/books`).

- `GET /books/{id}/edit`: Renders the `books/edit` view to edit a specific book.

- `PATCH /books/{id}`: Updates the details of a specific book based on the submitted form data. If there are validation errors, renders the `books/edit` view with the error messages. Otherwise, redirects to the book list page (`/books`).

- `DELETE /books/{id}`: Deletes a specific book from the library. Redirects to the book list page (`/books`).

- `PATCH /books/{id}/release`: Releases a book, removing its assignment to a person. Redirects to the book details page (`/books/{id}`).

- `PATCH /books/{id}/assign`: Assigns a book to a specific person based on the submitted form data. Redirects to the book details page (`/books/{id}`).

- `GET /books/search`: Renders the `books/search` view to perform a book search.

- `POST /books/search`: Performs a search based on the submitted query and retrieves books that match the title. Renders the `books/search` view with the search results.

## People Controller

The `PeopleController` handles requests related to people in the library.

### Endpoints

- `GET /people`: Retrieves all people records from the library. Renders the `people/show` view.

- `GET /people/{id}`: Retrieves a specific person by their ID. Renders the `people/person` view, displaying the person details and the books assigned to them.

- `GET /people/new`: Renders the `people/new` view to create a new person.

- `POST /people`: Creates a new person based on the submitted form data. If there are validation errors, renders the `people/new` view with the error messages. Otherwise, redirects to the people list page (`/people`).

- `GET /people/{id}/edit`: Renders the `people/edit` view to edit a specific person.

- `PATCH /people/{id}`: Updates the details of a specific person based on the submitted form data. If there are validation errors, renders the `people/edit` view with the error messages. Otherwise, redirects to the people list page (`/people`).

- `DELETE /people/{id}`: Deletes a specific person from the library. Redirects to the people list page (`/people`).