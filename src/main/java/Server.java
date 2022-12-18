import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8989)) {
            System.out.println("Сервер запущен");
            String word = "???";
            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true);) {

                    out.println(word);
                    String newWord = in.readLine();
                    if (word == "???") {
                        out.println("OK");
                        System.out.println("Новое слово: " + newWord);
                        word = newWord;
                    }
                    if (word != "???"){
                        char wordChar = word.charAt(word.length() - 1);
                        char newWordChar = newWord.charAt(0);
                        if (wordChar == newWordChar) {
                            out.println("OK");
                            System.out.println("Новое слово: " + newWord);
                            word = newWord;
                        } else {
                            out.println("NOT OK");
                            continue;
                        }
                    }
//                    System.out.println("Новое слово: " + newWord);
//                    word = newWord;

//                    out.println(word);
//                    String newWord = in.readLine();
//                    System.out.println("Новое слово: " + newWord);
//                    word = newWord;

//                    System.out.println("New connection accepted");
//                    final String name = in.readLine();
//                    out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }
}
