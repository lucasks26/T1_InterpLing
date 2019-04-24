import java.util.Map;
import java.util.HashMap;

public class Ambient {
	private Map<String, State> states;
	
	public Ambient() {
		states = new HashMap<>();
	}
	
	public Ambient(String[] es, State[] s) {
		states = new HashMap<>();
		for(int i=0;i<es.length;i++) {
			states.put(es[i], s[i]);
		}
	}
	
	public void addState(String es, State s) {
		states.put(es, s);
	}
	
	public State getVar(String es) {
		return states.get(es);
	}
}
