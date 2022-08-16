package chap05;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class chap05 {
    @Test
    @DisplayName("assertAll실패테스트")
    void assertAllTest() throws Exception {
        assertAll(
                ()->assertEquals(3,5/2),
                ()->assertEquals(4,2*2),
                ()->assertEquals(6,11/2)
        );

    }
}
