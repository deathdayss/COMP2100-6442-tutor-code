package tree.bstsample;

public class BinarySearchTreeSample<T extends Comparable> {
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

    public void insert(T value) {
        if (this.value.compareTo(value) < 0) {
            if (rightNode == null) {
                rightNode = new BinarySearchTreeSample(value);
                rightNode.parentNode = this;
            }
            else {
                rightNode.insert(value);
            }
        }
        else if (this.value.compareTo(value) > 0)  {
            if (leftNode == null) {
                leftNode = new BinarySearchTreeSample(value);
                leftNode.parentNode = this;
            }
            else {
                leftNode.insert(value);
            }
        }
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

    // helper function for delete
    public BinarySearchTreeSample<T> findNodeByValue(T value) {
        if (this.value.compareTo(value) < 0) {
            if (rightNode != null) {
                return rightNode.findNodeByValue(value);
            }
            else {
                return null;
            }
        }
        else if (this.value.compareTo(value) > 0)  {
            if (leftNode != null) {
                return leftNode.findNodeByValue(value);
            }
            else {
                return null;
            }
        }
        else {
            return this;
        }
    }

    // helper function for delete
    public void replaceByNode(boolean isLeft, BinarySearchTreeSample<T> node) {
        BinarySearchTreeSample<T> replaceNode = isLeft ? leftNode : rightNode;
        node.leftNode = replaceNode.leftNode;
        node.rightNode = replaceNode.rightNode;
        if (isLeft) {
            leftNode = node;
        }
        else {
            rightNode = node;
        }
        node.parentNode = this;
        replaceNode.parentNode = null;
    }

    public BinarySearchTreeSample<T> delete(T value) {
        BinarySearchTreeSample<T> deleteNode = findNodeByValue(value);
        if (deleteNode == null) {
            return this;
        }
        BinarySearchTreeSample<T> parentNode = deleteNode.parentNode;
        boolean isLeftChild = true;
        if (parentNode != null) {
            isLeftChild = parentNode.leftNode == deleteNode;
        }
        // case 1: no child node
        if (deleteNode.leftNode == null && deleteNode.rightNode == null) {
            if (parentNode == null) {
                return null;
            }
            if (isLeftChild) {
                parentNode.leftNode = null;
            }
            else {
                parentNode.rightNode = null;
            }
            deleteNode.parentNode = null;
        }
        // case 2: there is only one child node
        else if (deleteNode.leftNode == null) {
            if (parentNode == null) {
                deleteNode.rightNode.parentNode = null;
                return deleteNode.rightNode;
            }
            BinarySearchTreeSample<T> childNode = deleteNode.rightNode;
            deleteNode.rightNode = null;
            parentNode.replaceByNode(isLeftChild, childNode);
        }
        else if (deleteNode.rightNode == null) {
            if (parentNode == null) {
                deleteNode.leftNode.parentNode = null;
                return deleteNode.leftNode;
            }
            BinarySearchTreeSample<T> childNode = deleteNode.leftNode;
            deleteNode.leftNode = null;
            parentNode.replaceByNode(isLeftChild, childNode);
        }
        // case 3: there are two child nodes
        else {
            BinarySearchTreeSample<T> successorNode = deleteNode.getSuccessor();
            successorNode.delete(successorNode.value);
            if (parentNode == null) {
                leftNode.parentNode = successorNode;
                rightNode.parentNode = successorNode;
                successorNode.leftNode = leftNode;
                successorNode.rightNode = rightNode;
                return successorNode;
            }
            else  {
                parentNode.replaceByNode(isLeftChild, successorNode);
            }
        }
        return this;
    }
}