package OOP;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Knappelytter implements javafx.event.EventHandler<ActionEvent> {

	private Kalkulator kalk = new Kalkulator();	
	private TextField display = new TextField();
	
	@Override
	public void handle(ActionEvent e) {
		Button knapp = (Button) e.getSource();
		String s = knapp.getText();
		
		if(s.equals("0")) { kalk.siffer(0); }
		else if(s.equals("1")) { kalk.siffer(1); }
		else if(s.equals("2")) { kalk.siffer(2); }
		else if(s.equals("3")) { kalk.siffer(3); }
		else if(s.equals("4")) { kalk.siffer(4); }
		else if(s.equals("5")) { kalk.siffer(5); }
		else if(s.equals("6")) { kalk.siffer(6); }
		else if(s.equals("7")) { kalk.siffer(7); }
		else if(s.equals("8")) { kalk.siffer(8); }
		else if(s.equals("9")) { kalk.siffer(9); }
		else if(s.equals("1")) { kalk.siffer(1); }
		else if(s.equals("1")) { kalk.siffer(1); }
		else if(s.equals("1")) { kalk.siffer(1); }
		else if(s.equals("1")) { kalk.siffer(1); }
		else if(s.equals("1")) { kalk.siffer(1); }
		else if(s.equals("+")) { kalk.oper('+'); }
		else if(s.equals("-")) { kalk.oper('-'); }
		else if(s.equals("/")) { kalk.oper('/'); }
		else if(s.equals("*")) { kalk.oper('*'); }
		else if(s.equals("+/-")) { kalk.snuFortegn(); }
		else if(s.equals("C")) { kalk.nullstill(); }
		else if(s.equals("=")) { kalk.erLik(); }
		else {
			System.err.println("Logisk feil i programmet - skal ikke skje!");
			System.exit(-1);
		}
		
		display.setText(kalk.hentVerdi());
		
	}

	public TextField getDisplay() {
		return display;
	}

	
}
