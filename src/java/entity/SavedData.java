/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import database.DatabaseConnection;
import java.io.StringReader;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.json.stream.JsonParser;

/**
 *
 * @author c0644881
 */
@Stateless
public class SavedData {

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

    public String getSavedData(String place) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            StringWriter out = new StringWriter();
            JsonArrayBuilder jarray = Json.createArrayBuilder();
            String query = "SELECT * FROM saved_data where place like ? or type like ? or name like ?";
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

    public String getsavedType(String place, String type) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            StringWriter out = new StringWriter();
            JsonArrayBuilder jarray = Json.createArrayBuilder();
            String query = "SELECT * FROM saved_data WHERE search_type = ? AND (place like ? or type like ? or name like ?)";
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

//    public String addData(String str) {
//        JsonParser parser = Json.createParser(new StringReader(str));
//        Map<String, String> map = new HashMap<>();
//        String name = "";
//        String value;
//        while (parser.hasNext()) {
//            JsonParser.Event evt = parser.next();
//            switch (evt) {
//                case KEY_NAME:
//                    name = parser.getString();
//                    break;
//                case VALUE_STRING:
//                    value = parser.getString();
//                    map.put(name, value);
//                    break;
//                case VALUE_NUMBER:
//                    value = Integer.toString(parser.getInt());
//                    map.put(name, value);
//                    break;
//            }
//        }
//        int changes = 0;
//
//        try (Connection connection = DatabaseConnection.getConnection()) {
//            String query = "INSERT INTO saved_data (name, address, phone,search_type,place) VALUES (?, ?, ?, ? ,? )";
//            PreparedStatement pstmt = connection.prepareStatement(query);
//            pstmt.setString(1, map.get("name"));
//            pstmt.setString(2, map.get("address"));
//            pstmt.setString(3, map.get("phone"));
//            pstmt.setString(4, map.get("searchType"));
//            pstmt.setString(5, map.get("place"));
//            changes = pstmt.executeUpdate();
//            if (changes == 0) {
//                return "failed";
//            } else {
//                return "success";
//            }
//
//        } catch (SQLException ex) {
//            System.out.println("Sql Exception: " + ex.getMessage());
//            return "failed";
//        }
//
//    }

    public String delete(String id) {
        
        String query = "delete from saved_data where id = ?";
        int numChanges = 0;
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, id);
            numChanges = pstmt.executeUpdate();
            if (numChanges > 0) {
                return "Deleted";
            } else {
                
                return "failed to delete";
            }

        } catch (SQLException ex) {
           
            System.out.println("Sql Exception: " + ex.getMessage());
            return "failed";
        }

    }
    
        
    public String addData(String id) {
        System.out.println("hellooooo....." + id);
        
       int changes = 0;
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO saved_data (name, address, phone,search_type,place,type) select name,address,phone,search_type,place,type from search_data where id = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, id);
           
            changes = pstmt.executeUpdate();
            if (changes == 0) {
                 System.out.println("heloooooooooooooooooooooooooooooooooooo");
                return "failed";
            } else {
                return "success";
            }

        } catch (SQLException ex) {
             System.out.println("hexxxxxxxxxxxxxxxxxxxxxxxxooo");
            System.out.println("Sql Exception: " + ex.getMessage());
            return "failed";
        }

    }

   

}
