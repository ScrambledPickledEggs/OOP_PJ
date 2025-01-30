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

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProficiency(String proficiency) {
        this.proficiency = proficiency;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public void setPlayersLost(int playersLost) {
        this.playersLost = playersLost;
    }

    public void setMountainsVisited(int mountainsVisited) {
        this.mountainsVisited = mountainsVisited;
    }
}
