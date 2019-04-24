import java.util.Map;
import java.util.HashMap;

public class State {
	private Map<String, Integer> variables;
	
	public State() {
		variables = new HashMap<>();
	}
	
	public State(String[] ar) {
		variables = new HashMap<>();
		for(int i=0;i<ar.length;i++) {
			variables.put(ar[i].split(",")[0], Integer.valueOf(ar[i].split(",")[1]));
		}
	}
	
	public void addVar(String var, Integer val) {
		variables.put(var, val);
	}
	
	public Integer getVar(String var) {
		return variables.get(var);
	}
	
	@Override
	public String toString() {
		return variables.toString();
	}
}
