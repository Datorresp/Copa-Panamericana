package test;

import static org.junit.jupiter.api.Assertions.*;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EventTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	
    public static void setUpClass() {
    }
    

    public static void tearDownClass() {
    }

    public void tearDown() {
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

    }

}
