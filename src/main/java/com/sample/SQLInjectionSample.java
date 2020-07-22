package com.sample;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLInjectionSample {

    DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<AccountDTO>
    unsafeFind(String customerId)
            throws SQLException {
        List<AccountDTO> accountDTOS = new ArrayList<>();
        String sql = "select "
                + "customer_id,acc_number,branch_id,balance "
                + "from Accounts where customer_id = '"
                + customerId
                + "'";
        Connection c = dataSource.getConnection();
        ResultSet rs = c.createStatement().executeQuery(sql);
        while(rs.next()) {
            accountDTOS.add(new AccountDTO());
        }
        return accountDTOS;
    }

}
