package day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Quiz {

    private List<Player> players = new ArrayList<>();
    private Path path;
    private List<String> solutions;

    public Quiz(Path path) {
        this.path = path;
        fillPlayers();
    }

    public List<String> readFile() {
        List<String> fileContent = null;
        try {
            fileContent = Files.readAllLines(path);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        solutions = Arrays.asList(fileContent.get(0).split(""));
        return fileContent;
    }

    public void fillPlayers() {
        List <String> fileContent = readFile();
        for (int i = 1; i < fileContent.size(); i++) {
            String parts[] = fileContent.get(i).split(" ");
            String code = parts[0];
            String answer = parts[1];
            if (findPlayerByCode(code) == null) {
                players.add(new Player(code));
            }
            findPlayerByCode(code).getAnswers().add(answer);
        }
        setPoints();
    }

    private Player findPlayerByCode(String code) {
        for (Player player: players) {
            if (code.equals(player.getCode())) {
                return player;
            }
        }
        return null;
    }

    private void setPoints() {
        for (Player player: players) {
            for (int i = 0; i < player.getAnswers().size(); i++) {
                player.addPoint(getPoint(player, i));
            }
        }
    }

    private int getPoint(Player player, int i) {
        int point;
        if (player.getAnswers().get(i).equals(solutions.get(i))) {
            point = i + 1;
        } else if (player.getAnswers().get(i).equals("X")) {
            point = 0;
        } else {
            point = -2;
        }
        return point;
    }

    public boolean isRightAnswer(String code, int numberOfQuestion) {
        return findPlayerByCode(code).getAnswers().get(numberOfQuestion - 1).equals(solutions.get(numberOfQuestion - 1));
    }

    public String winner() {
        Collections.sort(players);
        return players.get(players.size() - 1).getCode();
    }
}