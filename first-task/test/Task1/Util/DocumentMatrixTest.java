package Task1.Util;

import java.util.ArrayList;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mohamed
 */
public class DocumentMatrixTest {
    
    public DocumentMatrixTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addDocument method, of class DocumentMatrix.
     */
    @Test
    public void testAddDocument() {
        System.out.println("addDocument");
        Document d = null;
        DocumentMatrix instance = new DocumentMatrix();
        instance.addDocument(d);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMatrix method, of class DocumentMatrix.
     */
    @Test
    public void testGetMatrix() {
        System.out.println("getMatrix");
        DocumentMatrix instance = new DocumentMatrix();
        HashMap<String, ArrayList<Boolean>> expResult = null;
        HashMap<String, ArrayList<Boolean>> result = instance.getMatrix();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBooleanResult method, of class DocumentMatrix.
     */
    @Test
    public void testGetBooleanResult() {
        System.out.println("getBooleanResult");
        DocumentMatrix instance = new DocumentMatrix();
        ArrayList<Boolean> expResult = null;
        ArrayList<Boolean> result = instance.getBooleanResult();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ExcuteQuery method, of class DocumentMatrix.
     */
    @Test
    public void testExcuteQuery() {
        System.out.println("ExcuteQuery");
        String query = "";
        DocumentMatrix instance = new DocumentMatrix();
        ArrayList<Document> expResult = null;
        ArrayList<Document> result = instance.ExcuteQuery(query);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
