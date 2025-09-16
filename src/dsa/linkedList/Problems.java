package dsa.linkedList;

public class Problems {

    // detect the loop
    public static boolean hasLoop(Node head) {

        if (head == null || head.next == null) {
            return false;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static Node reverseList(Node head) {

        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        // Create nodes
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Create a loop for testing
        head.next.next.next.next.next = head.next.next; // 5 → 3

        System.out.println("Does Linked List have loop? " + hasLoop(head));
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}



