package practicatema5;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class PersonajeRol {
    // atributos
    private String nombre;
    private String raza;
    private int nivel;
    // puntos de la salud
    private int vitalidad;
    // puntos de ataque
    private int fuerza;
    // puntos de velocidad
    private int agilidad;// sxs
    // puntos de armadura
    private int fortaleza;
    // puntos de resistencia magica
    private int resistenciaMagica;
    // indica si esta vivo o muelto
    private boolean vivo;

    private Arma armaDelPersonaje;
    private HashMap<String, Armadura> armadurasDelPersonaje;
    private ArrayList<Artefacto> artefactosDelPersonaje;

    // constructores
    public PersonajeRol(String nombre, String raza) {
        setNombre(nombre);
        setRaza(raza);
        nivel = 1;
        vitalidad = 100;//
        fuerza = 10;//
        agilidad = 10;//
        fortaleza = 10;
        resistenciaMagica = 10;
        vivo = true;
        armaDelPersonaje = new Arma();
        armadurasDelPersonaje = new HashMap<>();
        artefactosDelPersonaje = new ArrayList<>();
    }

    public PersonajeRol() {
        nombre = raza = "";
        nivel = 1;
        vitalidad = 100;
        fuerza = agilidad = fortaleza = resistenciaMagica = 10;
        vivo = true;
        armaDelPersonaje = new Arma();
        armadurasDelPersonaje = new HashMap<>();
        artefactosDelPersonaje = new ArrayList<>();
    }

    public PersonajeRol(PersonajeRol a) {
        this.setNombre(a.getNombre());
        this.setRaza(a.getRaza());
        this.setNivel(a.getNivel());
        this.setVitalidad(a.getVitalidad());
        this.setFuerza(a.getFuerza());
        this.setAgilidad(a.getAgilidad());
        this.setFortaleza(a.getFortaleza());
        this.setResistenciaMagica(a.getResistenciaMagica());
        this.setVivo(a.getvivo());
        if (!a.getArmaDelPersonaje().getNombre().equals("")) {
            this.setArmaDelPersonaje(a.getArmaDelPersonaje());
        }
        if (a.getArmadurasDelPersonaje().size() == 0) {
            this.armadurasDelPersonaje = new HashMap<>(a.armadurasDelPersonaje);
        }
        if (a.getArtefactosDelPersonaje().size() == 0) {
            this.artefactosDelPersonaje = new ArrayList<>(a.artefactosDelPersonaje);
        }
    }

    public PersonajeRol(String path) throws IOException {
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);

        String linea = "";
        String[] campos = new String[1];

        br.readLine();
        br.readLine();

        linea = br.readLine();
        campos = linea.split(" ");
        this.nombre = campos[1];

        br.readLine();
        linea = br.readLine();
        campos = linea.split(" ");
        this.raza = campos[1];

        br.readLine();
        linea = br.readLine();
        campos = linea.split(" ");
        int nivel = Integer.parseInt(campos[1]);
        this.nivel = nivel;

        linea = br.readLine();
        campos = linea.split(" ");
        int vitalidad = Integer.parseInt(campos[1]);
        this.vitalidad = vitalidad;

        linea = br.readLine();
        campos = linea.split(" ");
        int fuerza = Integer.parseInt(campos[1]);
        this.fuerza = fuerza;

        linea = br.readLine();
        campos = linea.split(" ");
        int agilidad = Integer.parseInt(campos[1]);
        this.agilidad = agilidad;

        linea = br.readLine();
        campos = linea.split(" ");
        int fortaleza = Integer.parseInt(campos[1]);
        this.fortaleza = fortaleza;

        linea = br.readLine();
        campos = linea.split(": ");
        int resistenciaMagica = Integer.parseInt(campos[1]);
        this.resistenciaMagica = resistenciaMagica;

        br.readLine();
        linea = br.readLine();
        campos = linea.split(": ");
        boolean vivo;
        if (campos[1].equals("vivo"))
            vivo = true;
        else
            vivo = false;
        this.vivo = vivo;

        br.close();
        fr.close();
    }

    // setters y getters
    public void setNombre(String nombre) {
        if (nombre.length() >= 4) {
            nombre.replace(" ", "");
            this.nombre = nombre;
        } else
            this.nombre = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setRaza(String raza) {
        if (raza.equals("ángel") || raza.equals("demonio")) {
            this.raza = "";
        } else
            this.raza = raza;
    }

    public String getRaza() {
        return raza;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }

    public void setVitalidad(int vitalidad) {
        this.vitalidad = vitalidad;
    }

    public int getVitalidad() {
        return vitalidad;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setAgilidad(int agilidad) {
        this.agilidad = agilidad;
    }

    public int getAgilidad() {
        return agilidad;
    }

    public void setFortaleza(int fortaleza) {
        this.fortaleza = fortaleza;
    }

    public int getFortaleza() {
        return fortaleza;
    }

    public void setResistenciaMagica(int resistenciaMagica) {
        this.resistenciaMagica = resistenciaMagica;
    }

    public int getResistenciaMagica() {
        return resistenciaMagica;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public boolean getvivo() {
        return vivo;
    }

    public Arma getArmaDelPersonaje() {
        return armaDelPersonaje;
    }

    public boolean setArmaDelPersonaje(Arma armaDelPersonaje) {
        boolean equipado = false;

        if (this.armaDelPersonaje != null) {
            this.armaDelPersonaje = new Arma(armaDelPersonaje);
            equipado = true;
        }
        return equipado;
    }

    public HashMap<String, Armadura> getArmadurasDelPersonaje() {
        return armadurasDelPersonaje;
    }

    public boolean setArmadurasDelPersonaje(Armadura armadurasDelPersonaje) {
        boolean equipado = false;

        if (this.armadurasDelPersonaje.size() <= 6
                && !this.armadurasDelPersonaje.containsKey(armadurasDelPersonaje.getTipo())) {
            this.armadurasDelPersonaje.put(armadurasDelPersonaje.getTipo(), armadurasDelPersonaje);
            equipado = true;

        }

        return equipado;
    }

    public ArrayList<Artefacto> getArtefactosDelPersonaje() {
        return artefactosDelPersonaje;
    }

    public boolean setArtefactosDelPersonaje(Artefacto artefactosDelPersonaje) {
        boolean equipado = false;

        if (this.artefactosDelPersonaje.size() <= 3) {
            if (comprobarAmuletoEqupado(artefactosDelPersonaje) == true
                    || artefactosDelPersonaje.getTipo().equals("anillo")) {
                this.artefactosDelPersonaje.add(artefactosDelPersonaje);
                equipado = true;
            }
        }

        return equipado;
    }

    // metodos
    public void subirNivel() {
        nivel += 1;
        vitalidad = vitalidad + ((int) (vitalidad * 0.1));
        int probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad >= 50) {
            fuerza += nivel;
        }
        probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad >= 50) {
            agilidad += nivel;
        }
        probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad >= 50) {
            fortaleza += nivel;
        }
        probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad >= 50) {
            resistenciaMagica += nivel;
        }

    }

    public int porcentaje(int vida) {
        double entero = vida;
        entero = entero + (entero * 0.1);
        vida = (int) entero;
        return vida;
    }

    public int contarDaño() {
        int daño = 0;

        if (armaDelPersonaje != null) {
            daño = armaDelPersonaje.recuperaEstadistica("ataque");
        }

        for (Artefacto i : artefactosDelPersonaje) {
            daño += i.recuperaEstadistica("ataque");
        }

        return daño;
    }

    public int contarDefensaFisica() {
        int defensa = 0;

        if (armadurasDelPersonaje.containsKey("yelmo")) {
            defensa += armadurasDelPersonaje.get("yelmo").recuperaEstadistica("armadura");
        }
        if (armadurasDelPersonaje.containsKey("pechera")) {
            defensa += armadurasDelPersonaje.get("pechera").recuperaEstadistica("armadura");
        }
        if (armadurasDelPersonaje.containsKey("hombreras")) {
            defensa += armadurasDelPersonaje.get("hombreras").recuperaEstadistica("armadura");
        }
        if (armadurasDelPersonaje.containsKey("guanteletes")) {
            defensa += armadurasDelPersonaje.get("guanteletes").recuperaEstadistica("armadura");
        }
        if (armadurasDelPersonaje.containsKey("grebas")) {
            defensa += armadurasDelPersonaje.get("grebas").recuperaEstadistica("armadura");
        }
        if (armadurasDelPersonaje.containsKey("botas")) {
            defensa += armadurasDelPersonaje.get("botas").recuperaEstadistica("5armadura");
        }

        for (Artefacto i : artefactosDelPersonaje) {
            defensa += i.recuperaEstadistica("armadura");
        }

        return defensa;
    }

    public int contarDefensaMagica() {
        int defensa = 0;

        if (armadurasDelPersonaje.containsKey("yelmo")) {
            defensa += armadurasDelPersonaje.get("yelmo").recuperaEstadistica("resistenciaMagica");
        }
        if (armadurasDelPersonaje.containsKey("pechera")) {
            defensa += armadurasDelPersonaje.get("pechera").recuperaEstadistica("resistenciaMagica");
        }
        if (armadurasDelPersonaje.containsKey("hombreras")) {
            defensa += armadurasDelPersonaje.get("hombreras").recuperaEstadistica("resistenciaMagica");
        }
        if (armadurasDelPersonaje.containsKey("guanteletes")) {
            defensa += armadurasDelPersonaje.get("guanteletes").recuperaEstadistica("resistenciaMagica");
        }
        if (armadurasDelPersonaje.containsKey("grebas")) {
            defensa += armadurasDelPersonaje.get("grebas").recuperaEstadistica("resistenciaMagica");
        }
        if (armadurasDelPersonaje.containsKey("botas")) {
            defensa += armadurasDelPersonaje.get("botas").recuperaEstadistica("resistenciaMagica");
        }

        for (Artefacto i : artefactosDelPersonaje) {
            defensa += i.recuperaEstadistica("resistenciaMagica");
        }

        return defensa;
    }

    public int luchar() {
        int daño = contarDaño();
        return fuerza + daño;
    }

    public void defender(int ataque, PersonajeRol a) {
        int defensa = 0;

        switch (a.getClass().getSimpleName()) {
            case "Mago":
                defensa = this.resistenciaMagica + this.contarDefensaMagica();
                ataque -= defensa;
                if (ataque < 0) {
                    ataque = 0;
                }
                this.vitalidad -= ataque;
                break;
            default:
                defensa += this.getFortaleza() + this.contarDefensaFisica();
                ataque -= defensa;
                if (ataque < 0) {
                    ataque = 0;
                }
                this.vitalidad -= ataque;
                break;
        }
    }

    public String toString() {
        String resultado = "nombre: " + nombre + "\n" +
                "Clase: " + this.getClass().getSimpleName() + "\n" +
                "raza: " + raza + "\n" + "\n" +

                "nivel: " + nivel + "\n" +
                "vitalidad: " + vitalidad + "\n" +
                "fuerza: " + fuerza + "\n" +
                "agilidad: " + agilidad + "\n" +
                "fortaleza: " + fortaleza + "\n" +
                "resistencia magica: " + resistenciaMagica + "\n" + "\n" +
                "Está actualmente:";
        if (vivo) {
            resultado += " vivo\n";
        } else
            resultado += " no vivo\n\n";

        return resultado;
    }

    public boolean comprobarAmuletoEqupado(Artefacto artefacto) {
        boolean resultado = true;
        for (int i = 0; i < this.artefactosDelPersonaje.size(); i++) {
            if (this.artefactosDelPersonaje.get(i).getTipo().equals("amuleto")) {
                resultado = false;
            }
        }
        return resultado;
    }

    public boolean PersonajesCasen(String path) throws IOException {
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);

        boolean casan = true;
        String linea = "";
        String[] campos = new String[1];

        br.readLine();
        br.readLine();
        linea = br.readLine();
        campos = linea.split(": ");
        if (!campos[1].equals(this.getNombre())) {
            casan = false;
            this.setNombre(campos[1]);
            System.out.println("ERROR nombre");
        }

        linea = br.readLine();
        campos = linea.split(": ");
        if (!campos[1].equals(this.getClass().getSimpleName())) {
            casan = false;
            System.out.println("ERROR FATAL TIPO DE PERSONAJE MUY DISTINTO");
        }

        linea = br.readLine();
        campos = linea.split(": ");
        if (!campos[1].equals(this.getRaza())) {
            casan = false;
            this.setRaza(campos[1]);
            System.out.println("ERROR raza");
        }

        br.readLine();
        linea = br.readLine();
        campos = linea.split(": ");
        int nivel = Integer.parseInt(campos[1]);
        if (nivel != this.getNivel()) {
            casan = false;
            this.setNivel(nivel);
            System.out.println("error nivel");
        }

        linea = br.readLine();
        campos = linea.split(": ");
        int vitalidad = Integer.parseInt(campos[1]);
        if (vitalidad != this.getVitalidad()) {
            casan = false;
            this.setVitalidad(vitalidad);
            System.out.println("error vida");
        }

        linea = br.readLine();
        campos = linea.split(": ");
        int fuerza = Integer.parseInt(campos[1]);
        if (fuerza != this.getFuerza()) {
            casan = false;
            this.setFuerza(fuerza);
            System.out.println("error fuerza");
        }

        linea = br.readLine();
        campos = linea.split(": ");
        int agilidad = Integer.parseInt(campos[1]);
        if (agilidad != this.getAgilidad()) {
            casan = false;
            this.setAgilidad(agilidad);
            System.out.println("error agilidad");
        }

        linea = br.readLine();
        campos = linea.split(": ");
        int fortaleza = Integer.parseInt(campos[1]);
        if (fortaleza != this.getFortaleza()) {
            casan = false;
            this.setFortaleza(fortaleza);
            System.out.println("error fortaleza");
        }

        linea = br.readLine();
        campos = linea.split(": ");
        int resistenciaMagica = Integer.parseInt(campos[1]);
        if (resistenciaMagica != this.getResistenciaMagica()) {
            casan = false;
            this.setResistenciaMagica(resistenciaMagica);
            System.out.println("error resistencia magica");
        }

        br.readLine();
        linea = br.readLine();
        campos = linea.split(": ");
        boolean vivo;
        if (campos[1].equals("vivo"))
            vivo = true;
        else
            vivo = false;
        if (vivo != this.getvivo()) {
            casan = false;
            this.setVivo(vivo);
            System.out.println("error vivo");
        }

        br.close();
        fr.close();

        return casan;
    }

}
