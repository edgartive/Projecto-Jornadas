package model;

public class Venda{
    private int id;
    private Date data_da_venda;
    private double valor_total;
    private Funcionario funcionario;
    private List<ItemVenda> itens;
    
    public Venda(int id, Date data_da_venda, double valor_total, Funcionario funcionario, List<ItemVenda> itens) {
        this.id = id;
        this.data_da_venda = data_da_venda;
        this.valor_total = valor_total;
        this.funcionario = funcionario;
        this.itens = itens;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Date getData_da_venda() {
        return data_da_venda;
    }
    public void setData_da_venda(Date data_da_venda) {
        this.data_da_venda = data_da_venda;
    }
    public double getValor_total() {
        return valor_total;
    }
    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }
    public Funcionario getFuncionario() {
        return funcionario;
    }
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    public List<ItemVenda> getItens() {
        return itens;
    }
    public void setItens(List<ItemVenda> itens) {
        this.itens = itens;
    }
    @Override
    public String toString() {
        return "Venda [id=" + id + ", data_da_venda=" + data_da_venda + ", valor_total=" + valor_total
                + ", funcionario=" + funcionario + ", itens=" + itens + "]";
    }
    
}