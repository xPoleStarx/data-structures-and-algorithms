public class LinkedList<T extends Comparable>
{
    private Node<T> head;

    public Node<T> createNode(T val)
    {
        return new Node<T>(val);
    }

    public void insertToFront(T val)
    {
        Node<T> newNode = createNode(val);
        newNode.next = head;
        head = newNode;
    }

    public void selectionSort(){
        if(head==null)
            return;
        Node<T> iterator=head;
        while(iterator.next!=null){
            Node<T> min=findMin(iterator);
            T temp=iterator.value;
            iterator.value=min.value;
            min.value=temp;
            iterator=iterator.next;
        }
    }


    public void insertToEnd(T val)
    {
        Node<T> newNode = createNode(val);
        if(head == null)
        {
            head = newNode;
            return;
        }

        Node<T> iterator = head;
        while(iterator.next != null)
        {
            iterator = iterator.next;
        }
        iterator.next = newNode;
    }


    public T findMin()
    {
        if(head == null)
        {
            return null;
        }

        T min = head.value;
        Node<T> iterator = head.next;

        while(iterator.next != null)
        {
            if(min.compareTo(iterator.value) == 1)
            {
                min = iterator.value;
            }
            iterator = iterator.next;
        }
        return min;
    }


    public T findMax() {
        if (head == null) {
            return null;
        }

        T max = head.value;
        Node<T> iterator = head.next;

        while (iterator != null) {
            if (max.compareTo(iterator.value) == -1) {
                max = iterator.value;
            }
            iterator = iterator.next;
        }

        return max;
    }


    public void sortedInsert(T val)
    {
        Node<T> newNode = createNode(val);
        if (head == null)
        {
            head = newNode;
        }
        else if (val.compareTo(head.value) <= 0)
        {
            newNode.next = head;
            head = newNode;
        }
        else
        {
            Node<T> iterator = head;
            while (iterator.next != null && iterator.next.value.compareTo(val) == -1)
            {
                iterator = iterator.next;
            }
            newNode.next = iterator.next;
            iterator.next = newNode;
        }
    }


    public void deleteTheFirst()
    {
        if (head != null)
        {
            head = head.next;
        }
    }


    public void deleteTheLast()
    {
        if(head.next == null)
        {
            head = null;
            return;
        }

        Node<T> iterator, previous;
        iterator = previous = head;

        while(iterator.next != null)
        {
            previous = iterator;
            iterator = iterator.next;
        }
        previous.next = null;
    }

    public void delete(T val)
    {
        if (head == null)
        {
            return; // Liste boşsa işlem yapma
        }

        if (head.value.compareTo(val) == 0)
        {
            head = head.next; // Başlangıçta silinecek eleman varsa, başı güncelle
        }
        else
        {
            Node<T> previous = head, iterator = head;

            while (iterator != null && iterator.value.compareTo(val) != 0)
            {
                previous = iterator;
                iterator = iterator.next;
            }

            // Silinecek eleman bulunduysa
            if (iterator != null)
            {
                previous.next = iterator.next; // Elemanı listeden çıkart
            }
        }
    }


    public boolean search(T val)
    {
        Node<T> iterator = head;

        while(iterator != null)
        {
            if (iterator.value.compareTo(val) == 0)
            {
                return true;
            }
            iterator = iterator.next;
        }
        return false;
    }


    public void display()
    {
        Node<T> iterator = head;
        while(iterator.next != null)
        {
            System.out.println(iterator);
            iterator = iterator.next;
        }
    }
}
