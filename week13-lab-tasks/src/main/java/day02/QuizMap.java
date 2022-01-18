
package day02;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class QuizMap {

    private Path path;
    private Map<String, List<String>> players = new HashMap<>();
    private List<String> solutions;

    public QuizMap(String path) {
        this.path = Path.of(path);
        readFile();
    }

    public Map<String, List<String>> getPlayers() {
        return players;
    }

    public void readFile() {
        try(Scanner scanner = new Scanner(path)) {
            solutions = Arrays.asList(scanner.nextLine().split(""));
            while (scanner.hasNextLine()) {
                addAnswer(scanner.nextLine());
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void addAnswer(String line) {
        String[] parts = line.split(" ");
        String code = parts[0];
        String answer = parts[1];
        if (!players.containsKey(code)) {
            players.put(code, new ArrayList<>());
        }
        players.get(code).add(answer);
    }

    public boolean isRightAnswer(String code, int numberOfQuestion) {
        return players.get(code).get(numberOfQuestion - 1).equals(solutions.get(numberOfQuestion - 1));
    }

    public String getWinner() {
        int max = Integer.MIN_VALUE;
        String winner = null;
        for (Map.Entry<String, List<String>> entry: players.entrySet()) {
            int points = getSumOfPoints(entry.getKey(), entry.getValue());
            if (points > max) {
                max = points;
                winner = entry.getKey();
            }
        }
        return winner;
    }

    private int getSumOfPoints(String code, List<String> answers) {
        int sum = 0;
        for (int i = 0; i < answers.size(); i++) {
            sum += getPoint(code, i);
        }
        return sum;
    }

    private int getPoint(String code, int i) {
        int point;
        if (isRightAnswer(code, i + 1)){
            point = i + 1;
        } else if (players.get(code).get(i).equals("X")) {
            point = 0;
        } else {
            point = -2;
        }
        return point;
    }
}