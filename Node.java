public class Node {
    private Object data;
    private MyNode next;

    public Node(Object d, MyNode n) {
        data = d;
        next = n;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object d) {
        data = d;
    }

    public MyNode getNext() {
        return next;
    }

    public void setNext(MyNode n) {
        next = n;
    }

    public String toString() {
        return String.valueOf(data);
    }

}
