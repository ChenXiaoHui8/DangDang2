<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<link href="${pageContext.request.contextPath}/css/book.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/second.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/list.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-1.11.1.js"></script>
		<script type="text/javascript">
			function goumai(id){
				var result = confirm("是否确认购买");
				if(result){
					location='<s:url action="shoppingCart_add" namespace="/main"/>?bid='+id;
				}
			}
		</script>
	</head>
	<body>
		&nbsp;

		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->

		<div style="width: 962px; margin: auto;">
			<a href="#"><img src="${pageContext.request.contextPath}/images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>
		<div class='your_position'>
			您现在的位置:&nbsp;
			<a href='${pageContext.request.contextPath}/main/main.jsp'><font style='color: #cc3300'><strong>当当图书</strong> </font></a> &gt;&gt;
			<a href='<s:url action="book_selectPage" namespace="/main"/>?cid=<s:property value="cid"/>&pid=0'><font style='color: #cc3300'><strong><s:property value="pname"/> </a>
			</strong> </font>
			<s:if test="cname!=null">
			&gt;&gt;<a href='<s:url action="book_selectPage" namespace="/main"/>?cid=<s:property value="cid"/>&pid=<s:property value="pid"/>'><font style='color: #cc3300'><strong><s:property value="cname"/></a>
			</s:if>
			</strong> </font>
		</div>

		<div class="book">

			<!--左栏开始-->
			<div id="left" class="book_left">
				<div id="__fenleiliulan">
					<div class=second_l_border2>
						<h2>
							分类浏览
						</h2>
						<ul>
							<li>
								<div>
									<div class=second_fenlei>
										<a href='<s:url action="book_selectPage" namespace="/main"/>?cid=<s:property value="category.cid"/>&num=<s:property value="category.length"/>&pid=0'>&middot;全部&nbsp;(<s:property value="category.length"/>)</a>
									</div>
								</div>
							</li>
							<div class="clear"></div>
							
							<!--2级分类开始-->
							<s:iterator value="category.categoryList">
							<li>
								<div>
									<div class=second_fenlei>
										&middot;
									</div>
									<div class=second_fenlei>
										<a href='<s:url action="book_selectPage" namespace="/main"/>?cid=<s:property value="pid"/>&pid=<s:property value="cid"/>&num=<s:property value="length"/>'><s:property value="cname"/>&nbsp;(<s:property value="length"/>)</a>
									</div>
								</div>
							</li>
						    <div class="clear"></div>
							</s:iterator>
							<!--2级分类结束-->
							
							<li>
								<div></div>
							</li>
						</ul>
					</div>
				</div>
			</div>

			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">

				<!--图书列表开始-->
				<div id="divRight" class="list_right">

					<div id="book_list" class="list_r_title">
						<div id="divTopPageNavi" class="list_r_title_text3">

							<!--分页导航开始-->
							<s:if test="curPage>1">
								<div class='list_r_title_text3a'>
								
									<a name=link_page_next
										href='<s:url action="book_selectPage" namespace="/main"/>?curPage=<s:property value="curPage-1"/>'>
									<img src='${pageContext.request.contextPath}/images/page_up.gif' /> </a>
								</div>
							</s:if>
							<s:else>
								<div class='list_r_title_text3a'>
									<img src='${pageContext.request.contextPath}/images/page_up_gray.gif' />
								</div>
							</s:else>
							<div class='list_r_title_text3b'>
								第<s:property value="curPage"/>页/共<s:property value="totalPage"/>页
							</div>
							<s:if test="curPage<totalPage">
							<div class='list_r_title_text3a'>
								<a name=link_page_next
									href='<s:url action="book_selectPage" namespace="/main"/>?curPage=<s:property value="curPage+1"/>'>
									<img src='${pageContext.request.contextPath}/images/page_down.gif' /> </a>
							</div>
							</s:if>
							<s:else>
							<div class='list_r_title_text3a'>
								<img src='${pageContext.request.contextPath}/images/page_down_gray.gif' />
							</div>
							</s:else>
							<!--分页导航结束-->
						</div>
					</div>
					
					<!--商品条目开始-->
						
						<div class="list_r_line"></div>
						<s:iterator value="bookList">
							<div class="clear"></div>
							
							<div class="list_r_list">
								<span class="list_r_list_book"><a name="link_prd_img" href='<s:url action="book_selectOne" namespace="/main"/>?bid=<s:property value="bid"/>&cid=<s:property value="cid"/>'>
									<img src="${pageContext.request.contextPath}/productImages/<s:property value="bimg"/>" /> </a> </span>
								<h2>
									<a name="link_prd_name" href='<s:url action="book_selectOne" namespace="/main"/>?bid=<s:property value="bid"/>&cid=<s:property value="cid"/>'><s:property value="bname"/></a>
								</h2>
								<h3>
									顾客评分：100
								</h3>
								<h4 class="list_r_list_h4">
									作 者:
									<a href='#' name='作者'><s:property value="author"/></a>
								</h4>
								<h4>
									出版社：
									<a href='#' name='出版社'>人民邮电出版社</a>
								</h4>
								<h4>
									出版时间：<s:property value="time"/>
								</h4>
								<h5>
									<s:property value="messages"/>
								</h5>
								<div class="clear"></div>
								<h6>
									<span class="del">￥<s:property value="bprice"/></span>
									<span class="red">￥<s:property value="dprice"/></span>
									节省：￥<s:property value="bprice-dprice"/>
								</h6>
								<span class="list_r_list_button"> 
								<a href="javascript:void(0)"> 
								<img src='${pageContext.request.contextPath}/images/buttom_goumai.gif' onclick='goumai(<s:property value="bid"/>)'/> </a>
								<span id="cartinfo"></span>
							</div>
							<div class="clear"></div>
						</s:iterator>
						<%-- <div class="clear"></div>
						<div class="list_r_list">
							<span class="list_r_list_book"><a name="link_prd_img" href='#'>
								<img src="../productImages/1.jpg" /> </a> </span>
							<h2>
								<a name="link_prd_name" href='#'>精通JavaEE轻量级框架整合方案</a>
							</h2>
							<h3>
								顾客评分：100
							</h3>
							<h4 class="list_r_list_h4">
								作 者:
								<a href='#' name='作者'>菜鸟</a>
							</h4>
							<h4>
								出版社：
								<a href='#' name='出版社'>人民邮电出版社</a>
							</h4>
							<h4>
								出版时间：2009-01-01
							</h4>
							<h5>
								这是一本好书，描述了Struts、Hibernate和Spring等框架的整合应用！
							</h5>
							<div class="clear"></div>
							<h6>
								<span class="del">￥79</span>
								<span class="red">￥60</span>
								节省：￥19
							</h6>
							<span class="list_r_list_button"> 
							<a href="#"> 
							<img src='../images/buttom_goumai.gif' /> </a>
							<span id="cartinfo"></span>
						</div>
						<div class="clear"></div>
						
						<div class="clear"></div>
						<div class="list_r_list">
							<span class="list_r_list_book"><a name="link_prd_img" href='#'>
								<img src="../productImages/1.jpg" /> </a> </span>
							<h2>
								<a name="link_prd_name" href='#'>精通JavaEE轻量级框架整合方案</a>
							</h2>
							<h3>
								顾客评分：100
							</h3>
							<h4 class="list_r_list_h4">
								作 者:
								<a href='#' name='作者'>菜鸟</a>
							</h4>
							<h4>
								出版社：
								<a href='#' name='出版社'>人民邮电出版社</a>
							</h4>
							<h4>
								出版时间：2009-01-01
							</h4>
							<h5>
								这是一本好书，描述了Struts、Hibernate和Spring等框架的整合应用！
							</h5>
							<div class="clear"></div>
							<h6>
								<span class="del">￥79</span>
								<span class="red">￥60</span>
								节省：￥19
							</h6>
							<span class="list_r_list_button"> 
							<a href="#"> 
							<img src='../images/buttom_goumai.gif' /> </a>
							<span id="cartinfo"></span>
						</div>
						<div class="clear"></div> --%>
					
						<!--商品条目结束-->

					<div class="clear"></div>
					<div id="divBottomPageNavi" class="fanye_bottom">
					</div>

				</div>
				<!--图书列表结束-->

			</div>
			<!--中栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
	</body>
</html>
