package practicatema5;

import java.util.HashMap;

public abstract class Equipamiento {
    //atributos
    private String nombre;
    private HashMap<String, Integer> estadisticas;
    private String rareza;
    private int valor;



    //constructores
    public Equipamiento(){
        this.nombre = "";
        this.estadisticas = new HashMap<>();
        this.rareza = "";
        this.valor = 0;
    }
    public Equipamiento(String nombre, String rareza, int valor, int hp, int ataque, int vel, int magia, int fe, int armadura, int resistenciaMagica){
        setNombre(nombre);
        setRareza(rareza);
        setValor(valor);

        setEstadisticas(hp, ataque, vel, magia, fe, armadura, resistenciaMagica);
    }
    public Equipamiento(Equipamiento a){
        this.setNombre(a.getNombre());
        this.setEstadisticas(a.recuperaEstadistica("hp"),
                a.recuperaEstadistica("ataque"),
                a.recuperaEstadistica("vel"),
                a.recuperaEstadistica("magia"),
                a.recuperaEstadistica("fe"),
                a.recuperaEstadistica("armadura"),
                a.recuperaEstadistica("resistenciaMagica"));
        this.setRareza(a.getRareza());
        this.setValor(a.getValor());
    }



    //getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        //en el archivo hay armas y armaduras con el nombre mas largo
        if (nombre.length() <= 30){
            this.nombre = nombre;
        }else System.err.println("Tamaño maximo del nombre 30 caracteres, intentalo otra vez");
    }
    public HashMap<String, Integer> getEstadisticas() {
        return estadisticas;
    }
    public void setEstadisticas(int hp, int ataque, int vel, int magia, int fe, int armadura, int resisMagica) {
        this.estadisticas = new HashMap<>();
        this.estadisticas.put("hp", hp);
        this.estadisticas.put("ataque", ataque);
        this.estadisticas.put("vel", vel);
        this.estadisticas.put("magia", magia);
        this.estadisticas.put("fe", fe);
        this.estadisticas.put("armadura", armadura);
        this.estadisticas.put("resistenciaMagica", resisMagica);
    }
    public String getRareza() {
        return rareza;
    }
    public void setRareza(String rareza) {
        rareza = rareza.toLowerCase();
        if (rareza.equals("comun") || rareza.equals("raro") || rareza.equals("epico") || rareza.equals("legendario")){
            this.rareza = rareza;
        }else System.err.println("Rareza imposible");
    }
    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        if (valor >= 1){
            this.valor = valor;
        }else System.err.println("Valor del equipamiento imposible");
    }


    //metodos de la clase
    public int recuperaEstadistica(String estadistica){
        int estadisticaRecuperada = 0;
        if (this.estadisticas.containsKey(estadistica)){
            estadisticaRecuperada = this.estadisticas.get(estadistica);
        }

        return estadisticaRecuperada;
    }
    public String toString(){
        return "El nombre del equipamiento es: "+this.getNombre()+
                "\nEl artefacto es: " + this.getClass().getSimpleName()+
                "\nSus estadisticas son: "+
                "\nHp: " + this.recuperaEstadistica("hp")+
                "\nAtaque: " + this.recuperaEstadistica("ataque")+
                "\nVel: " + this.recuperaEstadistica("vel")+
                "\nMagia: " + this.recuperaEstadistica("magia")+
                "\nFe: " + this.recuperaEstadistica("fe")+
                "\nArmadura: " + this.recuperaEstadistica("armadura")+
                "\nResistenciaMagica: " + this.recuperaEstadistica("resistenciaMagica")+
                "\nTiene una rareza de: " + this.getRareza()+
                "\nTiene un valor de: " + this.getValor();
    }
    public boolean equals(Equipamiento a){
        Boolean equals = true;

        if (this.nombre != a.getNombre())
            equals = false;

        if (this.recuperaEstadistica("hp") != a.recuperaEstadistica("hp"))
            equals = false;


        if (this.recuperaEstadistica("ataque") != a.recuperaEstadistica("ataque"))
            equals = false;

        if (this.recuperaEstadistica("vel") != a.recuperaEstadistica("vel"))
            equals = false;

        if (this.recuperaEstadistica("magia") != a.recuperaEstadistica("magia"))
            equals = false;

        if (this.recuperaEstadistica("fe") != a.recuperaEstadistica("fe"))
            equals = false;

        if (this.recuperaEstadistica("armadura") != a.recuperaEstadistica("armadura"))
            equals = false;

        if (this.recuperaEstadistica("resistenciaMagica") != a.recuperaEstadistica("resistenciaMagica"))
            equals = false;

        if (this.getRareza() != a.getRareza())
            equals = false;

        if (this.getValor() != a.getValor())
            equals = false;

        return equals;
    }
}
