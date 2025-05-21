package practicatema5;

import java.io.IOException;

public class Ladron extends PersonajeRol{

    //constructores
    public Ladron(){
        super();
    }
    public Ladron(String nombre, String raza){
        super(nombre, raza);
    }
    public Ladron(Ladron a){
        super(a);
    }
    public Ladron(String path) throws IOException {
        super(path);
    }



    //Metodos
    public void subirNivel(){
        setNivel(getNivel() + 1);

        setVitalidad(getVitalidad() + (int) (getVitalidad() * 0.1));

        int probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad <= 85){
            setAgilidad(getAgilidad() + (getNivel() * 2));
        }

        probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad <= 60){
            setFuerza(getFuerza() + getNivel());
        }

        probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad >= 40){
            setFortaleza(getFortaleza() + getNivel());
        }

        probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad >= 40){
            setResistenciaMagica(getResistenciaMagica() + getNivel());
        }
    }
    public int robar(){
        return getAgilidad();
    }
    public void equiparArma(Arma arma){
        if (arma.getTipo().equals("espada") || arma.getTipo().equals("daga")){
            setArmaDelPersonaje(arma);
        }
    }
    public void equiparArmaduras(Armadura armadura){
        if (armadura.getMaterial().equals("cuero")){
            setArmadurasDelPersonaje(armadura);
        }
    }
    public void equiparArtefactos(Artefacto artefacto){
        setArtefactosDelPersonaje(artefacto);
    }
    public String toString(){
        String resultado ="Ficha del Ladron: "+getNombre()+"\n"+"\n"
                + super.toString()+"\n";
        return resultado;
    }
    public boolean PersonajesCasan(String path) throws IOException{
        boolean casan = super.PersonajesCasen(path);

        if (casan == true){
            System.out.println("El ladron es perfecto");
        }else System.out.println("El ladon no es perfecto");

        return casan;
    }
}
