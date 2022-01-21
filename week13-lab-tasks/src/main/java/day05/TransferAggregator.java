package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class TransferAggregator {


    public List<TransferPerClient> readTransfer(Path path) {
        Map<String, TransferPerClient> sumPerClient = new TreeMap<>();
        for (String line : readLines(path)) {
            String[] parts = line.split(",");
            String source = parts[0];
            String dest = parts[1];
            int amount = Integer.parseInt(parts[2]);
            findOrInsert(sumPerClient, source).increase(amount);
            findOrInsert(sumPerClient, dest).decrease(amount);
        }
        return getTpcs(sumPerClient);
    }

    private List<TransferPerClient> getTpcs(Map<String, TransferPerClient> sumPerClient) {
        List<TransferPerClient> tpcs = new ArrayList<>();
        for (Map.Entry<String, TransferPerClient> entry: sumPerClient.entrySet()) {
            tpcs.add(entry.getValue());
        }
        return tpcs;
    }

    private TransferPerClient findOrInsert(Map<String, TransferPerClient> sumPerClient, String id) {
        TransferPerClient client;
        if (findTransferPerClientById(sumPerClient, id) == null) {
            client = new TransferPerClient(id);
        } else {
            client = findTransferPerClientById(sumPerClient, id);
        }
        sumPerClient.put(id, client);
        return client;
    }

    public TransferPerClient findTransferPerClientById(Map<String, TransferPerClient> sumPerClient, String id) {
        for (Map.Entry<String, TransferPerClient> entry: sumPerClient.entrySet()) {
            if (id.equals(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }

    private List<String> readLines(Path path) {
        List<String> transfers = null;
        try {
            transfers = Files.readAllLines(path);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return transfers;
    }

    public static void main(String[] args) {
        TransferAggregator ta = new TransferAggregator();
            int num = 1;
            for (TransferPerClient tp: ta.readTransfer(Path.of("src/main/resources/transfers.csv"))) {
                System.out.printf("%3d. %s\n", num++, tp);
            }
    }
}