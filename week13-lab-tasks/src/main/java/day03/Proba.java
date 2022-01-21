package day03;

public class Proba {
    public static void main(String[] args) {
        new ProbaInter() {
            public String getName() {
                return "name";
            }
        };
    }
}
