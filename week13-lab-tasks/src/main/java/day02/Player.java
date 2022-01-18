package day02;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Player implements Comparable<Player> {

    private String code;
    private List<String> answers = new ArrayList<>();
    private int points = 0;

    public Player(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void addPoint(int point) {
        this.points += point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return code.equals(player.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public int compareTo(Player o) {
        return points - o.points;
    }
}
