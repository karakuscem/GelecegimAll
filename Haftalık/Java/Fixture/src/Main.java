import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Team team1 = new Team("Galatasaray");
        Team team2 = new Team("Fenerbahçe");
        Team team3 = new Team("Beşiktaş");
        Team team4 = new Team("Trabzonspor");
        Team team5 = new Team("Başakşehir");
        Team team6 = new Team("Sivasspor");
        Team team7 = new Team("Alanyaspor");

        List<Team> teams = new ArrayList<>();
        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        teams.add(team4);
        teams.add(team5);
        teams.add(team6);
        teams.add(team7);

        Set<String> fixture = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        if (teams.size() % 2 != 0) {
            Team lastTeam = teams.get(teams.size() - 1);
            sb.append(lastTeam.getTeamName()).append(" vs ").append("Bay").append("\n");
            fixture.add(sb.toString());
            sb.setLength(0);
            sb.append("Bay").append(" vs ").append(lastTeam.getTeamName()).append("\n");
            fixture.add(sb.toString());
            sb.setLength(0);
            teams.remove(lastTeam);
        }

        for (Team team : teams) {
            for (Team value : teams) {
                if (team.getTeamName().equals(value.getTeamName())) {
                    continue;
                } else {
                    sb.append(team.getTeamName()).append(" vs ").append(value.getTeamName()).append("\n");
                    fixture.add(sb.toString());
                    sb.setLength(0);
                }
            }
        }

        for (String s : fixture) {
            System.out.println(s);
        }
    }
}