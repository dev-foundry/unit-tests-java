package pl.devfoundry.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountTest {


    @Test 
    public void myFirstTest() {

        //given
        Account newAccount = new Account();

        //then
        assertFalse(newAccount.isActive(), "Newly created account is not activated");
    }

    @Test
    public void mySecondTest() {

        //given
        Account newAccount = new Account();

        //when
        newAccount.activate();

        //then
        assertTrue(newAccount.isActive(), "'active' is set to true on Activated account");

    }
}