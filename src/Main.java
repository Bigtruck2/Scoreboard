import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/Scoreboard.txt");
        int[] score;
        HashMap<String,Integer> winingScores = new HashMap<>();

        System.out.println(file);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        }catch (FileNotFoundException ignored){
            System.err.println("wrong file");
        }
        Scoreboard game = null;
        do {
            assert scanner != null;
            if(!scanner.hasNextInt()){
                if(game!=null) {
                    score = game.getScores();
                    if(score[0] != score[1]) {
                        if (score[0] > score[1]) {
                            if (winingScores.containsKey(game.getTeamOneName()))
                                winingScores.put(game.getTeamOneName(), winingScores.get(game.getTeamOneName()) + 1);
                            winingScores.putIfAbsent(game.getTeamOneName(), 1);
                        } else {
                            if (winingScores.containsKey(game.getTeamTwoName()))
                                winingScores.put(game.getTeamTwoName(), winingScores.get(game.getTeamTwoName()) + 1);
                            winingScores.putIfAbsent(game.getTeamTwoName(), 1);
                        }
                    }
                }
                game = new Scoreboard(scanner.next(), scanner.next());

            }else {
                assert game != null;
                game.recordPlay(scanner.nextInt());
            }
        } while (scanner.hasNext());
        score = game.getScores();
        if(score[0] != score[1]) {
            if (score[0] > score[1]) {
                if (winingScores.containsKey(game.getTeamOneName()))
                    winingScores.put(game.getTeamOneName(), winingScores.get(game.getTeamOneName()));
                winingScores.putIfAbsent(game.getTeamOneName(), 1);
            } else {
                if (winingScores.containsKey(game.getTeamTwoName()))
                    winingScores.put(game.getTeamTwoName(), winingScores.get(game.getTeamTwoName()));
                winingScores.putIfAbsent(game.getTeamTwoName(), 1);
            }
        }
        System.out.println(winingScores);
        winingScores.values().stream().sorted(Comparator.reverseOrder()).forEach((i)->System.out.printf("Wins: %d Team: %s\n",i,winingScores.entrySet().stream().filter((entry)->entry.getValue().equals(i)).findFirst().orElse(null)));
    }
}