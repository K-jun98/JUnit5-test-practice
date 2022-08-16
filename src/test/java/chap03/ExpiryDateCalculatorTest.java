package chap03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class ExpiryDateCalculatorTest {


    private void assertExpiryDate(PayData payData,LocalDate expectedExpiryDate ){
        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate realExpiryDate = cal.calculateExpiryDate(payData);
        Assertions.assertEquals(realExpiryDate,expectedExpiryDate);

    }

    @Test
    @DisplayName("만원 납부")
    void 만원_납부하면_한달_기간_부여(){
    assertExpiryDate(PayData.builder().billingDate(LocalDate.of(2019,3,1))
            .payAmount(10_000)
            .build(),
            LocalDate.of(2019,4,1) );

    }


    @Test
    void 납부일과_한달_뒤_일자가_같지_않음(){
        assertExpiryDate(PayData.builder()
                .billingDate(LocalDate.of(2019,1,31))
                .payAmount(10_000).build(),
                LocalDate.of(2019,2,28) );

        assertExpiryDate(PayData.builder()
                .billingDate(LocalDate.of(2019,5,31))
                .payAmount(10_000).build(),
                LocalDate.of(2019,6,30) );

        assertExpiryDate(PayData.builder()
                .billingDate(LocalDate.of(2020,1,31))
                .payAmount(10_000).build(),
                LocalDate.of(2020,2,29) );
    }

    @Test
    void 첫_납부일과_만료일_날자가_다를때_만원_납부(){
        PayData payData = PayData.builder().firstBillingDate(LocalDate.of(2019,1,31))
                .billingDate(LocalDate.of(2019,2,28))
                .payAmount(10_000)
                .build();

        assertExpiryDate(payData,LocalDate.of(2019,3,31));
    }


}
