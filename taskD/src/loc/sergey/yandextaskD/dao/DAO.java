package loc.sergey.yandextaskD.dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class DAO {
    BufferedReader br;
    String row;
    String[] columns;

    public DAO(String fn) throws IOException {
        this.br = new BufferedReader(new InputStreamReader(new FileInputStream(fn)));
        this.row = br.readLine();  // Skip header
    }
}
