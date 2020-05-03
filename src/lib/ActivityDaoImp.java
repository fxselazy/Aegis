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
        String act = "INSERT INTO activity VALUES(?,?,?)";
        try (Connection conn = ConnectDB.getConnection();
                PreparedStatement pstm = conn.prepareStatement(act)) {
            pstm.setString(1, obj.getCodeAct());
            pstm.setString(2, obj.getNameOfActivity());
            pstm.setInt(3, obj.getHour());
            pstm.execute();
        } catch (SQLException sqlex) {
            java.util.logging.Logger.getLogger(ActivityDaoImp.class.getName()).log(Level.SEVERE, null, sqlex);
        }
    }

    @Override
    public void delete(Activity obj) {
        String act = "DELETE FROM activity WHERE ACode = ? ";
        try (Connection conn = ConnectDB.getConnection();
                PreparedStatement pstm = conn.prepareStatement(act)) {
            pstm.setString(1, obj.getCodeAct());
            pstm.execute();
        } catch (SQLException sqlex) {
            java.util.logging.Logger.getLogger(ActivityDaoImp.class.getName()).log(Level.SEVERE, null, sqlex);
        }
    }

    @Override
    public void update(Activity obj) {
        String act = "UPDATE activity SET ACode = ?, AName = ?,AHour = ?";
        try (Connection conn = ConnectDB.getConnection();
                PreparedStatement pstm = conn.prepareStatement(act)) {
            pstm.setString(1, obj.getCodeAct());
            pstm.setString(2, obj.getNameOfActivity());
            pstm.setInt(3, obj.getHour());
            pstm.execute();
        } catch (SQLException sqlex) {
            java.util.logging.Logger.getLogger(ActivityDaoImp.class.getName()).log(Level.SEVERE, null, sqlex);
        }
    }

    @Override
    public Activity findById(int acode) {
        Activity act = null;
        try (Connection conn = ConnectDB.getConnection(); Statement stm = conn.createStatement();) {
            ResultSet rs = stm.executeQuery("SELECT * FROM activity ");
            if (rs.next()) {
                act = new Activity(rs.getString(1), rs.getString(2), rs.getInt(3));
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
                act.add(new Activity(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ActivityDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }

        return act;
    }

}
