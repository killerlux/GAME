package Main;

import javax.swing.*;
public class Main {
    public static void main(String[] args) {

        JFrame fenetre = new JFrame();
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setResizable(false);
        fenetre.setTitle("Fils de Sparda");

        GamePanel Jeu= new GamePanel();
        fenetre.add(Jeu);

        fenetre.pack();

        fenetre.setLocationRelativeTo(null);
        fenetre.setVisible(true);

        Jeu.startThreadJeu();

    }
}