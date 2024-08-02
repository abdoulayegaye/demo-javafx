package sn.dev.demojavafx.service;

import sn.dev.demojavafx.entity.Utilisateur;

public interface IUtilisateur {
    public Utilisateur seConnecter(String username, String password);
}
