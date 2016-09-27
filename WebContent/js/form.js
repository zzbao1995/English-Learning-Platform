$(function(){
	var id = $(".select").attr("id");
	if(id!=null&&id!='')
	$(".select").get(0).selectedIndex=id-1;
});