package lib;

import account.Account;
import com.sun.istack.internal.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import lib.model.LibraryDao;

public class AccountDaoImp implements LibraryDao<Account> {

    @Override
    public void insert(Account obj) {
        String acc = "INSERT INTO account VALUES(?,?,?,?,?)";
        try (Connection conn = ConnectDB.getConnection();
                PreparedStatement pstm = conn.prepareStatement(acc)) {
            pstm.setLong(2, obj.getId());
            pstm.execute();
        } catch (SQLException sqlex) {
            java.util.logging.Logger.getLogger(AccountDaoImp.class.getName()).log(Level.SEVERE, null, sqlex);
        }
    }

    @Override
    public void delete(Account obj) {
        String acc = "DELETE from account ";
        try (Connection conn = ConnectDB.getConnection();
                PreparedStatement pstm = conn.prepareStatement(acc)) {
            pstm.setLong(2, obj.getId());
            pstm.execute();
        } catch (SQLException sqlex) {
            java.util.logging.Logger.getLogger(AccountDaoImp.class.getName()).log(Level.SEVERE, null, sqlex);
        }
    }

    @Override
    public void update(Account obj) {
        String acc = "UPDATE account ";
        try (Connection conn = ConnectDB.getConnection();
                PreparedStatement pstm = conn.prepareStatement(acc)) {
            pstm.setLong(2, obj.getId());
            pstm.execute();
        } catch (SQLException sqlex) {
            java.util.logging.Logger.getLogger(AccountDaoImp.class.getName()).log(Level.SEVERE, null, sqlex);
        }
    }

    @Override
    public Account findById(String id) {
        Account acc = null;
        try (Connection conn = ConnectDB.getConnection(); Statement stm = conn.createStatement();) {
            ResultSet rs = stm.executeQuery("SELECT * FROM accounts ");
            if (rs.next()) {
                acc = new Account();
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(AccountDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return acc;
    }

    @Override
    public ArrayList<Account> getAll() {
        ArrayList<Account> listacc = new ArrayList<Account>();
        try (Connection conn = ConnectDB.getConnection(); Statement stm = conn.createStatement()) {
            ResultSet rs = stm.executeQuery("SELECT * FROM accounts ");
            while (rs.next()) {
                listacc.add(new Account();
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(AccountDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

}
