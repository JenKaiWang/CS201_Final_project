import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print(
                    "-----------------------------------------" + "\n" +
                            "Hello please select number:" + "\n" +
                            "1. Display last 6 books" + "\n" +
                            "2. Display last 3 Print books" + "\n" +
                            "3. Display last 3 Audio books" + "\n" +
                            "4. Add book" + "\n" +
                            "5. Total cost of Print Book" + "\n" +
                            "6. Total cost of Audio Book" + "\n" +
                            "7. Number of books in each genre" + "\n" +
                            "8. Get AVG pages of Print Book" + "\n" +
                            "9. Get AVG length of Audio Book" + "\n" +
                            "10. Get total cost" + "\n" +
                            "11. Exit" + "\n");
            System.out.print("Enter your choice: ");
            if(input.hasNextInt()) {
                int choice1 = input.nextInt();
                System.out.print("-----------------------------------------" + "\n");
                 if(choice1 >= 1 && choice1 <= 11) {
                    switch (choice1) {
                        case 1:
                            PrintBook c1 = new PrintBook();
                            System.out.println("Book Type, Book Title, Author, Genre, Pages, MIN");
                            c1.DisplayLastSixBooks();
                            break;
                        case 2:
                            PrintBook c2 = new PrintBook();
                            System.out.println("Book Type, Book Title, Author, Genre, Pages, MIN");
                            c2.LastThreePrintBooks();
                            break;
                        case 3:
                            AudioBook c3 = new AudioBook();
                            System.out.println("Book Type, Book Title, Author, Genre, Pages, MIN");
                            c3.LastThreeAudioBooks();
                            break;
                        case 4:
                            //every input to lowercase can ignore the uppercase or lowercase from user
                            PrintBook c4 = new PrintBook();
                            System.out.println("Please enter the book information ");
                            System.out.println("Book Type : Print_Book / Audio_Book ( Please enter the same format )");
                            input.nextLine();
                            String BookType = input.nextLine().toLowerCase();
                            System.out.println("Book Title");
                            String Title = input.nextLine().toLowerCase();
                            System.out.println("Book Author: ");
                            String Author = input.nextLine().toLowerCase();
                            System.out.println("Book Genre: Fiction and N-Fiction or more from you ");
                            String Genre = input.nextLine().toLowerCase();
                            System.out.println("Book Pages: If this book is AUDIO book, please enter o");
                            int Pages = input.nextInt();
                            System.out.println("Min: If this book is PRINT book, please enter o");
                            int Min = input.nextInt();
                            c4.StoreBookInfo(BookType, Title, Author, Genre, Pages, Min);
                            break;
                        case 5:
                            PrintBook c5 = new PrintBook();
                            c5.getCost();
                            break;
                        case 6:
                            AudioBook c6 = new AudioBook();
                            c6.getCost();
                            break;
                        case 7:
                            BookInterface c7 = new PrintBook(); //Polymorphism
                            System.out.println("Please enter the book genre you want to see ");
                            String genre = input.next().toLowerCase();
                            System.out.println("Number of books in " + genre + " genre is = " + c7.NumberOfBooksByGenre(genre));
                            break;
                        case 8:
                            PrintBook c8 = new PrintBook();
                            c8.AVGPages();
                            break;
                        case 9:
                            AudioBook c9 = new AudioBook();
                            c9.AVGLength();
                            break;
                        case 10:
                            BookInterface c10 = new PrintBook(); //Polymorphism
                            System.out.println("The total cost is $" + c10.getTotalCost()); //Polymorphism
                            break;
                        case 11:
                            System.out.println("Exit book application");
                            return;
                    }
                 }
                 else
                 {
                    System.out.println("Invalid choice, please enter number between 1 and 11");
                 }
            }
            else
            {
                System.out.print("-----------------------------------------" + "\n");
                System.out.println("Invalid choice, please enter number");
                input.next();
            }
        }
    }
}