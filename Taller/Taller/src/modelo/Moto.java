package modelo;

public class Moto extends Vehiculo {

    /**
     * Atributos de moto
     */
    private int cilindraje;
    private int tam_tanque;

    /**
     * Constructo vacio.
     */
    public Moto() {
    }

    /**
     * Constructor con atrubutos definidos.
     * 
     * @param placa
     * @param marca
     * @param referencia
     * @param modelo
     * @param precio
     * @param num_ruedas
     * @param cilindraje
     * @param tam_tanque
     */
    public Moto(String placa, String marca, String referencia, String modelo, double precio, int num_ruedas,
            int cilindraje, int tam_tanque) {
        super(placa, marca, referencia, modelo, precio, num_ruedas);
        this.cilindraje = cilindraje;
        this.tam_tanque = tam_tanque;
    }

    @Override
    public String toString() {
        return super.toString() + // Llama al toString de la superclase (Vehiculo)
                "\nCilindraje: " + cilindraje +
                "\ntamaño tanque: " + tam_tanque;
    }

    /**
     * Getters and Settersb
     * 
     * @return
     */

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    public int getTam_tanque() {
        return tam_tanque;
    }

    public void setTam_tanque(int tam_tanque) {
        this.tam_tanque = tam_tanque;
    }

}
