<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>热销图书
</h2>
<div class="book_c_04">

	<!--热销图书A开始-->
	<s:iterator value="bookList" begin="0" end="7">
			<div class="second_d_wai">
				<div class="img">
					<a href="<s:url action="book_selectOne" namespace="/main"/>?bid=<s:property value="bid"/>&cid=<s:property value="cid"/>" target='_blank'><img
							src="${pageContext.request.contextPath}/productImages/<s:property value="bimg"/>" border=0 /> </a>
				</div>
				<div class="shuming">
					<a href="<s:url action="book_selectOne" namespace="/main"/>?bid=<s:property value="bid"/>&cid=<s:property value="cid"/>" target="_blank"><s:property value="bname"/></a>
				</div>
				<div class="price">
					定价：￥<s:property value="bprice"/>
				</div>
				<div class="price">
					当当价：￥<s:property value="dprice"/>
				</div>
			</div>
			<div class="book_c_xy_long"></div>
	</s:iterator>
	<!--热销图书A结束-->

</div>
<div class="clear"></div>