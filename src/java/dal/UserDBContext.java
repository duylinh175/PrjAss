/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entity.PermissionDirect;
import entity.accesscontrol.Feature;
import entity.accesscontrol.Role;
import entity.accesscontrol.User;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sonnt-local
 */
public class UserDBContext extends DBContext<User> {

    public User getPermissionDirect(String username) {
        String sql = "SELECT f.FeatureName, f.url FROM [User] u\n"
                + "                	INNER JOIN UserRole ur ON ur.UserName = u.UserName\n"
                + "                	INNER JOIN [Role] r ON r.RoleID = ur.RoleID\n"
                + "			INNER JOIN RoleFeature rf ON r.RoleID = rf.RoleID\n"
                + "                	INNER JOIN Feature f ON f.FeatureID = rf.FeatureID\n"
                + "                WHERE u.UserName = ?\n"
                + "                ORDER BY r.RoleID, f.FeatureID ASC";
        User user = new User();
        ArrayList<PermissionDirect> list = new ArrayList<>();
        try {
            PreparedStatement stm  = connection.prepareStatement(sql);
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new PermissionDirect(rs.getString(1), rs.getString(2)));
            }
            user.setPermisson(list);
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    public User get(String username, String password) {
        //encoding username / password
        String sql = "SELECT UserName, displayname FROM [User] \n"
                + "WHERE UserName = ? AND [password] = ?";
        PreparedStatement stm = null;
        User user = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setDisplayname(rs.getString("displayname"));
                user.setUsername(username);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stm.close();
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return user;
    }

    @Override
    public void insert(User entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(User entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(User entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<User> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public User get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
