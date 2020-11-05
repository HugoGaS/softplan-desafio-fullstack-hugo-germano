package br.com.softplan.enums;

import io.micrometer.core.instrument.util.StringUtils;

public enum Cargos {
	
	ADMIN("ADMIN"),
	USUARIO_TRIADOR("USUARIO_TRIADOR"),
	USUARIO_FINALIZADOR("USUARIO_FINALIZADOR");
	
	private String descricao;
	
	Cargos(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
    public static Cargos getValueFromDs(String descricao) {
    	Cargos cargo = null;
    	if(!StringUtils.isBlank(descricao)) {
            for (Cargos cargoEncontrado : Cargos.values()) {
                if (cargoEncontrado.getDescricao() == descricao) {
                	cargo =  cargoEncontrado;
                } 
            }
    	}
    	return cargo;
    }

	
	

}
