
package Objetos_BDD;

/**
 *
 * @author Jose Manuel Lopez Sanchez
 */
public class Apero {
    
    private short id_apero;
    private String marca;
    private String modelo;
    private String propietario;
    private char en_uso;
    private float consumo;

    public Apero(short id_apero, String marca, String modelo, 
            String propietario, char en_uso, float consumo) {
        this.id_apero = id_apero;
        this.marca = marca;
        this.modelo = modelo;
        this.propietario = propietario;
        this.en_uso = en_uso;
        this.consumo = consumo;
    }

    public short getId_apero() {
        return id_apero;
    }

    public void setId_apero(short id_apero) {
        this.id_apero = id_apero;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public char getEn_uso() {
        return en_uso;
    }

    public void setEn_uso(char en_uso) {
        this.en_uso = en_uso;
    }

    public float getConsumo() {
        return consumo;
    }

    public void setConsumo(float consumo) {
        this.consumo = consumo;
    }
}
