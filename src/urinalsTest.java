import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
