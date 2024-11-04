import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        File file = new File("src/Scoreboard.txt");
        HashMap<String,Integer> teams = new HashMap<>();
        Scanner scanner = new Scanner(file);
        Scoreboard game = null;
        do {
            if(!scanner.hasNextInt()){
                if(game!=null) {
                   incrementWinner(game,teams);
                }
                game = new Scoreboard(scanner.next(), scanner.next());
            }else {
                assert game != null;
                game.recordPlay(scanner.nextInt());
            }
        } while (scanner.hasNext());
        incrementWinner(game,teams);
        System.out.println(teams);
        teams.values().stream().sorted(Comparator.reverseOrder())
        .forEach((i)->System.out.printf("Wins: %d Team: %s\n",i, Objects.requireNonNull(teams.entrySet().stream()
        .filter((entry) -> entry.getValue()==i).findFirst().orElse(null)).getKey()));
    }
public static void incrementWinner( Scoreboard game, HashMap<String,Integer> teams){
    int[] score = game.getScores();
    if(score[0] != score[1]) {
        if (score[0] > score[1]) {
            if (teams.containsKey(game.getTeamOneName()))
                teams.put(game.getTeamOneName(), teams.get(game.getTeamOneName()) + 1);
            teams.putIfAbsent(game.getTeamOneName(), 1);
        } else {
            if (teams.containsKey(game.getTeamTwoName()))
                teams.put(game.getTeamTwoName(), teams.get(game.getTeamTwoName()) + 1);
            teams.putIfAbsent(game.getTeamTwoName(), 1);
        }
    }
}
}