import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientOne {
    public static void main(String[] args) {

        try (Socket client = new Socket("127.0.0.1", 8989);
             BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
             PrintWriter out = new PrintWriter(client.getOutputStream(), true);) {
            final String word = in.readLine();
            System.out.println(word);
            Scanner scanner = new Scanner(System.in);
            String newWord = scanner.nextLine();
            out.println(newWord);
            System.out.println(in.readLine());

//            out.println("Masha");
//            System.out.println(in.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
