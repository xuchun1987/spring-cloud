package cloud.common.entity;


import java.io.Serializable;

public class ResultEntity implements Serializable{

	private static final long serialVersionUID = -3649321607964742271L;

	private String code;//返回码

	private String msg;//返回信息

	private Object data=new String("{}");

	private String sign;
	
	public ResultEntity(){
		
	}

	public ResultEntity(String code, String msg, Object data){
		this.code=code;
		this.msg=msg;
		this.data=data;
	}


	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}


	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
}
