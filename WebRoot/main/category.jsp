<%@page contentType="text/html;charset=utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<div class="book_l_border1" id="__FenLeiLiuLan">
	<div class="book_sort_tushu">
		<h2>
			分类浏览
		</h2>
		
		<!--1级分类开始-->
			<s:iterator value="categoryList">
				<div class="bg_old" onmouseover="this.className = 'bg_white';"
					onmouseout="this.className = 'bg_old';">
					
					<h3>
						[<a href='<s:url action="book_selectPage" namespace="/main"/>?cid=<s:property value="cid"/>&num=<s:property value="length"/>&pid=0'><s:property value="cname"/></a>]
					</h3>
					<ul class="ul_left_list">
							<!--2级分类开始-->
						<s:iterator value="categoryList">	
							<li>
								<a href='<s:url action="book_selectPage" namespace="/main"/>?cid=<s:property value="pid"/>&pid=<s:property value="cid"/>&num=<s:property value="length"/>'><s:property value="cname"/></a>
							</li>
						</s:iterator>
							<!--2级分类结束-->
	
					</ul>
					<div class="empty_left">
					</div>
				</div>
	
				<div class="more2">
				</div>
				<!--1级分类结束-->
			</s:iterator>


		<div class="bg_old">
			<h3>
				&nbsp;
			</h3>
		</div>
	</div>
</div>
