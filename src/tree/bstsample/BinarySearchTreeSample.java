package tree.bstsample;

public class BinarySearchTreeSample<T extends Comparable<T>> {
    T value;
    BinarySearchTreeSample<T> leftNode;
    BinarySearchTreeSample<T> rightNode;
    BinarySearchTreeSample<T> parentNode; // optional

    public BinarySearchTreeSample(T value) {
        this.value = value;
    }

    public void inOrderTraversing()  {
        if (leftNode != null) {
            leftNode.inOrderTraversing();
        }
        System.out.print(value + " ");
        if (rightNode != null) {
            rightNode.inOrderTraversing();
        }
    }
    public void preOrderTraversing()  {
        System.out.print(value + " ");
        if (leftNode != null) {
            leftNode.preOrderTraversing();
        }
        if (rightNode != null) {
            rightNode.preOrderTraversing();
        }
    }
    public void postOrderTraversing()  {
        if (leftNode != null) {
            leftNode.postOrderTraversing();
        }
        if (rightNode != null) {
            rightNode.postOrderTraversing();
        }
        System.out.print(value + " ");
    }

    public BinarySearchTreeSample<T> insert(T value) {
        if (this.value.compareTo(value) < 0) {
            if (rightNode == null) {
                rightNode = new BinarySearchTreeSample<>(value);
                rightNode.parentNode = this;
            }
            else {
                rightNode.insert(value);
            }
        }
        else if (this.value.compareTo(value) > 0)  {
            if (leftNode == null) {
                leftNode = new BinarySearchTreeSample<>(value);
                leftNode.parentNode = this;
            }
            else {
                leftNode.insert(value);
            }
        }
        return this;
    }

    // helper function for getSuccessor
    public BinarySearchTreeSample<T> findMinimumNode() {
        if (leftNode == null) {
            return this;
        }
        return leftNode.findMinimumNode();
    }

    // find the smallest node greater than the node
    public BinarySearchTreeSample<T> getSuccessor() {
        if (rightNode != null) {
            return rightNode.findMinimumNode();
        }
        BinarySearchTreeSample<T> parentNode = this.parentNode;
        BinarySearchTreeSample<T> currentNode = this;
        while (parentNode != null && currentNode == parentNode.rightNode) {
            currentNode = parentNode;
            parentNode = currentNode.parentNode;
        }
        return parentNode;
    }

    // helper function for getPredecessor
    public BinarySearchTreeSample<T> findMaximumNode() {
        if (rightNode == null) {
            return this;
        }
        return rightNode.findMinimumNode();
    }

    // find the largest node less than the node
    public BinarySearchTreeSample<T> getPredecessor() {
        if (leftNode != null) {
            return leftNode.findMaximumNode();
        }
        BinarySearchTreeSample<T> parentNode = this.parentNode;
        BinarySearchTreeSample<T> currentNode = this;
        while (parentNode != null && currentNode == parentNode.leftNode) {
            currentNode = parentNode;
            parentNode = currentNode.parentNode;
        }
        return parentNode;
    }

    public BinarySearchTreeSample<T> delete(T value) {
        if (this.value.compareTo(value) < 0) {
            if (rightNode != null) {
                rightNode = rightNode.delete(value);
                if (rightNode != null) {
                    rightNode.parentNode = this;
                }
            }
            else {
                return this;
            }
        }
        else if (this.value.compareTo(value) > 0)  {
            if (leftNode != null) {
                leftNode = leftNode.delete(value);
                if (leftNode != null) {
                    leftNode.parentNode = this;
                }
            }
            else {
                return this;
            }
        }
        // case 1: no child node
        else if (leftNode == null && rightNode == null) {
            return null;
        }
        // case 2: there is only one child node
        else if (leftNode == null) {
            return rightNode;
        }
        else if (rightNode == null) {
            return leftNode;
        }
        // case 3: there are two child nodes
        else  {
            BinarySearchTreeSample<T> successorNode = getSuccessor();
            successorNode.parentNode.delete(successorNode.value);
            this.value = successorNode.value;
            return this;
        }
        return this;
    }
}