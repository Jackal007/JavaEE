package xmu.mall.goodsindex.zjh.constant;

import xmu.mall.goodsindex.zjh.model.AjaxReturnResult;
/**
 * 产生ajax的返回值
 * 处理成功则返回200
 * 处理失败则返回201
 * @author ZengJieHang
 *
 */
public class RenderAjaxReturnResult 
{
	public static final String JSON_CODE_SUCCESS="200";//成功执行
	public static final String JSON_CODE_FAILURE="201";//不成功执行
	
	/**
	 * Json处理成功返回事件
	 * @param message
	 * @return
	 */
	public static AjaxReturnResult renderSuccessResult(String message)
	{
		return new AjaxReturnResult(JSON_CODE_SUCCESS,message);
	}
	
	/**
	 * Json处理失败返回事件
	 * @param message
	 * @return
	 */
	public static AjaxReturnResult renderErrorResult(String message)
	{
		return new AjaxReturnResult(JSON_CODE_FAILURE,message);
	}
}
