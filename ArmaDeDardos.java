public class ArmaDeDardos extends Itens{
    private int municao;
    public ArmaDeDardos( String nome) {
        super("Bastao Elétrico");
        this.municao = 1;
    }
    public int getMunicao() {
        return municao;
    }
    public void setMunicao(int municao) {
        this.municao = municao;
    }
    
}
