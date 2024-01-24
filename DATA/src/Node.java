public class Node<T>
{
    public T value;
    public Node<T> next;

    public Node(T val)
    {
        this.value = val;
        this.next = null;
    }
}
