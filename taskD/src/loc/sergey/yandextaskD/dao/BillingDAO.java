package loc.sergey.yandextaskD.dao;

import loc.sergey.yandextaskD.entity.Billing;

import java.io.IOException;

public class BillingDAO extends DAO {

    public BillingDAO(String fn) throws IOException {
        super(fn);
    }

    public Billing getNextEntity() throws IOException {
        if ((row = br.readLine()) != null && row.length() != 0) {
            columns = row.split(",");
            return new Billing(Long.parseLong(columns[0]), Long.parseLong(columns[1]), Long.parseLong(columns[2]));
        } else
            return null;
    }
}
