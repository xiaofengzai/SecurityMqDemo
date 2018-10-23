import java.io.*;
import java.nio.Buffer;

public class ExceptionTest {
    public static void main(String[] args) {
       test();
    }

    public static void test() {
        BufferedReader file = null;
        try {
            file = new BufferedReader(new FileReader("/etc/profilet"));
            return;
            //System.out.println(file.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("not found");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO exception");
        } finally {
            System.out.println("In finaal");
        }
    }
}
