package As3_League;

public class As3_Team {
    private String name;
    private String city;
    private String proficiency;
    private int gamesWon;
    private int playersLost;
    private int mountainsVisited;

    public As3_Team(String n, String c, String p, int w, int l, int m){
        name = n;
        city = c;
        proficiency = p;
        gamesWon = w;
        playersLost = l;
        mountainsVisited = m;
    }

    public String toString(){
        return name + city + proficiency + gamesWon + playersLost + mountainsVisited;
    }

}
