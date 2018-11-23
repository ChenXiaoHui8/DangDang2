<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<div id="NewProduct_1_o_t" onmouseover="">
	<ul>
		<s:iterator value="bookList" status="sta">
			<s:if test="#sta.index<10">
			 <li><a href="<s:url action="book_selectOne" namespace="/main"/>?bid=<s:property value="bid"/>&cid=<s:property value="cid"/>" target='_blank'><s:property value="bname"/></a></li>
			</s:if>
		</s:iterator>
	</ul>
</div>