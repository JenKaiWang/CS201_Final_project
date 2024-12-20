To use this code, please follow the steps below:
1. Download the "Book" folder to your computer.
2. Open the "Book" folder in an IDE, such as IntelliJ IDEA.
3. Run the "Main" file located in Book -> src -> Main.
4. Once the program starts, you will see the code running.

This program demonstrates the principles of object-oriented design, with the following key features:

1. Encapsulation
A. Each class (e.g., AudioBook and PrintBook) encapsulates data through private attributes and public methods(getters and setters), preventing direct modification of properties to enhance security and maintainability.

B. Methods like getCost() and StoreBookInfo() abstract complex internal logic, exposing only necessary functionality to the user, who can operate the system without worrying about implementation details.

3. Inheritance
A. The abstract class "Book" provides shared properties and methods (e.g., book title, author, page count) for its subclasses :AudioBook" and "PrintBook".

B. Subclasses override methods such as getCost() to handle specific requirements for different types of books, enabling specialized behavior.

3. Polymorphism
A. Polymorphism is heavily used, allowing the program to operate on objects of "PrintBook" or "AudioBook" through the "BookInterface" or the parent class Book.

B. For example, in the Main class, generic calls to methods like "getTotalCost()" are made without needing to know the specific implementation of the object being handled, enabling flexibility in functionality.

4. Abstraction
A. The abstract class "Book" and the interface "BookInterface" define core functionalities (e.g., getCost() and StoreBookInfo()), which must be implemented by subclasses.
B. This abstraction simplifies the design and allows for future extensions, such as adding new book types, without affecting the existing functionality.

For a detailed walkthrough on how to use this project, please refer to the tutorial video:
https://www.loom.com/share/c3f772202cb84984800827522b476088?sid=55bdef0b-2896-4829-b196-5f8d804866ac
