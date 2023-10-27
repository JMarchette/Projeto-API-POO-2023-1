import java.io.FileInputStream;
import java.util.Properties;
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        String input = JOptionPane.showInputDialog(
        "Selecione uma opção:\n" +
        "1. Tradução\n" +
        "2. Geração de emoji\n" +
        "3. Explicação para crianças\n" +
        "4. Ver membros do grupo\n" +
        "5. Sair"
    );

    int opcao = Integer.parseInt(input);
    
    var properties = new Properties();
    properties.load(new FileInputStream("src/app.properties"));
    final String OPENAI_API_KEY = properties.getProperty("OPENAI_API_KEY");
    
    var ChatGPTClient = new ChatGPTClient();
    
    switch(opcao) {
    case 1:     /* ================================TRADUZIR UMA PALAVRA OU FRASE================================ */
        JOptionPane.showMessageDialog(null, "Opção de tradução selecionada! :)");

        String texto = JOptionPane.showInputDialog("Texto em ingles");
        String s = ChatGPTClient.traduzir(OPENAI_API_KEY, texto);

        JOptionPane.showMessageDialog(null, s);
    break;

    /* ================================DEFINIR UM FILME EM TRÊS EMOJIS================================ */
    case 2:
        JOptionPane.showMessageDialog(null, "Opção de gerar emoji selecionada! :)");

        String entrada = JOptionPane.showInputDialog("Nome do filme");
        String e = ChatGPTClient.pedirEmojString(OPENAI_API_KEY, entrada);

        JOptionPane.showMessageDialog(null, e);
    break;

    /* ================================EXPLICAÇÃO PARA CRIANÇAS================================ */
    case 3:
        JOptionPane.showMessageDialog(null, "Opção de explicação para criança selecionado! :)");


        String perguntaCrianca = JOptionPane.showInputDialog("Faça uma pergunta");
        String perguntarChat = ChatGPTClient.perguntarChat(OPENAI_API_KEY, perguntaCrianca);

        JOptionPane.showMessageDialog(null, perguntarChat);
    break;

    case 4: 
        JOptionPane.showMessageDialog(null, "Opção ver membros do grupo selecionada! :)");
        JOptionPane.showMessageDialog(null, "Grupo composto por:\n" + "Gabriel Hernandes\n" + "Guilherme Nicolaci\n" + "Gustavo Nicolaci\n" + "João Marchette\n" + "Mateus Isidorio");
        break;

    case 5:
        JOptionPane.showMessageDialog(null, "Opção sair selecionada! :(");
    break;

    default: 
        JOptionPane.showMessageDialog(null, "Opção inválida.");
    break;
    }
  }
}