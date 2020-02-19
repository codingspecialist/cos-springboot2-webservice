let index = {
		/*초기화*/
		init: function() {
			let _this = this;
			$('#btn-save').on('click', function(){
				_this.save(); // 여기에 this는 가장 가까운 function을 가르킨다. 그래서 _this를 사용.
			});
			$('#btn-update').on('click', function(){
				_this.update();
			});
			$('#btn-delete').on('click', function(){
				_this.delete();
			});			
		},
		
		/*게시글 등록*/
		save: function(){
			let data = {
					title: $('#title').val(),
					author: $('#author').val(),
					content: $('#content').val()
			};
			
			$.ajax({
				type: 'POST',
				url: '/api/v1/posts',
				dataType: 'json', // 응답 데이터 타입 지정 - 생략하면 서버에서 return 되는 데이터의 MIME 타입에 의해 결정
				contentType: 'application/json; charset=utf-8',
				data: JSON.stringify(data)
			}).done(function(resp){
				alert('글이 등록되었습니다.');
				window.location.href = '/';
			}).fail(function(error){
				alert(JSON.stringify(error));
			});
		},
		
		/*게시글 수정*/
		update: function(){
			let data = {
					title: $('#title').val(),
					content: $('#content').val()
			};

			let id = $('#id').val();
			
			$.ajax({
				type: 'PUT',
				url: '/api/v1/posts/'+id,
				dataType: 'json',
				contentType: 'application/json; charset=utf-8',
				data: JSON.stringify(data)
			}).done(function(resp){
				alert('글이 수정되었습니다.');
				window.location.href = '/';
			}).fail(function(error){
				alert(JSON.stringify(error));
			});
		},
		
		/*게시글 삭제*/
		delete: function(){	
			let id = $('#id').val();
			
			$.ajax({
				type: 'DELETE',
				url: '/api/v1/posts/'+id,
				dataType: 'json',
				contentType: 'application/json; charset=utf-8'
			}).done(function(resp){
				alert('글이 삭제되었습니다.');
				window.location.href = '/';
			}).fail(function(error){
				alert(JSON.stringify(error));
			});
		}
}

/*리스너 등록*/
index.init();