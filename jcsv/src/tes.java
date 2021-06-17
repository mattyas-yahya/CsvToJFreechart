import java.sql.*;

public class tes
{
public static void  main(String arx[])
{
    try {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://http://remotemysql.com:3306/s3JqbZDRh1";
        Connection conn = DriverManager.getConnection(url,"s3JqbZDRh1", "MNhAwz0Pnt");

//        Connection conn = DriverManager.getConnection(url, "s3JqbZDRh1", "MNhAwz0Pnt");
        String sql = "LOAD DATA INFILE 'C:\\Users\\rahmat.tri\\Documents\\department.csv' INTO TABLE departemen" +
                " CHARACTER  SET gb2312 FIELDS TERMINATED BY ','" +
                " optionally enclosed by '\"' escaped by '\"'  LINES TERMINATED BY '\\n' " +
                "ignore 1 lines  ( a2 , a1,a3 ,a4 ,a5 , a6 ,a7 ,a8 , a9 , a10 ,a11 , a12 , a13 , a14 ,a15)";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        System.out.println(sql);
        Boolean flag = false;
        int resNum = pstmt.executeUpdate();
        System.out.println(resNum);
        if (resNum == 1) {
            flag = true;
        }
        System.out.println(flag);
        pstmt.close();
        conn.close();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}
