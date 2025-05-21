package practicatema5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Mago extends PersonajeRol {

    // atributos
    private int puntosMagia;

    // constructores
    public Mago() {
        super();
        puntosMagia = 0;
    }

    public Mago(Mago a) {
        super(a);
        this.setPuntosMagia(a.getPuntosMagia());
    }

    public Mago(String nombre, String raza) {
        super(nombre, raza);
        this.puntosMagia = 10;
    }

    public Mago(String path) throws IOException {
        super(path);
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);

        String linea = "";
        String[] campos = new String[1];

        for (int i = 0; i < 14; i++) {
            br.readLine();
        }

        linea = br.readLine();
        campos = linea.split(": ");
        int puntosMagia = Integer.parseInt(campos[1]);
        this.puntosMagia = puntosMagia;

        br.close();
        fr.close();
    }

    // getters y setters
    public int getPuntosMagia() {
        return this.puntosMagia;
    }

    public void setPuntosMagia(int puntosMagia) {
        this.puntosMagia = puntosMagia;
    }

    // metodos
    public void subirNivel() {
        setNivel(getNivel() + 1);

        int probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad >= 10) {
            puntosMagia += getNivel();
        }
        probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad >= 65) {
            setVitalidad(getVitalidad() + (int) (getVitalidad() * 0.1));
        }
        probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad >= 65) {
            setFortaleza(getFortaleza() + (getFortaleza() / 2));
        }
        probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad >= 85) {
            setFuerza((int) (getFuerza() + (getNivel() / 4)));
        }
        probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad <= 80) {
            setResistenciaMagica(getResistenciaMagica() + getNivel());
        }
        probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad >= 35) {
            setAgilidad(getAgilidad() + getNivel());
        }
    }

    public int contarDañoMagico() {
        int dañoMagico = 0;

        dañoMagico += this.getArmaDelPersonaje().recuperaEstadistica("magia");

        for (Artefacto i : this.getArtefactosDelPersonaje()) {
            dañoMagico += i.recuperaEstadistica("magia");
        }

        return dañoMagico;
    }

    public int lanzarConjuro(int ataqueMagico, PersonajeRol a) {
        Guerrero prueba = new Guerrero();
        Guerrero[] prueba1 = new Guerrero[1];
        Guerrero aliado = new Guerrero();
        switch (ataqueMagico) {
            case 1:
                if (prueba.getNombre().equals(a.getClass().getSimpleName())) {
                    System.out.println("has alcanzado al objetivo");
                    return prueba.getVitalidad() - (int) (puntosMagia * 0.7);
                } else {
                    System.out.println("No has conseguido alcanzar al objetivo");
                }
                break;

            case 2:
                if (aliado.getNombre().equals(a.getClass().getSimpleName())) {
                    System.out.println("has protegido a tu compañero");
                    aliado.setResistenciaMagica(prueba.getVitalidad() + (int) Math.round(puntosMagia * 0.5));
                    aliado.setFortaleza(prueba.getVitalidad() + (int) Math.round(puntosMagia * 0.5));
                    return 0;
                } else {
                    System.out.println("no has conseguido proteger a tu aliado");
                }
                break;

            case 3:
                if (prueba1[0].getNombre().equals(a.getClass().getSimpleName())) {
                    for (int i = 0; i < prueba1.length; i++) {
                        System.out.println("has alcanzado a los objetivos");
                        return prueba1[i].getVitalidad() - (int) Math.round(puntosMagia * 0.3);
                    }
                } else {
                    System.out.println("no has alcanzado a ninguno");
                }
                break;

            case 4:
                if (aliado.getNombre().equals(a.getClass().getSimpleName())) {
                    System.out.println("Has ayudado a tu compañero");
                    aliado.setAgilidad(aliado.getAgilidad() + puntosMagia);
                    return 0;
                } else {
                    System.out.println("no has podido ayudar a tu compañero");
                }
                break;
            default:
                System.out.println("hechizo incorrecto");
                break;
        }
        return 0;
    }

    public void luchar(int ataqueMagico, PersonajeRol a) {
        if (ataqueMagico == 1 || ataqueMagico == 3) {
            this.lanzarConjuro(ataqueMagico, a);
        } else
            apoyar(ataqueMagico, a);
    }

    public void apoyar(int ataqueMagico, PersonajeRol a) {
        if (ataqueMagico == 2 || ataqueMagico == 4) {
            this.lanzarConjuro(ataqueMagico, a);
        } else
            luchar(ataqueMagico, a);
    }

    public void equiparArma(Arma arma) {
        if (arma.getTipo().equals("cetro") || arma.getTipo().equals("baston")) {
            setArmaDelPersonaje(arma);
        }
    }

    public void equiparArmaduras(Armadura armadura) {
        if (armadura.getMaterial().equals("tela")) {
            setArmadurasDelPersonaje(armadura);
        }
    }

    public void equiparArtefactos(Artefacto artefacto) {
        setArtefactosDelPersonaje(artefacto);
    }

    public String toString() {
        String resultado = "Ficha del mago: " + getNombre() + "\n" + "\n"
                + super.toString() + "\n"
                + "Puntos de magia: " + puntosMagia;
        return resultado;
    }

    public boolean PersonajesCasen(String path) throws IOException {
        boolean casan = super.PersonajesCasen(path);

        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);

        String linea = "";
        String[] campos = new String[1];

        for (int i = 0; i < 14; i++) {
            br.readLine();
        }

        linea = br.readLine();
        campos = linea.split(": ");

        int puntosMagia = Integer.parseInt(campos[1]);

        if (puntosMagia != this.getPuntosMagia()) {
            casan = false;
            this.setPuntosMagia(puntosMagia);
            System.out.println("error en los puntos de magia");
        }

        if (casan == true) {
            System.out.println("El mago esta perfecto");
        } else
            System.out.println("El mago no esta perfecto");

        br.close();
        fr.close();

        return casan;
    }
}
