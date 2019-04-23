import java.util.HashMap;

public class State {
	private HashMap<String, String> state;
	
	public State() {
		state = new HashMap<>();
	}
	
	public State(String[] ar) {
		state = new HashMap<>();
		for(int i=0;i<ar.length;i++) {
			state.put(ar[i].split(",")[0], ar[i].split(",")[1]);
		}
	}
	
	public void addVar(String var, String val) {
		state.put(var, val);
	}
	
	public String getVar(String var) {
		return state.get(var);
	}
}
