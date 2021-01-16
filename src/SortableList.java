import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SortableList<E> extends ArrayList<Integer> {

    /**
     * Creates an empty SortableList
     */
    public SortableList() {
        super();
    }

    /**
     * Loads the contents of the specified file into the SortableList
     * this method is called upon
     * @param filepath The filepath and name of the file to be read from
     */
    public void load(String filepath) {
        try {
            Scanner scanner = new Scanner(new File(filepath));
            int next;
            while(scanner.hasNextInt()) {
                next = scanner.nextInt();
                this.add(next);
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sorts the list this method is called upon in ascending
     * order by use of an LSD Radix Sort algorithm
     */
    public void sort() {
        ArrayList<Integer> bucket0 = new ArrayList<>();
        ArrayList<Integer> bucket1 = new ArrayList<>();
        ArrayList<Integer> bucket2 = new ArrayList<>();
        ArrayList<Integer> bucket3 = new ArrayList<>();
        ArrayList<Integer> bucket4 = new ArrayList<>();
        ArrayList<Integer> bucket5 = new ArrayList<>();
        ArrayList<Integer> bucket6 = new ArrayList<>();
        ArrayList<Integer> bucket7 = new ArrayList<>();
        ArrayList<Integer> bucket8 = new ArrayList<>();
        ArrayList<Integer> bucket9 = new ArrayList<>();

        for (int n = 0; n < this.findMaxDigits(); n++) {
            for (Integer integer : this) {
                switch (getDigit(integer, n)) {
                    case 0 -> bucket0.add(integer);
                    case 1 -> bucket1.add(integer);
                    case 2 -> bucket2.add(integer);
                    case 3 -> bucket3.add(integer);
                    case 4 -> bucket4.add(integer);
                    case 5 -> bucket5.add(integer);
                    case 6 -> bucket6.add(integer);
                    case 7 -> bucket7.add(integer);
                    case 8 -> bucket8.add(integer);
                    case 9 -> bucket9.add(integer);
                }
            }

            this.clear();
            this.addAll(bucket0);
            this.addAll(bucket1);
            this.addAll(bucket2);
            this.addAll(bucket3);
            this.addAll(bucket4);
            this.addAll(bucket5);
            this.addAll(bucket6);
            this.addAll(bucket7);
            this.addAll(bucket8);
            this.addAll(bucket9);
            bucket0.clear();
            bucket1.clear();
            bucket2.clear();
            bucket3.clear();
            bucket4.clear();
            bucket5.clear();
            bucket6.clear();
            bucket7.clear();
            bucket8.clear();
            bucket9.clear();
        }
    }

    /**
     * Finds the digit present at the specified place in the given number
     * @param integer The number to be iterated through
     * @param place The digit place of the number to go to: 0 = Ones, 1 = Tens, 2 = Hundreds, etc.
     * @return The digit in the specified place of the integer
     */
    private int getDigit(int integer, int place) {
        int digit = 0;
        for (int n = 0; n <= place; n++) {
            digit = integer % 10;
            integer /= 10;
        }
        return digit;
    }

    /**
     * Finds the maximum number of digits that the numbers within this list contain
     * @return The maximum number of digits found
     */
    private int findMaxDigits() {
        int temp;
        int individualMax;
        int absoluteMax = 0;

        for (Integer integer : this) {
            temp = integer;
            individualMax = 0;

            do {
                temp /= 10;
                individualMax++;
                if (individualMax > absoluteMax)
                    absoluteMax = individualMax;
            } while (temp % 10 != 0 || temp / 10 != 0);
        }
        return absoluteMax;
    }
}
