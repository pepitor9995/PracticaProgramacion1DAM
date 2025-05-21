package practicatema5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Cazador extends PersonajeRol {
    public class CompiAnimal extends PersonajeRol {
        // constructores
        public CompiAnimal() {
            super();
        }

        public CompiAnimal(CompiAnimal a) {
            super(a);
            this.setRaza(a.getRaza());
        }

        public CompiAnimal(String nombre, String raza) {
            super(nombre, raza);
            setRaza(raza);
        }

        public CompiAnimal(String path) throws IOException {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);

            String linea = "";
            String[] campos = new String[1];

            for (int i = 0; i < 17; i++) {
                br.readLine();
            }

            linea = br.readLine();
            campos = linea.split(": ");
            this.setNombre(campos[1]);

            br.readLine();
            linea = br.readLine();
            campos = linea.split(": ");
            this.setRaza(campos[1]);

            br.readLine();
            linea = br.readLine();
            campos = linea.split(": ");
            int nivel = Integer.parseInt(campos[1]);
            this.setNivel(nivel);

            linea = br.readLine();
            campos = linea.split(": ");
            int vitalidad = Integer.parseInt(campos[1]);
            this.setVitalidad(vitalidad);

            linea = br.readLine();
            campos = linea.split(": ");
            int fuerza = Integer.parseInt(campos[1]);
            this.setFuerza(fuerza);

            linea = br.readLine();
            campos = linea.split(": ");
            int agilidad = Integer.parseInt(campos[1]);
            this.setAgilidad(agilidad);

            linea = br.readLine();
            campos = linea.split(": ");
            int fortaleza = Integer.parseInt(campos[1]);
            this.setFortaleza(fortaleza);

            linea = br.readLine();
            campos = linea.split(": ");
            int resistenciaMagica = Integer.parseInt(campos[1]);
            this.setResistenciaMagica(resistenciaMagica);

            br.readLine();
            linea = br.readLine();
            campos = linea.split(": ");
            boolean vivo;
            if (campos[1].equals("vivo"))
                vivo = true;
            else
                vivo = false;
            this.setVivo(vivo);

            br.close();
            fr.close();

        }

        // setter y metodos
        public void setRaza(String raza) {
            switch (raza.toLowerCase()) {
                case "canido":
                    canido();
                    super.setRaza(raza);
                    break;
                case "felino":
                    felino();
                    setRaza(raza);
                    break;
                case "rapaz":
                    rapaz();
                    setRaza(raza);
                    break;
                default:
                    System.out.println("La raza no es correcto, se asignara a Canido automaticamente");
                    canido();
                    super.setRaza("canido");
                    break;
            }
        }

        public void canido() {
            setNivel(Cazador.this.getNivel());
            setVitalidad((int) (Cazador.this.getVitalidad() * 0.2));
            setFuerza((int) (Cazador.this.getFuerza() * 0.2));
            setAgilidad((int) (Cazador.this.getAgilidad() * 0.2));
            setFortaleza((int) (Cazador.this.getFortaleza() * 0.2));
            setResistenciaMagica(((int) (Cazador.this.getResistenciaMagica() * 0.2)));
        }

        public void felino() {
            setNivel(Cazador.this.getNivel());
            setVitalidad((int) (Cazador.this.getVitalidad() * 0.15));
            setFuerza((int) (Cazador.this.getFuerza() * 0.3));
            setAgilidad((int) (Cazador.this.getAgilidad() * 0.3));
            setFortaleza((int) (Cazador.this.getFortaleza() * 0.15));
            setResistenciaMagica(((int) (Cazador.this.getResistenciaMagica() * 0.15)));
        }

        public void rapaz() {
            setNivel(Cazador.this.getNivel());
            setVitalidad((int) (Cazador.this.getVitalidad() * 0.05));
            setFuerza((int) (Cazador.this.getFuerza() * 0.15));
            setAgilidad((int) (Cazador.this.getAgilidad() * 0.35));
            setFortaleza((int) (Cazador.this.getFortaleza() * 0.05));
            setResistenciaMagica(((int) (Cazador.this.getResistenciaMagica() * 0.25)));
        }

        public void equiparArtefacto(Artefacto artefacto) {
            boolean comprobacion = comprobarCantArtefacto();

            if (comprobacion) {
                setArtefactosDelPersonaje(artefacto);
            } else
                System.err.println("No se pueden equipar varios artefactos al compañero animal");
        }

        public boolean comprobarCantArtefacto() {// preguntar si esto esta bien
            boolean cantArtefacto = false;

            if (getArtefactosDelPersonaje() == null) {
                cantArtefacto = true;
            }

            return cantArtefacto;
        }

        public String toString() {
            return "Ficha de CompiAnimal " + getNombre() + "\n" + "\n"
                    + super.toString() + "\n";
        }

    }

    // atributos
    private CompiAnimal animal;

    // constructores
    public Cazador() {
        super();
        this.animal = new CompiAnimal();
    }

    public Cazador(String path) throws IOException {
        super(path);
        this.animal = new CompiAnimal(path);
    }

    public Cazador(Cazador a) {
        super(a);
        this.animal = new CompiAnimal(a.animal);
    }

    public Cazador(String Nombre, String Raza, String nombreCompi, String razaCompi) {
        super(Nombre, Raza);
        this.animal = new CompiAnimal(nombreCompi, razaCompi);
    }

    // metodos
    public void subirNivel() {
        setNivel(getNivel() + 1);

        setVitalidad(getVitalidad() + (int) (getVitalidad() * 0.1));

        int probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad < 70) {
            setAgilidad(getAgilidad() + getNivel());
        }

        probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad < 50) {
            setFuerza(getFuerza() + getNivel());
        }

        probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad < 50) {
            setResistenciaMagica(getResistenciaMagica() + getNivel());
        }

        probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad < 50) {
            setFortaleza(getFortaleza() + getNivel());
        }

        animal.setRaza(this.animal.getRaza());
    }

    public int luchar() {
        int daño = (((int) this.contarDaño()) + ((int) this.animal.contarDaño()));
        return this.getFuerza() + this.animal.getFuerza() + daño;
    }

    public void equimarArma(Arma arma) {
        switch (arma.getTipo()) {
            case "espada", "hacha", "daga", "arco":
                setArmaDelPersonaje(arma);
                break;
            default:
                System.err.println("No se puede equipar un arma que no sea una espada, hacha, daga o arco");
        }
    }

    public void equimarArmaduras(Armadura armadura) {
        if (armadura.getMaterial().equals("cuero")) {
            setArmadurasDelPersonaje(armadura);
        } else
            System.err.println("No se puede equipar armaduras que no sean de curo");
    }

    public void equiparArtefactos(Artefacto artefacto) {
        setArtefactosDelPersonaje(artefacto);
    }

    public String toString() {
        return "Ficha del Cazador: " + getNombre() + "\n" + "\n" +
                super.toString() + "\n" + "\n" +
                animal.toString();
    }

    public boolean PersonajesCasen(String path) throws IOException {
        boolean casan = super.PersonajesCasen(path);

        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);

        String linea = "";
        String[] campos = new String[1];

        for (int i = 0; i < 17; i++) {
            br.readLine();
        }

        linea = br.readLine();
        campos = linea.split(": ");
        if (!campos[1].equals(this.animal.getNombre())) {
            casan = false;
            this.animal.setNombre(campos[1]);
            System.out.println("error en nombre animal");
        }

        linea = br.readLine();
        campos = linea.split(": ");
        if (!campos[1].equals(this.animal.getClass().getSimpleName())) {
            casan = false;
            System.out.println("ERROR FATAL TIPO DE COMPIANIMAL ES MUY DISTINTO");
        }

        linea = br.readLine();
        campos = linea.split(": ");
        if (!campos[1].equals(this.animal.getRaza())) {
            casan = false;
            this.animal.setRaza(campos[1]);
            System.out.println("error raza animal");
        }

        br.readLine();

        linea = br.readLine();
        campos = linea.split(": ");
        int nivel = Integer.parseInt(campos[1]);
        if (nivel != this.animal.getNivel()) {
            casan = false;
            this.animal.setNivel(nivel);
            System.out.println("error en el nivel del animal");
        }

        linea = br.readLine();
        campos = linea.split(": ");
        int vitalidad = Integer.parseInt(campos[1]);
        if (vitalidad != this.animal.getVitalidad()) {
            casan = false;
            this.animal.setVitalidad(vitalidad);
            System.out.println("error en la vida del animal");
        }

        linea = br.readLine();
        campos = linea.split(": ");
        int fuerza = Integer.parseInt(campos[1]);
        if (fuerza != this.animal.getFuerza()) {
            casan = false;
            this.animal.setFuerza(fuerza);
            System.out.println("error en la fuerza del animal");
        }

        linea = br.readLine();
        campos = linea.split(": ");
        int agilidad = Integer.parseInt(campos[1]);
        if (agilidad != this.animal.getAgilidad()) {
            casan = false;
            this.animal.setAgilidad(agilidad);
            System.out.println("error en la velocidad del animal");
        }

        linea = br.readLine();
        campos = linea.split(": ");
        int fortaleza = Integer.parseInt(campos[1]);
        if (fortaleza != this.animal.getFortaleza()) {
            casan = false;
            this.animal.setFortaleza(fortaleza);
            System.out.println("error en la defensa del animal");
        }

        linea = br.readLine();
        campos = linea.split(": ");
        int resistenciaMagica = Integer.parseInt(campos[1]);
        if (resistenciaMagica != this.animal.getResistenciaMagica()) {
            casan = false;
            this.animal.setResistenciaMagica(resistenciaMagica);
            System.out.println("error en la defensa magica del animal");
        }

        br.readLine();

        linea = br.readLine();
        campos = linea.split(": ");
        boolean vivo;
        if (campos[1].equals("vivo")) {
            vivo = true;
        } else
            vivo = false;

        if (vivo != this.animal.getvivo()) {
            casan = false;
            this.animal.setVivo(vivo);
            System.out.println("error en la vida del animal");
        }

        br.close();
        fr.close();

        if (casan == true) {
            System.out.println("El cazador y el compañero animal estan perfecto");
        } else
            System.out.println("Ni el cazador ni el compañero animal estan perfecto");
        return casan;
    }
}
