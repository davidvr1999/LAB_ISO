import Persistencia.AgenteBD;

public class TestDB {

	public static void main(String[] args) {
		AgenteBD bd = new AgenteBD();
		
		System.out.println(bd.getConnection());

	}

}
