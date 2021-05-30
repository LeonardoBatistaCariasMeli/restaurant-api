package br.com.digitalhouse.restaurantapi.domain.entity.enums;

public enum OrderStats {
	
	CANCELLED(0, "CANCELLED"),
	WAITING_PAYMENT(1, "WAITING PAYMENT"),
	PAID(2, "PAID");
	
	private int cod;
	private String descricao;
	
	private OrderStats(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;		
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static OrderStats toEnum(Integer cod) throws Exception {
		
		if(cod == null) {
			return null;
		}
		
		for(OrderStats x : OrderStats.values()) {
			if(cod.equals(x.getCod()))
			{
				return x;
			}
		}
		throw new Exception("Stats not found!"); 
	}
	
}
