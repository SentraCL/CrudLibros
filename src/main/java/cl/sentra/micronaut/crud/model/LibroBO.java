package cl.sentra.micronaut.crud.model;

public class LibroBO {
	private Long id;
	private String titulo;
	private String autor;
	private String categoria;
	private float precio;
	private int stock;
	
		
	public LibroBO() {
		super();
	}
	
	public LibroBO(Long id, String titulo, String autor, String categoria, float precio, int stock) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.categoria = categoria;
		this.precio = precio;
		this.stock = stock;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public String resumen() {
		return "LibroBO [titulo=" + titulo + ", autor=" + autor + ", categoria=" + categoria+ "]";
	}	
}
