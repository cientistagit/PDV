/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.frameworkGerenciaTela.ScreensController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Jailton
 */
public class ScreensFramework extends Application {
    //Colocar o nome da tela (id) no nome da variável .
    //a variável do caminho da file é privada e final (não se modifica), só é utilizada dentro da classe.
    public static String telaLogin = "login";
    private static final String telaLoginFile = "/view/Login.fxml";
    public static String telaPrincipal = "principal";
    private static final String telaPrincipalFile = "/view/Principal.fxml";
    public static String telaCaixa = "caixa";
    public static final String telaCaixaFile = "/view/Caixa.fxml";
    public static String telaConsulta = "consulta";
    private static final String telaConsultaFile = "/view/Consulta.fxml";
    public static String telaVenda = "venda";
    private static final String telaVendaFile = "/view/Venda.fxml";
    public static String telaPagamento = "pagamento";
    private static final String telaPagamentoFile = "/view/Pagamento.fxml";
    public static String telaPagamentoCartao = "pagamentoCartao";
    private static final String telaPagamentoCartaoFile = "/view/PagamentoCartao.fxml";
    public static String telaFeaturesConfig = "featureConfig";
    public static final String telaFeaturesConfigFile = "/view/FeatureConfig.fxml";
    public static String telaRelatorios = "relarorios";
    public static final String telaRelatoriosFile = "/view/Relatorio.fxml";
    public static String telaRelMercadorias = "relarorioMercadorias";
    public static final String telaRelMercadoriasFile = "/view/Mercadorias.fxml";
    
    /**
     * colocado como global para que telas possam ser carregadas dinamicamente a partir de outros pontos do programa
     */
    public static ScreensController mainContainer = new ScreensController();
    
    @Override
    public void start(Stage primaryStage) {
        
        
               
        mainContainer.loadScreen(ScreensFramework.telaLogin, ScreensFramework.telaLoginFile);
        mainContainer.loadScreen(ScreensFramework.telaPrincipal, ScreensFramework.telaPrincipalFile);
        //mainContainer.loadScreen(ScreensFramework.telaCaixa, ScreensFramework.telaCaixaFile); // tela carregada ao clicar no botão "caixa"
        mainContainer.loadScreen(ScreensFramework.telaConsulta, ScreensFramework.telaConsultaFile);        
        mainContainer.loadScreen(ScreensFramework.telaVenda, ScreensFramework.telaVendaFile);
        mainContainer.loadScreen(ScreensFramework.telaPagamento, ScreensFramework.telaPagamentoFile);
        mainContainer.loadScreen(ScreensFramework.telaPagamentoCartao, ScreensFramework.telaPagamentoCartaoFile);
        mainContainer.loadScreen(ScreensFramework.telaRelatorios, ScreensFramework.telaRelatoriosFile);
        mainContainer.loadScreen(ScreensFramework.telaRelMercadorias, ScreensFramework.telaRelMercadoriasFile);
        //mainContainer.loadScreen(ScreensFramework.telaFeaturesConfig, ScreensFramework.telaFeaturesConfigFile); //tela carregada ao clicar no botão configurações
        
        mainContainer.setScreen(ScreensFramework.telaLogin);
        
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
