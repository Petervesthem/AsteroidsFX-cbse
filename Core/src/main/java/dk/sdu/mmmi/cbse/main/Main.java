package dk.sdu.mmmi.cbse.main;

import javafx.application.Application;

import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnnotationConfigApplicationContext annctx = new AnnotationConfigApplicationContext(ModuleConfig.class);

        for (String bean: annctx.getBeanDefinitionNames()){
            System.out.println(bean);
        }

        Game game = annctx.getBean(Game.class);

        game.start(primaryStage);

    }
}
