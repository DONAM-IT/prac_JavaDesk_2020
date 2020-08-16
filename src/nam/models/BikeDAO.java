/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nam.models;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import nam.conns.MyConnection;
import nam.dtos.BikeDTO;

/**
 *
 * @author Đỗ Nam
 */
public class BikeDAO implements Serializable {

    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    public BikeDAO() {

    }

    private void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public List<BikeDTO> getBikeList() throws Exception {
        List<BikeDTO> result = null;
        String id;
        String name;
        String manu;
        String model;
        float price;
        String year;
        BikeDTO dto = null;
        try {
            String sql = "SELECT BikeID, BikeName, Manufacturer, Model, Price, ReleasedYear FROM Bike";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                id = rs.getString("BikeID");
                name = rs.getString("BikeName");
                manu = rs.getString("Manufacturer");
                model = rs.getString("Model");
                price = rs.getFloat("Price");
                year = rs.getString("ReleasedYear");
                dto = new BikeDTO(id, name, manu, model, price, year);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public BikeDTO findByPrimaryKey(String id) throws Exception {
        String name;
        String manu;
        String model;
        float price;
        String year;
        BikeDTO dto = null;
        try {

            String sql = "SELECT BikeID, BikeName, Manufacturer, Model, Price, ReleasedYear FROM Bike Where BikeID = ?";
            //1 va 2
            conn = (Connection) MyConnection.getMyConnection();
            //3
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            rs = preStm.executeQuery();
            //4
            if (rs.next()) {
                id = rs.getString("BikeID");
                name = rs.getString("BikeName");
                manu = rs.getString("Manufacturer");
                model = rs.getString("Model");
                price = rs.getFloat("Price");
                year = rs.getString("ReleasedYear");
                dto = new BikeDTO(id, name, manu, model, price, year);

            }

        } finally {
            //5
            closeConnection();
        }
        return dto;
    }
    
    public List<BikeDTO> findByName(String search) throws Exception {
        List<BikeDTO> result = null;
        String id;
        String name;
        String manu;
        String model;
        float price;
        String year;
        BikeDTO dto = null;
        try {

            String sql = "SELECT BikeID, BikeName, Manufacturer, Model, Price, ReleasedYear FROM Bike Where (BikeName like ?)";
            //1 va 2
            conn = (Connection) MyConnection.getMyConnection();
            //3
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            //4
            result = new ArrayList<>();
            while (rs.next()) {
                id = rs.getString("BikeID");
                name = rs.getString("BikeName");
                manu = rs.getString("Manufacturer");
                model = rs.getString("Model");
                price = rs.getFloat("Price");
                year = rs.getString("ReleasedYear");
                dto = new BikeDTO(id, name, manu, model, price, year);
                result.add(dto);
            }

        } finally {
            //5
            closeConnection();
        }
        return result;
    }

    public boolean insert(String id, String name, String manu, String model, float price, String year) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert Into Bike(BikeID, BikeName, Manufacturer, Model, Price, ReleasedYear) values(?,?,?,?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            preStm.setString(2, name);
            preStm.setString(3, manu);
            preStm.setString(4, model);
            preStm.setFloat(5, price);
            preStm.setString(6, year);

            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean delete(String id) throws Exception {
        boolean check = false;
        try {
            String sql = "Delete FROM Bike Where BikeID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean update(String id, String name, String manu, String model, float price, String year) throws Exception {
        boolean check = false;
        try {
            String sql = "Update Bike set BikeName = ?, Manufacturer = ?, Model = ?, Price = ?, ReleasedYear = ? where BikeID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, name);
            preStm.setString(2, manu);
            preStm.setString(3, model);
            preStm.setFloat(4, price);
            preStm.setString(5, year);
            preStm.setString(6, id);

            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

}
