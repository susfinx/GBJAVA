import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class DZ2 {
    public static void main(String[] args) {
        int[] Array = new int[]{43,6,12,87,0,34,3,1,1,1,564,456,4,3,6,5,14,64};
        Puzyrek(Array);


////      String strin = readFile(); // Chtenie IZ Faila JSON
//        String strin =  ("{ { \"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
//                "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
//                "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}}");
//        strin = strin.substring(4, strin.length() - 3);
//        strin = strin.replace("\"", "");
//        strin = strin.replace("}", "");
//        splitstrok(strin);
    }

    static void splitstrok(String strin) {
        String[] splitStrin = strin.split("фамилия");
        for (int i = 0; i < splitStrin.length; i++) {
            StringBuilder stringBuilder = new StringBuilder("Student  Poluchil(a) otcenku  po  ");
            String[] splytfam = splitStrin[i].split(":|,");
            try {
                stringBuilder.insert(8, splytfam[1]);
                stringBuilder.insert(stringBuilder.length() - 5, splytfam[3]);
                stringBuilder.insert(stringBuilder.length() - 1, splytfam[5]);
                System.out.println(stringBuilder);
                writerfile(stringBuilder.toString()+"\n");
            } catch (Exception e) {
                continue;
            }
        }
    }
    static void writerfile(String str){
        try (FileWriter writ = new FileWriter("Note.txt", true))
        {
            writ.write(str);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
            loger();
        }
    }
    static String readFile(){
        File file = new File("JSON.txt");
        StringBuilder stringBuilder = new StringBuilder();
        try (Scanner scanner = new Scanner(file)){
            while (scanner.hasNext()){
                stringBuilder.append(scanner.nextLine());
                stringBuilder.append("\n");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
    static void loger(){
        Logger logger = Logger.getAnonymousLogger();
        logger.log(Level.INFO, "ZAPISALI");
        SimpleFormatter formatter = new SimpleFormatter();
        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("log.txt", true);
            fileHandler.setFormatter(formatter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.addHandler(fileHandler);
    }
    static void Puzyrek (int [] Array){
        boolean flag=true;
        int Boof=0;
        while (flag==true){
            flag=false;
            for (int i=1; i<Array.length;i++){
                if (Array[i]<Array[i-1]){
                    Boof=Array[i];
                    Array[i]=Array[i-1];
                    Array[i-1]=Boof;
                    flag=true;
                    loger();
                }

            }
        }
        System.out.println(Arrays.toString(Array));
    }

}
