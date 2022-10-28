import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class urinalsTest {
    private urinals urine;

    @BeforeEach
    public void setUrine() {
        urine = new urinals();
    }

    @Test
    void goodStringValid() {
        assertEquals(true, urine.goodString("====== Saurav Sarkar == TEST FIRST EXECUTED ======="));
    }

    @Test
    void goodStringInValid() {
        assertEquals(false, urine.goodString("====== Saurav Sarkar == TEST TWO EXECUTED ======="));
    }


}
