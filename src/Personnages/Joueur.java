package Personnages;
import Main.GamePanel;
import Main.ToucheClavier;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;


public class Joueur extends Personnages{

    GamePanel GP;
    ToucheClavier touche;

    public Joueur (GamePanel GP ,ToucheClavier touche){
        this.GP =GP;
        this.touche=touche;
        CaracteristiquesDefaut();
    }

    public void CaracteristiquesDefaut(){
        AxeY=100;
        AxeX=100;
        VitesseJoueur=4;
        direction="droit";
    }

    public void getImageJoueur()
    {
        try {
            bas1 = ImageIO.read(getClass().getResourceAsStream("/Joueur/bas1png"));
            bas2 = ImageIO.read(getClass().getResourceAsStream("/Joueur/bas2.png"));
            droit1 = ImageIO.read(getClass().getResourceAsStream("/Joueur/droit1.png"));
            droit2 = ImageIO.read(getClass().getResourceAsStream("/Joueur/droit2.png"));
            haut1 = ImageIO.read(getClass().getResourceAsStream("/Joueur/haut1.png"));
            gauche1 = ImageIO.read(getClass().getResourceAsStream("/Joueur/gauche1.png"));
            gauche2 = ImageIO.read(getClass().getResourceAsStream("/Joueur/gauche2.png"));
            haut2 = ImageIO.read(getClass().getResourceAsStream("/Joueur/haut2.png"));
        } catch (IOException Erreur) {
            Erreur.printStackTrace();
        }
    }
    public void maj(){
        if(touche.hautActiv==true){
            direction="haut";
            AxeY -= VitesseJoueur;
        }
        if(touche.basActiv==true){
            direction="bas";

            AxeY += VitesseJoueur;
        }
        if(touche.droitActiv==true){
            direction="droit";

            AxeX +=VitesseJoueur;

        }
        if(touche.gaucheActiv==true){
            direction="gauche";

            AxeX-=VitesseJoueur;

        }

    }


    public void draw(Graphics2D graphics2D){
        graphics2D.setColor(Color.red);
        graphics2D.fillRect(AxeX,AxeY,GP.TailleCarreauGrille, GP.TailleCarreauGrille);
    }


}
