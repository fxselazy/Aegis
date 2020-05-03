package lib;

import account.Account;
import courses.Courses;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import lib.model.LibraryDao;

public class CoursesDaoImp implements LibraryDao<Courses> {

    @Override
    public void insert(Courses obj) {
        String c = "INSERT INTO courses VALUES(?,?,?,?)";
        try (Connection conn = ConnectDB.getConnection();
                PreparedStatement pstm = conn.prepareStatement(c)) {
            pstm.setString(1, obj.getCourseCode());
            pstm.setString(2, obj.getSubject());
            pstm.setInt(3, obj.getCredits());
            pstm.setInt(4, obj.getCalCost());
            pstm.execute();
        } catch (SQLException sqlex) {
            java.util.logging.Logger.getLogger(CoursesDaoImp.class.getName()).log(Level.SEVERE, null, sqlex);
        }
    }

    @Override
    public void delete(Courses obj) {
        String c = "DELETE FROM courses  WHERE CCode = ?";
        try (Connection conn = ConnectDB.getConnection();
                PreparedStatement pstm = conn.prepareStatement(c)) {
            pstm.setString(1, obj.getCourseCode());
            pstm.execute();
        } catch (SQLException sqlex) {
            java.util.logging.Logger.getLogger(CoursesDaoImp.class.getName()).log(Level.SEVERE, null, sqlex);
        }
    }

    @Override
    public void update(Courses obj) {
        String c = "UPDATE courses SET CCode = ?, CName = ?, Credit = ?, Cost = ?";
        try (Connection conn = ConnectDB.getConnection();
                PreparedStatement pstm = conn.prepareStatement(c)) {
            pstm.setString(1, obj.getCourseCode());
            pstm.setString(2, obj.getSubject());
            pstm.setInt(3, obj.getCredits());
            pstm.setInt(4, obj.getCalCost());
            pstm.execute();
        } catch (SQLException sqlex) {
            java.util.logging.Logger.getLogger(CoursesDaoImp.class.getName()).log(Level.SEVERE, null, sqlex);
        }
    }

    @Override
    public Courses findById(String id) {
        Courses c = null;
        try (Connection conn = ConnectDB.getConnection(); Statement stm = conn.createStatement();) {
            ResultSet rs = stm.executeQuery("SELECT * FROM courses ");
            if (rs.next()) {
                c = new Courses(rs.getString(1), rs.getString(2), rs.getInt(3));
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(CoursesDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    @Override
    public ArrayList<Courses> getAll() {
        ArrayList<Courses> c = new ArrayList<Courses>();
        try (Connection conn = ConnectDB.getConnection(); Statement stm = conn.createStatement()) {
            ResultSet rs = stm.executeQuery("SELECT * FROM courses ");
            while (rs.next()) {
                c.add(new Courses(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(CoursesDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }

        return c;
    }
}
