package br.com.softplan.enums;

import io.micrometer.core.instrument.util.StringUtils;

public enum Perfis {
	
	ADMIN("ADMIN"),
	USUARIO_TRIADOR("USUARIO_TRIADOR"),
	USUARIO_FINALIZADOR("USUARIO_FINALIZADOR");
	
	private String descricao;
	
	Perfis(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
    public static Perfis getValueFromDs(String descricao) {
    	Perfis perfil = null;
    	if(!StringUtils.isBlank(descricao)) {
            for (Perfis perfilEncontrado : Perfis.values()) {
                if (perfilEncontrado.getDescricao() == descricao) {
                	perfil =  perfilEncontrado;
                } 
            }
    	}
    	return perfil;
    }

	
	

}
