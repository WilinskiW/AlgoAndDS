package heap;

import java.util.Arrays;

public class HeapDemo {
    public static void main(String[] args) {
        //int[] A = {5, 13, 2, 25, 7, 17, 20, 8};
        int[] A = {5, 13, 2, 25, 7, 17, 20, 8};
        System.out.println("Input: " + Arrays.toString(A));
        System.out.println("Output:" + Arrays.toString(heapsort(A)));
    }

    static int[] heapsort(int[] array) {
        buildHeap(array);
        int heapSize = array.length;

        for (int i = heapSize - 1; i > 0; i--) {
            int pom = array[0];
            array[0] = array[i];
            array[i] = pom;
            System.out.println(array[i] + "<->" + pom + " " + Arrays.toString(array));

            heapSize--;

            maxHeapify(array, 0, heapSize);
        }
        return array;
    }

    static int[] buildHeap(int[] array) {
        int heap = array.length;
        int startIndex = (heap - 2) / 2;

        for (int i = startIndex; i >= 0; i--) {
            maxHeapify(array, i, heap);
        }

        return array;
    }

    static int[] maxHeapify(int[] array, int i, int heapSize) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest;

        if (left < heapSize && array[left] > array[i]) {
            largest = left;
        } else {
            largest = i;
        }

        if (right < heapSize && array[right] > array[largest]) {
            largest = right;
        }

        if (i != largest) {
            int pom = array[i];
            array[i] = array[largest];
            array[largest] = pom;
            System.out.println(array[i] + "<->" + pom + " " + Arrays.toString(array));
            maxHeapify(array, largest, heapSize);
        }
        return array;
    }
}
