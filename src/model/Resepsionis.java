/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author lenovo
 */
public class Resepsionis extends User{
    public Resepsionis(String username, String password) {
        super(username, password);
    }

    // Override method getRole() dari User (Polymorphism)
    @Override
    public String getRole() {
        return "Resepsionis";
    }
    @Override public javax.swing.JFrame getDashboardFrame() { 
        return new view.ResepsionisFrame(this); 
    }
    @Override public boolean canEditDatabase() { 
        return false; 
    }
}
