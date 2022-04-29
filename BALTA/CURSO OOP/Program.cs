// using System;
// using System.Diagnostics.CodeAnalysis;
// using Payments;

// namespace CURSO_OOP
// {
//     class Program

//     {
//         // static void RealizarPagamento(double valor)
//         // {

//         // }
//         // static void Main(string[] args)
//         // {
//             // var sala = new Sala(3);
//             // sala.SalaEsgotadaEvent += OnSalaEsgotada;
//             // sala.ReservarAssento();
//             // sala.ReservarAssento();
//             // sala.ReservarAssento();
//             // sala.ReservarAssento();
//             // var pagar = new Pagamento.Pagar(RealizarPagamento);
//             // pagar(25);
//             // var payment = new Payment();

//             // var pessoaA = new Pessoa(1, "Mauricio Santana");
//             // var pessoaB = new Pessoa(1, "Neymar Santos");

//             // Console.WriteLine(pessoaA.Equals(pessoaB));

//             // var pessoaFisica = new PessoaFisica();
//             // var pessoaJuridica = new PessoaJuridica();

//             // pessoaFisica = (PessoaFisica)pessoa;
//             // pessoa = new PessoaFisica();
//             // pessoa = new PessoaJuridica();
//             // Pagamento.Vencimento = DateTime.Now;
//             // var pagamento = new Pagamento(DateTime.Now);
//             // pagamento. = DateTime.Now;
//             // pagamento.Pagar("1234");
//             // using (var pagamento = new Pagamento())
//             // {
//             //     Console.WriteLine("Processando o pagamento");

//             // }
//             // var pagamento = new Pagamento();
//             // pagamento.Dispose();
//             // Console.WriteLine("");

//         }

//         //     static void OnSalaEsgotada(object sender, EventArgs e)
//         //     {
//         //         Console.WriteLine("Sala Esgotada");
//         //     }
//         //     // }
//         //     // public class Pessoa : IEquatable<Pessoa>
//         //     // {
//         //     //     public Pessoa(int id, string nome)
//         //     //     {
//         //     //         Nome = nome;
//         //     //         Id = id;
//         //     //     }
//         //     //     public int Id { get; set; }
//         //     //     public string Nome { get; set; }

//         //     //     public bool Equals(Pessoa pessoa)
//         //     //     {
//         //     //         return Id == pessoa.Id;
//         //     //     }
//         //     // }
//         //     // public class PessoaFisica : Pessoa
//         //     // {
//         //     //     public string CPF { get; set; }
//         //     // }
//         //     // public class PessoaJuridica : Pessoa
//         //     // {
//         //     //     public string CNPJ { get; set; }
//         //     // }
//         //     // public sealed class Pagamento
//         //     // {
//         //     //     public DateTime Vencimento { get; set; }


//         //     // }

//         //     // public static class Settings{
//         //     //     public static string API_URL { get; set; }
//         //     // }
//         //     // public abstract class Pagamento : IPagamento
//         //     // {
//         //     //     public DateTime Vencimento { get; set; }

//         //     //     public virtual void Pagar(double valor)
//         //     //     {
//         //     //         //Executar
//         //     //     }
//         //     // }

//         //     // public class PagamentoCartaoCredito : Pagamento
//         //     // {

//         //     //     public override void Pagar(double valor)
//         //     //     {
//         //     //         base.Pagar(valor);
//         //     //     }
//         //     // }

//         //     // public class PagamentoBoleto : Pagamento
//         //     // {

//         //     //     public override void Pagar(double valor)
//         //     //     {
//         //     //         base.Pagar(valor);
//         //     //     }
//         //     // }

//         //     // public class PagamentoApplePay : Pagamento
//         //     // {

//         //     //     public override void Pagar(double valor)
//         //     //     {
//         //     //         base.Pagar(valor);
//         //     //     }
//         //     // }
//         //     // public interface IPagamento
//         //     // {
//         //     //     DateTime Vencimento { get; set; }

//         //     //     void Pagar(double valor);
//         //     // }
//         // }
//         // public class Sala
//         // {
//         //     public Sala(int assentos)
//         //     {
//         //         Assentos = assentos;
//         //         assentosEmUso = 0;

//         //     }
//         //     private int assentosEmUso = 0;
//         //     public int Assentos { get; set; }

//         //     public void ReservarAssento()
//         //     {
//         //         assentosEmUso++;
//         //         if (assentosEmUso >= Assentos)
//         //         {
//         //             OnSalaEsgotada(EventArgs.Empty);
//         //         }
//         //         else
//         //         {
//         //             Console.WriteLine("Assento reservado");
//         //         }
//         //     }

//         //     public event EventHandler SalaEsgotadaEvent;

//         //     protected virtual void OnSalaEsgotada(EventArgs e)
//         //     {
//         //         EventHandler handler = SalaEsgotadaEvent;
//         //         handler?.Invoke(this, e);
//         //     }
//         // }

//         // public class Pagamento
//         // {
//         //     public delegate void Pagar(double valor);
//         // }
//     }
// }
// // public class Pagamento : IDisposable
// // {
// //     public Pagamento()
// //     {
// //         Console.WriteLine("Iniciando Pagamento");

// //     }

// //     public void Dispose()
// //     {
// //         Console.WriteLine("Finalizando Pagamento");
// //     }

// // public DateTime DataPagamento { get; set; }

// // public Pagamento() {}
// // public Pagamento(DateTime vencimento)
// // {
// //     Console.WriteLine("iniciando o pagamento");
// //     DataPagamento = DateTime.Now;
// // }
// // public virtual void Pagar(string numero)
// // {
// //     Console.WriteLine("Pagar");

// // }

// // public void Pagar(string numero, DateTime vencimento,
// // bool pagarAposVencimento = false)
// // {


// // public DateTime Teste { get; private set; }
// // public DateTime Vencimento;
// // {
// //     get
// //     {
// //         return Vencimento;
// //     }
// //     set { }
// // // }
// // private DateTime _dataPagamento;
// // public DateTime DataPagamento;
// // {
// //     get
// //     {
// //         Console.WriteLine("Lendo o valor");
// //         return _dataPagamento;
// //     }
// //     set
// //     {
// //         Console.WriteLine("Atribuindo o valor");
// //         _dataPagamento = value;
// //     }
// // }


// // virtual permite que o metodo seja sobescrito
// // private void Pagar()
// // {
// // }

// // }

// // public class PagamentoCartao : Pagamento
// // {
// //     public PagamentoCartao(DateTime vencimento)
// //     : base(vencimento)
// //     {

// //     }
// //     public override void Pagar(string numero)
// //     {
// //         base.Pagar(numero);
// //         Console.WriteLine("Pagar com cartão");
// //     }
// // }
// // public class Endereco
// // {
// //     string Cep;
// // }
// // class PagamentoViaBoleto : Pagamento
// // {
// //     public string NumeroBoleto;

// //     public override void Pagar()
// //     {
// //         // Regra do boleto
// //     }
// // }

// // class PagamentoCartaoCredito : Pagamento
// // {
// //     public string Numero;

// //     public override void Pagar()
// //     {
// //         // Regra do cartão de credito
// //     }
// // }

