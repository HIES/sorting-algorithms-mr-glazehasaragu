public class SortingAlgorithms
{
    public static void bubbleSort(int[] nums)
    {
        boolean isSort = false;

        while(!isSort){
            boolean didSwap = false;
            for (int i = 0; i <nums.length-1; i++) {
                if (nums[i]>nums[i+1]) {
                    int temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                }
            }
            if (!didSwap)
            {
                isSort = true;
            }
        }
    }

    public static void selectionSort(int[] nums)
    {
        int min = nums[0];
        int minIndex = 0;
        int startIndex=0;
        int[] temp = new int[nums.length];
        while (!isSorted(nums))
        {
            while(startIndex< nums.length)
            {
                for(int i = startIndex; i < nums.length; i++)
                {
                    if(nums[i] < min)
                    {
                        min = nums[i];
                        minIndex = i;
                    }
                }

                temp[startIndex]= nums[minIndex];
                startIndex++;
                nums[minIndex] = Integer.MAX_VALUE;

            }
            nums = temp;
        }

    }

    public static void insertionSort(int[] nums)
    {

        for(int i = 1; i <nums.length; i++){
            int s = i -1;
            int num = nums[i];
            while (s>0 && num < nums[s-1] ){
                nums[s] = nums[s-1];
                s--;
            }
            
            nums[s]= num;
        }
    }
    // A helper method for you to check if your sorts work
    private static boolean isSorted(int[] nums){
        for (int i = 0; i < nums.length - 1; i++)
            if (nums[i] > nums[i+1])
                return false;
        return true;
    }

    // Generate an array of size N with random integers in the range [0, N]
    private static int[] generateRandomArray(int N){
        int[] nums = new int[N];
        for (int i = 0; i < N; i++)
            nums[i] = (int) (Math.random()*N);
        return nums;
    }

    // Generate a sorted array of size N whose contents are in the range [0, N]
    private static int[] generateSortedArray(int N){
        int[] nums = new int[N];
        for (int i = 0; i < N; i++)
            nums[i] = i;
        return nums;
    }

    // Generate a reversed array of size N whose contents are in the range [0, N]
    private static int[] generateReversedArray(int N){
        int[] nums = new int[N];
        for (int i = 0; i < N; i++)
            nums[i] = (N - 1 ) - i;
        return nums;
    }

    // Assumes that nums is not empty
    private static void printArray(int[] nums)
    {
        System.out.print("[" + nums[0]);
        for (int i = 1; i < nums.length; i++)
            System.out.print(", " + nums[i]);
        System.out.println("]");
    }

    // Use main for testing and timing your sorts
    public static void main(String[] args) 
    {
        int[] testArray = generateRandomArray(10);

        //printArray(testArray);

        System.out.println("Applying the bubble sort.");

        long start = System.currentTimeMillis();
        insertionSort(testArray);
        long end = System.currentTimeMillis();
        double sortTime = (end - start) / 1000.0; 

        printArray(testArray);

        System.out.format("Time to complete took %.4f seconds.%n", sortTime);
    }
}