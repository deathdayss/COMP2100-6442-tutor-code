package tree.p;

public class BSTP<T extends Comparable<T>> {
    T value;
    BSTP<T> leftNode, rightNode;

    public BSTP (T value) {
        this.value = value;
    }

    // TODO: BST Insertion - Practice
    // you can change the "return null" to return other value
    public BSTP<T> insert(T value) {
        return null;
    }

    // TODO: BST Delete - Practice
    // you can change the "return null" to return other value
    // hint: you need to use helper functions "find and delete successor" to finish this method
    public BSTP<T> delete(T value) {
        return null;
    }

    public String preOrderShow() {
        return value + (leftNode == null ? "" : " " + leftNode.preOrderShow()) + (rightNode == null ? "" : " " + rightNode.preOrderShow());
    }
}