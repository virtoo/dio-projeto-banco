public abstract class Conta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIA = 1;
    private int agencia;
    private int numero;
    private double saldo;
    private Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIA++;
        this.cliente = cliente;
    }
    public void sacar(double valor){
        if (valor <= this.saldo){
            this.saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }
    public void depositar(double valor){
        if (valor >= 1){
            saldo += valor;
            consultarSaldo();
        } else {
            System.out.println("Apenas Deposito acima de R$ 1,00");
        }
    }
    public void transferir(double valor, Conta contaDestino){
        this.sacar(valor);
        contaDestino.depositar(valor);
        System.out.println("Tranferência Realizada!");
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }
    abstract void imprimirExtrato();
    public void extratoAtributos(){
        System.out.println(String.format("Títular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agência: %d", this.getAgencia()));
        System.out.println(String.format("Número: %d", this.getNumero()));
        System.out.println(String.format("Saldo: %.2f", this.getSaldo()));
    }
    public void consultarSaldo(){
        System.out.println(String.format("Saldo: R$ %.2f", this.getSaldo()));
    }
}
