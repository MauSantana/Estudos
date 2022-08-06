console.log(`Trabalhando com listas`);

const listaSeries = new Array(
    'himym', 'atypical', 'breaking bad', 'arcane'
)

console.log(listaSeries);

listaSeries.push('eu nunca');

console.log(listaSeries);

listaSeries.splice(2,1);

console.log(listaSeries);

console.log(listaSeries[1]);
