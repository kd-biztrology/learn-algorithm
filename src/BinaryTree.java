import java.util.LinkedList;

/**
 * Created by kevin .
 * 通过数组构造二叉树，所有遍历算法以及求二叉树深度的递归算法
 */
public class BinaryTree {
    //根节点
    private Node<Integer> root;

    //二叉树中节点数量
    private int size;

    //无参构造器
    public BinaryTree() {
        root = new Node<Integer>();
    }

    //数组构造器
    public BinaryTree(int[] values) {
        System.out.print("新建binaryTree:");
        for (int i : values) {
            System.out.print(i);
        }
        System.out.println();
        boolean isLeft = true;
        int len = values.length;
        if (len == 0)
            return ;
        LinkedList<Node<Integer>> queue = new LinkedList<Node<Integer>>();
        root = new Node<Integer>(values[0]);
        queue.addLast(root);
        Node parent = null;
        Node current = null;
        for (int i=1; i<len; i++) {
            current = new Node<Integer>(values[i]);
            queue.addLast(current);
            if (isLeft)
                parent = queue.getFirst();
            else
                parent = queue.removeFirst();
            if (isLeft) {
                parent.setLeftChild(current);
                isLeft = false;
            }else {
                parent.setRightChild(current);
                isLeft = true;
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(new int[]{1,2,3,4,5,6,7,8});
        bt.inorder();
        bt.preorder();
        bt.layerorder();
        bt.preorderNoRecursion();
        bt.inorderNoRecursion();
        bt.postorderNoRecursion();
        System.out.println("深度为：" + bt.getDepth());
    }


    //递归中序遍历
    public void inorder() {
        System.out.print("binaryTree递归中序遍历:");
        inorderTraverseRecursion(root);
        System.out.println();
    }

    //层次遍历
    public void layerorder() {
        System.out.print("binaryTree层次遍历:");
        LinkedList<Node<Integer>> queue = new LinkedList<Node<Integer>>();
        queue.addLast(root);
        Node<Integer> current = null;
        while(!queue.isEmpty()) {
            current = queue.removeFirst();
            if (current.getLeftChild() != null)
                queue.addLast(current.getLeftChild());
            if (current.getRightChild() != null)
                queue.addLast(current.getRightChild());
            System.out.print(current.getValue());
        }
        System.out.println();
    }


    //获得二叉树深度
    public int getDepth() {
        return getDepthRecursion(root);
    }

    private int getDepthRecursion(Node<Integer> node){
        if (node == null)
            return 0;
        int llen = getDepthRecursion(node.getLeftChild());
        int rlen = getDepthRecursion(node.getRightChild());
        int maxlen = Math.max(llen, rlen);
        return maxlen + 1;
    }
    //递归先序遍历
    public void preorder() {
        System.out.print("binaryTree递归先序遍历:");
        preorderTraverseRecursion(root);
        System.out.println();
    }



    private void inorderTraverseRecursion(Node<Integer> node) {
        // TODO Auto-generated method stub
        if (node.getLeftChild() != null)
            inorderTraverseRecursion(node.getLeftChild());
        System.out.print(node.getValue());
        if (node.getRightChild() != null)
            inorderTraverseRecursion(node.getRightChild());
    }


    private void preorderTraverseRecursion(Node<Integer> node){
        System.out.print(node.getValue());
        if (node.getLeftChild() != null)
            preorderTraverseRecursion (node.getLeftChild());
        if (node.getRightChild() != null)
            preorderTraverseRecursion (node.getRightChild());
    }

    //非递归先序遍历
    public void preorderNoRecursion() {
        System.out.print("binaryTree非递归先序遍历:");
        LinkedList<Node<Integer>> stack = new LinkedList<Node<Integer>>();
        stack.push(root);
        Node<Integer> current = null;
        while (!stack.isEmpty()) {
            current = stack.pop();
            System.out.print(current.getValue());
            if (current.getRightChild() != null)
                stack.push(current.getRightChild());
            if (current.getLeftChild() != null)
                stack.push(current.getLeftChild());
        }
        System.out.println();
    }

    /**
     * 非递归中序遍历
     * 栈内保存将要访问的元素
     */
    public void inorderNoRecursion() {
        System.out.print("binaryTree非递归中序遍历:");
        LinkedList<Node<Integer>> stack = new LinkedList<Node<Integer>>();
        Node<Integer> current = root;
        while (current != null || !stack.isEmpty()) {
            while(current != null) {
                stack.push(current);
                current = current.getLeftChild();
            }
            if (!stack.isEmpty()) {
                current = stack.pop();
                System.out.print(current.getValue());
                current = current.getRightChild();
            }
        }
        System.out.println();
    }

    /**
     * 非递归后序遍历

     * 当上一个访问的结点是右孩子或者当前结点没有右孩子则访问当前结点
     */
    public void postorderNoRecursion() {
        System.out.print("binaryTree非递归后序遍历:");
        Node<Integer> rNode = null;
        Node<Integer> current = root;
        LinkedList<Node<Integer>> stack = new LinkedList<Node<Integer>>();
        while(current != null || !stack.isEmpty()) {
            while(current != null) {
                stack.push(current);
                current = current.getLeftChild();
            }
            current = stack.pop();
            while (current != null && (current.getRightChild() == null ||current.getRightChild() == rNode)) {
                System.out.print(current.getValue());
                rNode = current;
                if (stack.isEmpty()){
                    System.out.println();
                    return;
                }
                current = stack.pop();
            }
            stack.push(current);
            current = current.getRightChild();
        }

    }

}

class Node<V>{
    private V  value;
    private Node<V> leftChild;
    private Node<V> rightChild;

    public Node(){
    };

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
