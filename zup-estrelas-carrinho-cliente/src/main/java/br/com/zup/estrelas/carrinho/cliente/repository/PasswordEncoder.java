package br.com.zup.estrelas.carrinho.cliente.repository;

public interface PasswordEncoder {

	String encode(CharSequence var);

	boolean matches(CharSequence var1, String var2);

	default boolean upgradeEncoding(String encodeadPassword) {
		return false;
	}
}
