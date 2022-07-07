console.log(`Trabalhando com condicionais`);

const listaSeries = new Array(
    'himym', 'atypical', 'breaking bad', 'arcane'
)

const maiorIdade = 15
console.log(listaSeries);

if (maiorIdade >= 18) {
    console.log("maior de idade");
    listaSeries.splice(2, 1);
}else {
    console.log("chapou");
}


console.log(listaSeries);

