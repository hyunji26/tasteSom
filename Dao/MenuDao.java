package Dao;

import java.sql.*;

import Dao.JDBCUtil;
public class MenuDao {
    private JDBCUtil jdbcUtil = null;

    public MenuDao() {
        jdbcUtil = new JDBCUtil();
    }

    // Insert Menu
    public int insertMenu(Menu menu) {
        String sql = "INSERT INTO Menu (menu_id, name, price, restaurant_id, owner_id) VALUES (?, ?, ?, ?, ?)";
        Object[] params = new Object[] {
            menu.getMenuId(),
            menu.getName(),
            menu.getPrice(),
            menu.getRestaurantId(),
            menu.getOwnerId()
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

    // Delete Menu
    public boolean deleteMenu(int menuId) {
        String sql = "DELETE FROM Menu WHERE menu_id = ?";
        Object[] params = { menuId };

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

    // Update Menu
    public boolean updateMenu(Menu menu) {
        String sql = "UPDATE Menu SET name = ?, price = ?, restaurant_id = ?, owner_id = ? WHERE menu_id = ?";
        Object[] params = new Object[] {
            menu.getName(),
            menu.getPrice(),
            menu.getRestaurantId(),
            menu.getOwnerId(),
            menu.getMenuId()
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

