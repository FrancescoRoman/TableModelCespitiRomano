package itiscuneo.backend;

import java.time.LocalDate;
import java.util.Objects;

public class Cespiti {

    private static final String SEPARATORE = "," ;
    private String codice;
    private int quantita;
    private LocalDate dataAcquisto;

    public Cespiti(String codice, int quantita, LocalDate dataAcquisto) {
        this.codice = codice;
        this.quantita = quantita;
        this.dataAcquisto = dataAcquisto;
    }

    @Override
    public String toString() {
        return "Cespiti{" +
                "codice='" + codice + '\'' +
                ", quantita=" + quantita +
                ", dataAcquisto=" + dataAcquisto +
                '}';
    }

    public String toCsv() {
        return "Cespiti{" +
                codice + SEPARATORE +
                SEPARATORE + quantita +
                SEPARATORE + dataAcquisto +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cespiti cespiti = (Cespiti) o;
        return quantita == cespiti.quantita && Objects.equals(codice, cespiti.codice) && Objects.equals(dataAcquisto, cespiti.dataAcquisto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codice, quantita, dataAcquisto);
    }
}
