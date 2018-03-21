package mx.com.springmvc.capacitacion.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	private static final long serialVersionUID = -3164118456563284802L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 50)
	@NotBlank
	@Size(min = 3, max = 50)
	private String nome;

	@Column(nullable = false, length = 50)
	@NotBlank
	@Size(min = 3, max = 50, message = "Campo requerido entre {min} e {max} caracteres.")
	private String sobrenome;

	@Column(name = "tipo_sexo", nullable = false)
	@NotNull(message = "O campo data de nascimento e requerido.")
	@DateTimeFormat(iso = ISO.DATE) // converte uma data em formato String para LocalDate
	private LocalDate dtNascimento;

	@Column(name = "data_nascimento", nullable = false)
	@Enumerated(EnumType.STRING) // armazenara o valor textual da constante
	private TipoSexo sexo;

	public Usuario() {
		super();
	}

	public Usuario(Long id, String nome, String sobrenome, LocalDate dtNascimento, TipoSexo sexo) {

		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dtNascimento = dtNascimento;
		this.sexo = sexo;
	}

	public Usuario(Long id, String nome, String sobrenome, LocalDate dtNascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dtNascimento = dtNascimento;
	}

	public Usuario(Long id, String nome, String sobrenome) {

		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
	}

	public TipoSexo getSexo() {
		return sexo;
	}

	public void setSexo(TipoSexo sexo) {
		this.sexo = sexo;
	}

	public LocalDate getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());

		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + "]";
	}

}
