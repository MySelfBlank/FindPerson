package dao;

public class DaoException extends Exception{
	static final long serialVersionUID=19192L;
	String message;
	public DaoException() {
		// TODO �Զ����ɵĹ��캯�����
	}
	public DaoException(String message) {
		// TODO �Զ����ɵĹ��캯�����
		this.message=message;
	}
	public String getMessage() {
		// TODO �Զ����ɵķ������
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String toString() {
		// TODO �Զ����ɵķ������
		return message;
	}
}
