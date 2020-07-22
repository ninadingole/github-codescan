package com.sample;

import java.sql.SQLException;
import java.util.List;

public class App {
    public static void main(String[] args) throws SQLException {
        SQLInjectionSample c = new SQLInjectionSample();
        List<AccountDTO> accountDTOS = c.unsafeFind("1");
        System.out.println(accountDTOS);

    }
}
