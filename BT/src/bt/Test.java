/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bt;

//import com.sun.jdi.connect.spi.Connection;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Twin
 */
public class Test {
   public static void main(String[] args) throws SQLException {
    String dbURL = "jdbc:sqlserver://localhost;databaseName=QLSP;user=sa;password=sa";
    Connection conn = (Connection) DriverManager.getConnection(dbURL);
    Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select MaSP,TenSP,LoaiSanPham.TenLoaiSP from SanPham inner join "
                    + "LoaiSanPham on Sanpham.MaLoaiSP=LoaiSanPham.MaLoaiSP");
            System.out.printf("Danh sách sản phẩm:\n");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) 
                        + "  " + rs.getString(3));
    }
    Scanner sc=new Scanner(System.in);
    System.out.printf("Nhập mã loại sản phẩm:");
    String msp=sc.nextLine();
    System.out.printf("Nhập tên loại sản phẩm:");
    String ten=sc.nextLine();
    Statement stmt1 = conn.createStatement();
    stmt1.executeUpdate("insert into LoaiSanPham values('"+msp+"','"+ten+"')");
    System.out.printf("Danh sách loại sản phẩm:\n");
    Statement stmt2 = conn.createStatement();
    ResultSet rs2 = stmt2.executeQuery("select *from LoaiSanPham");
    while (rs2.next()) {
        System.out.println(rs2.getInt(1) + "  " + rs2.getString(2));
    }
  }
}
