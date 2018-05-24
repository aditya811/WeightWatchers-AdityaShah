package Question1;
import java.io.*;
/**
 * @author  Aditya Shah
 * @version 1.0
 *
 */
public class ReadFile {
    public static void main(String[]args) throws IOException {

        String fileName = new File("src/test/java/Question1/Dictionary.txt").getAbsolutePath();
        boolean isfileexists =  isfileExist(fileName);
        String line = null;
        if (isfileexists){
            FileReader fileReader =
                    new FileReader(fileName);

            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                breaklineAndPrint(line);
            }
            bufferedReader.close();
        }
    }

    public static void breaklineAndPrint(String line){

        String lines[] = line.split("–");
        System.out.println(lines[0].trim());
        System.out.println(lines[1].trim());
    }

    public static boolean isfileExist(String path) {

        try {
            FileReader fileReader =
                    new FileReader(path);
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);
            bufferedReader.close();
            return true;
        } catch (FileNotFoundException f) {
            System.out.println("file not found");
            return false;
        } catch (IOException f) {
            System.out.println(f);
            return false;
        }
    }
}
