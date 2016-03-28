package learnAlgorithm;

/**
 * Created by kevin.
 */
class Node<V> {
    private V value;
    private Node<V> leftChild;
    private Node<V> rightChild;

    Node(V value) {
        this.value = value;
        leftChild = null;
        rightChild = null;
    }

    void setLeftChild(Node<V> lNode) {
        this.leftChild = lNode;
    }

     void setRightChild(Node<V> rNode) {
        this.rightChild = rNode;
    }

     V getValue() {
        return value;
    }

    Node<V> getLeftChild() {
        return leftChild;
    }

     Node<V> getRightChild() {
        return rightChild;
    }
}
