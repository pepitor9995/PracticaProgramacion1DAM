import practicatema5.*;

import java.io.IOException;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        // Mounstro pepe = new Mounstro("pepe", "machete");
        Ladron alexis = new Ladron("alexis", "terceraEdad");
        Cazador ivan = new Cazador("ivan", "profesor", "pajaro", "canido");
        Guerrero carlos = new Guerrero("carlos", "mafia");
        Ladron pepe = new Ladron("pepe", "machete");

        ArrayList<PersonajeRol> aliados = new ArrayList<>();
        aliados.add(ivan);
        aliados.add(pepe);
        aliados.add(alexis);
        aliados.add(carlos);
        ArrayList<PersonajeRol> enemigos = new ArrayList<>();
        enemigos.add(alexis);
        enemigos.add(carlos);

        for (int i = 0; i < 150; i++) {
            ivan.subirNivel();
        }
        for (int i = 0; i < 5; i++) {
            alexis.subirNivel();
        }
        for (int i = 0; i < 15; i++) {
            pepe.subirNivel();
        }

        Simulador holi = new Simulador(aliados,
                "C:\\Users\\bibi_\\Desktop\\pepe\\PracticaTema5\\PracticaTema5\\FicherosPractica\\ficherosTema7\\Ficheros - Pra╠üctica 7\\Mazmorras\\hogarDelHacedor.csv");

        holi.Combate();

        // Combate.combate(aliados, enemigos);

        // Mazmorra HogarDelHacedor = new Mazmorra(
        // "C:\\Users\\bibi_\\Desktop\\pepe\\PracticaTema5\\PracticaTema5\\FicherosPractica\\ficherosTema7\\Ficheros
        // - Pra╠üctica 7\\Mazmorras\\hogarDelHacedor.csv");

        // System.out.println(HogarDelHacedor.combateAleatorio().toString());
        // System.out.println(HogarDelHacedor.toString());

        // System.out.println(HogarDelHacedor.combateAleatorio().toString());

        // Combate.combate(aliados, enemigos);
        // GameLogger.FichaPersonaje(pepe,"C:\\Users\\bibi_\\Desktop\\pepe\\pruebas\\prueba1.txt");
        // GameLogger.FichaPersonaje(alexis,"C:\\Users\\bibi_\\Desktop\\pepe\\pruebas\\prueba2.txt");
        // GameLogger.FichaPersonaje(ivan,
        // "C:\\Users\\bibi_\\Desktop\\pepe\\pruebas\\prueba3.txt");
        // GameLogger.FichaPersonaje(carlos,
        // "C:\\Users\\bibi_\\Desktop\\pepe\\pruebas\\prueba4.txt");
        // String [] rutas = new String[4];
        // rutas[0] = "C:\\Users\\bibi_\\Desktop\\pepe\\pruebas\\prueba1.txt";
        // rutas[1] = "C:\\Users\\bibi_\\Desktop\\pepe\\pruebas\\prueba2.txt";
        // rutas[2] = "C:\\Users\\bibi_\\Desktop\\pepe\\pruebas\\prueba3.txt";
        // rutas[3] = "C:\\Users\\bibi_\\Desktop\\pepe\\pruebas\\prueba4.txt";
        /*
         * for (int i = 0; i < 3;i++){
         * alexis.subirNivel();
         * }
         */
        // GameLogger.ComprobarClase(rutas, carlos);

        // System.out.println(pepe.toString()+"\n");
        // System.out.println(ivan.toString()+"\n");
        // System.out.println(ivan.toString());
        // Combate.combate(alexis, ivan);
        // GameLogger.AlmacenarCombate(pepe, ivan,
        // "C:\\Users\\bibi_\\Desktop\\pepe\\pruebas\\combate.txt");
        // GameLogger.SubirNivelPersonajeGanador(pepe,
        // ivan,"C:\\Users\\bibi_\\Desktop\\pepe\\pruebas\\combate.txt");
        // System.out.println(pepe.toString()+"\n");
        // System.out.println(ivan.toString()+"\n");

        // Arma macheta = new Arma("macheta", 50, 50, 50, 50, "legendario", 50, "una
        // mano", "espada");
        // Armadura caca = new Armadura("caca", "legendario", 5, 5, 5, 5, "botas",
        // "cuero");
        // System.out.println(caca.toString());
        // Artefacto caca2 = new Artefacto();
        // System.out.println(macheta.toString());
        // System.out.println(carlos.toString());

        // Combate com = new
        // Combate("C:\\Users\\bibi_\\Desktop\\pepe\\PracticaTema5\\PracticaTema5\\FicherosPractica\\ficherosTema7\\Ficheros
        // - Pra╠üctica 7\\Tesoros\\armas.csv",
        // "C:\\Users\\bibi_\\Desktop\\pepe\\PracticaTema5\\PracticaTema5\\FicherosPractica\\ficherosTema7\\Ficheros
        // - Pra╠üctica 7\\Tesoros\\armadura.csv",
        // "C:\\Users\\bibi_\\Desktop\\pepe\\PracticaTema5\\PracticaTema5\\FicherosPractica\\ficherosTema7\\Ficheros
        // - Pra╠üctica 7\\Tesoros\\artefactos.csv");

        // "C:\\Users\\bibi_\\Desktop\\pepe\\PracticaTema5\\PracticaTema5\\FicherosPractica\\ficherosTema7\\Ficheros
        // - Pra╠üctica 7\\Tesoros\\armas.csv"

    }
}
