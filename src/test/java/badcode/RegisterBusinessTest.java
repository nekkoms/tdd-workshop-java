package badcode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class RegisterBusinessTest {
    @Test
    public void case01(){
        RegisterBusiness rb = new RegisterBusiness();
        Exception ec = assertThrows(ArgumentNullException.class, () -> {
            rb.register(null , new Speaker());
        });
        assertEquals("First name is required.",ec.getMessage());
    }
    @Test
    public void case01a(){
        RegisterBusiness rb = new RegisterBusiness();
        Exception ec = assertThrows(ArgumentNullException.class, () -> {
            Speaker s = new Speaker();
            s.setFirstName("");
            rb.register(null , new Speaker());
        });
        assertEquals("First name is required.",ec.getMessage());
    }
    @Test
    public void case02(){
        RegisterBusiness rb = new RegisterBusiness();
        Exception ec = assertThrows(ArgumentNullException.class, () -> {
            Speaker s = new Speaker();
            s.setFirstName("first");
            rb.register(null , s);
        });
        assertEquals("Last name is required.",ec.getMessage());
    }
    @Test
    public void case02a(){
        RegisterBusiness rb = new RegisterBusiness();
        Exception ec = assertThrows(ArgumentNullException.class, () -> {
            Speaker s = new Speaker();
            s.setFirstName("first");
            s.setLastName("");
            rb.register(null , s);
        });
        assertEquals("Last name is required.",ec.getMessage());
    }
    @Test
    public void case03(){
        RegisterBusiness rb = new RegisterBusiness();
        Exception ec = assertThrows(ArgumentNullException.class, () -> {
            Speaker s = new Speaker();
            s.setFirstName("first");
            s.setLastName("last");
            rb.register(null , s);
        });
        assertEquals("Email is required.",ec.getMessage());
    }
    @Test
    public void case03a(){
        RegisterBusiness rb = new RegisterBusiness();
        Exception ec = assertThrows(ArgumentNullException.class, () -> {
            Speaker s = new Speaker();
            s.setFirstName("first");
            s.setLastName("last");
            s.setEmail("");
            rb.register(null , s);
        });
        assertEquals("Email is required.",ec.getMessage());
    }

    @Test
    public void case04(){
        RegisterBusiness rb = new RegisterBusiness();
        Exception ec = assertThrows(DomainEmailInvalidException.class, () -> {
            Speaker s = new Speaker();
            s.setFirstName("first");
            s.setLastName("last");
            s.setEmail("exxx");
            rb.register(null , s);
        });
        assertEquals(null,ec.getMessage());
    }

    @Test
    public void case05(){
        RegisterBusiness rb = new RegisterBusiness();
        Exception ec = assertThrows(SpeakerDoesntMeetRequirementsException.class, () -> {
            Speaker s = new Speaker();
            s.setFirstName("first");
            s.setLastName("last");
            s.setEmail("exxx@mail.com");
            rb.register(null , s);
        });
        assertEquals("Speaker doesn't meet our standard rules.",ec.getMessage());
    }

    @Test
    public void case06(){
        RegisterBusiness rb = new RegisterBusiness();
        Exception ec = assertThrows(SaveSpeakerException.class, () -> {
            Speaker s = new Speaker();
            s.setFirstName("first");
            s.setLastName("last");
            s.setEmail("exxx@gmail.com");
            rb.register(null , s);
        });
        assertEquals("Can't save a speaker.",ec.getMessage());
    }

    @Test
    public void case07(){
        RegisterBusiness rb = new RegisterBusiness();
        Speaker s = new Speaker();
        s.setFirstName("first");
        s.setLastName("last");
        s.setEmail("exxx@gmail.com");
        s.setExp(1);
        int id = rb.register(new SpeakerRepository() {
            @Override
            public Integer saveSpeaker(Speaker speaker) {
                return 100;
            }
        }, s);

        assertEquals(100, id);
    }
    @Test
    public void case07a(){
        RegisterBusiness rb = new RegisterBusiness();
        Speaker s = new Speaker();
        s.setFirstName("first");
        s.setLastName("last");
        s.setEmail("exxx@gmail.com");
        s.setExp(3);
        int id = rb.register(new SpeakerRepository() {
            @Override
            public Integer saveSpeaker(Speaker speaker) {
                return 100;
            }
        }, s);

        assertEquals(100, id);
    }
    @Test
    public void case07b(){
        RegisterBusiness rb = new RegisterBusiness();
        Speaker s = new Speaker();
        s.setFirstName("first");
        s.setLastName("last");
        s.setEmail("exxx@gmail.com");
        s.setExp(5);
        int id = rb.register(new SpeakerRepository() {
            @Override
            public Integer saveSpeaker(Speaker speaker) {
                return 100;
            }
        }, s);

        assertEquals(100, id);
    }
    @Test
    public void case07c(){
        RegisterBusiness rb = new RegisterBusiness();
        Speaker s = new Speaker();
        s.setFirstName("first");
        s.setLastName("last");
        s.setEmail("exxx@gmail.com");
        s.setExp(7);
        int id = rb.register(new SpeakerRepository() {
            @Override
            public Integer saveSpeaker(Speaker speaker) {
                return 100;
            }
        }, s);

        assertEquals(100, id);
    }

}