package tree.bstsample;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;


public class BinarySearchTreeSampleTest {

    private BinarySearchTreeSample<Integer> sampleBstree;
    /* Diagram of "sampleTree"
    *      5
    *    /  \
    *    3   10
    *  /  \    \
    * 1    4    15
    *          /
    *        13
    */

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUpSampleBstree() {
        sampleBstree = new BinarySearchTreeSample<Integer>(5);
        sampleBstree.insert(10);
        sampleBstree.insert(15);
        sampleBstree.insert(13);
        sampleBstree.insert(3);
        sampleBstree.insert(1);
        sampleBstree.insert(4);
    }

    // uncomment this method to see the actual print log
    @Before
    public void setUpStream() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void testInOrderTraversing() {
        sampleBstree.inOrderTraversing();
        assertEquals("1 3 4 5 10 13 15 ", outputStreamCaptor.toString());
    }

    @Test
    public void testPreOrderTraversing() {
        sampleBstree.preOrderTraversing();
        assertEquals("5 3 1 4 10 15 13 ", outputStreamCaptor.toString());
    }

    @Test
    public void testPostOrderTraversing() {
        sampleBstree.postOrderTraversing();
        assertEquals("1 4 3 13 15 10 5 ", outputStreamCaptor.toString());
    }

    @Test
    public void testSuccessor() {
        assertEquals(Integer.valueOf(5), sampleBstree.leftNode.rightNode.getSuccessor().value);
    }

    @Test
    public void testPrePredecessor() {
        assertEquals(Integer.valueOf(10), sampleBstree.rightNode.rightNode.leftNode.getPredecessor().value);
    }

    @Test
    public void testDeleteNoChild() {
        BinarySearchTreeSample<Integer> treeAfterDeletion = sampleBstree.delete(1);
        treeAfterDeletion.inOrderTraversing();
        assertEquals("3 4 5 10 13 15 ", outputStreamCaptor.toString());
    }

    @Test
    public void testDeleteOneChild() {
        BinarySearchTreeSample<Integer> treeAfterDeletion = sampleBstree.delete(15);
        treeAfterDeletion.inOrderTraversing();
        assertEquals("1 3 4 5 10 13 ", outputStreamCaptor.toString());
    }

    @Test
    public void testDeleteTwoChildren() {
        BinarySearchTreeSample<Integer> treeAfterDeletion = sampleBstree.delete(3);
        treeAfterDeletion.inOrderTraversing();
        assertEquals("1 4 5 10 13 15 ", outputStreamCaptor.toString());
    }
}
