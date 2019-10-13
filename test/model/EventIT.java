/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author diegoa.torres
 */
public class EventIT {
    
    public EventIT() {
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
     * Test of getRoot method, of class Event.
     */
    @org.junit.Test
    public void testGetRoot() {
        System.out.println("getRoot");
        Event instance = new Event();
        Viewer expResult = null;
        Viewer result = instance.getRoot();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRoot method, of class Event.
     */
    @org.junit.Test
    public void testSetRoot() {
        System.out.println("setRoot");
        Viewer root = null;
        Event instance = new Event();
        instance.setRoot(root);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirst method, of class Event.
     */
    @org.junit.Test
    public void testGetFirst() {
        System.out.println("getFirst");
        Event instance = new Event();
        Competitor expResult = null;
        Competitor result = instance.getFirst();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFirst method, of class Event.
     */
    @org.junit.Test
    public void testSetFirst() {
        System.out.println("setFirst");
        Competitor first = null;
        Event instance = new Event();
        instance.setFirst(first);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addViewer method, of class Event.
     */
    @org.junit.Test
    public void testAddViewer() {
        System.out.println("addViewer");
        Viewer v = null;
        Viewer roott = null;
        Event instance = new Event();
        instance.addViewer(v, roott);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addViewrFinal method, of class Event.
     */
    @org.junit.Test
    public void testAddViewrFinal() {
        System.out.println("addViewrFinal");
        Viewer v = null;
        Event instance = new Event();
        instance.addViewrFinal(v);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadTextFile method, of class Event.
     */
    @org.junit.Test
    public void testLoadTextFile() throws Exception {
        System.out.println("loadTextFile");
        String csv = "";
        Event instance = new Event();
        instance.loadTextFile(csv);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchViewerNormal method, of class Event.
     */
    @org.junit.Test
    public void testSearchViewerNormal() throws Exception {
        System.out.println("searchViewerNormal");
        String id = "";
        Viewer roott = null;
        Event instance = new Event();
        Viewer expResult = null;
        Viewer result = instance.searchViewerNormal(id, roott);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchVierwerInOrden method, of class Event.
     */
    @org.junit.Test
    public void testSearchVierwerInOrden() {
        System.out.println("searchVierwerInOrden");
        String id = "";
        Viewer roott = null;
        Event instance = new Event();
        Viewer expResult = null;
        Viewer result = instance.searchVierwerInOrden(id, roott);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delateViewer method, of class Event.
     */
    @org.junit.Test
    public void testDelateViewer() throws Exception {
        System.out.println("delateViewer");
        String id = "";
        Viewer raiz = null;
        Event instance = new Event();
        instance.delateViewer(id, raiz);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCompetitor method, of class Event.
     */
    @org.junit.Test
    public void testAddCompetitor() throws Exception {
        System.out.println("addCompetitor");
        Competitor c = null;
        Competitor nodo = null;
        Event instance = new Event();
        instance.addCompetitor(c, nodo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
