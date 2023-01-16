/**
 * 
 */

 $(document).ready(function(){
				
	//user1 목록 요청
	$('.user1_list1').click(function(){
		
		$.ajax({
			'url':'/Ch09/user1',
			'method':'get',
			'dataType':'json',
			'success':function(data){
				console.log(data);
			}
		});
	});
	
	//user1 목록 요청
	$('.user1_list2').click(function(){
		
		let uid = input.val();
		
		$.ajax({
			'url':'/Ch09/user1/a101',
			'method':'get',
			'dataType':'json',
			'success':function(data){
				console.log(data);
			}
		});
	});
	
	//user1 등록 요청
	$('.user1_register').click(function(){
		
		let jsonData = {
				"uid":"a101",
				"name":"aadd",
				"hp":"010-11234-1234",
				"age":22
			};
		
		
		$.ajax({
			url:'/Ch09/user1',
			method:'post',
			data:jsonData,
			dataType:'json',
			success:function(data){
				console.log(data);
			}
		});
	});
	
	
	//user1 수정 요청
	$('.user1_modify').click(function(){
		
		let jsonData = {
				"uid":"a101",
				"name":"aadd",
				"hp":"010-11234-1111",
				"age":27
			};
		
		$.ajax({
			url:'/Ch09/user1',
			method:'put',
			data:jsonData,
			dataType:'json',
			success:function(data){
				console.log(data);
			}
		});
	});
	
	//user1 삭제 요청
	$('.user1_delete').click(function(){
		
		$.ajax({
			url:'/Ch09/user1/a101',
			method:'delete',
			dataType:'json',
			success:function(data){
				console.log(data);
			}
		});
	});
	
});