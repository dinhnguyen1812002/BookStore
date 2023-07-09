
$(document).ready(function (){
    $.ajax({
      url: 'http://localhost:8080/api/v1/books',
      type: 'GET',
      dateType: 'json',
      success: function (data){
        let trHTML = '';
        $.each(data,function (i,item) {
          trHTML = trHTML + '<tr id=book-' + item.id + '">' +
                  '<td>' + item.id + '</td>' +
                  '<td>' + item.title + '</td>' +
                  '<td>' + item.author + '</td>' +
                  '<td>' + item.price + '</td>' +
                  '<td>' + item.category.name + '</td>' +
                  '<td> <a href="#' + item.id + '" class="text-primary">Edit</a> ' +
                  '<a href="/books" ' + item.id + 'class="text-danger"onclick="apiDeleteBook(' + item.id + ',this);return false;"sec:authorize="hasAnyAuthorit(\'ADMIN\')">Delete</a>' +
                  '</td> ' +
                  '</tr>';
          console.log(trHTML);
        });
        $('#book-table-body').append(trHTML);
      }
    });
 });

function apiDelete(id) {
    if(confirm('bạn có muốn xóa quyển sách này')){
        $.ajax({
            url: 'http://localhost:8080/api/v1/books'+ id,
            type: 'DELETE',
            success: function name(params) {
                alert('xóa thành công');
                $('#book-'+id).remove();
            }
        })
    }

}

