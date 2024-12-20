import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Inheritance : PrintBook class extends Book
// Encapsulation : PrintBook class include a lot of field and method,
//                 and those field and method don't need to show to the user

public class PrintBook extends Book {
    int TotalNumberOfPages;
    double PrintAVG;
    double PrintCount = 0;
    int counter = 0;

    public PrintBook() {
    }

    public int getTotalNumberOfPages() {
        return TotalNumberOfPages;
    }

    public void setTotalNumberOfPages(int totalNumberOfPages) {
        TotalNumberOfPages = totalNumberOfPages;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public double getPrintCount() {
        return PrintCount;
    }

    public void setPrintCount(double printCount) {
        PrintCount = printCount;
    }

    public double getPrintAVG() {
        return PrintAVG;
    }

    public void setPrintAVG(double printAVG) {
        PrintAVG = printAVG;
    }

    public void AVGPages() throws IOException{
        File OpenFile = new File("Book.txt");
        Scanner ReadFile = new Scanner(OpenFile);
        while (ReadFile.hasNextLine()) {
            Book = ReadFile.nextLine();
            BookParts = Book.split(",");
            BookPages = Integer.parseInt(BookParts[4]);
            TotalPages += BookPages;
            if(BookParts[0].equals("print_book")){
                this.PrintCount++;
            }
        }
        ReadFile.close();
        this.PrintAVG = TotalPages / this.PrintCount;
        System.out.println("The AVG pages of Print Book is =  " + Math.round(this.PrintAVG));
    }

    //Inheritance : PrintBook class implement getCost method from Book
    @Override
    void getCost() throws IOException{
       super.getTotalCost();
       System.out.println("The Print Book cost is = $" + super.getPrintBookCost());
    }

    public void LastThreePrintBooks() throws IOException{
        File OpenFile = new File("Book.txt");
        Scanner ReadFile = new Scanner(OpenFile);
        while (ReadFile.hasNextLine() && this.counter < 3) {
            Book = ReadFile.nextLine();
            BookParts = Book.split(",");
            if(BookParts[0].equals("print_book")){
                System.out.println(Book);
                this.counter++;
            }
        }
        ReadFile.close();
        System.out.println("This are last three print books");
    }

    //Inheritance : PrintBook class implement StoreBookInfo method from Book
    @Override
    void StoreBookInfo(String BookType, String Title, String Author, String Genre, int Pages, int Min ) throws IOException{
        List<String> Lines = new ArrayList<>();
        this.BookType = BookType;
        this.Title = Title;
        this.Author = Author;
        this.Genre = Genre;
        this.Pages = Pages;
        this.Min = Min;
        File file = new File("Book.txt");
        if(file.exists()){
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                Lines.add(line);
            }
            br.close();
        }

        String newLine = BookType + "," + Title + "," + Author + "," + Genre +"," + Pages + "," + Min;

        Lines.add(0,newLine);

        BufferedWriter bw = new BufferedWriter(new FileWriter("Book.txt"));
        for(String line : Lines){
            bw.write(line);
            bw.newLine();
        }
        bw.close();
        System.out.println("Add one Book into Book.txt success \n");
    }
}
