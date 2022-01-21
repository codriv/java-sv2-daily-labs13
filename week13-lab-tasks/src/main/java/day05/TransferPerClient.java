package day05;

public class TransferPerClient {

    private String clientId;
    private int sum;
    private int numberOfTransactions;

    public TransferPerClient(String clientId) {
        this.clientId = clientId;
    }

    public void increase (int amount) {
        sum += amount;
        numberOfTransactions++;
    }

    public void decrease (int amount) {
        sum -= amount;
        numberOfTransactions++;
    }

    @Override
    public String toString() {
        return String.format("%s,%,12d,%4d", clientId, sum, numberOfTransactions);
    }
}