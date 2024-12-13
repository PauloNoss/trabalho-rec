import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class CadastroDocumento extends JFrame {
    private JTextField tituloField, autorField, dataField;
    private JButton salvarButton;

    public CadastroDocumento() {
        setTitle("Cadastro de Documento");
        setLayout(new FlowLayout());
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tituloField = new JTextField(20);
        autorField = new JTextField(20);
        dataField = new JTextField(10);

        salvarButton = new JButton("Salvar");
        salvarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                salvarDocumento();
            }
        });

        add(new JLabel("Título:"));
        add(tituloField);
        add(new JLabel("Autor:"));
        add(autorField);
        add(new JLabel("Data de Criação (DD/MM/AAAA):"));
        add(dataField);
        add(salvarButton);
    }

    private void salvarDocumento() {
        String titulo = tituloField.getText();
        String autor = autorField.getText();
        String data = dataField.getText();

        if (titulo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "O título é obrigatório!");
            return;
        }

        if (autor.isEmpty()) {
            JOptionPane.showMessageDialog(this, "O autor é obrigatório!");
            return;
        }

        if (data.isEmpty()) {
            JOptionPane.showMessageDialog(this, "A data é obrigatória!");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("documentos.txt", true))) {
            writer.write("Título: " + titulo);
            writer.newLine();
            writer.write("Autor: " + autor);
            writer.newLine();
            writer.write("Data: " + data);
            writer.newLine();
            writer.newLine();
            JOptionPane.showMessageDialog(this, "Documento salvo com sucesso!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar o documento: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CadastroDocumento().setVisible(true);
            }
        });
    }
}
