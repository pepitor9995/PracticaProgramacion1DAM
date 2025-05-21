package practicatema5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Combate {
    // atributos
    static private String combate = "";
    static private ArrayList<Equipamiento> tesoros = new ArrayList<>();

    // metodos
    public static String combate(PersonajeRol pepe, PersonajeRol ivan) throws IOException {
        int probabilidad = (int) (Math.random() * tesoros.size()) + 1;
        do {
            if (pepe.getAgilidad() > ivan.getAgilidad() * 2) {

                System.out.println("WOW " + pepe.getNombre() + " es muy rapido ataca dos veces");
                combate += "WOW " + pepe.getNombre() + " es muy rapido ataca dos veces\n";

                ivan.defender(pepe.luchar(), pepe);
                ivan.defender(pepe.luchar(), pepe);

                System.out.println(ivan.getNombre() + " ataca ahora");
                combate += ivan.getNombre() + " ataca ahora\n";

                pepe.defender(ivan.luchar(), ivan);

                System.out.println("La vida de " + pepe.getNombre() + " es de" + pepe.getVitalidad());
                combate += "La vida de " + pepe.getNombre() + " es de" + pepe.getVitalidad() + "\n";

                System.out.println("La vida de " + ivan.getNombre() + " Ivan es de" + ivan.getVitalidad());
                combate += "La vida de " + ivan.getNombre() + " Ivan es de" + ivan.getVitalidad() + "\n";

            } else if (ivan.getAgilidad() > pepe.getAgilidad() * 2) {

                System.out.println("Ivan lo siento. " + ivan.getNombre() + " es muy rapido ataca dos veces");
                combate += "Ivan lo siento. " + ivan.getNombre() + " es muy rapido ataca dos veces\n";

                pepe.defender(ivan.luchar(), ivan);
                pepe.defender(ivan.luchar(), ivan);

                System.out.println(pepe.getNombre() + " ataca ahora");
                combate += pepe.getNombre() + " ataca ahora\n";

                ivan.defender(pepe.luchar(), pepe);

                System.out.println("La vida de " + pepe.getNombre() + " es de" + pepe.getVitalidad());
                combate += "La vida de " + pepe.getNombre() + " es de" + pepe.getVitalidad() + "\n";

                System.out.println("La vida de " + ivan.getNombre() + " Ivan es de" + ivan.getVitalidad());
                combate += "La vida de " + ivan.getNombre() + " Ivan es de" + ivan.getVitalidad() + "\n";

            } else if (pepe.getAgilidad() > ivan.getAgilidad()) {

                System.out.println(pepe.getNombre() + " ataca una vez");
                combate += pepe.getNombre() + " ataca una vez\n";

                ivan.defender(pepe.luchar(), pepe);

                System.out.println(ivan.getNombre() + " ataca ahora");
                combate += ivan.getNombre() + " ataca ahora\n";

                pepe.defender(ivan.luchar(), ivan);

                System.out.println("La vida de " + pepe.getNombre() + " es de" + pepe.getVitalidad());
                combate += "La vida de " + pepe.getNombre() + " es de" + pepe.getVitalidad() + "\n";

                System.out.println("La vida de " + ivan.getNombre() + " Ivan es de" + ivan.getVitalidad());
                combate += "La vida de " + ivan.getNombre() + " Ivan es de" + ivan.getVitalidad() + "\n";

            } else {

                System.out.println(ivan.getNombre() + " ataca una vez");
                combate += ivan.getNombre() + " ataca una vez\n";

                pepe.defender(ivan.luchar(), ivan);

                System.out.println(pepe.getNombre() + " ataca ahora");
                combate += pepe.getNombre() + " ataca ahora\n";

                ivan.defender(pepe.luchar(), pepe);

                System.out.println("La vida de " + pepe.getNombre() + " es de" + pepe.getVitalidad());
                combate += "La vida de " + pepe.getNombre() + " es de" + pepe.getVitalidad() + "\n";

                System.out.println("La vida de " + ivan.getNombre() + " Ivan es de" + ivan.getVitalidad());
                combate += "La vida de " + ivan.getNombre() + " Ivan es de" + ivan.getVitalidad() + "\n";

            }
        } while (pepe.getVitalidad() > 0 && ivan.getVitalidad() > 0);

        añadirTesoros(
                "C:\\Users\\bibi_\\Desktop\\pepe\\PracticaTema5\\PracticaTema5\\FicherosPractica\\ficherosTema7\\Ficheros - Pra╠üctica 7\\Tesoros\\armas.csv",
                "C:\\Users\\bibi_\\Desktop\\pepe\\PracticaTema5\\PracticaTema5\\FicherosPractica\\ficherosTema7\\Ficheros - Pra╠üctica 7\\Tesoros\\armadura.csv",
                "C:\\Users\\bibi_\\Desktop\\pepe\\PracticaTema5\\PracticaTema5\\FicherosPractica\\ficherosTema7\\Ficheros - Pra╠üctica 7\\Tesoros\\artefactos.csv");

        if (pepe.getVitalidad() > 0) {
            System.out.println("El personaje " + pepe.getNombre() + " gano");
            combate += "El personaje " + pepe.getNombre() + " gano\n";

            switch (tesoros.get(probabilidad).getClass().getSimpleName()) {
                case "Arma":
                    System.out.println(
                            "\nEl personaje adquirio el arma: " + tesoros.get(probabilidad).getNombre() + "\n");
                    pepe.setArmaDelPersonaje((Arma) tesoros.get(probabilidad));
                    tesoros.remove(probabilidad);
                    break;
                case "Armadura":
                    System.out.println(
                            "\nEl personaje adquirio el arma: " + tesoros.get(probabilidad).getNombre() + "\n");
                    pepe.setArmadurasDelPersonaje((Armadura) tesoros.get(probabilidad));
                    tesoros.remove(probabilidad);
                    break;
                case "Artefacto":
                    System.out.println(
                            "\nEl personaje adquirio el arma: " + tesoros.get(probabilidad).getNombre() + "\n");
                    pepe.setArtefactosDelPersonaje((Artefacto) tesoros.get(probabilidad));
                    tesoros.remove(probabilidad);
                    break;
                default:
                    break;
            }

        } else if (ivan.getVitalidad() > 0) {
            System.out.println("El personaje " + ivan.getNombre() + " gano");
            combate += "El personaje " + ivan.getNombre() + " gano\n";

            switch (tesoros.get(probabilidad).getClass().getSimpleName()) {
                case "Arma":
                    System.out.println(
                            "\nEl personaje adquirio el arma: " + tesoros.get(probabilidad).getNombre() + "\n");
                    ivan.setArmaDelPersonaje((Arma) tesoros.get(probabilidad));
                    tesoros.remove(probabilidad);
                    break;
                case "Armadura":
                    System.out.println(
                            "\nEl personaje adquirio el arma: " + tesoros.get(probabilidad).getNombre() + "\n");
                    ivan.setArmadurasDelPersonaje((Armadura) tesoros.get(probabilidad));
                    tesoros.remove(probabilidad);
                    break;
                case "Artefacto":
                    System.out.println(
                            "\nEl personaje adquirio el arma: " + tesoros.get(probabilidad).getNombre() + "\n");
                    ivan.setArtefactosDelPersonaje((Artefacto) tesoros.get(probabilidad));
                    tesoros.remove(probabilidad);
                    break;
                default:
                    break;
            }

        } else {
            System.out.println("Empate tecnico");
            combate += "Empate tecnico\n";
        }

        return combate;
    }

    public static String combate(ArrayList<PersonajeRol> aliados, ArrayList<Mounstro> enemigos) throws IOException {
        int probabilidad = 0;

        CompararNivel.compareNivel(aliados);
        CompararNivel.compareNivelMonstruo(enemigos);

        do {

            if (aliados.get(0).getAgilidad() > enemigos.get(0).getAgilidad() * 2) {
                System.out.println("WOW " + aliados.get(0).getNombre() + " es muy rapido ataca dos veces");
                combate += " WOW" + aliados.get(0).getNombre() + " es muy rapido ataca dos veces";
                enemigos.get(0).defender(aliados.get(0).luchar(), aliados.get(0));
                enemigos.get(0).defender(aliados.get(0).luchar(), aliados.get(0));

                System.out.println(enemigos.get(0).getNombre() + " ataca ahora");
                aliados.get(0).defender(enemigos.get(0).luchar(), enemigos.get(0));

                System.out.println("La vida de: " + aliados.get(0).getNombre() + " es de: "
                        + aliados.get(0).getVitalidad());
                combate += "La vida de: " + aliados.get(0).getNombre() + " es de: "
                        + aliados.get(0).getVitalidad();
                System.out.println("La vida de: " + enemigos.get(0).getNombre() + " es de: "
                        + enemigos.get(0).getVitalidad() + "\n");
                combate += "La vida de: " + enemigos.get(0).getNombre() + " es de: "
                        + enemigos.get(0).getVitalidad() + "\n";

            } else if (enemigos.get(0).getAgilidad() > aliados.get(0).getAgilidad() * 2) {
                System.out.println("WOW " + enemigos.get(0).getNombre() + " es muy rapido ataca dos veces");
                combate += "WOW " + enemigos.get(0).getNombre() + " es muy rapido ataca dos veces";
                aliados.get(0).defender(enemigos.get(0).luchar(), enemigos.get(0));
                aliados.get(0).defender(enemigos.get(0).luchar(), enemigos.get(0));

                System.out.println(aliados.get(0).getNombre() + " ataca ahora");
                enemigos.get(0).defender(aliados.get(0).luchar(), aliados.get(0));

                System.out.println("La vida de: " + aliados.get(0).getNombre() + " es de: "
                        + aliados.get(0).getVitalidad());
                combate += "La vida de: " + aliados.get(0).getNombre() + " es de: "
                        + aliados.get(0).getVitalidad();
                System.out.println("La vida de: " + enemigos.get(0).getNombre() + " es de: "
                        + enemigos.get(0).getVitalidad() + "\n");
                combate += "La vida de: " + enemigos.get(0).getNombre() + " es de: "
                        + enemigos.get(0).getVitalidad() + "\n";

            } else if (aliados.get(0).getAgilidad() > enemigos.get(0).getAgilidad()) {
                System.out.println(aliados.get(0).getNombre() + " ataca una vez");
                combate += aliados.get(0).getNombre() + " ataca una vez";
                enemigos.get(0).defender(aliados.get(0).luchar(), aliados.get(0));

                System.out.println(enemigos.get(0).getNombre() + " ataca una vez");
                combate += enemigos.get(0).getNombre() + " ataca una vez";
                aliados.get(0).defender(enemigos.get(0).luchar(), enemigos.get(0));

                System.out.println("La vida de: " + aliados.get(0).getNombre() + " es de: "
                        + aliados.get(0).getVitalidad());
                combate += "La vida de: " + aliados.get(0).getNombre() + " es de: "
                        + aliados.get(0).getVitalidad();
                System.out.println("La vida de: " + enemigos.get(0).getNombre() + " es de: "
                        + enemigos.get(0).getVitalidad() + "\n");
                combate += "La vida de: " + enemigos.get(0).getNombre() + " es de: "
                        + enemigos.get(0).getVitalidad() + "\n";

            } else {
                System.out.println(enemigos.get(0).getNombre() + " ataca una vez");
                combate += enemigos.get(0).getNombre() + " ataca una vez";
                aliados.get(0).defender(enemigos.get(0).luchar(), enemigos.get(0));

                System.out.println(aliados.get(0).getNombre() + " ataca una vez");
                combate += aliados.get(0).getNombre() + " ataca una vez";
                enemigos.get(0).defender(aliados.get(0).luchar(), aliados.get(0));

                System.out.println("La vida de: " + aliados.get(0).getNombre() + " es de: "
                        + aliados.get(0).getVitalidad());
                combate += "La vida de: " + aliados.get(0).getNombre() + " es de: "
                        + aliados.get(0).getVitalidad();
                System.out.println("La vida de: " + enemigos.get(0).getNombre() + " es de: "
                        + enemigos.get(0).getVitalidad() + "\n");
                combate += "La vida de: " + enemigos.get(0).getNombre() + " es de: "
                        + enemigos.get(0).getVitalidad() + "\n";
            }

            if (aliados.get(0).getVitalidad() < 1) {
                System.err.println("eliminado " + aliados.get(0).getNombre() + "\n");
                aliados.remove(0);
            }
            if (enemigos.get(0).getVitalidad() < 1) {
                System.err.println("eliminado " + enemigos.get(0).getNombre() + "\n");
                enemigos.remove(0);
            }

        } while (!aliados.isEmpty() && !enemigos.isEmpty());

        añadirTesoros(
                "C:\\Users\\bibi_\\Desktop\\pepe\\PracticaTema5\\PracticaTema5\\FicherosPractica\\ficherosTema7\\Ficheros - Pra╠üctica 7\\Tesoros\\armas.csv",
                "C:\\Users\\bibi_\\Desktop\\pepe\\PracticaTema5\\PracticaTema5\\FicherosPractica\\ficherosTema7\\Ficheros - Pra╠üctica 7\\Tesoros\\armadura.csv",
                "C:\\Users\\bibi_\\Desktop\\pepe\\PracticaTema5\\PracticaTema5\\FicherosPractica\\ficherosTema7\\Ficheros - Pra╠üctica 7\\Tesoros\\artefactos.csv");

        int cont = 0;

        if (enemigos.isEmpty()) {
            System.out.println("Los aliados han ganado\n");

            while (cont < aliados.size()) {
                probabilidad = (int) (Math.random() * tesoros.size()) + 1;

                for (int i = 0; i < aliados.size(); i++) {
                    switch (tesoros.get(probabilidad).getClass().getSimpleName()) {
                        case "Arma":
                            if (aliados.get(i).setArmaDelPersonaje((Arma) tesoros.get(probabilidad))) {
                                aliados.get(i).setArmaDelPersonaje((Arma) tesoros.get(probabilidad));

                                System.out.println("Arma: " + tesoros.get(probabilidad).getNombre() + " equipado a: "
                                        + aliados.get(i).getNombre());

                                i = aliados.size();
                                tesoros.remove(probabilidad);
                            } else {
                                System.err.println(
                                        "No se puede equipar el arma: " + tesoros.get(probabilidad).getNombre());
                            }
                            break;
                        case "Armadura":
                            if (aliados.get(i).setArmadurasDelPersonaje((Armadura) tesoros.get(probabilidad))) {
                                aliados.get(i).setArmadurasDelPersonaje((Armadura) tesoros.get(probabilidad));

                                System.out
                                        .println("Armadura: " + tesoros.get(probabilidad).getNombre() + " equipado a: "
                                                + aliados.get(i).getNombre());

                                i = aliados.size();
                                tesoros.remove(probabilidad);
                            } else {
                                System.err.println(
                                        "No se puede equipar la armadura: " + tesoros.get(probabilidad).getNombre());
                            }
                            break;
                        case "Artefacto":
                            if (aliados.get(i).setArtefactosDelPersonaje((Artefacto) tesoros.get(probabilidad))) {
                                aliados.get(i).setArtefactosDelPersonaje((Artefacto) tesoros.get(probabilidad));

                                System.out
                                        .println("Artefacto: " + tesoros.get(probabilidad).getNombre() + " equipado a; "
                                                + aliados.get(i).getNombre());

                                i = aliados.size();
                                tesoros.remove(probabilidad);
                            } else {
                                System.err.println(
                                        "No se puede equipar el artefacto: " + tesoros.get(probabilidad).getNombre());
                            }
                            break;
                        default:
                            break;
                    }
                }
                cont++;
            }

        } else if (aliados.isEmpty()) {
            System.out.println("Los monstruos han ganado\n");
            while (cont < enemigos.size()) {
                probabilidad = (int) (Math.random() * tesoros.size()) + 1;

                for (int i = 0; i < enemigos.size(); i++) {
                    switch (tesoros.get(probabilidad).getClass().getSimpleName()) {
                        case "Arma":
                            if (enemigos.get(i).equiparArma((Arma) tesoros.get(probabilidad))) {
                                enemigos.get(i).equiparArma((Arma) tesoros.get(probabilidad));

                                System.out.println("Arma: " + tesoros.get(probabilidad).getNombre() + " equipado a: "
                                        + enemigos.get(i).getNombre());

                                i = enemigos.size();
                                tesoros.remove(probabilidad);
                            } else {
                                System.err.println(
                                        "No se puede equipar el arma: " + tesoros.get(probabilidad).getNombre()
                                                + " Al monstruo: " + enemigos.get(i).getNombre());
                            }
                            break;
                        case "Armadura":
                            if (enemigos.get(i).equiparArmaduras((Armadura) tesoros.get(probabilidad))) {
                                enemigos.get(i).equiparArmaduras((Armadura) tesoros.get(probabilidad));

                                System.out
                                        .println("Armadura: " + tesoros.get(probabilidad).getNombre() + " equipado a: "
                                                + enemigos.get(i).getNombre());

                                i = enemigos.size();
                                tesoros.remove(probabilidad);
                            } else {
                                System.err.println(
                                        "No se puede equipar la armadura: " + tesoros.get(probabilidad).getNombre()
                                                + " Al monstruo: " + enemigos.get(i).getNombre());
                            }
                            break;
                        case "Artefacto":
                            if (enemigos.get(i).equiparArtefactos((Artefacto) tesoros.get(probabilidad))) {
                                enemigos.get(i).equiparArtefactos((Artefacto) tesoros.get(probabilidad));

                                System.out.println("Arma: " + tesoros.get(probabilidad).getNombre() + " equipado a: "
                                        + enemigos.get(i).getNombre());

                                i = enemigos.size();
                                tesoros.remove(probabilidad);
                            } else {
                                System.err.println(
                                        "No se puede equipar el artefacto: " + tesoros.get(probabilidad).getNombre()
                                                + " Al monstruo: " + enemigos.get(i).getNombre());
                            }
                            break;
                        default:
                            break;
                    }
                }
                cont++;
            }

        } else {
            System.out.println("Empate tecnico");
        }

        return combate;
    }

    public static void añadirTesoros(String pathArmas, String pathArmadura, String pathArtefacto) throws IOException {
        String linea;
        Arma arma;
        Armadura armadura;
        Artefacto artefacto;

        FileReader fr = new FileReader(pathArmas);
        BufferedReader br = new BufferedReader(fr);

        br.readLine();

        while ((linea = br.readLine()) != null) {
            arma = new Arma(convertirArma(linea));
            tesoros.add(new Arma(arma));
        }

        br.close();
        fr.close();

        FileReader fr2 = new FileReader(pathArmadura);
        BufferedReader br2 = new BufferedReader(fr2);

        br2.readLine();

        while ((linea = br2.readLine()) != null) {
            armadura = new Armadura(convertirArmadura(linea));
            tesoros.add(new Armadura(armadura));
        }

        br2.close();
        fr2.close();

        FileReader fr3 = new FileReader(pathArtefacto);
        BufferedReader br3 = new BufferedReader(fr3);

        br3.readLine();

        while ((linea = br3.readLine()) != null) {
            artefacto = new Artefacto(convertirArtefacto(linea));
            tesoros.add(new Artefacto(artefacto));
        }

        br3.close();
        fr3.close();
    }

    public static Arma convertirArma(String arma) {
        Arma armaEquipada = new Arma();

        String[] campos = new String[5];
        String[] camposDeEstadisticas = new String[4];

        campos = arma.split(",");
        camposDeEstadisticas = campos[3].split("-");

        armaEquipada.setNombre(campos[0]);
        armaEquipada.setRareza(campos[1].toLowerCase());
        armaEquipada.setValor(Integer.parseInt(campos[4]));
        armaEquipada.setEstadisticas(0, Integer.parseInt(camposDeEstadisticas[0]),
                Integer.parseInt(camposDeEstadisticas[1]), Integer.parseInt(camposDeEstadisticas[2]),
                Integer.parseInt(camposDeEstadisticas[3]), 0, 0);
        switch (campos[2].toLowerCase()) {
            case "espada", "maza", "hacha", "cetro", "daga", "mangual":
                armaEquipada.setEmpuñadura("una mano");
                break;
            case "espadon", "martillo", "arco", "baston", "pica":
                armaEquipada.setEmpuñadura("dos manos");
                break;
            default:
                break;
        }
        armaEquipada.setTipo(campos[2]);

        return armaEquipada;
    }

    public static Armadura convertirArmadura(String armadura) {
        Armadura armaduraEquipada = new Armadura();

        String[] campos = new String[6];
        String[] camposDeEstadisticas = new String[3];

        campos = armadura.split(",");
        camposDeEstadisticas = campos[4].split("-");

        armaduraEquipada.setNombre(campos[0]);
        armaduraEquipada.setRareza(campos[1]);
        armaduraEquipada.setValor(Integer.parseInt(campos[5]));
        armaduraEquipada.setEstadisticas(Integer.parseInt(camposDeEstadisticas[2]), 0, 0, 0, 0,
                Integer.parseInt(camposDeEstadisticas[0]), Integer.parseInt(camposDeEstadisticas[1]));
        armaduraEquipada.setTipo(campos[2]);
        armaduraEquipada.setMaterial(campos[3]);

        return armaduraEquipada;
    }

    public static Artefacto convertirArtefacto(String artefacto) {
        Artefacto artefactoEquipado = new Artefacto();

        String[] campos = new String[5];
        String[] camposDeEstadisticas = new String[7];

        campos = artefacto.split(",");
        camposDeEstadisticas = campos[3].split("-");

        artefactoEquipado.setNombre(campos[0]);
        artefactoEquipado.setRareza(campos[1]);
        artefactoEquipado.setEstadisticas(Integer.parseInt(camposDeEstadisticas[6]),
                Integer.parseInt(camposDeEstadisticas[0]), Integer.parseInt(camposDeEstadisticas[1]),
                Integer.parseInt(camposDeEstadisticas[2]), Integer.parseInt(camposDeEstadisticas[3]),
                Integer.parseInt(camposDeEstadisticas[4]), Integer.parseInt(camposDeEstadisticas[6]));
        artefactoEquipado.setTipo(campos[2]);
        artefactoEquipado.setValor(Integer.parseInt(campos[4]));

        return artefactoEquipado;
    }
}
