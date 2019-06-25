package app;

import controller.ControllerTelaPrincipal;
import view.TelaPrincipal;

public class App {
	
	public static void main(String[] args) {
		TelaPrincipal telaPrincipal = new TelaPrincipal();
		new ControllerTelaPrincipal(telaPrincipal);
	}

}
