package loc.sergey.yandextaskD.dao;

import loc.sergey.yandextaskD.entity.Market;

import java.io.IOException;

public class MarketDAO extends DAO {

    public MarketDAO(String fn) throws IOException {
        super(fn);
    }

    public Market getNextEntity() throws IOException {
        if ((row = br.readLine()) != null && row.length() != 0) {
            columns = row.split(",");
            return new Market(Long.parseLong(columns[0]), columns[1]);
        } else
            return null;
    }
}
