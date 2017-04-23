<%@page import="java.util.Iterator"%>
<%@page import="util.MaestroDatos"%>
<%@page import="java.util.Map"%>
<%@page import="util.Utilidades"%>
<%@page import="util.Constantes"%>
<%@page import="java.util.List"%>
<%@page import="service.PersonaService"%>
<%@page import="bean.Asociacion"%>
<%@page import="bean.Persona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!--<meta charset="utf-8">-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">


<title>Socios</title>
    <!-- Bootstrap Core CSS -->
    <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="lib/startbootstrap-sb-admin-gh-pages/css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="lib/startbootstrap-sb-admin-gh-pages/css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="lib/fonts/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

   <!-- Theme bootstrap Table -->
   <link type="text/css" rel="stylesheet" href="lib/bootstraptable/dist/bootstrap-table.css"/>
   




    
    
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<%
	Persona p = (Persona)request.getSession().getAttribute(Constantes.sessionUsuario);
	PersonaService personaS = new PersonaService();
	List<Persona> listado_socios = personaS.listPersonas();
	Map<Boolean, String> listadoBooleanos = (Map<Boolean,String>)MaestroDatos.getBooleanValuesSelect();
 	Iterator iterator = listadoBooleanos.entrySet().iterator();
	
%>

    <div id="wrapper">
        <!-- Navigation Up -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">SB Admin</a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope"></i> <b class="caret"></b></a>
                    <ul class="dropdown-menu message-dropdown">
                        <li class="message-preview">
                            <a href="#">
                                <div class="media">
                                    <span class="pull-left">
                                        <img class="media-object" src="http://placehold.it/50x50" alt="">
                                    </span>
                                    <div class="media-body">
                                        <h5 class="media-heading"><strong><%= p.getNombre() %></strong>
                                        </h5>
                                        <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                        <p>Lorem ipsum dolor sit amet, consectetur...</p>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="message-preview">
                            <a href="#">
                                <div class="media">
                                    <span class="pull-left">
                                        <img class="media-object" src="http://placehold.it/50x50" alt="">
                                    </span>
                                    <div class="media-body">
                                        <h5 class="media-heading"><strong><%= p.getNombre() %></strong>
                                        </h5>
                                        <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                        <p>Lorem ipsum dolor sit amet, consectetur...</p>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="message-preview">
                            <a href="#">
                                <div class="media">
                                    <span class="pull-left">
                                        <img class="media-object" src="http://placehold.it/50x50" alt="">
                                    </span>
                                    <div class="media-body">
                                        <h5 class="media-heading"><strong><%= p.getNombre() %></strong>
                                        </h5>
                                        <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                        <p>Lorem ipsum dolor sit amet, consectetur...</p>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="message-footer">
                            <a href="#">Read All New Messages</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bell"></i> <b class="caret"></b></a>
                    <ul class="dropdown-menu alert-dropdown">
                        <li>
                            <a href="#">Alert Name <span class="label label-default">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-primary">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-success">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-info">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-warning">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-danger">Alert Badge</span></a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">View All</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> <%= p.getNombre() %> <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-envelope"></i> Inbox</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="LogoutServlet"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Navbar Left -->
            <div class="collapse navbar-collapse navbar-ex1-collapse" id="nav_left">
            </div>
        </nav>
            <!-- /.navbar-collapse -->

        <div id="page-wrapper">


            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Dashboard <small>Statistics Overview</small>
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="main.jsp"> Principal</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-bar-chart-o"></i> Socios
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

		<!-- CUERPO DE WEB -->
    <div class="row">
<div class="container-fluid">
  <div class="row">

  <div class="col-md-9" id="containerTable">
  <%
  if(personaS.checkAuthUpdateDeleteSocios(p.getIdRol())){
	%>
	<div id="toolbar" class="btn-group">
    <button type="button" class="btn btn-default" id="btnEdit">
        <i class="glyphicon glyphicon-pencil"></i>
    </button>
    <!-- 
    <button type="button" class="btn btn-default" id="btnRemove">
        <i class="glyphicon glyphicon-trash"></i>
    </button>
    
    -->
</div>
	<%
  }
  %>

<table data-toolbar="#toolbar" data-show-columns="true" data-unique-id="ColumnId" data-click-to-select="true" data-single-select="true" data-toggle="table" id="tablaDinamica" data-search="true" data-pagination="true">
<thead>
<tr> 
<th tabindex="0" data-field="ColumnState" data-checkbox="true"></th> 
<th data-field="ColumnEmail" data-sortable="true">Email</th>
<th data-field="ColumnNombre" data-sortable="true">Nombre</th>
<th data-field="ColumnApellidos" data-sortable="true">Apellidos</th> 
<!-- <th data-field="ColumnContrasenna" data-sortable="true">Contraseña</th>-->
<th data-field="ColumnMovil" data-sortable="true">Teléfono</th>
<th data-field="ColumnFecha" data-sortable="true">Fecha Nacimiento</th>
<th data-field="ColumnRol" data-sortable="true">Rol</th>
<th data-field="ColumnFundador" data-sortable="true">Fundador</th>
<th data-field="ColumnActivo" data-sortable="true">Activo</th>
<th data-field="ColumnFechaAlta" data-sortable="true">Fecha Alta</th>
<th data-field="ColumnFechaBaja" data-sortable="true">Fecha Baja</th>
</tr>
</thead><tbody>
	<%
		for(int i = 0;i<listado_socios.size();i++){
			Persona aux = listado_socios.get(i);
			%> <tr id="<%= Utilidades.getEmailByTableBootstrap(aux.getEmail()) %>">
				<td></td>
				<td class="columnEmail"><%= aux.getEmail() %></td> 
				<td class="columnNombre"><%= aux.getNombre() %></td>
        		<td class="columnApellidos"><%= aux.getApellidos() %></td>
        	<!-- 	<td class="columnContrasenna"><%= aux.getPass() %></td>-->
        		<td class="columnMovil"><%= aux.getTelefono() %></td>
        		<td class="columnFecha"><%= Utilidades.getFechaToJSP(aux.getFechaNacimiento()) %></td>
        		<td class="columnRol"><%= Utilidades.getValueRol(aux.getIdRol()) %></td>
        		<td class="columnFundador"><%= Utilidades.getValueBooleanSelectToJSP(aux.isFundador()) %></td>
        		<td class="columnActivo"><%= Utilidades.getValueBooleanSelectToJSP(aux.isActivo()) %></td>
        		<td class="columnFechaAlta"><%= Utilidades.getFechaToJSP(aux.getFechaAlta()) %></td>
        		<td class="columnFechaBaja"><%= Utilidades.getFechaToJSP(aux.getFechaBaja()) %></td>
        		</tr>
        <%
		}
	%>
</tbody></table>
    </div>
  </div>

<div class="row">
    <div class="containerEdit col-md-9" style="display: none;">
        <table id="tableEdit" class="table table-bordered" >
            <thead>
              <tr> 
             <th data-field="Email">Email</th>
             <!--  <th data-field="Nombre">Nombre</th> 
              <th data-field="Apellidos">Apellidos</th>
              <th data-field="Contrasenna">Contraseña</th>
              <th data-field="Movil">Movil</th>
              <th data-field="Fecha">Fecha Nacimiento</th>
              <th data-field="Rol">Rol</th>-->
              <th data-field="Fundador">Fundador</th>
              <th data-field="Activo">Activo</th>
              <th data-field="FechaAlta">Fecha Alta</th>
              </tr>
              <tr>
                <td><input type="text" class="form-control" id="editEmail" disabled/></td>
            <!--    <td><input type="text" class="form-control" id="editNombre" disabled/></td>
                <td><input type="text" class="form-control" id="editApellidos" disabled/></td>
               <td><input type="text" class="form-control" id="editContrasenna" disabled/></td>
                <td><input type="text" class="form-control" id="editMovil" disabled/></td>
                <td><input type="date" class="form-control" id="editFecha" disabled/></td>
                <td><input type="text" class="form-control" id="editRol" disabled/></td>-->
             <!--    <td><input type="text" class="form-control" id="editFundador"/></td>-->
                   <td><select class="form-control" id="editFundador">
     <% while (iterator.hasNext()){	
     	 Map.Entry<Boolean,String> entry = (Map.Entry<Boolean,String>) iterator.next();
     	 	if(p.isFundador() == entry.getKey()){
     	 		 %><option id="<%=entry.getKey() %>" selected><%=entry.getValue() %></option><%
     	 	}
     	 	else{
     	 		%><option id="<%=entry.getKey() %>"><%=entry.getValue() %></option><% 
     	 	}
     		
      }%>
     </select></td>
                <!-- <td><input type="text" class="form-control" id="editActivo" disabled/></td>-->
                 <td><select class="form-control" id="editActivo">
     <% 
     
     iterator = listadoBooleanos.entrySet().iterator();
     while (iterator.hasNext()){	
     	 Map.Entry<Boolean,String> entry = (Map.Entry<Boolean,String>) iterator.next();
     	 	if(p.isActivo() == entry.getKey()){
     	 		 %><option id="<%=entry.getKey() %>" selected><%=entry.getValue() %></option><%
     	 	}
     	 	else{
     	 		%><option id="<%=entry.getKey() %>"><%=entry.getValue() %></option><% 
     	 	}
     		
      }%>
     </select></td>
 <td><input  id="editFechaAlta" placeholder="AAAA/MM/DD" class="form-control"  type="date" value="<%= Utilidades.getFechaToJSP(p.getFechaAlta()) %>"></td>
     
 
              </tr>
            </thead>
        </table>
        <div id="toolbarEdit">
            <form method="post" action="ControllerSocios" id="actualizaSocios">
        	<input type="hidden" id="params" name="params" value="">
            <button id="button" class="btn btn-default" onclick="tratamientoFila('actualiza');">Actualiza</button>
            </form>
        </div>
</div>
</div>

  </div> 
    </div>
        <div id="results" class="row">
    <%
    String respuesta = (String)request.getAttribute(Constantes.RESPUESTA_ACCION);
    if(respuesta != null){
    	if(respuesta.equals(Constantes.RESPUESTA_OK_VALUE)){
    		%><label><%=Constantes.MSG_OK_UPDATE%></label><%
    	}
    	else{
    		%><label><%=Constantes.MSG_ERROR_UPDATE%></label><%
    	}
    }
    %>
    </div>
            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

       <!-- jQuery -->
    <script src="lib/jquery/jquery-3.1.0.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="lib/bootstrap/bootstrap.min.js"></script>
          
    <!-- Bootstrap Table JavaScript -->
<script type="text/javascript" src="js/util_bootstrap_table.js"></script>
<script type="text/javascript" src="lib/bootstraptable/dist/bootstrap-table.js"></script>
<script type="text/javascript" src="lib/bootstraptable/dist/locale/bootstrap-table-es-ES.js"></script>


    <!-- Morris Charts JavaScript -->
    <script src="lib/startbootstrap-sb-admin-gh-pages/js/plugins/morris/raphael.min.js"></script>
    <script src="lib/startbootstrap-sb-admin-gh-pages/js/plugins/morris/morris.min.js"></script>
    <script src="lib/startbootstrap-sb-admin-gh-pages/js/plugins/morris/morris-data.js"></script>
	<!-- Load NavBar Left -->
	<script src="lib/navbar_left.js"></script>
	<script>
	$(document).ready(function() {
	});
	</script>
</body>

</html>