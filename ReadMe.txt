

一、给想使用这个工程的人

	环境:tomcat8.5(版本低的tomcat可能会有一点问题)
	
	数据库:本地mysql
	
	表格及初始数据: sql文件在src/main/resouces文件夹下,导入mysql数据库
	
	数据库链接（修改用户名和密码）:在包xmu.mystore.config下找到MybatisConfig
	
	修改方法public DruidDataSource dataSource()里相应的数据库连接配置



二、给曹将将支付流程小组

	前端发给你们的数据为两个String数组
	
	(我试了其他一些方法,想在后台直接接收List<OrderInfo>.
	
	但是form表单没有成功过,ajax提交就成功了
	
	但是,ajax提交势必意味着两次访问后台服务器,会降低效率,所以最后还是采用了这种挫挫的两个一维数组提交方式)
	
	第一个String数组为商品id列表,第二个String数组为商品数量列表。我能保证这两个数组长度一致,能够匹配
	
	在实际使用的时候请参考我的包controller下类ShoppingCartController方法public String turnToOrderPage()
	
	PS:最好把整个方法移植到你们的控制器里面去,以保证ShoppingCartController只用来处理购物车的相关事务(你可以看到ShoppingCartController处理的url路径均为JavaEE/cart/***)
	
	然后修改前端的提交路径为比如JavaEE/pay/orderCommit
	
	前端提交路径的修改方式:
	
	找路径webapp/resources/js/zjh/cartIndex.js,找到函数function buyGoods()
	
	里面用jquery新建了一个form,代码如下:
	
	var form=$("<form action='"+springUrl+"/cart/order' method='post'></form>")
	
	修改action里面的路径为action='"+springUrl+"/pay/orderCommit/(比如这样)
	
	springUrl为工程的绝对路径,这是一个预定义的常量
	
	最后最后,记得把我model层的OrderInfo删了,那个是我为了自己测试用的



三、给韦于萍(没记错的话)用户管理小组

	后端使用的时候,我用了session来记录用户id
	
	系统运行的时候,用户登录（假设我们有登陆这个操作,或者从微信端进入的时候）
	
	要把用户id存进session中 
	
	我在实际使用的时候默认用户id为1,在controller包下IndexController可以看到我把1放进了session中
	
	Session使用方法大致如下:
	
	在方法参数中添加一个HttpSession session的生命,如public void home(Model model,HttpSession session)
	
	然后直接session.addAttribute("userId",abcdefg)
	
	获取String userId=session.getAttribute("userId").toString()
	
	如果转化成Long,Long userId=Long.valueOf(session.getAttribute("userId").toString())


四、给杨梦洋商品管理小组

	想不到有什么想说的
	
	哦,商品图片上传路径记得是resources/images/姓名/
	
	然后数据库存的路径是resources/images/姓名/图片名


五、谢谢你看到了这里，

	好像没什么想说的了，想到再补充。完
