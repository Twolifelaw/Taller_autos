package modelo;

public abstract class Vehiculo {
    /**
     * estos son los atributos den objeto.
     */
    private String placa;
    private String marca;
    private String referencia;
    private String modelo;
    private double precio;
    private int num_ruedas;

    /**
     * Constructor vacio vehiculo.
     */
    public Vehiculo() {
    }

    /**
     * Constructor definiendo atributos.
     * 
     * @param placa
     * @param marca
     * @param referencia
     * @param modelo
     * @param precio
     * @param num_ruedas
     */

    public Vehiculo(String placa, String marca, String referencia, String modelo, double precio, int num_ruedas) {
        this.placa = placa;
        this.marca = marca;
        this.referencia = referencia;
        this.modelo = modelo;
        this.precio = precio;
        this.num_ruedas = num_ruedas;
    }

    

    @Override
    public String toString() {
        String s = "Vehiculo [placa=" + placa + ", marca=" + marca + ", referencia=" + referencia + ", modelo=" + modelo
                + ", precio=" + precio + ", num_ruedas=" + num_ruedas + "]";
            return s;
    }

    /**
     * Getters and Setters.
     * 
     * @return
     */

    public String getPlaca() {
        return placa;
    }


    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getNum_ruedas() {
        return num_ruedas;
    }

    public void setNum_ruedas(int num_ruedas) {
        this.num_ruedas = num_ruedas;
    }

   

}
