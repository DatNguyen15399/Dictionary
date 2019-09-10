package com.nguyenDat.DataDictionary;

import com.nguyenDat.PaneHome.PaneHome;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataDictionarySQL {
    private static Connection con;
    private static PreparedStatement pstm;

    public DataDictionarySQL() {
        con = getConnectionSQL.getConnection();
    }

    public static String SearchAnhViet(String w) {
        String sql;
        if(PaneHome.AnhViet)
            sql = "select detail from AnhViet where word = ?";
        else{
            sql ="select detail from VietAnh where word = ?";
        }
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, w);

            ResultSet rs = pstm.executeQuery();
            String mean = null;
            while (rs.next()) {
                mean = rs.getString("detail");
            }
            return mean;
        } catch (java.sql.SQLException e) {
            System.out.println(e);
        }
        return null;

    }
    public static String[] ListWord(String word) {
        String sql;
        if(PaneHome.AnhViet)
            sql = "SELECT word FROM AnhViet WHERE word  LIKE ?";
        else{
            sql ="SELECT word FROM VietAnh WHERE word  LIKE ?";
        }
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, word + "%");
            ResultSet rs = pstm.executeQuery();
            String mean[] = new String[201];
            mean[0] = SearchAnhViet(word);
            int i = 0;
            if(mean[0] != null){
                mean[0] = word;
                i= 1;
            }

            while (rs.next()) {
                mean[i] = rs.getString("word");
                if(mean[i].equals(word)) continue;
                i++;
                if (i > 200) return mean;
            }
            if (i < 200) {
                String[] mean2 = new String[i];
                for (int j = 0; j < i; j++) {
                    mean2[j] = mean[j];
                }
                return mean2;
            }
            return mean;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public static void DeleteWord(String word) {
        String sql;
        if(PaneHome.AnhViet)
            sql = "delete from AnhViet where word = ?";
        else{
            sql ="delete from VietAnh where word = ?";
        }
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, word);
            pstm.executeUpdate();

        } catch (java.sql.SQLException e) {
            System.out.println(e);
        }
    }

    public static void UpdateWord(String oldWord, String word, String mean) {
        String sql;
        if(PaneHome.AnhViet)
            sql = "update AnhViet set word = ?,detail = ? where word = ?";
        else{
            sql ="update VietAnh set word = ?,detail = ? where word = ?";
        }
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, word);
            pstm.setString(2, mean);
            pstm.setString(3, oldWord);
            pstm.executeUpdate();
        } catch (java.sql.SQLException e) {
            System.out.println(e);
        }
    }

    public static void addWord(String word, String mean) {
        String sql;
        if(PaneHome.AnhViet)
            sql = "insert into AnhViet(word,detail) values (?,?)";
        else{
            sql ="insert into VietAnh(word,detail) values (?,?)";
        }
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, word);
            pstm.setString(2, mean);
            pstm.executeUpdate();
        } catch (java.sql.SQLException e) {
            System.out.println(e);
        }
    }
    public static String RecentWord(boolean AnhViet) {
        String sql;
        if(AnhViet)
            sql = "select word from RecentWordE where id = 1";
        else{
            sql ="select word from RecentWordV where id = 1";
        }
        try {
            pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            String mean = null;
            while (rs.next()) {
                mean = rs.getString("word");
            }
            return  mean;
        } catch (java.sql.SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    public static void UpdateRecent(String lis,boolean AnhViet) {
        String sql;
        if(AnhViet)
            sql = "update RecentWordE set word = ? where id = 1";
        else{
            sql ="update RecentWordV set word = ? where id = 1";
        }
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1,lis);
            pstm.executeUpdate();
        } catch (java.sql.SQLException e) {
            System.out.println(e);
        }
    }
}
