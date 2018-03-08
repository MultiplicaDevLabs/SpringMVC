package mx.com.springmvc.capacitacion.domain;

public enum TipoSexo {

	MUJER('M'), HOMBRE('H');
	
	private char desc;

	TipoSexo(char desc) {
		this.desc = desc;
	}

	public char getDesc() {
		return desc;
	}

	public void setDesc(char desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {

		return super.toString();
	}
	
}
