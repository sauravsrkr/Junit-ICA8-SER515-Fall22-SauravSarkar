
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class urinalsTest {
    private final urinals urine = new urinals();

    @Test
    void goodString() {
        assertEquals(2, "====== Mike Findler == TEST TWO EXECUTED =======");
    }

}
