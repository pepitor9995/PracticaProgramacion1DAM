package practicatema5;

public class Arma extends Equipamiento{
    //atributos
    private String empuñadura;
    private String tipo;



    //constructores
    public Arma(){
        this.empuñadura=this.tipo="";

    }
    public Arma(String nombre, int ataque, int vel, int magia, int fe, String rareza, int valor, String empuñadura, String tipo){
        super(nombre, rareza, valor, 0,ataque, vel, magia, fe, 0,0);

        this.setEmpuñadura(empuñadura);
        this.setTipo(tipo);
    }
    public Arma(Arma arma){
        super(arma);

        this.setEmpuñadura(arma.getEmpuñadura());
        this.setTipo(arma.getTipo());
    }



    //getters y setters
    public String getEmpuñadura() {
        return empuñadura;
    }
    public void setEmpuñadura(String empuñadura) {
        if (empuñadura.equals("una mano") || empuñadura.equals("dos manos")){
            this.empuñadura = empuñadura.toLowerCase();
        }else System.err.println("Empuñadura erronea");
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        if (getEmpuñadura().equals("una mano")){
            switch (tipo.toLowerCase()){
                case "espada", "maza", "hacha", "cetro", "daga", "mangual":
                    this.tipo = tipo;
                    break;
                default:
                    System.err.println("Tipo de arma erroneo");
            }
        } else if (getEmpuñadura().equals("dos manos")) {
            switch (tipo.toLowerCase()){
                case "espadon", "martillo", "arco", "baston", "pica":
                    this.tipo = tipo;
                    break;
                default:
                    System.err.println("Tipo de arma erroneo");
            }
        }
    }



    //metodos
    public String toString(){
        return super.toString()+
                "\nEl arma es de: " + this.getEmpuñadura()+
                "\nEl tipo del arma es de: " + this.getTipo();
    }
    public boolean equals(Arma arma){
        boolean equals = super.equals(arma);

        if (this.getEmpuñadura().equals(arma.getEmpuñadura()) || this.getTipo().equals(arma.getTipo())){
            equals = false;
        }

        return equals;
    }
}
