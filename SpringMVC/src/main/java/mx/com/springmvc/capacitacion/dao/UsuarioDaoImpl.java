package mx.com.springmvc.capacitacion.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mx.com.springmvc.capacitacion.domain.TipoSexo;
import mx.com.springmvc.capacitacion.domain.Usuario;

@Repository
@Transactional // faz com que todos os metodos da classe estejam anotados com essa anotacao
public class UsuarioDaoImpl implements UsuarioDao {

	// da acesso aos metodos da JPA
	@PersistenceContext // obtem um objeto entity manager da nossa fabrica de objetos EntityManeger
						// criado na SpringJPAConfig.entityManagerFactory
	private EntityManager entityManager;

	@Override
	public void salvar(Usuario usuario) {

		// se nao tivessemos a anotacao transaction no topo da classe, teriamos que
		// realizar essa operacao comente com a JPA da seguinte maneira
		/*
		 * this.entityManager.getTransaction().begin();
		 * this.entityManager.persist(usuario);
		 * this.entityManager.getTransaction().commit(); this.entityManager.close();
		 */

		// como temos a anotacao transaction no topo da classe, o Spring encapsula toda
		// essa logica que esta acima demonstrada e com isso podemoa apenas fazer o
		// seguinte
		this.entityManager.persist(usuario);
	}

	@Transactional
	@Override
	public void editar(Usuario usuario) {

		this.entityManager.merge(usuario);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Usuario> getBySexo(TipoSexo sexo) {

		String jpql = "from Usuario u where u.sexo = :sexo";
		TypedQuery<Usuario> query = this.entityManager.createQuery(jpql, Usuario.class);
		query.setParameter("sexo", sexo);

		return query.getResultList();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Usuario> getByNome(String nome) {
		
		String jpql = "from Usuario u where u.nome like :nome or u.sobrenome like :sobrenome";
		TypedQuery<Usuario> query = entityManager.createQuery(jpql, Usuario.class);
		query.setParameter("nome", "%" + nome + "%");
		query.setParameter("sobrenome", "%" + nome + "%");
		
		return query.getResultList();
	}

	@Transactional
	@Override
	public void excluir(Long id) {

		this.entityManager.remove(entityManager.getReference(Usuario.class, id));
	}

	@Transactional(readOnly = true)
	@Override
	public Usuario getId(Long id) {

		String jpql = "from Usuario u where u.id = :id"; // se usa parametro nomeado, no caso id
		TypedQuery<Usuario> query = this.entityManager.createQuery(jpql, Usuario.class);
		query.setParameter("id", id); // seta o parametro que preenche o parametro nomeado id

		return query.getSingleResult();
	}

	@Transactional(readOnly = true) // informa ao gerenciamento de transacoes do spring que esse eh um metodo
									// somente de leitura, o seu valor default eh false
	@Override
	public List<Usuario> getTodos() {

		String jpql = "from Usuario u"; // eh o mesmo que um select * from Usuario
		TypedQuery<Usuario> query = this.entityManager.createQuery(jpql, Usuario.class); // classe interna da JPA para
																							// lidar com queries

		return query.getResultList(); // retorna um java.util.List com todos os Usuarios da tablea Usuario
	}

}
