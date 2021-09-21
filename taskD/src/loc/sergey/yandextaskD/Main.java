package loc.sergey.yandextaskD;

import loc.sergey.yandextaskD.dao.BillingDAO;
import loc.sergey.yandextaskD.dao.MarketDAO;
import loc.sergey.yandextaskD.entity.Billing;
import loc.sergey.yandextaskD.entity.Market;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        String line;

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
            StringTokenizer tk;

            line = br.readLine();
            tk = new StringTokenizer(line);

            MarketDAO marketDAO = new MarketDAO(tk.nextToken());
            BillingDAO billingDAO = new BillingDAO(tk.nextToken());

            // Close file input
            br.close();

            joinEntity(marketDAO, billingDAO);

        }
        catch (IOException e) {
            System.out.println(e.getMessage());

        }
    }

    private static void joinEntity(MarketDAO marketDAO, BillingDAO billingDAO) throws IOException {
        Market m = marketDAO.getNextEntity();
        Billing b = billingDAO.getNextEntity();

        // Out header
        System.out.println("order_id,shop_name,shop_id,cost");

        while (m != null && b != null) {
            if (m.getShopId() == b.getShopId()) {
                // Out
                System.out.printf("%d,%s,%d,%d%n", b.getOrderId(), m.getShopName(), m.getShopId(), b.getCost());
                b = billingDAO.getNextEntity();
            } else {

                if (m.getShopId() < b.getShopId()) {
                    m = marketDAO.getNextEntity();
                } else {
                    b = billingDAO.getNextEntity();
                }
            }
        }
    }
}
