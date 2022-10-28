import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class urinalsTest {
    private checkUrinals urine;

    @BeforeEach
    public void setUrine() {
        urine = new checkUrinals();
    }

    @Test
    void goodStringOne() {
        System.out.println("====== Saurav Sarkar == goodStringOne == TEST ONE EXECUTED =======");
        assertEquals(true, urine.goodString("1010"));
    }

    @Test
    void goodStringTwo() {
        System.out.println("====== Saurav Sarkar == goodStringTwo == TEST TWO EXECUTED =======");
        assertEquals(false, urine.goodString(""));
    }

    @Test
    void goodStringThree() {
        System.out.println("====== Saurav Sarkar == goodStringThree == TEST THREE EXECUTED - NumberFormatException =======");
        assertThrows(NumberFormatException.class, () -> {
            urine.goodString("abc");
        });
    }

    @Test
    void getFreeUrinalsOne() {
        System.out.println("====== Saurav Sarkar == getFreeUrinalsOne == TEST ONE EXECUTED =======");
        assertEquals(1, urine.getFreeUrinals("10001"));
    }

    @Test
    void getFreeUrinalsTwo() {
        System.out.println("====== Saurav Sarkar == getFreeUrinalsTwo == TEST TWO EXECUTED =======");
        assertEquals(0, urine.getFreeUrinals("1001"));
    }

    @Test
    void getFreeUrinalsThree() {
        System.out.println("====== Saurav Sarkar == getFreeUrinalsThree == TEST THREE EXECUTED =======");
        assertEquals(3, urine.getFreeUrinals("00000"));
    }

    @Test
    void getFreeUrinalsFour() {
        System.out.println("====== Saurav Sarkar == getFreeUrinalsFour == TEST FOUR EXECUTED =======");
        assertEquals(2, urine.getFreeUrinals("0000"));
    }

    @Test
    void getFreeUrinalsFive() {
        System.out.println("====== Saurav Sarkar == getFreeUrinalsFive == TEST FIVE EXECUTED =======");
        assertEquals(1, urine.getFreeUrinals("01000"));
    }

    @Test
    void getFreeUrinalsSix() {
        System.out.println("====== Saurav Sarkar == getFreeUrinalsSix == TEST SIX EXECUTED =======");
        assertEquals(-1, urine.getFreeUrinals("011"));
    }

    @Test
    void readFromFileOne() throws IOException {
        System.out.println("====== Saurav Sarkar == readFromFileOne == TEST ONE EXECUTED - Valid Case =======");
        String filePath = "src/urinal.dat";
        assertArrayEquals(new String[]{"10001", "1001", "00000", "0000", "01000", "011"}, urine.readFromFile(filePath));
    }

    @Test
    void readFromFileTwo() {
        System.out.println("====== Saurav Sarkar == readFromFileTwo == TEST TWO EXECUTED - File doesn't exist =======");
        String filePath = "urinal.dat1";
        assertThrows(FileNotFoundException.class, () -> {
            urine.readFromFile(filePath);
        });
    }

    @Test
    void readFromFileThree() throws IOException {
        System.out.println("====== Saurav Sarkar == readFromFileThree == TEST THREE EXECUTED - Empty file =======");
        String filePath = "src/urinal.dat";
        String [] inputs = urine.readFromFile(filePath);
        assertArrayEquals(inputs, urine.readFromFile(filePath));
    }

    @Test
    void readFromFileFour() {
        System.out.println("====== Saurav Sarkar == readFromFileFour == TEST FOUR EXECUTED - IOException =======");
        String filePath = "urinal";
        assertThrows(IOException.class, () -> {
            urine.readFromFile(filePath);
        });
    }

    @Test
    void writeToFileOne() {
        System.out.println("====== Saurav Sarkar == writeToFileThree == TEST ONE EXECUTED - Exception =======");
        assertThrows(Exception.class, () -> {
            urine.writeToFile(new String[]{"abc", "1001", "00000", "0000", "01000", "011"});
        });
    }

    @Test
    void writeToFileTwo() throws IOException {
        System.out.println("====== Saurav Sarkar == writeToFileFour == TEST TWO EXECUTED - Valid =======");
        // does not throw any error
        urine.writeToFile(new String[]{"10001", "1001", "00000", "0000", "01000", "011"});
    }
}
