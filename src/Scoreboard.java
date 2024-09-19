public class Scoreboard {
    private final String teamOneName;
    private final String teamTwoName;
    private boolean teamOneActive = true;
    private int scoreOne = 0;
    private int scoreTwo = 0;


    public Scoreboard(String teamOneName, String teamTwoName){
        this.teamOneName = teamOneName;
        this.teamTwoName = teamTwoName;
    }
    /*During a turn, a team makes one or
more plays. Each play can score one or more points and the team’s turn continues, or the play can fail, in
which case no points are scored and the team’s turn ends. The Scoreboard class, which you will write, is
used to keep track of the score in a game.
     */
    public void recordPlay(int pointsScored){
        if(pointsScored == 0){
            teamOneActive =!teamOneActive;
            return;
        }
        if(teamOneActive){
            scoreOne+=pointsScored;
        }else {
            scoreTwo+=pointsScored;
        }
    }

    public String getScore() {
        if(teamOneActive){
            return scoreOne+"-"+scoreTwo+"-"+teamOneName;
        }else {
            return scoreOne+"-"+scoreTwo+"-"+teamTwoName;
        }
    }
}
