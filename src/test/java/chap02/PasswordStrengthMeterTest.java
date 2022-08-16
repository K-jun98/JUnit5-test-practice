package chap02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordStrengthMeterTest {
    private PasswordStrengthMeter meter = new PasswordStrengthMeter();

    private void assertStrength(String password,Stage stage){
        Stage result = meter.meter(password);
        assertEquals(result,stage);
    }

    @Test
    @DisplayName("모든 조건 충족")
    void meetsAllCriteria_Then_Strong() {
        assertStrength("abc1!Add",Stage.HARD);
    }

    @Test
    @DisplayName("문자열 길이미달")
    void meetsOtherCriteria_except_for_length_Then_Normal() {
        assertStrength("ab12!@A",Stage.NORMAL);
    }

    @Test
    @DisplayName("숫자없는 테스트")
    void meetsOtherCriteria_except_for_number_Then_Normal() {
        assertStrength("ab!@ABqwer",Stage.NORMAL);
    }

    @Test
    @DisplayName("NULL")
    void nullInput_Then_Invalid(){
        assertStrength(null,Stage.INVALID);
    }

    @Test
    @DisplayName("빈문자열")
    void emptyInput_Then_Invalid(){
        assertStrength("",Stage.INVALID);
    }

    @Test
    @DisplayName("대문자 미포함 문자열")
    void meetsOtherCriteria_except_for_Uppercase_Then_Normal(){
        assertStrength("ab12!@df",Stage.NORMAL);
    }

    @Test
    @DisplayName("8글자 이상인 조건만 충족하는 경우")
    void meetsOnlyLengthCriteria_Then_Weak(){
        assertStrength("abcdefghi",Stage.EASY);
    }

    @Test
    @DisplayName("숫자로만 구성된 경우")
    void meetsOnlyNumCriteria_Then_Weak(){
        assertStrength("12345",Stage.EASY);
    }

    @Test
    @DisplayName("대문자로만 구성된 경우")
    void meetsOnlyUpperCriteria_Then_Weak(){
        assertStrength("ABCDE",Stage.EASY);
    }
}
