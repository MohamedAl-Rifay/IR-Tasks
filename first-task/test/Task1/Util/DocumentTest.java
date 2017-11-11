/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task1.Util;

import java.util.Arrays;
import java.util.HashSet;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mohamed
 */
public class DocumentTest {

    Document instance;

    @Before
    public void setUp() {
        instance = new Document("title", "Hello, he is fine and cold.");
    }

    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of getTitle method, of class Document.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        String expResult = "title";
        String result = instance.getTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getDoc method, of class Document.
     */
    @Test
    public void testGetDoc() {
        System.out.println("getDoc");
        String expResult = "Hello, he is fine and cold.";
        String result = instance.getDoc();
        assertEquals(expResult, result);
    }

    /**
     * Test of getWords method, of class Document.
     */
    @Test
    public void testGetWords() {
        System.out.println("getWords");
        HashSet<String> expResult = new HashSet<>(Arrays.asList(new String[] {"fine", "hello", "cold"}));
        HashSet<String> result = instance.getWords();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Document.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "title";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

}
