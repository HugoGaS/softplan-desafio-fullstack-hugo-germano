package br.com.softplan.model.dto;

import org.springframework.data.domain.Page;

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

	private String cargo;

	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.cargo = usuario.getCargo().getDescricao();
	}

	public static Page<UsuarioDTO> converter(Page<Usuario> usuarios) {
		return usuarios.map(UsuarioDTO::new);
	}

}
