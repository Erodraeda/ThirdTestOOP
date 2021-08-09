public class CarroException extends Exception {

    private static final long serialVersionUID = 1L;
    private String mensagem;

    public CarroException(String mensagem) {
        super(mensagem);
    }

    public String getMensagem(CarroException e) {
        return mensagem;
    }

}
