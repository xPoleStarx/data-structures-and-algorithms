public class bubbleSort
{
    public static void bubbleSort(int[] values)
    {
        boolean sorted = true;
        for (int i = 0; i < values.length-1; i++)
        {
            for (int j = 0; j < values.length-1-i; j++)
            {
                if (values[j] > values[j+1])
                {
                    int temp = values[j];
                    values[j] = values[j+1];
                    values[j+1] = temp;
                    sorted = false;
                }
            }//inner for loop

        }//outer for loop

        if (sorted) return;
        sorted = true;

    }
}
