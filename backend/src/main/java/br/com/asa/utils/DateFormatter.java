package br.com.asa.utils;

public class DateFormatter {
    private DateFormatter() {}

    public static java.sql.Date convertDateObjectToDateSql() {
        java.util.Date now = new java.util.Date();
        return new java.sql.Date(now.getTime());
    }
}
