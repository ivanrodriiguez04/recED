package entidades;

public class Productos {
	//Variables
	private String nombreProducto;
	private int cantidadProducto;
	private String unidadMedida;
	
	
	//Constructores
	public Productos(String nombreProducto, int cantidadProducto, String unidadMedida) {
		super();
		this.nombreProducto = nombreProducto;
		this.cantidadProducto = cantidadProducto;
		this.unidadMedida = unidadMedida;
	}
	public Productos() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	//Getter & Setters
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public int getCantidadProducto() {
		return cantidadProducto;
	}
	public void setCantidadProducto(int cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}
	public String getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	
	@Override
	public String toString() {
		return "Productos [Producto: " + nombreProducto + ", Cantidad: " + cantidadProducto + 
				 unidadMedida+ "]";
	}
}
