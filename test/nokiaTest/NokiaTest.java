package nokiaTest;

import nokia.Nokia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NokiaTest {

    Nokia tope;

    @BeforeEach
    void setUp() { tope = new Nokia();}

    @Test
    public void objectNokiaExit(){
        assertNotNull(tope);
    }

    @Test public void iCan_createPhoneBook_functions(){
        tope.phoneBook();
        assertTrue(true);



    }


}
