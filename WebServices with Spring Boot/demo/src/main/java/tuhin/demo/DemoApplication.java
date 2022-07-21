package tuhin.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context =
				SpringApplication.run(DemoApplication.class, args);
		//MarioGame game=new MarioGame();
		//SuperContraGame game=new SuperContraGame();
		//GameRunner runner=new GameRunner(game);
		GameRunner runner=context.getBean(GameRunner.class);
				
		runner.runGame();
	}

}
