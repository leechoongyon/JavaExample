package datastructure;

/**
 * LinkedList 의 특징은 데이터가 다음 데이터의 주소를 가지고 있다는 것.
 * 단방향은 한쪽 방향으로의 주소를 가지고 있고, 양방향은 양쪽 주소를 가지고 있다.
 * LinkedList 의 특징 상 삭제, 삽입에 빠르고 조회는 느리다.
 */

public class LinkedList {

    private Node head;
    private Node tail;

    public static class Node {
        private Object item;
        private Node next;

        public Node(Object item) {
            this.item = item;
        }

        public Object getItem() {
            return this.item;
        }
    }

    public void addLast(Object item) {
        if (head == null) {
            head = new Node(item);
            tail = head;
        } else {
            Node newNode = new Node(item);
            tail.next = newNode;
            tail = newNode;
        }
    }

    public Node getNode(int idx) {
        Node node = head;
        for (int i = 0 ; i < idx ; i++) {
            node = node.next;
        }
        return node;
    }
}
