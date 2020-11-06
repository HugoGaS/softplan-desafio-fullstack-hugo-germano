package br.com.softplan.model.dto;

import com.sun.istack.NotNull;

import br.com.softplan.model.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

	private Long id;

	@NotNull
	private String nome;

	@NotNull
	private String email;

	private String perfil;

	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.perfil = usuario.getPerfil() != null ? usuario.getPerfil().getDescricao() : null;
	}

}
