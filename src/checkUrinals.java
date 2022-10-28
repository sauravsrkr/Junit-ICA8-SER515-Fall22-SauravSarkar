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

    String[] readFromFile(String filepath) {
        return null;
    }

    void writeToFile(int counter, int[] data) {
        return;
    }
}
