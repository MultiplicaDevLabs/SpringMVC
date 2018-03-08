package mx.com.springmvc.capacitacion.dao;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import mx.com.springmvc.capacitacion.domain.TipoSexo;
import mx.com.springmvc.capacitacion.domain.Usuario;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {

	private static List<Usuario> us;

	public UsuarioDaoImpl() {
		createUserList();
	}

	private List<Usuario> createUserList() {
		if (us == null) {
			us = new LinkedList<>();
			us.add(new Usuario(System.currentTimeMillis() + 1L, "Ana", "da Silva", LocalDate.of(1978, 12, 03), TipoSexo.MUJER));
			us.add(new Usuario(System.currentTimeMillis() + 2L, "Luiz", "dos Santos", LocalDate.of(1971, 10, 23), TipoSexo.HOMBRE));
			us.add(new Usuario(System.currentTimeMillis() + 3L, "Mariana", "Mello", LocalDate.of(1990, 01, 01), TipoSexo.MUJER));
			us.add(new Usuario(System.currentTimeMillis() + 4L, "Caren", "Pereira"));
			us.add(new Usuario(System.currentTimeMillis() + 5L, "Sonia", "Fagundes"));
			us.add(new Usuario(System.currentTimeMillis() + 6L, "Norberto", "de Souza"));
		}
		return us;
	}

	@Override
	public void salvar(Usuario usuario) {
		usuario.setId(System.currentTimeMillis());
		us.add(usuario);
	}

	@Override
	public void editar(Usuario usuario) {
		us.stream().filter((u) -> u.getId().equals(usuario.getId())).forEach((u) -> {
			u.setNome(usuario.getNome());
			u.setSobrenome(usuario.getSobrenome());
			u.setDtNascimento(usuario.getDtNascimento());
			u.setSexo(usuario.getSexo());
		});
	}

	@Override
	public void excluir(Long id) {
		us.removeIf((u) -> u.getId().equals(id));
	}

	@Override
	public Usuario getId(Long id) {
		return us.stream().filter((u) -> u.getId().equals(id)).collect(Collectors.toList()).get(0);
	}

	@Override
	public List<Usuario> getTodos() {
		return us;
	}
}
