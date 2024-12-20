import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public interface BookInterface {

    default void DisplayLastSixBooks() throws IOException {
        int counter = 0;
        File OpenFile = new File("Book.txt");
        Scanner ReadFile = new Scanner(OpenFile);

        while (ReadFile.hasNext() && counter < 6) {
            System.out.println(ReadFile.nextLine());
            counter++;
        }
        ReadFile.close();
        System.out.println("This is the last six books");
    }

    //Abstract method
    abstract int NumberOfBooksByGenre(String Genre) throws IOException;

    //Abstract method
    abstract double getTotalCost() throws FileNotFoundException;
}
