public class DNode<T extends Comparable>
{
    public T value;
    public DNode<T> next, prev;

    public DNode(T val)
    {
        this.value = val;
        this.prev = null;
        this.next = null;
    }

    public String toString()
    {
        return String.valueOf(value);
    }
}
