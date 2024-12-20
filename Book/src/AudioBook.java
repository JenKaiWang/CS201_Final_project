import java.io.*;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Inheritance : AudioBook class extends Book
// Encapsulation : AudioBook class include a lot of field and method,
//                 and those field and method don't need to show to the user

public class AudioBook extends Book{
    int TotalLengthMinutes;
    double AudioAVG;
    double Audiocount = 0;
    int counter = 0;

    public AudioBook() {

    }

    public int getTotalLengthMinutes() {
        return TotalLengthMinutes;
    }

    public void setTotalLengthMinutes(int totalLengthMinutes) {
        TotalLengthMinutes = totalLengthMinutes;
    }

    public double getAudioAVG() {
        return AudioAVG;
    }

    public void setAudioAVG(double audioAVG) {
        AudioAVG = audioAVG;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public double getAudiocount() {
        return Audiocount;
    }

    public void setAudiocount(double audiocount) {
        Audiocount = audiocount;
    }

    public void AVGLength() throws IOException{
        File OpenFile = new File("Book.txt");
        Scanner ReadFile = new Scanner(OpenFile);
        while (ReadFile.hasNextLine()) {
            Book = ReadFile.nextLine();
            BookParts = Book.split(",");
            BookLength = Integer.parseInt(BookParts[5]);
            TotalLength += BookLength;
            if(BookParts[0].equals("audio_book")){
                this.Audiocount++;
            }
        }
        ReadFile.close();
        this.AudioAVG = TotalLength / this.Audiocount;
        System.out.println("The AVG length of Audio Book is =  " + Math.round(this.AudioAVG));
    }

    //Inheritance : AudioBook class implement getCost method from Book
    @Override
    void getCost() throws IOException {
        super.getTotalCost();
        System.out.println("The Audio Book cost is = $" + super.getAudioBookCost());
    }

    public void LastThreeAudioBooks() throws IOException {
        File OpenFile = new File("Book.txt");
        Scanner ReadFile = new Scanner(OpenFile);
        while (ReadFile.hasNextLine() && this.counter < 3) {
            Book = ReadFile.nextLine();
            BookParts = Book.split(",");
            if(BookParts[0].equals("audio_book")){
                System.out.println(Book);
                this.counter++;
            }
        }
        ReadFile.close();
        System.out.println("This are last three audio books");
    }

    //Inheritance : AudioBook class implement StoreBookInfo method from Book
    @Override
    void StoreBookInfo(String BookType, String Title, String Author, String Genre, int Pages, int Min) throws IOException {
        List<String> Lines = new ArrayList<>();
        File file = new File("Book.txt");
        if(file.exists()){
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                Lines.add(line);
            }
            reader.close();
        }

        String newdata = BookType + "," + Title + "," + Author + "," + Genre +"," + Pages + "," + Min;

        Lines.add(0, newdata);

        BufferedWriter writer = new BufferedWriter(new FileWriter("Book.txt"));
        for(int i = 0; i < Lines.size(); i++){
            writer.write(Lines.get(i));
            writer.newLine();
        }
        writer.close();
        System.out.println("Add one Book into Book.txt success \n");
    }
}
