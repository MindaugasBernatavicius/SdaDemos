package cf.mindaugas.sdademos._03_design._02_patterns._03_behavioral._02_command.sda;

public class CommandPattern {

    private static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            int n = (int) (Math.random() * 20 + 1);
            arr[i] = n;
        }
        return arr;
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        int[] arr = generateRandomArray(10000);
        CommandInterface bubbleSort = new BubbleSort(arr.clone());
        CommandInterface quickSort = new QuickSort(arr.clone());
        CommandInterface bucketSort = new BucketSort(arr.clone());
        CommandInterface mergeSort = new MergeSort(arr.clone());
        CommandInterface heapSort = new HeapSort(arr.clone());

        controller.setCommand(bubbleSort);
        controller.runSort();

        controller.setCommand(quickSort);
        controller.runSort();

        controller.setCommand(bucketSort);
        controller.runSort();

        controller.setCommand(mergeSort);
        controller.runSort();

        controller.setCommand(heapSort);
        controller.runSort();

//        CommandInterface shellSort = new ShellSort(arr.clone());
//        controler.setCommand(shellSort);
//        controler.runSort();

    }
}

interface CommandInterface {

    public void execute();

    public static void printArray(int[] arr, String type) {
        if (arr.length <= 20) {
            System.out.print(type + ": ");
            int n = arr.length;
            System.out.print("[");
            for (int i = 0; i < n; ++i) {
                System.out.print(arr[i] + " ");
            }
            System.out.println("]");
        }
    }
}

class Controller {
    private CommandInterface command;

    public void setCommand(CommandInterface command) {
        this.command = command;
    }

    public void runSort() {
        command.execute();
    }
}

class BubbleSort implements CommandInterface {
    private int[] arr;

    public BubbleSort(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void execute() {
        long timestamp = System.currentTimeMillis();
        System.out.println("Bubble Sort");
        CommandInterface.printArray(arr, "Before");
        sort();
        CommandInterface.printArray(arr, "After");
        System.out.println("Bubble Sort opertation time " + (System.currentTimeMillis() - timestamp) + " ms");
    }

    private void sort() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] < arr[j - 1]) {
                    int greater = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = greater;
                }
            }
        }
    }
}

class BucketSort implements CommandInterface {

    private int[] arr;

    public BucketSort(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void execute() {
        long timestamp = System.currentTimeMillis();
        System.out.println("Bucket Sort");
        CommandInterface.printArray(arr, "Before");
        sort();
        CommandInterface.printArray(arr, "After");
        System.out.println("Bucket Sort opertation time " + (System.currentTimeMillis() - timestamp) + " ms");
    }

    public void sort() {
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (maxVal < arr[i]) {
                maxVal = arr[i];
            }
        }
        int[] bucket = new int[maxVal + 1];

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = 0;
        }

        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }

        int outPos = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                arr[outPos++] = i;
            }
        }
    }
}

class HeapSort implements CommandInterface {

    private int[] arr;

    public HeapSort(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void execute() {
        long timestamp = System.currentTimeMillis();
        System.out.println("Heap Sort");
        CommandInterface.printArray(arr, "Before");
        sort();
        CommandInterface.printArray(arr, "After");
        System.out.println("Heap Sort opertation time " + (System.currentTimeMillis() - timestamp) + " ms");
    }

    public void sort() {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    void heapify(int arr[], int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int t = arr[i];
            arr[i] = arr[largest];
            arr[largest] = t;

            heapify(arr, n, largest);
        }
    }
}

class MergeSort implements CommandInterface {

    private int[] arr;

    public MergeSort(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void execute() {
        long timestamp = System.currentTimeMillis();
        System.out.println("Merge Sort");
        CommandInterface.printArray(arr, "Before");
        sort(arr, arr.length);
        CommandInterface.printArray(arr, "After");
        System.out.println("Merge Sort opertation time " + (System.currentTimeMillis() - timestamp) + " ms");
    }

    public void sort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        sort(l, mid);
        sort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    public void merge(int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
}

class QuickSort implements CommandInterface {

    private int[] arr;

    public QuickSort(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void execute() {
        long timestamp = System.currentTimeMillis();
        System.out.println("Quick Sort");
        CommandInterface.printArray(arr, "Before");
        sort(arr, 0, arr.length - 1);
        CommandInterface.printArray(arr, "After");
        System.out.println("Quick Sort opertation time " + (System.currentTimeMillis() - timestamp) + " ms");
    }

    public void sort(int[] tab, int start, int end) {
        if (start < end) {
            int pivot = arr[end];
            int i = (start - 1);

            for (int j = start; j < end; j++) {
                if (arr[j] <= pivot) {
                    i++;

                    int swap = arr[i];
                    arr[i] = arr[j];
                    arr[j] = swap;
                }
            }

            int swap = arr[i + 1];
            arr[i + 1] = arr[end];
            arr[end] = swap;
            int pivotIndex = i + 1;

            sort(arr, start, pivotIndex - 1);
            sort(arr, pivotIndex + 1, end);
        }
    }
}

