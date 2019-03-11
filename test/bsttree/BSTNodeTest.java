/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bsttree;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author csc190
 */
public class BSTNodeTest {

    public BSTNodeTest() {
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

    protected int[] genRandArr() {
        Random rand = new Random();
        int size = rand.nextInt(1000);
        int [] arr = new int [size+1];
        for(int i=0; i<size+1; i++){
            arr[i] = rand.nextInt();
        }
        return arr;
    }

    protected HashSet<Integer> getSet(int[] arr) {
        HashSet<Integer> set = new HashSet();
        for(int i=0; i<arr.length; i++){
            set.add(arr[i]);
        }
        return set;
        
    }

    protected HashSet<Integer> getSet(BSTNode root) {
        HashSet<Integer> set = new HashSet();
        if (root == null) {
            return set;
        } else {
            set.add(root.val);
            HashSet<Integer> set1 = getSet(root.left);
            HashSet<Integer> set2 = getSet(root.right);
            set.addAll(set1);
            set.addAll(set2);
            return set;

        }
    }

    protected boolean isBST(BSTNode root, int leftbound, int rightbound) {
        if(root==null) return true;
        return root.val >=leftbound && root.val<=rightbound &&
                isBST(root.left, leftbound, root.val-1) && isBST(root.right, root.val+1, rightbound);
    }

    protected void oneRandomTest() {
        int [] arr = genRandArr();
        BSTNode root = BSTNode.buildTree(arr);
        //verify
        if(!getSet(root).equals(getSet(arr))){
            fail("Contents noght right!");
        }
        
        if(!isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)){
            fail("it's not a bst!");
        }
    }

    @Test
    public void randomTestBuildTree() {
        final int NUMBERS = 1;
        for (int i = 0; i < NUMBERS; i++) {
            oneRandomTest();
        }
    }

}
