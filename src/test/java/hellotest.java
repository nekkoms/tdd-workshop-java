import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class hellotest {

    @Test
    @DisplayName("ทดสอบด้วย J5")
    public void  case01(){
    Hello hello = new Hello();
    String result =  hello.say("Nekko");
    Assertions.assertEquals(result, "Hello Nekko");
    }
}
