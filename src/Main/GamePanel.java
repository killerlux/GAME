package Main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    // SCREEN SETTINGS
    private final int TailleCareau = 16; // On choisit 16x16 car nous allons utiliser des images(personnages,objets) qui font cette taille là
    private final int echelle = 4; // leur taille de 16 sera multipliée par echelle

    private final int TailleCarreauGrille = TailleCareau * echelle; // la taille de chaque carreau de la grille sera de 16*4
    private final int AxeY = 18;
    private final int AxeX = 14;


    // Window mode
    private final int Largeur = TailleCarreauGrille * AxeY; // 864 px
    private final int Hauteur = TailleCarreauGrille * AxeX; // 576 px


    Thread ThreadJeu;
    public GamePanel() {
        this.setPreferredSize(new Dimension(Largeur,Hauteur));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
    }


    public void startThreadJeu() {
        ThreadJeu = new Thread(this);
        ThreadJeu.start();
    }
    @Override
    public void run() {
        while(ThreadJeu!=null){
            System.out.println("boucle de jeu");

        }

    }
}
