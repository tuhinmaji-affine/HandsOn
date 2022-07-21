package tuhin.demo;

public class SuperContraGame implements GamingConsole {
	public void up() {
		System.out.println("jump");
	}
	public void down() {
		System.out.println("slow");
	}
	public void left() {
		System.out.println("break");
	}
	public void right() {
		System.out.println("go fast");
	}
}
