package my.test;

import java.util.Random;

public class InOutFileTask {

    public static void main(String[] args) {
        int[] offsets = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        blend(offsets);
        for (int offset : offsets) {
            String line = readLineFromFileByOffset(offset);
            writeLineToTheEndOfFile(line);
        }
    }

    private static void blend(int[] offset) {
        Random rnd = new Random();
        for (int i = offset.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int a = offset[index];
            offset[index] = offset[i];
            offset[i] = a;
        }
    }

    private static void writeLineToTheEndOfFile(String line) {
        System.out.println(line);
    }

    private static String readLineFromFileByOffset(int offset) {
        return String.valueOf(offset) + ") line";
    }
}
