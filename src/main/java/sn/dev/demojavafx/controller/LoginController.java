package sn.dev.demojavafx.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sn.dev.demojavafx.entity.Utilisateur;
import sn.dev.demojavafx.service.IUtilisateur;
import sn.dev.demojavafx.service.UtilisateurImpl;
import sn.dev.demojavafx.tools.Notification;
import sn.dev.demojavafx.tools.Outils;

import java.io.IOException;

public class LoginController {

    private IUtilisateur userDao = new UtilisateurImpl();

    @FXML
    private PasswordField passwordTfd;

    @FXML
    private TextField usernameTfd;

    @FXML
    void login(ActionEvent event) throws IOException {
        String username = usernameTfd.getText();
        String password = passwordTfd.getText();
        if (username.trim().equals("") || password.trim().equals("")) {
            Notification.NotifError("Echec !", "Tous les champs sont obligatoires !");
        } else {
            Utilisateur user = userDao.seConnecter(username, password);
            if (user != null) {
                Notification.NotifSuccess("Succés !", "Connexion réussie pour : " + user.getNomComplet());
                Outils.load(event, "Gestion des produits", "/pages/produit.fxml");
            } else {
                Notification.NotifError("Echec !", "Username et/ou Password incorrects !");
            }
        }
    }
}