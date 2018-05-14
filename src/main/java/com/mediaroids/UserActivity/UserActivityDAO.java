package com.mediaroids.UserActivity;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UserActivityDAO {
    private DatabaseConnector DB;

    public UserActivityDAO() {
        this.DB = new DatabaseConnector();
    }

    public Boolean insertUserActivity(int userId, int contentId, String contentType, String actionType) {

        try {
            String sql = "INSERT INTO USER_ACTIVITY (userId, contentId, contentType, actionType) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = DB.getConn().prepareStatement(sql);
            stmt.setInt(1, userId);
            stmt.setInt(2, contentId);
            stmt.setString(3, contentType);
            stmt.setString(4, actionType);

            return stmt.executeUpdate(sql) > 0;



        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Something went Wrong
        return false;
    }


}
