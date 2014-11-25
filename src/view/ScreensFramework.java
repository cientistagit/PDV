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
    public static String telaLogin = "login";
    public static String telaLoginFile = "/view/Login.fxml";
    public static String telaCaixa = "caixa";
    public static String telaCaixaFile = "/view/Caixa.fxml";
    public static String telaConsulta = "screen3";
    public static String telaConsultaFile = "Screen3.fxml";
    public static String telaVenda = "venda";
    public static String telaVendaFile = "/view/Venda.fxml";
    public static String telaPagamento = "pagamento";
    public static String telaPagamentoFile = "/view/Pagamento.fxml";
    
    
    @Override
    public void start(Stage primaryStage) {
        
        ScreensController mainContainer = new ScreensController();
       
        mainContainer.loadScreen(ScreensFramework.telaLogin, ScreensFramework.telaLoginFile);
        mainContainer.loadScreen(ScreensFramework.telaCaixa, ScreensFramework.telaCaixaFile);
        mainContainer.loadScreen(ScreensFramework.telaConsulta, ScreensFramework.telaConsultaFile);
        mainContainer.loadScreen(ScreensFramework.telaConsulta, ScreensFramework.telaPagamentoFile);
        
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
