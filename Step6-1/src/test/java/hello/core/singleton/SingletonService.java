package hello.core.singleton;

public class SingletonService {

	private static final SingletonService instance = new SingletonService();//static으로 하나만 등록
	
	public static SingletonService getInstance() {
		return instance;
	}
	
	private SingletonService() { //new 로외부에서 생성되는것을 막는다 .
		
	}
	
	public static void main(String[] args) {
		
	}
}
