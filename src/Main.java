import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        divideFile();
    }

    public static void divideFile() throws IOException {
        Scanner scan = new Scanner(new FileInputStream("src/data.txt"));
        String[] header = scan.nextLine().split(";");
        String newheader = header[1] + " " + header[2] + " " + header[3] +'\n';
        String dogs = "";
        String cats = "";
        while(scan.hasNextLine()) {
            String[] str = scan.nextLine().split(";");
            if(str[0].equals("собака")) {
                dogs += str[1] + " " + str[2] + " " + str[3] + '\n';
            }
            if(str[0].equals("кошка"))
                cats += str[1] + " " + str[2] + " " + str[3] + '\n';
        }

        FileWriter writer = new FileWriter("src/dogs.txt",false);
        writer.write(newheader);
        writer.write(dogs);
        writer.close();

        String catstr = dogs.toString();
        FileWriter writer2 = new FileWriter("src/cats.txt",false);
        writer2.write(newheader);
        writer2.write(cats);
        writer2.close();
    }
}
