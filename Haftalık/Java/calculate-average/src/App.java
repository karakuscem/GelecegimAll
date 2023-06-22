import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int totalScore = 0;
        int average = 0;
        String[] lessons = {"Math", "Physic", "Chemistry", "Turkish", "History", "Music"};
        for (int i = 0; i < lessons.length; i++)
        {
            System.out.println("Enter your %s score.\n".formatted(lessons[i]));
            totalScore += input.nextInt();
        }
        average = totalScore / lessons.length;
        String result = average >= 60 ? "Success.\n" : "Failure.\n";
        System.out.println(result);
        input.close();
    }
}
