/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import database.DatabaseConnection;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;

/**
 *
 * @author c0644881
 */
@Stateless
public class SearchData {

    private int id;
    private String name;
    private String address;
    private String phone;
    private String searchType;
    private String place;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getSearchData(String place) {
        
        try (Connection connection = DatabaseConnection.getConnection()) {
            StringWriter out = new StringWriter();
            JsonArrayBuilder jarray = Json.createArrayBuilder();
            String query = "SELECT * FROM search_data WHERE place like ? or type like ? or name like ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, place);
            pstmt.setString(2, "%" + place + "%");
            pstmt.setString(3, place + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                JsonObjectBuilder obj = Json.createObjectBuilder()
                        .add("id", rs.getInt("id"))
                        .add("name", rs.getString("name"))
                        .add("address", rs.getString("address"))
                        .add("phone", rs.getString("phone"))
                        .add("searchType", rs.getString("search_type"));
                jarray.add(obj);
            }
            return jarray.build().toString();

        } catch (SQLException ex) {
            System.out.println("Exception in getting database connection: " + ex.getMessage());
            return "failed";
        }

    }

    public String getSearchType(String place, String type) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            StringWriter out = new StringWriter();
            JsonArrayBuilder jarray = Json.createArrayBuilder();
            String query = "SELECT * FROM search_data WHERE search_type = ? AND place like ? or type like ? or name like ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, type);
            pstmt.setString(2, place);
            pstmt.setString(3, "%" + place + "%");
            pstmt.setString(4, place + "%");
            
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                JsonObjectBuilder obj = Json.createObjectBuilder()
                        .add("id", rs.getInt("id"))
                        .add("name", rs.getString("name"))
                        .add("address", rs.getString("address"))
                        .add("phone", rs.getString("phone"))
                        .add("searchType", rs.getString("search_type"));
                jarray.add(obj);
            }
            return jarray.build().toString();

        } catch (SQLException ex) {
            System.out.println("Exception in getting database connection: " + ex.getMessage());
            return "failed";
        }
    }
    
    
    public String getDetails(int id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            StringWriter out = new StringWriter();
            JsonArrayBuilder jarray = Json.createArrayBuilder();
            String query = "SELECT * FROM search_data WHERE place = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                JsonObjectBuilder obj = Json.createObjectBuilder()
                        .add("id", rs.getInt("id"))
                        .add("name", rs.getString("name"))
                        .add("address", rs.getString("address"))
                        .add("phone", rs.getString("phone"))
                        .add("searchType", rs.getString("search_type"));
                jarray.add(obj);
            }
            return jarray.build().toString();

        } catch (SQLException ex) {
            System.out.println("Exception in getting database connection: " + ex.getMessage());
            return "failed";
        }

    }

}
