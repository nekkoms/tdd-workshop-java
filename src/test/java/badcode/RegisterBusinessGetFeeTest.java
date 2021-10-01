package badcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RegisterBusinessGetFeeTest {
    @ParameterizedTest
    @CsvSource({
            "0,500",
            "1,500",
            "2,250",
            "3,250",
            "4,100",
            "5,100",
            "8,50",
            "9,50",
            "10,0",
            "20,0",
    })
    public void getFee(int exp, int fee) {
        RegisterBusiness business = new RegisterBusiness();
        int actualFee = business.getFee(exp);
        assertEquals(fee, actualFee);
    }

    @ParameterizedTest
    @CsvSource({
            "0",
            "1",
            "2",
            "3",
            "4",
            "5",
            "8",
            "9",
            "10",
            "20",
    })
    public void case07WithCsvSource(int exp){
        RegisterBusiness rb = new RegisterBusiness();
        Speaker s = new Speaker();
        s.setFirstName("first");
        s.setLastName("last");
        s.setEmail("exxx@gmail.com");
        s.setExp(exp);
        int id = rb.register(new SpeakerRepository() {
            @Override
            public Integer saveSpeaker(Speaker speaker) {
                return 100;
            }
        }, s);

        assertEquals(100, id);
    }

}