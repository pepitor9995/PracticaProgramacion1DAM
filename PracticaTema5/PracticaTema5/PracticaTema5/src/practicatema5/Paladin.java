package practicatema5;

import java.io.IOException;

public class Paladin extends Creyente{
    //constructores
    public Paladin(){
        super();
    }
    public Paladin(Paladin a){
        super(a);
    }
    public Paladin(String nombre, String raza){
        super(nombre, raza);
    }
    public Paladin(String path) throws IOException {
        super(path);
    }



    //metodos
    public void subirNivel(){
        setNivel(getNivel()+1);

        int probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad <= 50){
            setVitalidad(getVitalidad() + ((int) (getVitalidad() * 0.1)) + ((int) (getVitalidad() * 0.05)));
        }else setVitalidad(getVitalidad() + (int) (getVitalidad() * 0.2));

        probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad <= 70){
            setFortaleza(getFortaleza() + (getNivel() * 2));
        }

        probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad <= 60){
            setFuerza(getFuerza() + getNivel());
        }

        probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad <= 15){
            setAgilidad(getAgilidad() + ((int) (getNivel() * 0.25)));
        }

        probabilidad = (int) (Math.random() * 100) + 1;
        if (probabilidad <= 30){
            setFe(getFe() + getNivel());
        }
    }
    public int plegaria(int milagro, String objetivo) {
        System.out.println("1) Imbuir arma 2)Baluarte de fe");
        switch (milagro){
            case 1:
                return getFe() + ((int) (getFe() * 0.8));
            case 2:
                setFortaleza(getFortaleza() + ((int) (getFe()+ 0.3)));
                break;
        }
        return 0;
    }
    public void equiparArma(Arma arma){
        if (!arma.getTipo().equals("arco") || !arma.getTipo().equals("baston")){
            setArmaDelPersonaje(arma);
        }
    }
    public void equiparArmaduras(Armadura armadura){
        if (armadura.getMaterial().equals("metal")){
            setArmadurasDelPersonaje(armadura);
        }
    }
    public void equiparArtefactos(Artefacto artefacto){
        setArtefactosDelPersonaje(artefacto);
    }
    public String toString(){
        String resultado = "Ficha del Paladin: "+getNombre()+"\n"+"\n"
                +super.toString();
        return resultado;
    }
    public boolean PersonajesCasen(String path) throws IOException{
        boolean casan = super.PersonajesCasen(path);

        if (casan == true){
            System.out.println("el paladin esta perfecto");
        }
        else System.out.println("el paladin no esta perfecto");

        return casan;
    }
}
