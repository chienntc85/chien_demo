$(document).ready(function getlistuser() {
	//save table
	var table;
	//index row
	var rowclick=-1;
	//state button save -1: add, >-1: update
	var button_save=-1;
	var mydata;
	var role1='<select class="badge-info myselect"> <option data-id="1" value="USER" selected>USER</option>'+
	'<option data-id="2" value="ADMIN">ADMIN</option></select>';
	var role2='<select class="badge-danger myselect"> <option data-id="1" value="USER" >USER</option>'+
	'<option data-id="2" value="ADMIN" selected>ADMIN</option></select>';
	$.ajax({
		type : "GET",
		url : "api/v1/users"
	}).then(function(data) {
		var auth = '';    	
		$.each(data, function (i, item) {	 	

			auth+='<tr><td class="idUser">'+item.idUser+'</td> ' +
			'<td class="nameUser font-weight-bold">'+item.nameUser+'</td>'+
			'<td class="numberphone">'+item.numberphone+'</td>'+
			'<td class="email">'+item.email+'</td>';
			if(item.sex==1){
				auth += '<td class="sex" data-id="1">Nữ</td>';
			}else{
				auth += '<td class="sex" data-id="0">Nam</td>';
			}
			auth+='<td class="birthday">'+item.birthday+'</td><td class="address">'+item.address+'</td>';
			auth+='<td class="idRole">';
			if(item.role.idRole==1){
				auth += role1;
			}else if(item.role.idRole==2){
				auth += role2;
			}
			auth+='</td><td><a href="#" class="edit-user btn btn-icon btn-pill btn-primary" data-toggle="tooltip" title="Edit" ><i class="fa fa-fw fa-edit"></i></a>'+
			'<a href="#" class="btn btn-icon btn-pill btn-danger delete-user" data-toggle="tooltip" title="Delete"><i class="fa fa-fw fa-trash"></i></a>'+
			'</td></tr>';

		});
		mydata=data;
		$('#list-user').append(auth);
		table=$('#table-user').DataTable(); 	 
	});

	$('#table-user tbody').on( 'click', 'a.edit-user', function () {
		var idUser=$(this).closest("tr").find('.idUser').text();
		window.location = 'add-user/'+idUser;
	});

	$('#table-user tbody').on('change', 'select.myselect', function () {
		var optionSelected = $("option:selected", this);
		var valueSelected = this.value;
		var idRole= optionSelected.data('id');
		$('#modalChange').modal('toggle');
		var idUser=$(this).closest("tr").find('.idUser').text();

		var this_role=$(this).closest("tr").find('td.idRole');
		this_role.empty();
		if(idRole==1){
			this_role.append(role1);
		}else if(idRole==2){
			this_role.append(role2);
		}

		$('#change-role').click(function(){
			$('#modalChange').modal('toggle');
			$.ajax({
				url : "api/v1/users/"+idUser+"/roles/"+idRole,
				type : "PUT",
				success : function(data) {
					$('.thongbao').html('<div class="alert alert-success" role="alert"><i class="far fa-check-circle"></i> Thay đổi thành công!!!</div>');
					$('.thongbao').fadeIn();
					setTimeout(function() {

						$('.thongbao').fadeOut(function() {
							$('.thongbao').empty();
						});
					}, 1000);
					//alertsuccess("Thay đổi thành công!!!");
				},
				statusCode: {
					404: function() {
						alert('404 page not found');
					},

					400: function() {
						alert('400 bad request');
					}
				}
			});
		});
	});


	/*==========================


    /*click delete*/ 
	$('#table-user tbody ').on( 'click', 'a.delete-user', function () {
		//get data row clicked
		var id=$(this).closest("tr").find('.idUser').text();
		var name=$(this).closest("tr").find('.nameUser').text();
		var index= table.row( $(this).closest("tr") ).index();
		$('#xoa-title').text('Bạn có chắc muốn xóa người dùng có tên: "'+name+'" không?');
		deleteuser(id, index);
	});
	/* Delete user*/ 
	function deleteuser(idUser, index){
		$('#modalDelete').modal('toggle');
		$('#delete-user').click(function(){
			$('#modalDelete').modal('toggle');
			alert(idUser);
			$.ajax({
				url : "api/v1/users/"+idUser,
				type : "DELETE",
				success : function(data) {
					table.row(index).remove().draw();
					mydata.splice(index, 1);
					alert('xóa thành công!');
				},
				statusCode: {
					404: function() {
						alert('404 page not found');
					},

					400: function() {
						alert('400 bad request');
					}
				}
			});
		});
	}
});