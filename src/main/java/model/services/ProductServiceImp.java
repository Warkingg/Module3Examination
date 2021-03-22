package model.services;

import JDBC.DBConnection;
import model.entities.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceImp implements IProductService{
    private static final String INSERT_NEW_PRODUCT = "INSERT INTO product(product_name,price,quantity,color,descriptions,category_name) VALUES (?,?,?,?,?,?);";
    private static final String DELETE_PRODUCT = "DELETE FROM product where product_id=?;";
    private static final String UPDATE_PRODUCT_SQL = "UPDATE product set product_name=?,price=?,quantity=?,color=?,descriptions=?,category_name=? where product_id=?;";
    private static final String SELECT_ALLPRODUCT = "SELECT * from product;";
    private static final String SELECTPRODUCT_BYID = "SELECT * from product WHERE product_id=?;";
    private static final String SEARCH_ALL_PRODUCT_BY_NAME="SELECT * FROM product where product_name like ?";
    @Override
    public void insertProduct(Product product) throws SQLException {
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_PRODUCT);
            preparedStatement.setString(1,product.getProduct_name());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setInt(3,product.getQuantity());
            preparedStatement.setString(4,product.getColor());
            preparedStatement.setString(5,product.getDescriptions());
            preparedStatement.setString(6,product.getCategory_name());
            preparedStatement.executeUpdate();
        }catch (SQLException ex){
            DBConnection.printSQLException(ex);
        }
    }


    @Override
    public Product selectProductById(int id) throws SQLException {
        Product product = null;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECTPRODUCT_BYID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                String productName = rs.getString("product_name");
                double productPrice = rs.getDouble("price");
                int productQuantity = rs.getInt("quantity");
                String productColor = rs.getString("color");
                String des = rs.getString("descriptions");
                String categoryName = rs.getString("category_name");
                product = new Product(id,productName,productPrice,productQuantity,productColor,des,categoryName);
            }
        }catch (SQLException ex){
            DBConnection.printSQLException(ex);
        }
        return product;
    }

    @Override
    public List<Product> selectAllProduct() throws SQLException {
        List<Product> list = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALLPRODUCT);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                int id = rs.getInt("product_id");
                String productName = rs.getString("product_name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String des = rs.getString("descriptions");
                String categoryName = rs.getString("category_name");
                list.add(new Product(id,productName,price,quantity,color,des,categoryName));
            }
        }catch (SQLException ex){
            DBConnection.printSQLException(ex);
        }
        return list;
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
        boolean delete = true;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT);
            preparedStatement.setInt(1,id);
            delete = preparedStatement.executeUpdate()>0;
        }catch (SQLException ex){
            DBConnection.printSQLException(ex);
        }
        return delete;
    }


    @Override
    public boolean updateProduct(Product product, int id) throws SQLException {
        boolean update = true;
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_SQL);
            preparedStatement.setString(1,product.getProduct_name());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setInt(3,product.getQuantity());
            preparedStatement.setString(4,product.getColor());
            preparedStatement.setString(5,product.getDescriptions());
            preparedStatement.setString(6,product.getCategory_name());
            preparedStatement.setInt(7,id);
            update = preparedStatement.executeUpdate()>0;
        }catch (SQLException ex){
            DBConnection.printSQLException(ex);
        }
        return update;
    }


    @Override
    public List<Product> searchProduct(String product_name) throws SQLException {
        List<Product> productList=new ArrayList<>();
        try(
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement=connection.prepareStatement(SEARCH_ALL_PRODUCT_BY_NAME);){
            product_name = "%"+product_name+"%";
            preparedStatement.setString(1,product_name);
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()){
                int productId = rs.getInt("id");
                String productName = rs.getString("product_name");
                double productPrice = rs.getDouble("price");
                int productQuantity = rs.getInt("quantity");
                String productColor = rs.getString("color");
                String des = rs.getString("descriptions");
                String categoryName = rs.getString("categoryname");
                productList.add(new Product(productId,productName,productPrice,productQuantity,productColor,des,categoryName));
            }
        }
        return productList;
    }
}
