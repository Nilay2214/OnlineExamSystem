package com.exam.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.exam.util.DBUtil;

public class TestDB {
    public static void main(String[] args) {

        try (Connection con = DBUtil.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM users")) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt(1) + " " +    // first column
                        rs.getString(2)          // second column
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
