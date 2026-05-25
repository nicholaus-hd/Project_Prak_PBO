/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;
import model.User;
/**
 *
 * @author lenovo
 */
public interface UserDAO {
    User login(String username, String password);
}
