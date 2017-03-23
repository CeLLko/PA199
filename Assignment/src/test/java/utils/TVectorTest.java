package utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import engine.util.Vec3;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adam
 */
public class TVectorTest {
    
    public TVectorTest() {
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
     * Test of inverse method, of class TVector.
     */
    @Test
    public void testInverse_0args() {
        System.out.println("inverse");
        Vec3 instance = new Vec3(1,2,3);
        Vec3 expResult = new Vec3(-1,-2,-3);
        Vec3 result = instance.inverse();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of magnitude method, of class TVector.
     */
    @Test
    public void testMagnitude_0args() {
        System.out.println("magnitude");
        Vec3 instance = new Vec3(2,-4,6);
        double expResult = Math.sqrt(56);
        double result = instance.magnitude();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of length method, of class TVector.
     */
    @Test
    public void testLength() {
        System.out.println("length");
        Vec3 instance = new Vec3(2,-4,6);
        double expResult = Math.sqrt(56); 
       double result = instance.length();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of unit method, of class TVector.
     */
    @Test
    public void testUnit_0args() {
        System.out.println("unit");
        Vec3 instance = new Vec3(2,-4,6);
        Vec3 expResult = new Vec3(1/Math.sqrt(14), -Math.sqrt(2/7.0), 3/Math.sqrt(14));
        Vec3 result = instance.unit();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of normalize method, of class TVector.
     */
    @Test
    public void testNormalize_0args() {
        System.out.println("normalize");
        Vec3 instance = new Vec3(2,-4,6);
        Vec3 expResult = new Vec3(1/Math.sqrt(14), -Math.sqrt(2/7.0), 3/Math.sqrt(14));
        Vec3 result = instance.normalize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of add method, of class TVector.
     */
    @Test
    public void testAdd_TVector() {
        System.out.println("add");
        Vec3 other = new Vec3(1,2,3);
        Vec3 instance = new Vec3(9,8,7);
        Vec3 expResult = new Vec3(10,10,10);
        Vec3 result = instance.add(other);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of sub method, of class TVector.
     */
    @Test
    public void testSub_TVector() {
        System.out.println("sub");
        Vec3 other = new Vec3(3,2,1);
        Vec3 instance = new Vec3(9,8,7);
        Vec3 expResult = new Vec3(6,6,6);
        Vec3 result = instance.sub(other);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of cross method, of class TVector.
     */
    @Test
    public void testCross_TVector() {
        System.out.println("cross");
        Vec3 other = new Vec3(4,9,2);
        Vec3 instance = new Vec3(3,-3,1);
        Vec3 expResult = new Vec3(-15,-2,39);
        Vec3 result = instance.cross(other);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of dot method, of class TVector.
     */
    @Test
    public void testDot_TVector() {
        System.out.println("dot");
        Vec3 other = new Vec3(6,7,8);
        Vec3 instance = new Vec3(1,2,3);
        double expResult = 44.0;
        double result = instance.dot(other);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of inverse method, of class TVector.
     */
    @Test
    public void testInverse_TVector() {
        System.out.println("inverse");
        Vec3 vec = new Vec3(1,2,3);
        Vec3 expResult = new Vec3(-1,-2,-3);
        Vec3 result = Vec3.inverse(vec);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of magnitude method, of class TVector.
     */
    @Test
    public void testMagnitude_TVector() {
        System.out.println("magnitude");
        Vec3 vec = new Vec3(2,-4,6);
        double expResult = Math.sqrt(56);
        double result = Vec3.magnitude(vec);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of unit method, of class TVector.
     */
    @Test
    public void testUnit_TVector() {
        System.out.println("unit");
        Vec3 vec = new Vec3(2,-4,6);
        Vec3 expResult = new Vec3(1/Math.sqrt(14), -Math.sqrt(2/7.0), 3/Math.sqrt(14));
        Vec3 result = Vec3.unit(vec);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of normalize method, of class TVector.
     */
    @Test
    public void testNormalize_TVector() {
        System.out.println("normalize");
        Vec3 vec = new Vec3(2,-4,6);
        Vec3 expResult = new Vec3(1/Math.sqrt(14), -Math.sqrt(2/7.0), 3/Math.sqrt(14));
        Vec3 result = Vec3.normalize(vec);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of add method, of class TVector.
     */
    @Test
    public void testAdd_TVector_TVector() {
        System.out.println("add");
        Vec3 vecA = new Vec3(1,2,3);
        Vec3 vecB = new Vec3(9,8,7);
        Vec3 expResult = new Vec3(10,10,10);
        Vec3 result = Vec3.add(vecA, vecB);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of sub method, of class TVector.
     */
    @Test
    public void testSub_TVector_TVector() {
        System.out.println("sub");
        Vec3 vecA = new Vec3(9,8,7);
        Vec3 vecB = new Vec3(3,2,1);
        Vec3 expResult = new Vec3(6,6,6);
        Vec3 result = Vec3.sub(vecA, vecB);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of cross method, of class TVector.
     */
    @Test
    public void testCross_TVector_TVector() {
        System.out.println("cross");
        Vec3 vecA = new Vec3(3,-3,1);
        Vec3 vecB = new Vec3(4,9,2);
        Vec3 expResult = new Vec3(-15,-2,39);
        Vec3 result = Vec3.cross(vecA, vecB);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of dot method, of class TVector.
     */
    @Test
    public void testDot_TVector_TVector() {
        System.out.println("dot");
        Vec3 vecA = new Vec3(6,7,8);
        Vec3 vecB = new Vec3(1,2,3);
        double expResult = 44.0;
        double result = Vec3.dot(vecA, vecB);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
