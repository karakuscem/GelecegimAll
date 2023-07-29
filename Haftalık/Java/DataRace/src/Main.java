import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static final Object lock = new Object();


    public static void addOddsAndEvens(List<Integer> list, List<Integer> odds, List<Integer> evens) {
        for (Integer i : list) synchronized (lock){
            if (i % 2 == 0)
                evens.add(i);
            else synchronized (lock) {
                odds.add(i);
            }
        }
    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++)
            list.add(i);
        List<Integer> list1 = list.subList(0, 2500);
        List<Integer> list2 = list.subList(0, 2500);
        List<Integer> list3 = list.subList(0, 2500);
        List<Integer> list4 = list.subList(0, 2500);

        List<Integer> odds = new ArrayList<>();
        List<Integer> evens = new ArrayList<>();

        Thread t1 = new Thread(() -> addOddsAndEvens(list1, odds, evens));
        Thread t2 = new Thread(() -> addOddsAndEvens(list2, odds, evens));
        Thread t3 = new Thread(() -> addOddsAndEvens(list3, odds, evens));
        Thread t4 = new Thread(() -> addOddsAndEvens(list4, odds, evens));

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }

        System.out.println("Odds: " + odds.size());
        System.out.println("Evens: " + evens.size());
    }
}