import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyRangeFailureTest {

    @Test
    @DisplayName("ขึ้นต้นด้วย [,( , input = 1,5]")
    public void case01() {
        try {
            MyRange range = new MyRange("1,5]");
            range.validate();
            fail("Incorrect");
        } catch (InputInvalidException e) {
            if(!"Input error".equals(e.getMessage())) {
                fail("Error message Incorrect " + e.getMessage());
            }
        }
    }

    @Test
    @DisplayName("ขึ้นต้นด้วย [,( , input = 1,5] version junit5")
    public void case02() {
        MyRange range = new MyRange("1,5]");
        Exception e = assertThrows(InputInvalidException.class, range::validate);
        assertEquals("Input error", e.getMessage() );
    }

}
