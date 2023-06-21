package bankApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankTest {
    Bank joshNickBank;

    @BeforeEach
    void setUp() { joshNickBank = new Bank();}

    @Test public void objectOfBankExist() {assertNotNull(joshNickBank);}
    @Test public void testingIf_iCan_createAn_accountNumber(){
        joshNickBank.openAccount("john","femi","1111");
        assertEquals(1, joshNickBank.getSizeOfAccounts());
    }
    @Test public void bankCan_createMultipleAccounts(){
        joshNickBank.openAccount("josh","tope","1111");
        joshNickBank.openAccount("josh","tope","1111");
        joshNickBank.openAccount("josh","tope","1111");
        joshNickBank.openAccount("josh","tope","1111");
        assertEquals(4, joshNickBank.getSizeOfAccounts());
    }
    @Test public void bankCanDepositToAccountAndAlsoCheckBalance(){
        joshNickBank.openAccount("josh","tope","1111");
        assertEquals(1, joshNickBank.getSizeOfAccounts());
        joshNickBank.depositToAccount("1122330", 500);
        assertEquals(500, joshNickBank.checkAccountBalance("1111", "1122330"));
    }
    @Test public void bankCanDepositAgain(){
        joshNickBank.openAccount("josh","tope","1111");
        assertEquals(1, joshNickBank.getSizeOfAccounts());
        joshNickBank.depositToAccount("1122330", 5000);
        assertEquals(5000, joshNickBank.checkAccountBalance("1111", "1122330"));
    }

    @Test public void iCanDoInterBank_transfer(){
        joshNickBank.openAccount("josh","tope","1111");
        joshNickBank.openAccount("josh","tope","2222");
        assertEquals(2, joshNickBank.getSizeOfAccounts());
        joshNickBank.depositToAccount("1122330", 5000);
        joshNickBank.intraBankTransfer(1000,"1122330","1122331","1111" );
        assertEquals(4_000, joshNickBank.checkAccountBalance("1111", "1122330"));
        assertEquals(1000, joshNickBank.checkAccountBalance("2222", "1122331"));
    }

    @Test public void iWantToBe_ableTo_withdraw(){
        joshNickBank.openAccount("josh","tope","3333");
        joshNickBank.depositToAccount("1122330", 20_000);
        joshNickBank.withdraw("1122330", "3333", 10_000);
        assertEquals(10_000,joshNickBank.checkAccountBalance("3333","1122330"));

    }

    @Test public void testIf_iCan_transferMore_thanIHave_inMyAccount(){
        joshNickBank.openAccount("josh","tope","3333");
        joshNickBank.openAccount("josh","tope","4444");
        joshNickBank.depositToAccount("1122330", 100_000);
        joshNickBank.intraBankTransfer(900_000,"1122330", "1122331","3333");
        assertEquals(100_000, joshNickBank.checkAccountBalance("3333", "1122330"));
        assertEquals(0, joshNickBank.checkAccountBalance("4444", "1122331"));

    }

    @Test public void testIf_iCanTransferTo_multipleUsers(){
        joshNickBank.openAccount("josh","tope","1111");
        joshNickBank.openAccount("josh","tope","2222");
        joshNickBank.openAccount("josh","tope","3333");
        joshNickBank.openAccount("josh","tope","4444");
        joshNickBank.depositToAccount("1122330",50_000);
        joshNickBank.intraBankTransfer(10_000,"1122330","1122331","1111");
        joshNickBank.intraBankTransfer(10_000,"1122330","1122332","1111");
        joshNickBank.intraBankTransfer(10_000,"1122330","1122333","1111");
        assertEquals(20_000, joshNickBank.checkAccountBalance("1111","1122330"));
        assertEquals(10_000, joshNickBank.checkAccountBalance("2222","1122331"));
        assertEquals(10_000, joshNickBank.checkAccountBalance("3333","1122332"));
        assertEquals(10_000, joshNickBank.checkAccountBalance("4444","1122333"));
    }
    @Test public void testingThatI_cantWithdraw_moreThan_iHave_inMy_account(){
        joshNickBank.openAccount("josh","tope","1111");
        joshNickBank.depositToAccount("1122330",10_000);
        joshNickBank.withdraw("1122330", "1111", 50_000);
        assertEquals(10_000,joshNickBank.checkAccountBalance("1111", "1122330"));
        System.out.println(joshNickBank.checkAccountBalance("1111", "1122330"));

    }

    @Test public void testingIf_iCanDeposit_aNegativeAmount(){
        joshNickBank.openAccount("josh","tope","1111");
        joshNickBank.depositToAccount("1122330",-2000);
        assertEquals(0,joshNickBank.checkAccountBalance("1111", "1122330"));
        System.out.println(joshNickBank.checkAccountBalance("1111", "1122330"));
    }

    @Test public void testingIf_iCanWithdraw_aNegativeAmount(){
        joshNickBank.openAccount("josh","tope","1111");
        joshNickBank.depositToAccount("1122330",20_000);
        joshNickBank.withdraw("1122330","1111", -10_000);
        assertEquals(20000,joshNickBank.checkAccountBalance("1111", "1122330"));
        System.out.println(joshNickBank.checkAccountBalance("1111", "1122330"));
    }





}
