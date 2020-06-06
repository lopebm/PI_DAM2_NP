
package Objetos_BDD;

/**
 *
 * @author Jose Manuel Lopez Sanchez
 */
public class Vehiculo {
    
    private String matricula;
    private String marca;
    private String modelo;
    private String propietario;
    private char en_uso;
    private float consumo;

    public Vehiculo(String matricula, String marca, String modelo, String propietario, char en_uso, float consumo) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.propietario = propietario;
        this.en_uso = en_uso;
        this.consumo = consumo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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
