package xmu.mystore.goodsindex.zjh.constant;

import xmu.mystore.goodsindex.zjh.model.AjaxReturnResult;

public class RenderAjaxReturnResult 
{
	public static final String JSON_CODE_SUCCESS="200";
	public static final String JSON_CODE_FAILURE="201";
	
	//Json处理成功返回事件
	public static AjaxReturnResult renderSuccessResult(String message)
	{
		return new AjaxReturnResult(JSON_CODE_SUCCESS,message);
	}
	
	//Json处理失败返回事件
	public static AjaxReturnResult renderErrorResult(String message)
	{
		return new AjaxReturnResult(JSON_CODE_FAILURE,message);
	}
}
