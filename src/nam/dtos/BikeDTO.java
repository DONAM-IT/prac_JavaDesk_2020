/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nam.dtos;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author Đỗ Nam
 */
public class BikeDTO implements Serializable{
    private String BikeID;
    private String BikeName;
    private String Manufacturer;
    private String Model;
    private float Price;
    private String ReleasedYear;

    public BikeDTO() {
        
    }

    public BikeDTO(String BikeID, String BikeName, String Manufacturer, String Model, float Price, String ReleasedYear) {
        this.BikeID = BikeID;
        this.BikeName = BikeName;
        this.Manufacturer = Manufacturer;
        this.Model = Model;
        this.Price = Price;
        this.ReleasedYear = ReleasedYear;
    }

 
 
    
    public Vector toVector() {
        Vector v = new Vector();
        v.add(BikeID);
        v.add(BikeName);
        v.add(Manufacturer);
        v.add(Model);        
        v.add(Price);
        v.add(ReleasedYear);
        return v;
    }

    public String getBikeID() {
        return BikeID;
    }

    public void setBikeID(String BikeID) {
        this.BikeID = BikeID;
    }

    public String getBikeName() {
        return BikeName;
    }

    public void setBikeName(String BikeName) {
        this.BikeName = BikeName;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float Price) {
        this.Price = Price;
    }

    public String getManufacturer() {
        return Manufacturer;
    }

    public void setManufacturer(String Manufacturer) {
        this.Manufacturer = Manufacturer;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public String getReleasedYear() {
        return ReleasedYear;
    }

    public void setReleasedYear(String ReleasedYear) {
        this.ReleasedYear = ReleasedYear;
    }

    
}
