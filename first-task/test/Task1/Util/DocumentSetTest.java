/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task1.Util;

import java.util.HashMap;
import java.util.LinkedHashSet;
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
public class DocumentSetTest {
    
    public DocumentSetTest() {
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
     * Test of getQueryPostingList method, of class DocumentSet.
     */
    @Test
    public void testGetQueryPostingList() {
        System.out.println("getQueryPostingList");
        DocumentSet instance = new DocumentSet();
        HashMap<String, LinkedHashSet<Document>> expResult = null;
        HashMap<String, LinkedHashSet<Document>> result = instance.getQueryPostingList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addDocument method, of class DocumentSet.
     */
    @Test
    public void testAddDocument() {
        System.out.println("addDocument");
        Document d = null;
        DocumentSet instance = new DocumentSet();
        instance.addDocument(d);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ExcuteQuery method, of class DocumentSet.
     */
    @Test
    public void testExcuteQuery() {
        System.out.println("ExcuteQuery");
        String query = "";
        DocumentSet instance = new DocumentSet();
        LinkedHashSet<Document> expResult = null;
        LinkedHashSet<Document> result = instance.ExcuteQuery(query);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
