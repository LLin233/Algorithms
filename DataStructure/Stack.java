import java.util.*;
public class Stack {
    public Node head;
    public Node current;

    public void push(int data) {
        if (head == null) {
            head = new Node(data);
            current = head;
        } else {
            Node node = new Node(data);
            node.pre = current;
            current = node;
        }
    }

    public Node pop() {
        if (current == null) {
            return null;
        }

        Node node = current; // current结点是我们要出栈的结点
        current = current.pre;  //每出栈一个结点后，current后退一位
        return node;

    }
    class Node {
        int data;
        Node pre;

        public Node(int data) {
            this.data = data;
        }
    }
}