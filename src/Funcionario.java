import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);

        this.salario = salario;
        this.funcao = funcao;
    }

    public void aumentoSalarial(String aumentoStr) {
        BigDecimal aumento = new BigDecimal(aumentoStr);
        BigDecimal novoSalario = salario.multiply(aumento);
        setSalario(novoSalario);
    }

    public void imprimeInfo() {
        DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        NumberFormat formatadorDinheiro = NumberFormat.getInstance(new Locale("pt", "BR"));

        String dataFormatada = getDataNascimento().format(formatadorData);
        String salarioFormatado = formatadorDinheiro.format(getSalario());

        System.out.println("Nome: " + getNome());
        System.out.println("Data de Nascimento: " + dataFormatada);
        System.out.println("Salário: " + salarioFormatado);
        System.out.println("Função: " + funcao);
        System.out.println("-----------------------------------");
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}
