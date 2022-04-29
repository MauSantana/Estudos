package br.com.banctec.correcaoc13adsa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UsuarioController {

    private List<Usuario> usuarios = new ArrayList<>();

    @GetMapping("/cadastrar-usuario/{login}/{nome}/{senha}")
    public String cadastrar(@PathVariable String login,
                            @PathVariable String nome,
                            @PathVariable String senha) {

        Usuario novo = new Usuario(login, senha, nome, false);
        usuarios.add(novo);

        return String.format("Usuário %s autenticado com sucesso", nome);
    }

    @GetMapping("/usuarios")
    public List<Usuario> listar() {
        return usuarios;
    }

    @GetMapping("/autenticar/{login}/{senha}")
    public Usuario cadastrar(@PathVariable String login,
                            @PathVariable String senha) {

        List<Usuario> encontrados = usuarios.stream()
                                        .filter(usuario -> usuario.autenticar(login, senha))
                                        .collect(Collectors.toList());

        if (encontrados.isEmpty()) {
            return null;
        } else {
            Usuario encontrado = encontrados.get(0);
            return encontrado;
        }
    }

    @GetMapping("/logoff/{login}")
    public String logoff(@PathVariable String login) {

        List<Usuario> autenticados = usuarios.stream()
                .filter(usuario -> usuario.getLogin().equals(login) && usuario.getAutenticado())
                .collect(Collectors.toList());

        if (autenticados.isEmpty()) {
            return String.format("Usuário %s não autenticado", login);
        } else {
            Usuario autenticado = autenticados.get(0);
            autenticado.logoff();
            return String.format("Usuário %s saiu do sistema", autenticado.getNome());
        }
    }
}
