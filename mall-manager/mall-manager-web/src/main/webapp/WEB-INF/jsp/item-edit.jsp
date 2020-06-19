<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<style type="text/css">
.form-item {
	margin-bottom: 15px;
	width: 100%;
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
	<form id="itemeEditForm" method="post">
		<div class="form-item">
			<label for="" class="label-top">商品类目:</label> <a
				href="javascript:void(0)" class="easyui-linkbutton selectItemCat">选择类目</a>
			<input type="hidden" name="cid" style="width: 280px;"></input>
		</div>
		<div class="form-item">
			<label for="" class="label-top">商品标题:</label> <input
				class="easyui-textbox" type="text" name="title"
				data-options="required:true" style="width: 280px;"></input>
		</div>
		<div class="form-item">
			<label for="" class="label-top">商品卖点:</label> <input
				class="easyui-textbox" name="sellPoint"
				data-options="multiline:true,validType:'length[0,150]'"
				style="height: 60px; width: 280px;"></input>
		</div>
		<div class="form-item">
			<label for="" class="label-top">商品价格:</label> <input
				class="easyui-numberbox" type="text" name="priceView"
				data-options="min:1,max:99999999,precision:2,required:true" /> <input
				type="hidden" name="price" value="0" />
		</div>
		<div class="form-item">
			<label for="" class="label-top">库存数量:</label> <input
				class="easyui-numberbox" type="text" name="num"
				data-options="min:1,max:99999999,precision:0,required:true" />
		</div>
		<div class="form-item">
			<label for="" class="label-top">条形码:</label>
			<input class="easyui-textbox" type="text" name="barcode" data-options="validType:'length[1,30]'" />
		</div>
		<div class="form-item">
			<label for="" class="label-top">商品图片:</label>
			 <a href="javascript:void(0)" class="easyui-linkbutton picFileUpload">上传图片</a>
	                 <input type="hidden" name="image"/>
		</div>
		<div class="form-item">
			<label for="" class="label-top" style="align-content: center;">商品描述:</label>
			  <textarea style="width:800px;height:300px;visibility:hidden;" name="desc"></textarea>
		</div>
		<div class="form-item">
			<label for="" class="label-top params hide">商品规格:</label>
		</div>
			<div class="form-item">
			<a href="javascript:void(0)" class="easyui-linkbutton warning"
				onclick="clearForm()">取消</a> <a href="javascript:void(0)"
				class="easyui-linkbutton success" onclick="submitForm()">提交</a>
		</div>
	</form>

</div>
<script type="text/javascript">
	var itemEditEditor ;
	$(function(){
		//实例化编辑器
		itemEditEditor = TT.createEditor("#itemeEditForm [name=desc]");
	});
	
	//提交表单
	function submitForm(){
		//有效性验证
		if(!$('#itemEditForm').form('validate')){
			$.messager.alert('提示','表单还未填写完成!');
			return ;
		}
		//同步文本框中的商品描述
		itemEditEditor.sync();
		//ajax的post方式提交表单
		alert($("#itemEditForm").serialize());
		$.post("/item/update",$("#itemeEditForm").serialize(), function(data){
			if(data.status == 200){
				$.messager.alert('提示','修改商品成功!','info',function(){
					$("#itemEditWindow").window('close');
					$("#dgTbItem").datagrid("reload");
				});
			}
		});
	}
	
	function clearForm(){
		$('#itemEditForm').form('reset');
	}
</script>