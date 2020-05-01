package lib;

import account.Account;
import activity.Activity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import lib.model.LibraryDao;

public class ActivityDaoImp implements LibraryDao<Activity> {

    @Override
    public void insert(Activity obj) {
        String acc = "INSERT INTO activity VALUES(?,?,?,?,?)";
        try (Connection conn = ConnectDB.getConnection();
                PreparedStatement pstm = conn.prepareStatement(acc)) {
            pstm.setLong(2, obj.getHour());
            pstm.execute();
        } catch (SQLException sqlex) {
            java.util.logging.Logger.getLogger(ActivityDaoImp.class.getName()).log(Level.SEVERE, null, sqlex);
        }
    }

    @Override
    public void delete(Activity obj) {
        String acc = "DELETE from activity ";
        try (Connection conn = ConnectDB.getConnection();
                PreparedStatement pstm = conn.prepareStatement(acc)) {
            pstm.setLong(2, obj.getHour());
            pstm.execute();
        } catch (SQLException sqlex) {
            java.util.logging.Logger.getLogger(ActivityDaoImp.class.getName()).log(Level.SEVERE, null, sqlex);
        }
    }

    @Override
    public void update(Activity obj) {
        String acc = "UPDATE activity ";
        try (Connection conn = ConnectDB.getConnection();
                PreparedStatement pstm = conn.prepareStatement(acc)) {
            pstm.setLong(2, obj.getHour());
            pstm.execute();
        } catch (SQLException sqlex) {
            java.util.logging.Logger.getLogger(ActivityDaoImp.class.getName()).log(Level.SEVERE, null, sqlex);
        }
    }

    @Override
    public Activity findById(String id) {
        Activity act = null;
        try (Connection conn = ConnectDB.getConnection(); Statement stm = conn.createStatement();) {
            ResultSet rs = stm.executeQuery("SELECT * FROM activity ");
            if (rs.next()) {
                act = new Activity();
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ActivityDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return act;
    }

    @Override
    public ArrayList<Activity> getAll() {
        ArrayList<Activity> act = new ArrayList<Activity>();
        try (Connection conn = ConnectDB.getConnection(); Statement stm = conn.createStatement()) {
            ResultSet rs = stm.executeQuery("SELECT * FROM activity ");
            while (rs.next()) {
                act.add(new Activity();
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ActivityDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }

        return act;
    }

}
