import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String str= bufferedReader.readLine();
        double A=Double.parseDouble(str.split(" ")[0]);
        double B=Double.parseDouble(str.split(" ")[1]);

        System.out.print(A/B);
    }
}