import java.io.*;
import java.util.Properties;

public class JavaIOExample {

    public static void main(String[] args) {

        // 1. Read using InputStream
        try {
            FileInputStream fis = new FileInputStream("input.txt");
            int i;
            while ((i = fis.read()) != -1) {
                System.out.print((char) i);
            }
            fis.close();
        } catch (Exception e) {
            System.out.println("Error reading using InputStream");
        }

        // 2. Write using OutputStream
        try {
            FileOutputStream fos = new FileOutputStream("output.txt");
            String text = "Hello World using OutputStream";
            fos.write(text.getBytes());
            fos.close();
        } catch (Exception e) {
            System.out.println("Error writing using OutputStream");
        }

        // 3. BufferedInputStream
        try {
            BufferedInputStream bis = new BufferedInputStream(
                    new FileInputStream("input.txt"));
            int i;
            while ((i = bis.read()) != -1) {
                System.out.print((char) i);
            }
            bis.close();
        } catch (Exception e) {
            System.out.println("Error in BufferedInputStream");
        }

        // 4. BufferedOutputStream
        try {
            BufferedOutputStream bos = new BufferedOutputStream(
                    new FileOutputStream("output2.txt"));
            String text = "Writing using BufferedOutputStream";
            bos.write(text.getBytes());
            bos.close();
        } catch (Exception e) {
            System.out.println("Error in BufferedOutputStream");
        }

        // 5. FileReader
        try {
            FileReader fr = new FileReader("input.txt");
            int i;
            while ((i = fr.read()) != -1) {
                System.out.print((char) i);
            }
            fr.close();
        } catch (Exception e) {
            System.out.println("Error in FileReader");
        }

        // 6. FileWriter
        try {
            FileWriter fw = new FileWriter("output3.txt");
            fw.write("Writing using FileWriter");
            fw.close();
        } catch (Exception e) {
            System.out.println("Error in FileWriter");
        }

        // 7. BufferedReader
        try {
            BufferedReader br = new BufferedReader(
                    new FileReader("input.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error in BufferedReader");
        }

        // 8. BufferedWriter
        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter("output4.txt"));
            bw.write("Writing using BufferedWriter");
            bw.close();
        } catch (Exception e) {
            System.out.println("Error in BufferedWriter");
        }

        // 9. Properties file
        try {
            FileInputStream fis = new FileInputStream("config.properties");
            Properties p = new Properties();
            p.load(fis);

            System.out.println("Property value: " + p.getProperty("name"));
            fis.close();
        } catch (Exception e) {
            System.out.println("Error reading properties file");
        }

        // 10 & 11 Excel (Simple simulation)
        try {
            FileWriter fw = new FileWriter("excel.csv");
            fw.write("Name,Age\n");
            fw.write("Parthibhan,21\n");
            fw.close();

            BufferedReader br = new BufferedReader(new FileReader("excel.csv"));
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();

        } catch (Exception e) {
            System.out.println("Error in Excel simulation");
        }
    }
}