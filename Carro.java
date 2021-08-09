public class Carro implements Comparable<Carro> {

    private String nome;
    private char marcha;
    private double velocidade;
    private boolean ligado;

    public Carro(String nome) {
        this.nome = nome;
        this.marcha = 'N';
        this.velocidade = 0;
        this.ligado = false;
    }

    public String getNome() {
        return this.nome;
    }

    public double getVelocidade() {
        return this.velocidade;
    }

    public char getMarcha() {
        return this.marcha;
    }

    public void upMarcha() {

        if (this.marcha != '5') {

            if (this.marcha == 'N') {
                this.marcha = '1';
            } else if (this.marcha == '1') {
                this.marcha = '2';
            } else if (this.marcha == '2') {
                this.marcha = '3';
            } else if (this.marcha == '3') {
                this.marcha = '4';
            } else if (this.marcha == '4') {
                this.marcha = '5';
            }

        }

    }

    public void downMarcha() {

        if (this.marcha != 'N') {

            if (this.marcha == '1') {
                this.marcha = 'N';
            } else if (this.marcha == '2') {
                this.marcha = '1';
            } else if (this.marcha == '3') {
                this.marcha = '2';
            } else if (this.marcha == '4') {
                this.marcha = '3';
            } else if (this.marcha == '5') {
                this.marcha = '4';
            }

        }

    }

    public boolean isLigado() {
        return this.ligado;
    }

    public String toString() {
        String ligadoString;
        if (this.ligado) {
            ligadoString = "Ligado";
        } else
            ligadoString = "Desligado";
        return this.getNome() + "-> (" + ligadoString + ", marcha: " + this.getMarcha() + ", " + this.getVelocidade()
                + "km/h)";
    }

    public int compareTo(Carro c) {
        if (this.getNome() == c.getNome() && this.getMarcha() == c.getMarcha()) {
            return 0;
        } else if (this.getNome() == c.getNome() && this.getMarcha() > c.getMarcha()) {
            return 1;
        } else if (this.getNome() == c.getNome() && this.getMarcha() < c.getMarcha()) {
            return -1;
        } else if (this.getNome().compareTo(c.getNome()) > 0) {
            return 1;
        } else
            return -1;

    }

    public void liga() throws CarroException {
        if (!this.isLigado() && this.getMarcha() == 'N') {
            this.ligado = true;
        } else if (!this.isLigado() && this.getMarcha() != 'N') {
            throw new CarroException("Carro engatado, para ligar coloque no Neutro");
        }

    }

    public void desliga() {
        if (this.isLigado()) {
            this.ligado = false;
        }

    }

    public void freia(double valor) {

        if (this.velocidade >= valor)
            this.velocidade -= valor;
        else if (this.velocidade < valor) {
            this.velocidade = 0;
        }
    }

    public void acelera(double valor) throws CarroException {
        if (!this.isLigado() || this.getMarcha() == 'N') {
            throw new CarroException("Para carro andar deve estar ligado e com marcha engatada! Status atual: ligado: <"
                    + isLigado() + ">, marcha: <" + getMarcha() + ">");
        } else {
            this.velocidade = velocidade + valor;

            if (this.getMarcha() == '1' && this.velocidade > 20) {
                this.velocidade = 20;
            } else if (this.getMarcha() == '2' && this.velocidade > 40) {
                this.velocidade = 40;
            } else if (this.getMarcha() == '3' && this.velocidade > 60) {
                this.velocidade = 60;
            } else if (this.getMarcha() == '4' && this.velocidade > 80) {
                this.velocidade = 80;
            } else if (this.getMarcha() == '5' && this.velocidade > 100) {
                this.velocidade = 100;
            }
        }
    }

}
