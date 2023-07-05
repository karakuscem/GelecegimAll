import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ArrayList<String> studentsInClassA = new ArrayList<>();
        ArrayList<String> studentsInClassB = new ArrayList<>();
        ArrayList<String> studentsInClassC = new ArrayList<>();

        studentsInClassA.add("Cem Karakuş");
        studentsInClassA.add("Engin Demiroğ");
        studentsInClassA.add("Kaan Korkmaz");
        studentsInClassA.add("Sinem Varış");
        studentsInClassA.add("Kubilay Tunçel");
        studentsInClassA.add("Ecem Kurtboğan");
        studentsInClassA.add("Furkan Çelik");

        studentsInClassB.add("Cengizhan Öztürk");
        studentsInClassB.add("Hilal Yıldız");
        studentsInClassB.add("Dağhan Korkmaz");
        studentsInClassB.add("Karan Çelik");
        studentsInClassB.add("Kayra Uçar");
        studentsInClassB.add("Orhan Bayar");
        studentsInClassB.add("Berkehan Aydoğdu");

        studentsInClassC.add("Ada Yiğit");
        studentsInClassC.add("Alkan Deniz");
        studentsInClassC.add("Alparslan Uzun");
        studentsInClassC.add("Kutay Öz");
        studentsInClassC.add("Altan Babacan");
        studentsInClassC.add("Arslan Korucu");
        studentsInClassC.add("Tuğçe Sağlam");


        Map<String, List<String>> students = new HashMap<>();
        students.put("A", studentsInClassA);
        students.put("B", studentsInClassB);
        students.put("C", studentsInClassC);

        students.forEach((key, value) -> {
            for (String student : value) {
                if (student.split(" ")[0].contains("an")) {
                    System.out.println(key + " sınıfından " + student + " isimli öğrencinin adı 'an' ile bitiyor.");
                }
            }
        });


    }
}