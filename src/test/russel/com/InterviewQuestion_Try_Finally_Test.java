package test.russel.com;
import org.junit.Assert;
import org.junit.Test;

;

/**
 * Example of try-finally usage.
 */
public class InterviewQuestion_Try_Finally_Test {

    private String message() {
        try {
            return "Hi";
        } finally {
            return "Bye";
        }
    }

    /**
     * Q1. Is there a potential race condition within message()?
     * Not at all.Since the finally block is always guaranteed to execute unless you call System.exit(0),it will override the return value in the catch block
     *
     * Q2. Why does this test fail?
     * the method will return "Bye" because it the return in the finally block overrides that of the catch block
     */
    @Test
    public void try_finally_test() {
        final String msg = message();
        Assert.assertEquals("Hi", msg);
    }
}
