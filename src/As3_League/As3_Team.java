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

    public void printMe(){
        System.out.println("City & Team name: " + city + " " + name + ". Proficiency level: " + proficiency + ". Games won: " + gamesWon + ". Players who have perished: " + playersLost + ". Mountains visited: " + mountainsVisited);
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getProficiency() {
        return proficiency;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public int getPlayersLost() {
        return playersLost;
    }

    public int getMountainsVisited() {
        return mountainsVisited;
    }

}
