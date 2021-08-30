import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        divideFile();
    }

    public static void divideFile()
    {
        try(Scanner scan = new Scanner(new FileInputStream("src/data.txt"));
            FileWriter writer = new FileWriter("src/dogs.txt",false);
            FileWriter writer2 = new FileWriter("src/cats.txt",false)) {
            String[] header = scan.nextLine().split(";");
            String newheader = header[1] + " " + header[2] + " " + header[3] +'\n';
            StringBuilder dogs =  new StringBuilder();
            StringBuilder cats = new StringBuilder();
            while(scan.hasNextLine()) {
                String[] str = scan.nextLine().split(";");
                if(str[0].equals("собака")) {
                    dogs.append(str[1] + " " + str[2] + " " + str[3] + '\n');
                }
                if(str[0].equals("кошка"))
                    cats.append(str[1] + " " + str[2] + " " + str[3] + '\n');
            }
            writer.write(newheader);
            writer.write(dogs.toString());

            writer2.write(newheader);
            writer2.write(cats.toString());
        }
        catch (Exception e) {
            System.out.println("Поймали исключение  " + e.getMessage());
        }
    }
}

