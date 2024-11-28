package Dao;

import java.sql.*;

import Dao.JDBCUtil;

public class RestaurantDao {
    private JDBCUtil jdbcUtil = null;

    public RestaurantDao() {
        jdbcUtil = new JDBCUtil();
    }

    // Insert Restaurant
    public int insertRestaurant(Restaurant restaurant) {
        String sql = "INSERT INTO Restaurant (restaurant_id, name, location, owner_id, rating) VALUES (?, ?, ?, ?, ?)";
        Object[] params = new Object[] {
            restaurant.getRestaurantId(),
            restaurant.getName(),
            restaurant.getLocation(),
            restaurant.getOwnerId(),
            restaurant.getRating()
        };

        jdbcUtil.setSqlAndParameters(sql, params);
        try {
            jdbcUtil.executeUpdate();
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close();
        }
        return 0;
    }

    // Delete Restaurant
    public boolean deleteRestaurant(int restaurantId) {
        String sql = "DELETE FROM Restaurant WHERE restaurant_id = ?";
        Object[] params = { restaurantId };

        jdbcUtil.setSqlAndParameters(sql, params);
        try {
            jdbcUtil.executeUpdate();
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close();
        }
        return 0;
    }

    // Update Restaurant
    public boolean updateRestaurant(Restaurant restaurant) {
        String sql = "UPDATE Restaurant SET name = ?, location = ?, owner_id = ?, rating = ? WHERE restaurant_id = ?";
        Object[] params = {
            restaurant.getName(),
            restaurant.getLocation(),
            restaurant.getOwnerId(),
            restaurant.getRating(),
            restaurant.getRestaurantId()
        };

        jdbcUtil.setSqlAndParameters(sql, params);
        try {
            jdbcUtil.executeUpdate();
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close();
        }
        return 0;
    }
}