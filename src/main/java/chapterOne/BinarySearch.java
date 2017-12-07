package chapterOne;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Vladimir Glinskikh on 02.12.2017.
 * e-mail: vladimir.v.glinskikh@gmail.com
 */
public class BinarySearch {
    private static void binarySearch(int[] array, int low, int high, int item) {
        int middle = (low + high) / 2;
        int comparisonCount = 1;

        while ((array[middle] != item) && (low <= high)) {
            comparisonCount++;
            if (array[middle] > item) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
            middle = (low + high) / 2;
        }
        if (low <= high) {
            System.out.println(item + " является " + ++middle + " элементом в массиве.");
            System.out.println("Метод бинарного поиска нашел число после " + comparisonCount + " сравнений.");
        } else {
            System.out.println("Элемент не найден в массиве. Метод бинарного поиска завершил работу после " +
                    comparisonCount + " сравнений.");
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите колличество элементов массива: ");
        int num = Integer.parseInt(reader.readLine());

        int[] array = new int[num];
        System.out.println("Введите " + num + " чисел");

        for (int counter = 0; counter < num; counter++)
            array[counter] = Integer.parseInt(reader.readLine());

        Arrays.sort(array);

        System.out.println("Введите элемент для поиска: ");

        int item = Integer.parseInt(reader.readLine());
        int first = 0;
        int last = num - 1;

        binarySearch(array, first, last, item);
    }
}
