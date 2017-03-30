package utils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import util.Mat3;
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
public class TMatrixTest {
    
    public TMatrixTest() {
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
     * Test of add method, of class TMatrix.
     */
    @Test
    public void testAdd_TMatrix() {
        System.out.println("add");
        Mat3 other = new Mat3(9,8,7,6,5,4,3,2,1);
        Mat3 instance = new Mat3(1,2,3,4,5,6,7,8,9);
        Mat3 expResult = new Mat3(10,10,10,10,10,10,10,10,10);
        Mat3 result = instance.add(other);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of sub method, of class TMatrix.
     */
    @Test
    public void testSub_TMatrix() {
        System.out.println("sub");
        Mat3 other = new Mat3(9,8,7,6,5,4,3,2,1);
        Mat3 instance = new Mat3(1,2,3,4,5,6,7,8,9);
        Mat3 expResult = new Mat3(-8,-6,-4,-2,0,2,4,6,8);
        Mat3 result = instance.sub(other);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of mul method, of class TMatrix.
     */
    @Test
    public void testMul_TMatrix() {
        System.out.println("mul");
        Mat3 other = new Mat3(9,8,7,6,5,4,3,2,1);
        Mat3 instance = new Mat3(1,2,3,4,5,6,7,8,9);
        Mat3 expResult = new Mat3(30,24,18,84,69,54,138,114,90);
        Mat3 result = instance.mul(other);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of transpone method, of class TMatrix.
     */
    @Test
    public void testTranspone() {
        System.out.println("transpone");
        Mat3 instance = new Mat3(1,2,3,0,1,4,5,6,0);
        Mat3 expResult = new Mat3(1,0,5,2,1,6,3,4,0);
        Mat3 result = instance.transpone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of inverse method, of class TMatrix.
     */
    @Test
    public void testInverse() {
        System.out.println("inverse");
        Mat3 instance = new Mat3(1,2,3,0,1,4,5,6,0);
        Mat3 expResult = new Mat3(-24,18,5,20,-15,-4,-5,4,1);
        Mat3 result = instance.inverse();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of det method, of class TMatrix.
     */
    @Test
    public void testDet() {
        System.out.println("det");
        Mat3 instance = new Mat3(1,2,3,0,1,4,5,6,0);
        double expResult = 1.0;
        double result = instance.det();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of add method, of class TMatrix.
     */
    @Test
    public void testAdd_TMatrix_TMatrix() {
        System.out.println("add");
        Mat3 mat1 = new Mat3(9,8,7,6,5,4,3,2,1);
        Mat3 mat2 = new Mat3(1,2,3,4,5,6,7,8,9);
        Mat3 expResult = new Mat3(10,10,10,10,10,10,10,10,10);
        Mat3 result = Mat3.add(mat1, mat2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of sub method, of class TMatrix.
     */
    @Test
    public void testSub_TMatrix_TMatrix() {
        System.out.println("sub");
        Mat3 mat1 = new Mat3(9,8,7,6,5,4,3,2,1);
        Mat3 mat2 = new Mat3(1,2,3,4,5,6,7,8,9);
        Mat3 expResult = new Mat3(8,6,4,2,0,-2,-4,-6,-8);
        Mat3 result = Mat3.sub(mat1, mat2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of mul method, of class TMatrix.
     */
    @Test
    public void testMul_TMatrix_TMatrix() {
        System.out.println("mul");
        Mat3 mat1 = new Mat3(1,2,3,4,5,6,7,8,9);
        Mat3 mat2 = new Mat3(9,8,7,6,5,4,3,2,1);
        Mat3 expResult = new Mat3(30,24,18,84,69,54,138,114,90);
        Mat3 result = Mat3.mul(mat1, mat2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of transpone method, of class TMatrix.
     */
    @Test
    public void testTranspone_TMatrix() {
        System.out.println("transpone");
        Mat3 mat = new Mat3(1,2,3,0,1,4,5,6,0);
        Mat3 expResult = new Mat3(1,0,5,2,1,6,3,4,0);
        Mat3 result = Mat3.transpone(mat);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of inverse method, of class TMatrix.
     */
    @Test
    public void testInverse_TMatrix() {
        System.out.println("inverse");
        Mat3 mat = new Mat3(1,2,3,0,1,4,5,6,0);
        Mat3 expResult = new Mat3(-24,18,5,20,-15,-4,-5,4,1);
        Mat3 result = Mat3.inverse(mat);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of det method, of class TMatrix.
     */
    @Test
    public void testDet_TMatrix() {
        System.out.println("det");
        Mat3 other = new Mat3(1,2,3,0,1,4,5,6,0);
        double expResult = 1.0;
        double result = Mat3.det(other);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
