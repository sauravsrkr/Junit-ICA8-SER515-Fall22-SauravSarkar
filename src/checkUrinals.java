import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class checkUrinals {

    Boolean goodString(String str) {
        if (str.trim().length() == 0)
            return false;
        Pattern pattern = Pattern.compile("^[0-1]*$");
        if (!pattern.matcher(str).matches()) {
            throw new NumberFormatException("Invalid input string");
        }
        return pattern.matcher(str).find();
    }

    int getFreeUrinals(String str) {
        boolean matches = Pattern.compile("11").matcher(str).find();
        if (matches)
            return -1;
        int count = 0;
        int temp = 0;
        if (str.length() == 0 || str.length() == 1) {
            return 1 - (str.charAt(0) - '0');
        } else if (str.charAt(0) == '0' && str.charAt(1) == '0') {
            count++;
        }
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == '1' && temp != 0) {
                count += Math.floorDiv((temp - 1), 2);
                temp = 0;
            }
            if (str.charAt(i) == '0') {
                temp += 1;
            }
        }
        if (temp != 0) {
            if (temp % 2 == 0) {
                count += Math.floorDiv(temp, 2);
            } else {
                count += Math.floorDiv((temp - 1), 2);
            }
        }
        return count;
    }

    String[] readFromFile(String filepath) throws IOException {
        List<String> inputStrings = new ArrayList<>();
        BufferedReader bf = new BufferedReader(new FileReader(filepath));
        String l = bf.readLine();
        while (l != null) {
            inputStrings.add(l);
            l = bf.readLine();
        }
        bf.close();
        return inputStrings.toArray(new String[0]);
    }

    void writeToFile(String[] inputs) throws IOException {
        String write = writeToOutputFile();
        File of = new File("./" + write);
        StringBuilder output = new StringBuilder();
        for (String l : inputs) {
            if (goodString(l))
                output.append(this.getFreeUrinals(l)).append("\n");
        }
        Files.write(of.toPath(), output.toString().getBytes());
        System.out.println("Output written to " + write);
    }

    String writeToOutputFile() {
        File f = new File("./rule.txt");
        if (!f.exists()) return "rule.txt";
        File fol = new File("./");
        File[] files = fol.listFiles();
        int count = 0;
        assert files != null;
        for (File x : files) {
            if (x.isFile()) {
                String fileName = x.getName();
                if (fileName.contains("rule")) count ++;
            }
        }
        return "rule" + count + ".txt";
    }
}
