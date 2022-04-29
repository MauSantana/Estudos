package br.com.banctec.correcaoc13adsa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class UsuarioController {

    private List<Usuario> usuarios = new ArrayList<>();

    private Map<String, Object> informacoes = new HashMap<>();

    @GetMapping("/cadastrar-usuario/{login}/{nome}/{senha}")
    public String cadastrar(@PathVariable String login,
                            @PathVariable String nome,
                            @PathVariable String senha) {

        Usuario novo = new Usuario(login, senha, nome, false);
        usuarios.add(novo);

        informacoes.put("ultimoCadastrado", novo);
        informacoes.put("totalCadastrados", (Integer)informacoes.getOrDefault("totalCadastrados", 0) + 1);

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

            informacoes.put("ultimoAutenticado", encontrado);

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

            informacoes.put("ultimoLogoff", autenticado);

            return String.format("Usuário %s saiu do sistema", autenticado.getNome());
        }
    }

    @GetMapping("/informacoes")
    public Map getInformacoes() {
        return informacoes;
    }
}
