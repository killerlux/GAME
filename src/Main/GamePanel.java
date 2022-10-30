package Main;

import javax.swing.JPanel;
import java.awt.*;

import java.awt.Color;


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


    ToucheClavier touche =new ToucheClavier();

    int AxeXPersonnage=100;

    int AxeYPersonnage=100;

    int VitessePersonnage=5;

    Thread ThreadJeu;
    public GamePanel() {
        this.setPreferredSize(new Dimension(Largeur,Hauteur));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(touche);
        this.setFocusable(true); // pour que GamePanel recoit la touche



    }


    public void startThreadJeu() {
        ThreadJeu = new Thread(this);
        ThreadJeu.start();
    }
    @Override
    public void run() {
        while(ThreadJeu!=null){
            System.out.println("boucle de jeu");
            maj();
            repaint();

        }

    }
    public void maj(){
        if(touche.hautActiv==true){
            AxeYPersonnage -= VitessePersonnage;
        }
        if(touche.basActiv==true){
            AxeYPersonnage += VitessePersonnage;

        }
        if(touche.droitActiv==true){
            AxeXPersonnage +=VitessePersonnage;

        }
        if(touche.gaucheActiv==true){
            AxeXPersonnage-=VitessePersonnage;

        }

    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D graphics2D =(Graphics2D) g;
        graphics2D.setColor(Color.red);
        graphics2D.fillOval(AxeXPersonnage,AxeYPersonnage,TailleCareau,TailleCareau);
        graphics2D.dispose();// libère ressources utilisées

    }
}
