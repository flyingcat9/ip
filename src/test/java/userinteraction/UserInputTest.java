package userinteraction;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UserInputTest {

    @Test
    public void testOne() {
        UserInput u = new UserInput();
        assertEquals(false, u.exitingTheLoop("HIII"));
    }

    @Test
    public void testTwo() {
        UserInput u = new UserInput();
        assertEquals(true, u.exitingTheLoop(""));
    }

    @Test
    public void testThree() {
        UserInput u = new UserInput();
        assertEquals(true, u.exitingTheLoop("bye"));
    }

    @Test
    public void testFour() {
        UserInput u = new UserInput();
        assertEquals(false, u.exitingTheLoop("HII"));
    }

    @Test
    public void testFive() {
        UserInput u = new UserInput();
        assertEquals(true, u.exitingTheLoop(null));
    }

}
