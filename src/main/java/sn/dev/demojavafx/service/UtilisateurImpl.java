package sn.dev.demojavafx.service;

import sn.dev.demojavafx.dao.DB;
import sn.dev.demojavafx.entity.Utilisateur;

import java.sql.ResultSet;

public class UtilisateurImpl implements  IUtilisateur{

    private DB db  = new DB();
    private ResultSet rs;

    @Override
    public Utilisateur seConnecter(String username, String password) {
        Utilisateur utilisateur = null;
        String sql = "SELECT * FROM utilisateur WHERE username = ? AND password = ?";
        try {
            db.initPrepar(sql);
            db.getPstm().setString(1, username);
            db.getPstm().setString(2, password);
            rs = db.executeSelect();
            if(rs.next()){
                utilisateur = new Utilisateur();
                utilisateur.setId(rs.getInt("id"));
                utilisateur.setUsername(rs.getString("username"));
                utilisateur.setPassword(rs.getString("password"));
                utilisateur.setNomComplet(rs.getString("nomComplet"));
            }
            db.closeConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        return utilisateur;
    }
}
