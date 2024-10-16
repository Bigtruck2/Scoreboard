import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/Scoreboard.txt");
        int[] wins;
        HashMap<Integer,String> winingScores = new HashMap<>();

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
                    wins = game.getWins();
                    if (wins[0] > wins[1]) {
                        winingScores.put(wins[0], game.getTeamOneName());
                    } else {
                        winingScores.put(wins[1],game.getTeamTwoName());
                    }
                }
                game = new Scoreboard(scanner.next(), scanner.next());

            }else {
                assert game != null;
                game.recordPlay(scanner.nextInt());
            }
        } while (scanner.hasNext());
        wins = game.getWins();
        if (wins[0] > wins[1]) {
            winingScores.put(wins[0],game.getTeamOneName());
        } else {
            winingScores.put(wins[1],game.getTeamTwoName());
        }


        sort(winingScores);
    }
    public static void sort(HashMap<Integer, String> winingScores){
        while (!winingScores.isEmpty()) {
            Map.Entry<Integer, String> max= Map.entry(0, "");
            for (Map.Entry<Integer, String> i : winingScores.entrySet()) {
                if(i.getKey()>max.getKey()){
                    max = i;
                }
            }
            System.out.println(max);
            winingScores.remove(max.getKey(),max.getValue());
        }
    }
}