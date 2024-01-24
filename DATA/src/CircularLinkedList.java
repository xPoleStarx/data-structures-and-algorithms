public class CircularLinkedList<T extends Comparable>
{
    Node<T> head;

    public void insertToFront(T val)
    {
        Node<T> newNode = new Node<T>(val);
        if(head == null)
        {
            head = newNode;
            head.next = head;
        }
        else
        {
            Node<T> iterator = head;
            while(iterator.next != head)
            {
                iterator = iterator.next;
                iterator.next = newNode;
                newNode.next = head;
            }
        }
    }

    public void insertToEnd(T val)
    {
        Node<T> newNode = new Node<T>(val);
        if(head == null)
        {
            head = newNode;
            head.next = head;
        }
        else
        {
            Node<T> iterator = head;
            while(iterator.next != head)
            {
                iterator = iterator.next;
                iterator.next = newNode;
                newNode.next = head;
            }
        }
    }
}
