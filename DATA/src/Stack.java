public class Stack {
    private int[] values;
    private int top;

    public Stack(int[] size)
    {
        this.top = -1;
        this.values = new int[/*size*/8];
    }


    public int size()
    {
        return values.length;
    }


    public boolean isEmpty()
    {
        if(this.top == -1)
        {
            return true;
        }

        else
        {
            return false;
        }
    }

    public boolean isFull()
    {
        if(this.top+1 == values.length)
        {
            return true;
        }
        else
        {
            return false;
        }
    }


    public int peek()
    {
        return this.values[this.top];
    }


    public int count()
    {
       return this.top + 1;
    }

    public void push(int val)
    {
        if(isFull())
        {
            System.out.println("Stack is full!");
        }
        else
        {
            this.top++;
            this.values[this.top] = val;
        }
    }


    public int pop()
    {
        if(isEmpty())
        {
            return -1;
        }
        else
        {
            this.top--;
            return values[this.top++];

        }

    }

    public void display()
    {
        if(isEmpty())
        {
            System.out.println("Stack is empty!");
        }

        for(int i = this.top; i >-1; i--)
        {
            System.out.println(this.values[i]);
        }
    }


}






