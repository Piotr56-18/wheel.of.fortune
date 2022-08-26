package service.player.data;

public class Player {
    private String name;
    private int score;

    public Player (){};

    public Player(String name) {
        this.score = 0;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
