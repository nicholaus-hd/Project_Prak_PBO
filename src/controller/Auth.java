/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import dao.UserDAO;
import dao.UserDAOImpl;
import model.User;
/**
 *
 * @author lenovo
 */
public class Auth {
    private UserDAO dao;

    public Auth() {
        dao = new UserDAOImpl();
    }

    public User handleLogin(String username, String password) {

        if(username == null || password == null) {
            return null;
        }
        
        if(username.trim().isEmpty() || password.trim().isEmpty()) {
            return null;
        }   

        return dao.login(username.trim(), password.trim());
    }
    
    
}
