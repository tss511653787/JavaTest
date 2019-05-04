package Test4;

//自定义一个异常类
public class ExceptionTest extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String info;

	public ExceptionTest() {
		super();
	}

	public ExceptionTest(String info) {
		super(info);
		this.info = info;
		System.out.println(info);
	}

}
