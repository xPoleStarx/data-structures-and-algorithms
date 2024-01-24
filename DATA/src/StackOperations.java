public class StackOperations
{
    //This method searches a given value in a given stack
    public static boolean search(Stack stk, int val)
    {
        Stack tempStack=new Stack(stk.count());


        while(!stk.isEmpty())
        {
            int iterator = stk.pop();
            tempStack.push(iterator);

            if(iterator==val)
            {
                //restrose the original stack
                while(!tempStack.isEmpty())
                {
                    stk.push(tempStack.pop());
                }
                return true; //value found

            }
        }

        // Value not found, restore the original stack
        while(!tempStack.isEmpty())
        {
            stk.push(tempStack.pop());
            return false; //value not found
        }
    }
    //write a remove method that will remove a specific element from a given stack
    public static void remove(Stack stk, int val)
    {
        Stack tempStack = new Stack(stk.count());

        while(!stk.isEmpty())
        {
            int iterator = stk.pop();

            if (iterator != val)
            {
                tempStack.push(iterator);
            }
        }

        while(!tempStack.isEmpty())
        {
            stk.push(tempStack.pop());
        }
    }


    // control the if 2 stack is equal
    public static boolean isEqual(Stack s1, Stack s2)
    {

        if(s1.count() != s2.count())
        {
            return false;
        }

        Stack tempStack1 = new Stack(s1.count());
        Stack tempStack2 = new Stack(s2.count());
        boolean result = true;

        while(!s1.isEmpty())
        {
            int val1 = s1.pop();
            int val2 = s2.pop();

            tempStack1.push(val1);
            tempStack2.push(val2);

            if(val1 != val2)
            {
                result = false;
                break;
            }
        }

        while(!tempStack1.isEmpty())
        {
            s1.push(tempStack1.pop());
            s2.push(tempStack2.pop());
        }

        return result;
    }
}


