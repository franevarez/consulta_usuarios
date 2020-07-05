<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Consulta De Usuarios</title>
	<script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.css">
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.js"></script>
	<script>
		var jsonVar;
	      window.onload = (event) => {
	      fetch('http://192.168.0.10:8080/consulta-usuarios/hello')
			.then(response => response.json())
						      .then(data => {
						      jsonVar = data;
		$('#table_id').DataTable( {
		  data: jsonVar,
		  columns: [
						              { title: 'ID' },
						              { title: 'Nombre' },
						              { title: 'Edad' },
						              { title: 'Email' },
						              { title: 'Fecha de Registro' }
						          ]
						      } );
						      });
	      };
	</script>
</head>
<body>
	<table id="table_id" class="display"></table>
</body>
</html>
