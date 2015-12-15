package learnAlgorithm;

/**
 * Created by kevin.
 */
public class Node<V> {
    private V value;
    private Node<V> leftChild;
    private Node<V> rightChild;

    public Node() {
    }

    public Node(V value) {
        this.value = value;
        leftChild = null;
        rightChild = null;
    }

    public void setLeftChild(Node<V> lNode) {
        this.leftChild = lNode;
    }

    public void setRightChild(Node<V> rNode) {
        this.rightChild = rNode;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node<V> getLeftChild() {
        return leftChild;
    }

    public Node<V> getRightChild() {
        return rightChild;
    }
}
