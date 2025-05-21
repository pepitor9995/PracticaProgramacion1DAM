package practicatema5;

import java.io.*;
import java.util.Arrays;

public class GameLogger {
    public static void FichaPersonaje(PersonajeRol personaje, String path) throws IOException {
        FileWriter fw = new FileWriter(path);
        fw.write(personaje.toString());
        fw.close();
    }

    public static void FichasPersonajes(PersonajeRol[] personajeRols, String path) throws IOException {
        Arrays.sort(personajeRols, new CompareVelo());
        FileWriter fw = new FileWriter(path);
        for (int i = 0; i < personajeRols.length; i++) {
            fw.write(i + 1 + "\n");
            fw.write(personajeRols[i].toString());
            fw.write("\n" + "\n");
        }
        fw.close();
    }

    public static void ComprobarNombre(String[] paths, String nombre) throws IOException {
        int rutas = paths.length;
        String linea;
        String campos[] = new String[1];

        for (int i = 0; i < rutas; i++) {
            FileReader fr = new FileReader(paths[i]);
            BufferedReader br = new BufferedReader(fr);

            linea = br.readLine();
            campos = linea.split(": ");

            if (campos[1].equals(nombre)) {
                System.out.println("el nombre de: " + nombre + " conicide con la ruta: " + paths[i]);
            }

            br.close();
            fr.close();
        }

    }

    public static void ComprobarClase(String[] paths, PersonajeRol pepe) throws IOException {
        int rutas = paths.length;
        String linea;
        String campos[];

        for (int i = 0; i < rutas; i++) {
            FileReader fr = new FileReader(paths[i]);
            BufferedReader br = new BufferedReader(fr);

            br.readLine();
            br.readLine();
            br.readLine();

            linea = br.readLine();
            campos = linea.split(": ");

            if (campos[1].equals(pepe.getClass().getSimpleName())) {
                System.out.println("la clase de: " + pepe.getClass().getSimpleName()
                        + " conicide con la clase de la ruta: " + paths[i]);
            }
            br.close();
            fr.close();
        }
    }

    public static void AlmacenarCombate(PersonajeRol pepe, PersonajeRol ivan, String path) throws IOException {
        String combate = Combate.combate(pepe, ivan);
        FileWriter fw = new FileWriter(path);
        fw.write(combate);
        fw.close();
    }

    public static int RevisarCombate(String path) throws IOException {
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);

        String linea;
        int contador = 0;

        while ((linea = br.readLine()) != null) {
            contador++;
        }

        br.close();
        fr.close();

        return contador;
    }

    public static void SubirNivelPersonajeGanador(PersonajeRol pepe, PersonajeRol ivan, String path)
            throws IOException {
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);

        String linea;
        int contador = RevisarCombate(path);
        int cont = 0;

        while ((linea = br.readLine()) != null) {
            cont++;

            if (cont == contador) {
                if (linea.contains(pepe.getNombre())) {
                    pepe.subirNivel();
                    System.out.println("Se subio el nivel del personaje:" + pepe.getNombre());
                } else if (linea.contains(ivan.getNombre())) {
                    ivan.subirNivel();
                    System.out.println("Se subio el nivel del personaje:" + ivan.getNombre());
                } else
                    System.out.println("no se subio el nivel de ningun personaje");
            }
        }
        br.close();
        fr.close();
    }
}
