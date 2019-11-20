package app.utils;

public class Dado implements Comparable<Dado> {
	
	private int ano;
	private int mes;
	private String local;
	private int valor;
	
	public Dado() {}
	
	public Dado(Dado d) {
		// TODO Auto-generated constructor stub
		this.ano = d.getAno();
		this.mes = d.getMes();
		this.local = d.getLocal();
		this.valor = d.getValor();
	}
	
	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public int getMes() {
		return mes;
	}
	
	public void setMes(int mes) {
		this.mes = mes;
	}
	
	public int getValor() {
		return valor;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
	
	public String toString(){
		return 	ano+"\n"+
				mes+"\n"+
				local+"\n"+
				valor+"\n";
	}

	public int compareTo(Dado d) { //metodo implementado pela inteface Comparable<Dados>
		// TODO Auto-generated method stub
	    return 0;
	}
}