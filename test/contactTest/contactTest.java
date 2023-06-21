package contactTest;

import contact.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class contactTest {

    Contact nickContact;

    @BeforeEach

    public void startWith(){
        nickContact = new Contact("joseph", "damilola", "08137729210");
    }

    @Test public void testingThatThe_contact_exist(){
        assertNotNull(nickContact);
    }

    @Test public void testingThatWe_create_contact(){
        nickContact.createContact("mrSutun","temitope","08137729210");

    }


}
