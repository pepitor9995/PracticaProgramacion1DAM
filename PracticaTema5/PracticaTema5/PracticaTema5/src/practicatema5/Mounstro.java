package practicatema5;

import java.io.IOException;

public class Mounstro extends PersonajeRol {
    // constructores
    public Mounstro() {
        super();
    }

    public Mounstro(Mounstro a) {
        super(a);
        this.setraza(a.getRaza());
    }

    public Mounstro(String nombre, String raza) {
        super(nombre, raza);
        this.setraza(raza);
    }

    public Mounstro(String path) throws IOException {
        super(path);
    }

    // getter y setter de raza
    public String getRaza() {
        return super.getRaza();
    }

    public void setraza(String raza) {
        raza = raza.toLowerCase();
        switch (raza) {
            case "bestia":
                setRaza(raza);
                break;
            case "no-muerto":
                setRaza(raza);
                break;
            case "gigante":
                setRaza(raza);
                break;
            default:
                setRaza("");
        }
    }

    // metodos
    public void subirNivel() {
        switch (getRaza()) {
            case "bestia":
                setNivel(getNivel() + 1);
                setFuerza(getNivel() * 2);
                setAgilidad(getAgilidad() * 2);
                setVitalidad(getVitalidad() + getNivel() + 1);
                setFortaleza(getFortaleza() + ((int) (getNivel() / 2)));
                setResistenciaMagica(getResistenciaMagica() + ((int) (getNivel() / 2)));
                break;
            case "no-muerto":
                setNivel(getNivel() + 1);
                setResistenciaMagica(getResistenciaMagica() + getNivel() * 4);
                setFuerza(getFuerza() + getNivel());
                setVitalidad(getVitalidad() + ((int) (getNivel() / 2)));
                setFortaleza(getFortaleza() + ((int) (getNivel() / 2)));
                setAgilidad(getAgilidad() + ((int) (getNivel() * 0.25)));
                break;
            case "gigante":
                setNivel(getNivel() + 1);
                setVitalidad(getVitalidad() + getNivel() * 4);
                setFuerza(getFuerza() + getNivel() * 4);
                setFortaleza(getFortaleza() + getNivel());
                setAgilidad(getAgilidad() + ((int) (getNivel() * 0.25)));
                setResistenciaMagica(getResistenciaMagica() + ((int) (getNivel() * 0.25)));
                break;
            default:
                break;
        }
    }

    public boolean equiparArma(Arma arma) {
        boolean equipado = true;

        switch (getRaza()) {
            case "bestia":
                equipado = false;
                break;
            case "no_muerto":
                super.setArmaDelPersonaje(arma);
                equipado = super.setArmaDelPersonaje(arma);
                break;
            case "gigante":
                equipado = false;
                break;
            default:
                break;
        }
        return equipado;
    }

    public boolean equiparArmaduras(Armadura armadura) {
        boolean equipado = true;

        switch (getRaza()) {
            case "bestia":
                equipado = false;
                break;
            case "no-muerto":
                equipado = false;
                break;
            case "gigante":
                setArmadurasDelPersonaje(armadura);
                equipado = setArmadurasDelPersonaje(armadura);
                break;
        }
        return equipado;
    }

    public boolean equiparArtefactos(Artefacto artefacto) {
        boolean equipado = true;

        switch (getRaza()) {
            case "bestia":
                if (this.getArmadurasDelPersonaje().size() < 1) {
                    setArtefactosDelPersonaje(artefacto);
                    equipado = setArtefactosDelPersonaje(artefacto);
                } else
                    equipado = false;
                break;
            case "no-muerto":
                setArtefactosDelPersonaje(artefacto);
                equipado = setArtefactosDelPersonaje(artefacto);
                break;
            case "gigante":
                setArtefactosDelPersonaje(artefacto);
                equipado = setArtefactosDelPersonaje(artefacto);
                break;
            default:
                break;
        }
        return equipado;
    }

    public String toString() {
        String resultado = "Fiche del Mounstro: " + getNombre() + "\n" + "\n"
                + super.toString();
        return resultado;
    }

    public boolean PersonajesCasen(String path) throws IOException {
        boolean casan = super.PersonajesCasen(path);

        if (casan == true) {
            System.out.println("el monstruo esta perfecto");
        } else
            System.out.println("el monstruo no esta perfecto");

        return casan;
    }

}
