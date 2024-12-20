import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

// Abstract class
// Encapsulation : abstract class Book include a lot of field and method,
//                 and those field and method don't need to show to the user

// Inheritance : Book abstract class implements BookInterface,
//               but because the Book class is an abstract class,
//               so Book class don't need to implements every method in BookInterface
public abstract class Book implements BookInterface {
    double TotalCost = 0;
    double BookPages;
    double TotalPages = 0;
    double BookLength;
    double TotalLength;
    double PrintBookCost;
    double AudioBookCost;
    String Book;
    String[] BookParts;
    String BookType;
    String Title;
    String Author;
    String Genre;
    int NumberOfBookByGenre;
    int Pages;
    int Min;

    public Book() {
    }

    public void setTotalCost(double totalCost) {
        TotalCost = totalCost;
    }

    public double getBookPages() {
        return BookPages;
    }

    public void setBookPages(double bookPages) {
        BookPages = bookPages;
    }

    public double getTotalPages() {
        return TotalPages;
    }

    public void setTotalPages(double totalPages) {
        TotalPages = totalPages;
    }

    public double getBookLength() {
        return BookLength;
    }

    public void setBookLength(double bookLength) {
        BookLength = bookLength;
    }

    public double getTotalLength() {
        return TotalLength;
    }

    public void setTotalLength(double totalLength) {
        TotalLength = totalLength;
    }

    public String getBook() {
        return Book;
    }

    public void setBook(String book) {
        Book = book;
    }

    public String[] getBookParts() {
        return BookParts;
    }

    public void setBookParts(String[] bookParts) {
        BookParts = bookParts;
    }

    public double getPrintBookCost() {
        return PrintBookCost;
    }

    public void setPrintBookCost(double printBookCost) {
        PrintBookCost = printBookCost;
    }

    public double getAudioBookCost() {
        return AudioBookCost;
    }

    public void setAudioBookCost(double audioBookCost) {
        AudioBookCost = audioBookCost;
    }

    public int getNumberOfBookByGenre() {
        return NumberOfBookByGenre;
    }

    public void setNumberOfBookByGenre(int numberOfBookByGenre) {
        NumberOfBookByGenre = numberOfBookByGenre;
    }

    public String getBookType() {
        return BookType;
    }

    public void setBookType(String bookType) {
        BookType = bookType;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public int getPages() {
        return Pages;
    }

    public void setPages(int pages) {
        Pages = pages;
    }

    public int getMin() {
        return Min;
    }

    public void setMin(int min) {
        Min = min;
    }

    //Abstract method
    abstract void StoreBookInfo(String BookType,String Title, String Author, String Genre, int Pages, int Min) throws IOException;

    //Inheritance : Book abstract class implement getTotalCost method from BookInterface
    @Override
    public double getTotalCost() throws FileNotFoundException {
        File OpenFile = new File("Book.txt");
        Scanner ReadFile = new Scanner(OpenFile);
        while (ReadFile.hasNextLine()) {
            Book = ReadFile.nextLine();
            BookParts = Book.split(",");
            BookPages = Integer.parseInt(BookParts[4]);
            TotalPages += BookPages;
            BookLength = Integer.parseInt(BookParts[5]);
            TotalLength += BookLength;
        }
        ReadFile.close();
        PrintBookCost = TotalPages * 10;
        AudioBookCost = TotalLength * 5;
        TotalCost = PrintBookCost + AudioBookCost;
        return TotalCost;

    }

    //Abstract method
    abstract void getCost() throws IOException;

    //Inheritance : Book abstract class implement NumberOfBookByGenre method from BookInterface
    @Override
    public int NumberOfBooksByGenre(String Genre) throws IOException{
        File OpenFile = new File("Book.txt");
        Scanner ReadFile = new Scanner(OpenFile);
        while (ReadFile.hasNextLine()) {
            Book = ReadFile.nextLine();
            BookParts = Book.split(",");
            if(BookParts[3].equals(Genre)){
                NumberOfBookByGenre++;
            }
        }
        return NumberOfBookByGenre;
    }

    //Abstract method
}
