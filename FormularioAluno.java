import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

//Nome dupla: André e Auan Implementar o formulário possibilitando ao usuário cadastrar uma lista de alunos:
public class FormularioAluno extends JFrame {

    private JTextField txtNome, txtIdade, txtEndereco;
    private List<Aluno> listaAlunos;

    public FormularioAluno() {
        super("Cadastro de Alunos - TP02");
        listaAlunos = new ArrayList<>();

        JPanel painelSuperior = new JPanel(new GridLayout(3, 2, 10, 10));
        painelSuperior.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        painelSuperior.add(txtNome);

        painelSuperior.add(new JLabel("Idade:"));
        txtIdade = new JTextField();
        painelSuperior.add(txtIdade);

        painelSuperior.add(new JLabel("Endereço:"));
        txtEndereco = new JTextField();
        painelSuperior.add(txtEndereco);

        JPanel painelInferior = new JPanel(new GridLayout(1, 4, 10, 10));
        JButton btnOk = new JButton("Ok");
        JButton btnLimpar = new JButton("Limpar");
        JButton btnMostrar = new JButton("Mostrar");
        JButton btnSair = new JButton("Sair");

        painelInferior.add(btnOk);
        painelInferior.add(btnLimpar);
        painelInferior.add(btnMostrar);
        painelInferior.add(btnSair);

        setLayout(new BorderLayout(10, 10));
        add(painelSuperior, BorderLayout.CENTER);
        add(painelInferior, BorderLayout.SOUTH);

        btnOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Aluno aluno = new Aluno();
                    aluno.setUuid(UUID.randomUUID());
                    aluno.setNome(txtNome.getText());
                    aluno.setIdade(Integer.parseInt(txtIdade.getText()));
                    aluno.setEndreco(txtEndereco.getText());
                    listaAlunos.add(aluno);
                    JOptionPane.showMessageDialog(FormularioAluno.this, "Aluno cadastrado com sucesso!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(FormularioAluno.this, "Erro ao cadastrar: " + ex.getMessage());
                }
            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtNome.setText("");
                txtIdade.setText("");
                txtEndereco.setText("");
            }
        });

        btnMostrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (listaAlunos.isEmpty()) {
                    JOptionPane.showMessageDialog(FormularioAluno.this, "Nenhum aluno cadastrado!");
                } else {
                    StringBuilder mensagem = new StringBuilder("Alunos cadastrados:\n");
                    for (Aluno aluno : listaAlunos) {
                        mensagem.append("ID: ").append(aluno.getUuid())
                                .append(" - Nome: ").append(aluno.getNome()).append("\n");
                    }
                    JOptionPane.showMessageDialog(FormularioAluno.this, mensagem.toString());
                }
            }
        });

        btnSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        setSize(400, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FormularioAluno();
    }
}
