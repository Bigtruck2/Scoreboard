public class Scoreboard {
    private final String teamOneName,teamTwoName;
    private boolean teamOneActive = true;
    private final int[] scores = {0,0};
    public Scoreboard(String teamOneName, String teamTwoName){
        this.teamOneName = teamOneName;
        this.teamTwoName = teamTwoName;
    }
    public void recordPlay(int pointsScored){
        if(pointsScored == 0){
            teamOneActive =! teamOneActive;
            return;
        }
        scores[teamOneActive ? 0 : 1] += pointsScored;
    }
    public int[] getScores() {
        return scores;
    }
    public String getTeamOneName() {
        return teamOneName;
    }
    public String getTeamTwoName() {
        return teamTwoName;
    }
    public String getScore() {
        return scores[0]+"-"+scores[1]+"-"+(teamOneActive ? teamOneName : teamTwoName);
    }
}
