<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<style type="text/css">
.form-item {
	margin-bottom: 15px;
	width: 50%;
	float: left;
}

.form-item>label {
	min-width: 72px;
	display: inline-block;
}

.form-item input, select {
	width: 170px;
}
</style>
<div class="super-theme-example">
	<form id="ff" method="post">
		<div class="form-item">
			<label for="" class="label-top">商品类目:</label> 
				<a href="javascript:void(0)" class="easyui-linkbutton selectItemCat">选择类目</a>
	            	<input type="hidden" name="cid" style="width: 280px;"></input>
		</div>

	</form>

</div>
<script  type="text/javascript">
//页面初始化完毕后执行此方法
$(function(){
	//初始化类目选择和图片上传器
	TT.init({fun:function(node){
	}});
});
</script>