import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

public class ControleContatosGUI extends JFrame {
    private ControleContatos controleContatos;
    private JTextField nomeCampo, telefoneCampo, emailCampo, buscarNomeCampo, buscarTelefoneCampo;

    public ControleContatosGUI() {
        controleContatos = new ControleContatos();

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        setTitle("Controle de Contatos");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel painelCadastro = painelCadastro();
        JPanel painelBusca = painelBusca();

        add(painelCadastro, BorderLayout.NORTH);
        add(painelBusca, BorderLayout.CENTER);

        setVisible(true);
    }

    private JPanel painelCadastro() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Adicionar Contato"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Nome:"), gbc);

        gbc.gridx = 1;
        nomeCampo = new JTextField(15);
        panel.add(nomeCampo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Telefone:"), gbc);

        gbc.gridx = 1;
        telefoneCampo = new JTextField(15);
        panel.add(telefoneCampo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        emailCampo = new JTextField(15);
        panel.add(emailCampo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;

        JButton botaoAdicionar = new JButton("Adicionar");
        botaoAdicionar.addActionListener(new AdicionarContatoListener());
        panel.add(botaoAdicionar, gbc);

        gbc.gridy = 4;
        JButton botaoRemover = new JButton("Remover");
        botaoRemover.addActionListener(new RemoverContatoListener());
        panel.add(botaoRemover, gbc);

        return panel;
    }

    private JPanel painelBusca() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Buscar Contato"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Buscar por Nome:"), gbc);

        gbc.gridx = 1;
        buscarNomeCampo = new JTextField(10);
        panel.add(buscarNomeCampo, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        panel.add(new JLabel("Buscar por Telefone:"), gbc);

        gbc.gridx = 1;
        buscarTelefoneCampo = new JTextField(10);
        panel.add(buscarTelefoneCampo, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        JButton botaoBuscarNome = new JButton("Buscar Nome");
        botaoBuscarNome.addActionListener(new BuscarContatoPorNomeListener());
        panel.add(botaoBuscarNome, gbc);

        gbc.gridx = 1;
        JButton botaoBuscarTelefone = new JButton("Buscar Telefone");
        botaoBuscarTelefone.addActionListener(new BuscarContatoPorTelefoneListener());
        panel.add(botaoBuscarTelefone, gbc);

        return panel;
    }

    private class AdicionarContatoListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String nome = nomeCampo.getText().trim();
            String telefone = telefoneCampo.getText().trim();
            String email = emailCampo.getText().trim();

            if (nome.isEmpty() || telefone.isEmpty() || email.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencher todos os campos");
                return;
            }

            Contato novoContato = new Contato(nome, telefone, email);
            String resultado = controleContatos.adicionarContato(novoContato);
            JOptionPane.showMessageDialog(null, resultado);

            nomeCampo.setText("");
            telefoneCampo.setText("");
            emailCampo.setText("");
        }
    }

    private class RemoverContatoListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String telefoneRemover = telefoneCampo.getText().trim();
            if (telefoneRemover.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencher telefone");
                return;
            }
            String resultado = controleContatos.removerContato(telefoneRemover);
            JOptionPane.showMessageDialog(null, resultado);

            telefoneCampo.setText("");
        }
    }

    private class BuscarContatoPorNomeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String nomeBuscar = buscarNomeCampo.getText().trim();
            if (nomeBuscar.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencher nome.");
                return;
            }
            Optional<String> telefone = controleContatos.buscarPorNome(nomeBuscar);
            if (telefone.isPresent()) {
                JOptionPane.showMessageDialog(null, "Telefone encontrado: " + telefone.get());
            } else {
                JOptionPane.showMessageDialog(null, "Contato não encontrado.");
            }

            buscarNomeCampo.setText("");
        }
    }

    private class BuscarContatoPorTelefoneListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String telefoneBuscar = buscarTelefoneCampo.getText().trim();
            if (telefoneBuscar.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencher o telefone");
                return;
            }
            Optional<String> nome = controleContatos.buscarPorTelefone(telefoneBuscar);
            if (nome.isPresent()) {
                JOptionPane.showMessageDialog(null, "Nome encontrado: " + nome.get());
            } else {
                JOptionPane.showMessageDialog(null, "Contato não encontrado.");
            }

            buscarTelefoneCampo.setText("");
        }
    }


}
