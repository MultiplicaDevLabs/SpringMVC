package mx.com.springmvc.capacitacion.web.conversor;

import org.springframework.core.convert.converter.Converter;

import mx.com.springmvc.capacitacion.domain.TipoSexo;

public class TipoSexoConverter implements Converter<String, TipoSexo> {

	@Override
	public TipoSexo convert(String texto) {
		
		char tipo = texto.charAt(0);
		
		return tipo == TipoSexo.MUJER.getDesc() ? TipoSexo.MUJER : TipoSexo.HOMBRE;
	}

}
