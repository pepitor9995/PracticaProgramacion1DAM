package practicatema5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Guerrero extends PersonajeRol {
    // atributos
    private boolean furia;
    private Arma armaComple;

    // constructores
    public Guerrero() {
        super();

        furia = false;
        armaComple = new Arma();
    }

    public Guerrero(Guerrero a) {
        super(a);

        this.setFuria(a.getFuria());

    }

    public Guerrero(String nombre, String raza) {
        super(nombre, raza);
    }

    public Guerrero(String path) throws IOException {
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
        if (campos[1].equals("furioso"))
            this.furia = true;
        else
            this.furia = false;

        br.close();
        fr.close();
    }

    // setters y getters
    public boolean getFuria() {
        return furia;
    }

    public void setFuria(boolean furia) {
        this.furia = furia;
    }

    public Arma getArmaComple() {
        return armaComple;
    }

    public void setArmaComple(Arma arma) {
        if (this.getArmaDelPersonaje().getEmpuñadura().equals("una mano") && arma.getEmpuñadura().equals("una mano")) {
            if (!arma.getTipo().equals("cetro") || !arma.getTipo().equals("arco") || !arma.getTipo().equals("baston")) {
                this.armaComple = new Arma(arma);
            } else
                System.err.println("El arma no puede ser un cetro, arco o baston");
        } else
            System.err.println("El arma tiene que ser a una mano");
    }

    // metodos
    public void subirNivel() {
        int nivel = getNivel();
        nivel += 1;
        setNivel(nivel);
        int probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad >= 20) {
            int fuerzaGuerrero = getFuerza();
            fuerzaGuerrero += nivel * 2;
            setFuerza(fuerzaGuerrero);
        }
        probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad >= 25) {
            setVitalidad(getVitalidad() + (int) (getVitalidad() * 0.1));
            setFortaleza(getFortaleza() + getNivel());
        }
        probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad >= 80) {
            int resistenciMagicaGuerrero = getResistenciaMagica();
            resistenciMagicaGuerrero += (int) Math.round(nivel);
            setResistenciaMagica(resistenciMagicaGuerrero);
        }

        probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad >= 50) {
            setAgilidad(getAgilidad() + nivel);
        }
    }

    public int luchar() {
        int daño = contarDaño();
        if (furia == true) {
            return ((getFuerza() * 2) + daño);
        } else
            return getFuerza() + daño;
    }

    public void defender(int ataque, PersonajeRol a) {
        int defensa = 0;

        if (!this.furia) {
            switch (a.getClass().getSimpleName()) {
                case "Mago":
                    defensa += this.getResistenciaMagica() + this.contarDefensaMagica();
                    ataque -= defensa;
                    this.setVitalidad(this.getVitalidad() - ataque);
                    break;
                default:
                    defensa += this.getFortaleza() + this.contarDefensaFisica();
                    ataque -= defensa;
                    if (ataque < 0) {
                        ataque = 0;
                    }
                    this.setVitalidad(this.getVitalidad() - ataque);
                    break;
            }
        } else {
            switch (a.getClass().getSimpleName()) {
                case "Mago":
                    defensa += this.getResistenciaMagica() + this.contarDefensaMagica();
                    ataque -= defensa;
                    this.setVitalidad(this.getVitalidad() - (ataque * 2));
                    break;
                default:
                    defensa += this.getFortaleza() + this.contarDefensaFisica();
                    ataque -= defensa;
                    if (ataque < 0) {
                        ataque = 0;
                    }
                    this.setVitalidad(this.getVitalidad() - (ataque * 2));
                    break;
            }
        }
    }

    public void equiparArma(Arma arma) {
        if (!arma.getTipo().equals("cetro") || !arma.getTipo().equals("arco") || !arma.getTipo().equals("baston")) {
            setArmaDelPersonaje(arma);
        }
    }

    public void equiparArmaduras(Armadura armadura) {
        if (armadura.getMaterial().equals("metal")) {
            setArmadurasDelPersonaje(armadura);
        }
    }

    public void equiparArtefactos(Artefacto artefacto) {
        setArtefactosDelPersonaje(artefacto);
    }

    public String toString() {// tengo que revisarlo y el de todos los demas tambien
        String resultado = "Ficha del Guerrero: " + getNombre() + "\n" + "\n"
                + super.toString() + "\n"
                + "Furia: ";
        if (furia)
            resultado += "furioso\n\n";
        else
            resultado += "No furioso\n\n";

        /*
         * resultado += "El equipamiento del guerrero consta de: \n\n" +
         * this.getArmaDelPersonaje().toString() + "\n\n" +
         * this.getArmadurasDelPersonaje().toString() + "\n\n" +
         * this.getArtefactosDelPersonaje().toString();
         */

        return resultado;
    }

    public boolean PersonajesCasen(String path) throws IOException {
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);

        String linea = "";
        String[] campos = new String[1];

        boolean casan = super.PersonajesCasen(path);

        for (int i = 0; i < 14; i++) {
            br.readLine();
        }

        linea = br.readLine();
        campos = linea.split(": ");
        boolean furias;

        if (campos[1].equals("furioso")) {
            furias = true;
        } else
            furias = false;

        if (furias != this.getFuria()) {
            casan = false;
            this.setFuria(furias);
            System.out.println("error furia");
        }

        if (casan == true) {
            System.out.println("El guerrero esta perfecto");
        } else
            System.out.println("El guerrero no esta perfecto");

        br.close();
        fr.close();

        return casan;
    }
}
