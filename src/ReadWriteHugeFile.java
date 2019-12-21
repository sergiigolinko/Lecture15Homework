import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ReadWriteHugeFile {
    public static void main(String[] args) throws Exception {
        Map<String,Integer> map=new HashMap<>();
        FileOutputStream fileOutputStream = new FileOutputStream("output.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\Сергей\\IdeaProjects\\Lecture15Homework\\src\\1.txt")));
        StringBuilder stringBuilder = new StringBuilder();
        boolean nextLineExists = true;
        while (nextLineExists) {
            String currentLine = reader.readLine();
            String[] words=currentLine.split(" ");
            for (String s:words
                 ) {
                if(map.containsKey(s)){
                    map.put(s,map.get(s)+1);
                }
                else {
                    map.put(s,1);
                }
            }
            /*byte[] bytesToWrite = map.getBytes();
            fileOutputStream.write(bytesToWrite);*/
            oos.writeObject(map);


            //System.out.println(map);
            if (currentLine != null) {
                stringBuilder.append(currentLine).append("\n");
            } else {
                nextLineExists = false;
            }
        }
        oos.close();
        fileOutputStream.close();
        System.out.println(stringBuilder.toString());
        System.out.println(oos.toString());

    }
}
