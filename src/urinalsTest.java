import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class urinalsTest {
    private urinals urine;

    @BeforeEach
    public void setUrine() {
        urine = new urinals();
    }

//    @Test
//    void goodStringValid() {
//        assertEquals(true, urine.goodString("====== Saurav Sarkar == TEST FIRST EXECUTED ======="));
//    }
//
//    @Test
//    void goodStringInValid() {
//        assertEquals(false, urine.goodString("====== Saurav Sarkar == TEST TWO EXECUTED ======="));
//    }

    @Test
    void getFreeUrinalsOne() {
        System.out.println("====== Saurav Sarkar == TEST ONE EXECUTED =======");
        assertEquals(1, urine.getFreeUrinals("10001"));
    }

    @Test
    void getFreeUrinalsTwo() {
        System.out.println("====== Saurav Sarkar == TEST TWO EXECUTED =======");
        assertEquals(0, urine.getFreeUrinals("1001"));
    }

    @Test
    void getFreeUrinalsThree() {
        System.out.println("====== Saurav Sarkar == TEST THREE EXECUTED =======");
        assertEquals(3, urine.getFreeUrinals("00000"));
    }

    @Test
    void getFreeUrinalsFour() {
        System.out.println("====== Saurav Sarkar == TEST FOUR EXECUTED =======");
        assertEquals(2, urine.getFreeUrinals("0000"));
    }

    @Test
    void getFreeUrinalsFive() {
        System.out.println("====== Saurav Sarkar == TEST FIVE EXECUTED =======");
        assertEquals(1, urine.getFreeUrinals("01000"));
    }

    @Test
    void getFreeUrinalsSix() {
        System.out.println("====== Saurav Sarkar == TEST SIX EXECUTED =======");
        assertEquals(-1, urine.getFreeUrinals("011"));
    }

    @Test
    void readFromFileOne() {
        System.out.println("====== Saurav Sarkar == TEST ONE EXECUTED - Valid Case =======");
        String filePath = "urinal.dat";
        assertEquals(new String[]{"10001", "1001", "00000", "0000", "01000", "011"}, urine.readFromFile(filePath));
    }

    @Test
    void readFromFileTwo() {
        System.out.println("====== Saurav Sarkar == TEST TWO EXECUTED - File doesn't exist =======");
        String filePath = "urinal.dat1";
        assertThrows(FileNotFoundException.class, () -> {
            urine.readFromFile(filePath);
        });
    }

    @Test
    void readFromFileThree() {
        System.out.println("====== Saurav Sarkar == TEST THREE EXECUTED - Empty file =======");
        String filePath = "urinal.dat";
        assertEquals(new String[]{}, urine.readFromFile(filePath));
    }

    @Test
    void readFromFileFour() {
        System.out.println("====== Saurav Sarkar == TEST FOUR EXECUTED - IOException =======");
        String filePath = "urinal";
        assertThrows(IOException.class, () -> {
            urine.readFromFile(filePath);
        });
    }
}
