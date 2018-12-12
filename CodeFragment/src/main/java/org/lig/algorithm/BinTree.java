package org.lig.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树 demo
 *
 */
public class BinTree {

    private BinNode root;

    private List<BinNode> result = new ArrayList<BinNode>();

    public void init() {
        BinNode b = new BinNode("b", null, null);
        BinNode a = new BinNode("a", null, b);
        BinNode c = new BinNode("c", a, null);

        BinNode e = new BinNode("e", null, null);
        BinNode g = new BinNode("g", null, null);
        BinNode f = new BinNode("f", e, g);
        BinNode h = new BinNode("h", f, null);

        BinNode d = new BinNode("d", c, h);

        BinNode j = new BinNode("j", null, null);
        BinNode k = new BinNode("k", j, null);
        BinNode m = new BinNode("m", null, null);
        BinNode o = new BinNode("o", null, null);
        BinNode p = new BinNode("p", o, null);
        BinNode n = new BinNode("n", m, p);
        BinNode l = new BinNode("l", k, n);

        root = new BinNode( "i", d, l );
    }

    // 先序递归
    public void preOrderRecursion(BinNode node) {
        if (node == null) return;

        result.add(node);

        preOrderRecursion( node.getlChild() );
        preOrderRecursion( node.getrChild() );

    }

    // 中序递归
    public void midOrderRecursion(BinNode node) {
        if (node == null) return;

        midOrderRecursion( node.getlChild() );

        result.add(node);

        midOrderRecursion( node.getrChild() );
    }
    // 后序递归
    public void postOrderRecursion(BinNode node) {
        if (node == null) return;

        postOrderRecursion( node.getlChild() );

        postOrderRecursion( node.getrChild() );

        result.add(node);

    }

    public void clearResultList() {
        result.clear();
    }

    public void printNodeList() {
        for (BinNode node : result) {
            System.out.print(node.getElement()+ " ");
        }
        System.out.println();
    }


    // 先序，非递归、栈
    public void preOrderWithStack(BinNode root){

        BinNode node = root;
        Stack<BinNode> treeStack = new Stack<BinNode>();

        List<BinNode> result = new ArrayList<BinNode>();

        treeStack.push( node );

        while (!treeStack.isEmpty()){
            BinNode tmpNode = treeStack.pop();
            result.add( tmpNode );
            if(tmpNode.getrChild()!=null) treeStack.push( tmpNode.getrChild() );
            if(tmpNode.getlChild()!=null) treeStack.push( tmpNode.getlChild() );
        }

        for (BinNode tmp : result) {
            System.out.print(tmp.getElement()+ " ");
        }

        System.out.println();

    }

    //栈中序遍历
    public void middleOrderWithStack(BinNode node) {
        Stack<BinNode> stack = new Stack<BinNode>();
        List<BinNode> result = new ArrayList<BinNode>();

        while (node != null || !stack.isEmpty()) {

            while (node != null) {
                stack.push( node);
                node = node.getrChild();
            }

            if (stack.size() > 0) {
                node = stack.pop();
                System.out.print(node.getElement());
                node = node.getrChild();
            }
        }

       System.out.println();
    }
    //栈后序遍历
    public void postOrderWithStack(BinNode node) {
        Stack<BinNode> stack = new Stack<BinNode>();
        List<BinNode> result = new ArrayList<BinNode>();
        BinNode q = node;
        while (node != null) {
            for (; node.getlChild() != null; node = node.getlChild())
                stack.push(node);
            // 当前节点无右子或右子已经输出
            while (node != null && (node.getrChild() == null || node.getrChild() == q)) {
                System.out.print(node.getElement());
                q = node;// 记录上一个已输出节点
                if (stack.empty())
                    return;
                node = stack.pop();
            }
            // 处理右子
            stack.push(node);
            node = node.getrChild();
        }

    }

    public static void main(String[] args) {
        BinTree binTree = new BinTree();
        binTree.init();

        System.out.println(
                "先序：i d c a b h f e g l k j n m p o \n" +
                "中序：a b c d e f g h i j k l m n o p \n" +
                "后序：b a c e g f h d j k m o p n l i ");

        System.out.println("递归先序遍历");
        binTree.clearResultList();
        binTree.preOrderRecursion(binTree.root);
        binTree.printNodeList();

        System.out.println("递归中序遍历");
        binTree.clearResultList();
        binTree.midOrderRecursion(binTree.root);
        binTree.printNodeList();

        System.out.println("递归后序遍历");
        binTree.clearResultList();
        binTree.postOrderRecursion(binTree.root);
        binTree.printNodeList();

        System.out.println("栈先序遍历");
        binTree.preOrderWithStack(binTree.root);

        System.out.println("栈中序遍历");
        binTree.middleOrderWithStack(binTree.root);

        System.out.println("栈后序遍历");
        binTree.postOrderWithStack(binTree.root);
    }
}


/**
 * 定义Node
 */
class BinNode {

    private Object element;
    private BinNode lChild;
    private BinNode rChild;

    public BinNode(Object element, BinNode lChild, BinNode rChild) {
        this.element = element;
        this.lChild = lChild;
        this.rChild = rChild;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public BinNode getlChild() {
        return lChild;
    }

    public void setlChild(BinNode lChild) {
        this.lChild = lChild;
    }

    public BinNode getrChild() {
        return rChild;
    }

    public void setrChild(BinNode rChild) {
        this.rChild = rChild;
    }
}
