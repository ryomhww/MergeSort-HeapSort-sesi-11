class MergeSort {
    void merge(int arr[], int l, int m, int r, String param) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        if (param.equals("asc")) {
            while (i < n1 && j < n2) {
                if (L[i] <= R[j])
                    arr[k++] = L[i++];
                else
                    arr[k++] = R[j++];
            }
            while (i < n1) {
                arr[k] = L[i];
                i++;
                k++;
            }
            while (j < n2) {
                arr[k] = R[j];
                j++;
                k++;
            }
        } else {
            while (i < n1 && j < n2) {
                if (L[i] >= R[j])
                    arr[k++] = L[i++];
                else
                    arr[k++] = R[j++];
            }
            while (i < n1) {
                arr[k] = L[i];
                i++;
                k++;
            }
            while (j < n2) {
                arr[k] = R[j];
                j++;
                k++;
            }
        }
    }

    void sort(int arr[], int l, int r, String param) {
        if (l < r) {
            int m = l + (r - l) / 2;

            sort(arr, l, m, param);
            sort(arr, m + 1, r, param);
            merge(arr, l, m, r, param);
        }
    }

    public static void main(String args[]) throws Exception {
        int arr[] = { 12, 11, 13, 5, 6, 7 };

        System.out.println("Given Array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1, "asc");

        System.out.println("\nSorted Array (Ascending)");
        printArray(arr);

        ob.sort(arr, 0, arr.length - 1, "desc");

        System.out.println("\nSorted Array (Descending)");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}