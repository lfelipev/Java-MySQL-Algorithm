package br.com.ConexaoBanco;

import java.util.ArrayList;
import java.util.List;

public class ExecutaSQL extends ConexaoMySQL {

	private String sql;
	private String table;
	private String field;
	private String data;
	private String msg;
	private String tableValue;
	private String tableSearch;
	
	public void insert() {
		List<String> commands = new ArrayList<String>();
		commands.add("INSERT INTO "+this.table+" ("+this.field+") VALUES ("+this.data+")");
		
		System.out.println(commands);
		
		if(this.executarSQL(commands)) {
			this.msg = "Registro executado com sucesso.";
			System.out.println(this.msg);
		}
		
	}
	
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	public String getTableSearch() {
		return tableSearch;
	}
	public void setTableSearch(String tableSearch) {
		this.tableSearch = tableSearch;
	}
	public String getTableValue() {
		return tableValue;
	}
	public void setTableValue(String tableValue) {
		this.tableValue = tableValue;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	
	
}