
package Objetos_BDD;

/**
 *
 * @author Jose Manuel Lopez Sanchez
 */
public class Herramienta {
    
    private short id_herram;
    private String marca;
    private String modelo;
    private short tipo;
    private String propietario;
    private float consumo;
    private short en_uso;
    private short cant_total;

    public Herramienta(short id_herram, String marca, String modelo, 
            short tipo, String propietario, float consumo, 
            short en_uso, short cant_total) {
        this.id_herram = id_herram;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
        this.propietario = propietario;
        this.consumo = consumo;
        this.en_uso = en_uso;
        this.cant_total = cant_total;
    }

    public short getId_herram() {
        return id_herram;
    }

    public void setId_herram(short id_herram) {
        this.id_herram = id_herram;
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

    public short getTipo() {
        return tipo;
    }

    public void setTipo(short tipo) {
        this.tipo = tipo;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public float getConsumo() {
        return consumo;
    }

    public void setConsumo(float consumo) {
        this.consumo = consumo;
    }

    public short getEn_uso() {
        return en_uso;
    }

    public void setEn_uso(short en_uso) {
        this.en_uso = en_uso;
    }

    public short getCant_total() {
        return cant_total;
    }

    public void setCant_total(short cant_total) {
        this.cant_total = cant_total;
    }
}
