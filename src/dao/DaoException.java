package dao;

public class DaoException extends Exception{
	static final long serialVersionUID=19192L;
	String message;
	public DaoException() {
		// TODO 自动生成的构造函数存根
	}
	public DaoException(String message) {
		// TODO 自动生成的构造函数存根
		this.message=message;
	}
	public String getMessage() {
		// TODO 自动生成的方法存根
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String toString() {
		// TODO 自动生成的方法存根
		return message;
	}
}
