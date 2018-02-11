<%@page import="java.util.Date"%>
<%@page import="bean.Invitado"%>
<%@page import="service.InvitadoService"%>
<%@page import="java.util.Map"%>
<%@page import="util.Utilidades"%>
<%@page import="util.Constantes"%>
<%@page import="java.util.List"%>
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


<title>Invitados</title>
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
	InvitadoService invitadoS = new InvitadoService();
	List<Invitado> listado_invitados = invitadoS.listInvitadosPendientes(p);
	List<Invitado> listado_invitados_confirmados = invitadoS.listInvitadosConfirmados(p, null, null);
	
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
                <a class="navbar-brand" href="">SB Admin</a>
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
                            Invitados
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="main.jsp"> Principal</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-bar-chart-o"></i> Invitados
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
  <div class="col-md-offset-5"><h3>Invitados pendientes</h3></div>
	<div id="toolbar" class="btn-group">
    <button type="button" class="btn btn-default" id="btnAdd">
        <i class="glyphicon glyphicon-plus"></i>
    </button>	
    <button type="button" class="btn btn-default" id="btnEdit">
        <i class="glyphicon glyphicon-pencil"></i>
    </button>
    <button type="button" class="btn btn-default" id="btnRemove">
        <i class="glyphicon glyphicon-trash"></i>
    </button>
</div>

<table data-toolbar="#toolbar" data-show-columns="true" data-unique-id="ColumnId" data-click-to-select="true" data-single-select="true" data-toggle="table" id="tablaDinamica" data-search="true" data-pagination="true">
<thead>
<tr> 
<th tabindex="0" data-field="ColumnState" data-checkbox="true"></th> 
<th data-field="ColumnId" data-sortable="true" disabled>Identificador</th>
<th data-field="ColumnNombre" data-sortable="true">Nombre</th>
<th data-field="ColumnFecha" data-sortable="true">Fecha</th>
<th data-field="ColumnObservaciones" data-sortable="true">Observaciones</th>
</tr>
</thead><tbody>
	<%
		for(int i = 0;i<listado_invitados.size();i++){
			Invitado aux = listado_invitados.get(i);
			%> <tr>
				<td></td>
				<td class="columnId" id="<%= aux.getIdInvitado() %>" disabled><%= aux.getIdInvitado() %></td>
				<td class="columnNombre"><%= aux.getNombreInvitado() %></td>
        		<td class="columnFecha"><%= Utilidades.getFechaToJSP(aux.getFechaInvitacion()) %></td>
        		<td class="columnObservaciones"><%= aux.getObservaciones() %></td>
        		</tr>
        <%
		}
	%>
</tbody></table>
    </div>
  </div>

<div class="row">
    <div class="containerAdd col-md-9" style="display: none;">
        <table id="tableAdd" class="table table-bordered">
            <thead>
              <tr> 
              <% int identificador = 1;
              	if(!listado_invitados.isEmpty()){
              		identificador = listado_invitados.get(listado_invitados.size()-1).getIdInvitado();
              	}
              %>
              <th data-field="Id" data-sortable="true">Identificador</th>
              <th data-field="Nombre" data-sortable="true">Nombre</th>
              <th data-field="Fecha" data-sortable="true">Fecha</th> 
              <th data-field="Observaciones" data-sortable="true">Observaciones</th>
              </tr>
              <tr>
                <td><input type="text" class="form-control" id="addId" value="<%= identificador %>" readonly/></td>
                <td><input type="text" class="form-control" id="addNombre"/></td>
                <td><input type="date" class="form-control" id="addFecha" type="date" value="<%= Utilidades.getFechaActualToJSP() %>"/></td> 
                <td><input type="text" class="form-control" id="addObservaciones"/></td>
              </tr>
            </thead>
        </table>
        <div id="toolbarAdd">
            <button id="button" class="btn btn-default" onclick="tratamientoFila('alta');">Insertar</button>
        </div>

</div>

    <div class="containerEdit col-md-9" style="display: none;">
        <table id="tableEdit" class="table table-bordered" >
            <thead>
              <tr> 
              <th data-field="Id">Identificador</th> 
              <th data-field="Nombre">Nombre</th> 
              <th data-field="Fecha">Fecha</th>
              <th data-field="Observaciones">Observaciones</th>
              </tr>
              <tr>
              <td><input type="text" class="form-control" id="editId"/></td>
             <td><input type="text" class="form-control" id="editNombre"/></td>
 			 <td><input type="datetime" class="form-control" maxlength="10" id="editFecha"/></td>
              <td><input type="text" class="form-control" id="editObservaciones"/></td> 
              </tr>
            </thead>
        </table>
        <div id="toolbarEdit">
            <form method="post" action="ControllerInvitados" id="actualizaInvitados">
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
        <div class="row">



<%
	if(listado_invitados_confirmados.isEmpty()){
		%><div class="caption"><h3>No has realizado invitaciones en este año, anímate! :)</h3></div><%
	}
	else{
		%>
		  <div class="col-md-9">
		  <div class="col-md-offset-5"><h3>Invitados confirmados</h3></div>
<table data-show-columns="true" data-unique-id="ColumnId" data-click-to-select="true" data-single-select="true" data-toggle="table" data-search="true" data-pagination="true">
<thead>
<tr> 
<th data-field="ColumnId" data-sortable="true" disabled>Identificador</th>
<th data-field="ColumnNombre" data-sortable="true">Nombre</th>
<th data-field="ColumnFecha" data-sortable="true">Fecha</th>
<th data-field="ColumnObservaciones" data-sortable="true">Observaciones</th>
</tr>
</thead><tbody>
	<%
		for(int i = 0;i<listado_invitados_confirmados.size();i++){
			Invitado aux = listado_invitados_confirmados.get(i);
			%> <tr>
				<td class="columnId" id="<%= aux.getIdInvitado() %>" disabled><%= aux.getIdInvitado() %></td>
				<td class="columnNombre"><%= aux.getNombreInvitado() %></td>
        		<td class="columnFecha"><%= Utilidades.getFechaToJSP(aux.getFechaInvitacion()) %></td>
        		<td class="columnObservaciones"><%= aux.getObservaciones() %></td>
        		</tr>
        <%
		}
	%>
</tbody></table>
    </div>		
		<%
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
<script type="text/javascript" src="js/invitados.js"></script>
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