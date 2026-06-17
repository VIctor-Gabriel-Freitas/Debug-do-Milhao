package Model;

import org.w3c.dom.Text;

public class Alternativa {
    private String texto;
    private boolean correta;

    public void alternativa(String texto, boolean correta) {
        this.texto = texto;
        this.correta = correta;
    }


    public String getTexto() {
        return this.texto;
    }

    public boolean isCorreta() {
        return this.correta;
    }

    public String getText() {
        return this.texto;
    }
}