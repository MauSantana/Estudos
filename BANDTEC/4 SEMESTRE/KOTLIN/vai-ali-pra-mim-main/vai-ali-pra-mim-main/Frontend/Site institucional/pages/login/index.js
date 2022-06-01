var synth = window.speechSynthesis;
var narracaoAtivada = false;

function acionarReconhecimentoVoz() {
    console.log("narracao ativada")
    let frase = new SpeechSynthesisUtterance("Narração ativada");

    speechSynthesis.speak(frase);
    frase = new SpeechSynthesisUtterance("Aperte TAB, e depois digite seu usuário");
    speechSynthesis.speak(frase);
    narracaoAtivada = true;
}

async function login() {
    let user = {
        email: document.getElementById('input-email').value,
        senha: document.getElementById('input-password').value
    }

    let url = 'http://localhost:8888/usuarios/login';
    let param = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(user)
    }
    try {
        let response = await (await fetch(url, param)).json();
        window.location.href = `http://localhost:3000/mapa/${response.idUsuario}`
        console.log("Login com sucesso")
    }
    catch(e){
        console.error(e)
        //window.location.href = "Senha/Usuário incorretas"
        console.log("Senha/Usuário incorretas")
    }
    
}

function acionarReconhecimentoVozPorTecla() {
    // Get the input field
    var barraLateral = document.getElementById("barraLateral");

    // Execute a function when the user releases a key on the keyboard
    barraLateral.addEventListener("keyup", function (event) {
        // Number 13 is the "Enter" key on the keyboard
        if (event.keyCode === 13) {
            // Cancel the default action, if needed
            event.preventDefault();
            // Trigger the button element with a click
            document.getElementById("barraLateral").click();
        }
    });

}

function falarFraseEmail() {
    var inputEmail = document.querySelector("body > div > div > div.login-container > div > input:nth-child(3)");

    inputEmail.addEventListener("keyup", function (event) {
        if (event.keyCode === 13) {
            event.preventDefault();
            if (narracaoAtivada) {
                let frase = new SpeechSynthesisUtterance("Assim que digitar seu usuário, aperte TAB e digite sua senha");
                speechSynthesis.speak(frase);
            }
        }
    });
}

function falarFraseEmailOnFocus() {
    if (narracaoAtivada) {
        let frase = new SpeechSynthesisUtterance("Assim que digitar seu usuário, aperte TAB e digite sua senha");
        speechSynthesis.speak(frase);
    }
}

function falarFraseSenha() {
    var inputSenha = document.querySelector("body > div > div > div.login-container > div > input:nth-child(5)")
    inputSenha.addEventListener("keyup", function (event) {
        if (event.keyCode === 13) {
            event.preventDefault();
            if (narracaoAtivada) {
                let frase = new SpeechSynthesisUtterance("Após digitar sua senha, aperte TAB e depois 'Enter' para se logar");
                speechSynthesis.speak(frase);
            }
        }
    });
}

function falarFraseSenhaOnFocus() {
    if (narracaoAtivada) {
        let frase = new SpeechSynthesisUtterance("Após digitar sua senha, aperte TAB e depois 'Enter' para se logar");
        speechSynthesis.speak(frase);
    }
}

function pressionarEnter() {
    var btnEntrar = document.getElementById("btn-entrar");
    btnEntrar.addEventListener("keyup", function (event) {
        if (event.keyCode === 13) {
            event.preventDefault();
        }
    });
}