package main.java;

import java.sql.*;
import java.sql.Driver;

public enum PostgresqlProperties {
    DB_DRIVER("org.postgresql.Driver"),
    DB_CONNECTION("jdbc:postgresql://127.0.0.1:5432/ShopTom"),
    DB_USER("postgres"),
    DB_PASSWORD("Klose.4040");

    private final String value;
    private PostgresqlProperties(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
