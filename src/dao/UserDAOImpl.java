/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Admin;
import model.Resepsionis;
import model.User;
/**
 *
 * @author lenovo
 */
public class UserDAOImpl implements UserDAO{
    @Override
    public User login(String username, String password) {

        if(username.equals("admin") && password.equals("admin123")) {
            return new Admin(username, password);
        }

        if(username.equals("resepsionis") && password.equals("res123")) {
            return new Resepsionis(username, password);
        }

        return null;
    }
}
