package org.prog.mysteps;

import io.cucumber.java.en.Given;
import org.prog.ProductDto.GoodsDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SqlSteps {
    public static List<GoodsDto> goods;

    @Given("Get products from DB")
    public void getProductFromDB() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "password");
        Statement stmt = con.createStatement();

        ResultSet sqlResults = stmt.executeQuery("SELECT * FROM RozetkaGoods");

        goods = new ArrayList<>();
        while (sqlResults.next()) {
            goods.add(GoodsDto
                    .builder()
                    .nameProduct(sqlResults.getString("NameProduct"))
                    .Price(sqlResults.getInt("Price"))
                    .URl(sqlResults.getString("URLProduct"))
                    .build());
        }
    }
}
