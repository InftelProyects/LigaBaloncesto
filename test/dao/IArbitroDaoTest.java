/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Arbitro;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author josep
 */
public class IArbitroDaoTest {
    
    public IArbitroDaoTest() {
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
     * Test of buscarPorDni method, of class IArbitroDao.
     */
    @Test
    public void testBuscarPorDni() {
        System.out.println("buscarPorDni");
        String dni = "";
        IArbitroDao instance = new IArbitroDaoImpl();
        Arbitro expResult = null;
        Arbitro result = instance.buscarPorDni(dni);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of buscarTodos method, of class IArbitroDao.
     */
    /*@Test
    public void testBuscarTodos() {
        System.out.println("buscarTodos");
        IArbitroDao instance = new IArbitroDaoImpl();
        List<Arbitro> expResult = instance.buscarTodos();
        List<Arbitro> result = instance.buscarTodos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }*/

    /**
     * Test of insertarArbitro method, of class IArbitroDao.
     */
    @Test
    public void testInsertarArbitro() {
        System.out.println("insertarArbitro");
        Arbitro a = null;
        IArbitroDao instance = new IArbitroDaoImpl();
        boolean expResult = false;
        boolean result = instance.insertarArbitro(a);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of eliminarPorDniArbitro method, of class IArbitroDao.
     */
    @Test
    public void testEliminarPorDniArbitro() {
        System.out.println("eliminarPorDniArbitro");
        String dni = "";
        IArbitroDao instance = new IArbitroDaoImpl();
        boolean expResult = false;
        boolean result = instance.eliminarPorDniArbitro(dni);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    /**
     * Test of actualizarArbitro method, of class IArbitroDao.
     */
    @Test
    public void testActualizarArbitro() {
        System.out.println("actualizarArbitro");
        Arbitro a = null;
        IArbitroDao instance = new IArbitroDaoImpl();
        boolean expResult = false;
        boolean result = instance.actualizarArbitro(a);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    public class IArbitroDaoImpl implements IArbitroDao {

        /**
         *
         * @param dni
         * @return
         */
        @Override
        public Arbitro buscarPorDni(String dni) {
            return null;
        }

        /**
         *
         * @return
         */
        @Override
        public List<Arbitro> buscarTodos() {
            return null;
        }

        /**
         *
         * @param a
         * @return
         */
        @Override
        public boolean insertarArbitro(Arbitro a) {
            return false;
        }

        /**
         *
         * @param dni
         * @return
         */
        @Override
        public boolean eliminarPorDniArbitro(String dni) {
            return false;
        }

        /**
         *
         * @param a
         * @return
         */
        @Override
        public boolean actualizarArbitro(Arbitro a) {
            return false;
        }
    }
    
}
