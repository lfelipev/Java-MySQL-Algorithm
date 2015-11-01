package br.com.ConexaoBanco;

public class principal {

	public principal() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ExecutaSQL reg = new ExecutaSQL();
		
		reg.setTable("user");
		
		String nome = "Luis";
		String senha = "123";
		String email = "feligma";
		
		reg.setField("nome, senha, email");
		reg.setData("'"+nome+"','"+senha+"','"+email+"'");
		reg.insert();
		
		reg.getMsg();

	}

}
