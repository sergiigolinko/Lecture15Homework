import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ReadWriteHugeFile {
    public static void main(String[] args) throws Exception {
        Map<String, Integer> map = new HashMap<>();
        FileOutputStream fileOutputStream = new FileOutputStream("output.txt");


        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\Сергей\\IdeaProjects\\Lecture15Homework\\src\\big.txt")));
        StringBuilder stringBuilder = new StringBuilder();
        boolean nextLineExists = true;
        while (nextLineExists) {
            String currentLine = reader.readLine();
            String[] words = currentLine.split(" ");
            for (String s : words
            ) {
                if (map.containsKey(s)) {
                    map.put(s, map.get(s) + 1);
                } else {
                    map.put(s, 1);
                }
            }
            for (Map.Entry<String, Integer> entry : map.entrySet()
            ) {
                String readline2 = " " + entry.getKey() + " " + "=" + " " + entry.getValue() + " ";
                byte[] bytesToWrite = readline2.getBytes();
                fileOutputStream.write(bytesToWrite);
            }

            if (currentLine != null) {
                stringBuilder.append(currentLine).append("\n");
            } else {
                nextLineExists = false;
            }
        }
        fileOutputStream.close();
    }
}
