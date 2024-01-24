public class Queue
{
    private int[] values;
    private int front, rear;

    public Queue(int size)
    {
        values = new int[size];
        front = 0;
        rear = 0;
    }

    public boolean isEmpty()
    {
        return front == rear;
    }

    public boolean isFull()
    {
        return rear == values.length;
    }

    public void enQueue(int val)
    {
        if(isFull())
        {
            System.out.println("Queue is full");
            return;
        }

        values[rear] = val;
        rear++;
    }

    public int deQueue()
    {
        if(isEmpty())
        {
            System.out.println("Queue is empty");
            return -1;
        }

        front++;
        return values[front-1];

    }

    public int count()
    {
        return rear-front;
    }


    public void display()
    {
        if(isEmpty())
        {
            System.out.println("Queue is empty");
        }

        for(int i = front; i<rear; i++)
        {
            System.out.println(values[i]);
        }
    }
}
