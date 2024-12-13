public class Documento {
    private String titulo;
    private String autor;
    private String dataCriacao;

    public Documento(String titulo, String autor, String dataCriacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.dataCriacao = dataCriacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public String toCSV() {
        return titulo + ";" + autor + ";" + dataCriacao;
    }

    public static Documento fromCSV(String csv) {
        String[] dados = csv.split(";");
        return new Documento(dados[0], dados[1], dados[2]);
    }
}
