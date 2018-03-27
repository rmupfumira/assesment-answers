package test.russel.com;

import org.junit.Assert;
import org.junit.Test;

;

/**
 * Below are two methods being used in tests.
 *
 * initObjA() illustrate a certain property/behaviour of Java.
 *
 * initObjB() has a poor coding style.
 */
public class InterviewQuestion_Init_Test {

    /**
     * BasicObject class contains a single field (attr) which holds a char value.
     */
    class BasicObject {
        char attr;
    }

    private void initObjA(BasicObject obj) {
        obj = new BasicObject();
        obj.attr = 'A';
    }

    private BasicObject initObjB(BasicObject obj) {
        obj = new BasicObject();
        obj.attr = 'B';
        return obj;
    }


    private BasicObject initObjC() {
        BasicObject obj = new BasicObject();
        obj.attr = 'C';
        return obj;
    }

    /**
     * Q1. Why does the below test throw an Exception? - Because Java passes method parameters by value hence the reference obj inside the method is a "new copy" and hence the test throws an NPE
     * because the reference outside the method has been assigned to null
     *
     * Q2. What property of the language does this highlight? - It highlights the fact that Java passes parameters by value
     */
    @Test
    public void object_init_test_A() {
        BasicObject o = null;
        initObjA(o);
        Assert.assertEquals('A', o.attr);
    }

    /**
     * Q3. What is undesirable about the way initObjB() is written/utilized? - The passing of parameter o to the initObjB method is redundant as the method  will create and return a new reference
     */
    @Test
    public void object_init_test_B() {
        BasicObject o = null;
        o = initObjB(o);
        Assert.assertEquals('B', o.attr);
    }

    /**
     * Q4. Please right a better version of initObjB() (initObjC() perhaps) to initialize a BasicObject.
     *
     * The test should pass with the commented-out Assert statement.
     */
    @Test
    public void object_init_test_C() {
        BasicObject o = null;
        o = initObjC();
        Assert.assertEquals('C', o.attr);
    }
}
