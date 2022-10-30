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


    private final int FPS = 60; //images par seconde




    // Window mode
    private final int Largeur = TailleCarreauGrille * AxeY; // 864 px
    private final int Hauteur = TailleCarreauGrille * AxeX; // 576 px


    ToucheClavier touche =new ToucheClavier();

    int AxeXPersonnage=100;

    int AxeYPersonnage=100;

    int VitessePersonnage=3;

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
        double ecart = 1_000_000_000 / FPS; // une seconde = 1 000 000 000 nanosecondes et 1sec/60 = 1 itération de boucle de jeu
        double x = 0;
        long dernierTempsCapture = System.nanoTime();
        long TempsActuel;
        long compteur=0;
        int compteur2=0;


        while(ThreadJeu!=null){
            TempsActuel= System.nanoTime();
            x+= (TempsActuel - dernierTempsCapture) / ecart;
            dernierTempsCapture=TempsActuel;
            if(1<=x){
            maj();
            repaint();
            x--;
        }

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
        graphics2D.fillRect(AxeXPersonnage,AxeYPersonnage,TailleCareau,TailleCareau);
        graphics2D.dispose();// libère ressources utilisées

    }
}
