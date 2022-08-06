public class App {
    public static void main(String[] args) {
        PilhaObj pilhaObj = new PilhaObj(10);
        Livro l1 = new Livro("Manisfesto do partido comunista",
                "Karl Marx e Emile Durkein", "Socialismo", 80.000);
        Livro l2 = new Livro("O que o tio Sam realmente quer", "Noam Chomsky", "Historia",
                100.000);
        Livro l3 = new Livro("O cortiço", "Aluisio de Azevedo", "Naturalismo BR", 150.000);

        pilhaObj.push(l1);
        pilhaObj.push(l2);
        pilhaObj.push(l3);

        pilhaObj.exibe();
    }
}
