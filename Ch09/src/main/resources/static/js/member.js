/**
 * 
 */

 $(document).ready(function(){
				
	//member 목록 요청
	$('.member_list1').click(function(){
		
		$.ajax({
			'url':'/Ch09/member',
			'method':'get',
			'dataType':'json',
			'success':function(data){
				console.log(data);
			}
		});
	});
	
	//member 목록 요청
	$('.member_list2').click(function(){
		
		let uid = input.val();
		
		$.ajax({
			'url':'/Ch09/member/a101',
			'method':'get',
			'dataType':'json',
			'success':function(data){
				console.log(data);
			}
		});
	});
	
	//member 등록 요청
	$('.member_register').click(function(){
		
		let jsonData = {
				"uid":"a101",
				"name":"aadd",
				"hp":"010-11234-1234",
				"pos":"사원",
				"dep":110
			};
		
		
		$.ajax({
			url:'/Ch09/member',
			method:'post',
			data:jsonData,
			dataType:'json',
			success:function(data){
				console.log(data);
			}
		});
	});
	
	
	//member 수정 요청
	$('.member_modify').click(function(){
		
		let jsonData = {
				"uid":"a101",
				"name":"aadd",
				"hp":"010-11234-1234",
				"pos":"사원",
				"dep":110
			};
		
		$.ajax({
			url:'/Ch09/member',
			method:'put',
			data:jsonData,
			dataType:'json',
			success:function(data){
				console.log(data);
			}
		});
	});
	
	//member 삭제 요청
	$('.member_delete').click(function(){
		
		$.ajax({
			url:'/Ch09/member/a101',
			method:'delete',
			dataType:'json',
			success:function(data){
				console.log(data);
			}
		});
	});
	
});