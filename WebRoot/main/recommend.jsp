<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<h2>
	编辑推荐
</h2>
<div id=__bianjituijian/danpin>
	<div class=second_c_02>
	
		<!--编辑推荐开始-->
		<s:iterator value="bookList" begin="0" end="1">
			
				<div class=second_c_02_b1>
					<div class=second_c_02_b1_1>
						<a href='<s:url action="book_selectOne" namespace="/main"/>?bid=<s:property value="bid"/>&cid=<s:property value="cid"/>' target='_blank'><img src="${pageContext.request.contextPath}/productImages/<s:property value="bimg"/>" width=70 border=0 /> </a>
					</div>
					<div class=second_c_02_b1_2>
						<h3>
							<a href='<s:url action="book_selectOne" namespace="/main"/>?bid=<s:property value="bid"/>&cid=<s:property value="cid"/>' target='_blank' title='输赢'><s:property value="bname"/></a>
						</h3>
						<h4>
							作者：<s:property value="author"/> 著
							<br />
							出版社：×××&nbsp;&nbsp;&nbsp;&nbsp;出版时间：<s:property value="time"/>
						</h4>
						<h5>
							简介 &nbsp;&nbsp;&nbsp;&nbsp;<s:property value="messages"/>
						</h5>
						<h6>
							定价：￥<s:property value="bprice"/>&nbsp;&nbsp;当当价：￥<s:property value="dprice"/>
						</h6>
						<div class=line_xx></div>
					</div>
				</div>
				
		
		</s:iterator>
		<!--编辑推荐结束-->
		
	</div>
</div>
