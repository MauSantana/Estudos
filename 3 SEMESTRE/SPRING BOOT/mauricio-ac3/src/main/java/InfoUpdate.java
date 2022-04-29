public class InfoUpdate {

    private Integer id;
    private Integer valorNovo;

    public InfoUpdate(Integer id, Integer valorNovo) {
        this.id = id;
        this.valorNovo = valorNovo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValorNovo() {
        return valorNovo;
    }

    public void setValorNovo(Integer valorNovo) {
        this.valorNovo = valorNovo;
    }
}
