package xmu.mall.goodsindex.zjh.model;

/**
 * ajax的返回
 * @author ZengJieHang
 *
 */
public class AjaxReturnResult 
{
	private String code;//处理成功或失败
	private String message;//处理信息
	
	public AjaxReturnResult(String code,String message)
	{
		this.code=code;
		this.message=message;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
