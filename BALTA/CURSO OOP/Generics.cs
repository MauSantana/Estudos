using System;
using System.Collections.Generic;
using System.Linq;

namespace Aula_Generics
{
    class Generics
    {
        static void Main(string[] args)
        {
            // var pessoa = new Pessoa();
            // var pagamento = new Pagamento();
            // var assinatura = new Assinatura();
            // var contexto = new ContextoDados<IPessoa, Pagamento, Assinatura>();
            // contexto.Salvar(pessoa);
            // contexto.Salvar(pessoa);
            // contexto.Salvar(assinatura);

            var payments = new List<Payment>();
            // var lista = new List<string>();
            // var payments = new ICollection<Payment>();
            // var payments = new IEnumerable<Payment>();
            // IEnumerable<Payment> payments = new List<Payment>();
            // IList<Payment> payments = new List<Payment>();
            payments.Add(new Payment(1));
            payments.Add(new Payment(2));
            payments.Add(new Payment(3));
            payments.Add(new Payment(4));
            payments.Add(new Payment(5));

            // payments.AsEnumerable();

            // foreach (var item in payments)
            // {
            //     Console.WriteLine(item.Id);

            // }
            // Console.WriteLine("");

            // var payment = payments.Where(x => x.Id == 3);
            // var payment = payments.First(x => x.Id == 3);
            // Console.WriteLine(payment.Id);
            // Console.WriteLine("");

            // payments.Remove(payment);
            // foreach (var item in payments)
            // {
            //     Console.WriteLine(item.Id);

            // }
            // Console.WriteLine("");

            // var exists = payments.Any(x => x.Id == 3);
            // Console.WriteLine(exists);
            // Console.WriteLine("");


            // var contagem = payments.Count(x => x.Id == 4);
            // Console.WriteLine(contagem);
            // Console.WriteLine("");

            // // var pular = payments;
            // // Console.WriteLine(pular);
            // // Console.WriteLine("");

            // foreach (var item in payments.Skip(1))
            // {
            //     Console.WriteLine(item.Id);

            // }
            // Console.WriteLine("");

            // foreach (var item in payments.Take(3))
            // {
            //     Console.WriteLine(item.Id);

            // }
            // Console.WriteLine("");

            // foreach (var item in payments.Skip(1).Take(3))
            // {
            //     Console.WriteLine(item.Id);

            // }
            // Console.WriteLine("");




            // var paidPayments = new List<Payment>();
            // paidPayments.AddRange(payments);
            // payments.Remove(new Payment());


        }
    }

    public class Payment
    {
        public int Id { get; set; }
        public Payment(int id)
        {
            Id = id;
        }
    }

    // public class ContextoDados<P, PA, A>
    // where P : IPessoa
    // where PA : Pagamento
    // where A : Assinatura
    // {
    //     public void Salvar(P entidade)
    //     {

    //     }
    //     public void Salvar(PA entidade)
    //     {

    //     }
    //     public void Salvar(A entidade)
    //     {

    //     }
    // }

    // public interface IPessoa
    // {

    // }
    // public class Pessoa : IPessoa
    // {

    // }
    // public class Pagamento
    // {

    // }
    // public class Assinatura
    // {

    // }
}