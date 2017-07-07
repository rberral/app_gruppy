<%@page import="com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const"%>
<%@page import="java.util.Iterator"%>
<%@page import="util.MaestroDatos"%>
<%@page import="java.util.Map"%>
<%@page import="org.hibernate.engine.Cascade"%>
<%@page import="service.DesgloseService"%>
<%@page import="bean.DesgloseCuentas"%>
<%@page import="bean.DesgloseCuentasAdicional"%>
<%@page import="java.util.List"%>
<%@page import="dao.DesgloseCuentasDAO"%>
<%@page import="util.Utilidades"%>
<%@page import="util.Constantes"%>
<%@page import="bean.Asociacion"%>
<%@page import="bean.Persona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <!-- <meta charset="utf-8">-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Desglose Cuentas</title>

    <!-- Bootstrap Core CSS -->
    <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="lib/startbootstrap-sb-admin-gh-pages/css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="lib/startbootstrap-sb-admin-gh-pages/css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="lib/fonts/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">


    <!-- jQuery -->
    <script src="lib/jquery/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="lib/bootstrap/bootstrap.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="lib/startbootstrap-sb-admin-gh-pages/js/plugins/morris/raphael.min.js"></script>
    <script src="lib/startbootstrap-sb-admin-gh-pages/js/plugins/morris/morris.min.js"></script>
    <script src="lib/startbootstrap-sb-admin-gh-pages/js/plugins/morris/morris-data.js"></script>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Custom Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
       <!-- Theme bootstrap Table -->
   <link type="text/css" rel="stylesheet" href="lib/bootstraptable/dist/bootstrap-table.css"/>
   
</head>

<body>
<%
	Persona p = (Persona)request.getSession().getAttribute(Constantes.sessionUsuario);
	
	List<DesgloseCuentasAdicional> listaDesgloseAdicional = (List<DesgloseCuentasAdicional>) request.getAttribute("listaDesgloseAdicional");
	List<DesgloseCuentas> listaDesgloseCuotas = (List<DesgloseCuentas>) request.getAttribute("listadesgloseCuentas");
	int lv_size_cuotas_adicionales = (Integer)request.getAttribute("sizeInvitados");
	int lv_size_cuotas_invitados = (Integer)request.getAttribute("sizeOtros");
	int loadList = (Integer) request.getAttribute("loadList");
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
                <a class="navbar-brand" href="main.jsp">SB Admin</a>
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
            <!-- Sidebar NavBar Left -->
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
                                <i class="fa fa-dashboard"></i>  <a href="main.jsp">Principal</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-bar-chart-o"></i> Desglose Cuentas
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-comments fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge"><%= listaDesgloseCuotas.size() %></div>
                                        <div>Cuotas Mensuales</div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left"><a href="javascript:callDesgloseCuentas();">Ver detalles</a></span>
                                    <span class="pull-right"><i class="fa fa-balance-scale-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-green">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-tasks fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge"><%= lv_size_cuotas_adicionales %></div>
                                        <div>Cuotas Adicionales</div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left"><a href="javascript:callDesgloseCuentas(2);">Ver detalles</a></span>
                                    <span class="pull-right"><i class="fa fa-balance-legal-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-yellow">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-shopping-cart fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge"><%= lv_size_cuotas_invitados %></div>
                                        <div>Invitados</div>
                                    </div>
                                </div>
                            </div>
                            <a href="#">
                                <div class="panel-footer">
                                    <span class="pull-left"><a href="javascript:callDesgloseCuentas(1);">Ver detalles</a></span>
                                    <span class="pull-right"><i class="fa fa-child-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
                <!-- /.row -->
                
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title"><i class="fa fa-bar-chart-o fa-fw"></i>Detalles</h3>
                            </div>
                            <div class="panel-body">
   <%
   switch(loadList){
   case 0: // Cuotas Mensuales

  if(p.getIdRol() == Constantes.ROLE_TESORERO){
	%>
	<div id="toolbar" class="btn-group">
    <button type="button" class="btn btn-default" id="btnEditMensualidad">
        <i class="glyphicon glyphicon-pencil"></i>
    </button>
</div>
	<%
  }
  %>
<table data-toolbar="#toolbar" data-show-columns="true" data-unique-id="ColumnId" data-click-to-select="true" data-single-select="true" data-toggle="table" id="tablaDinamicaMensualidad" data-search="true" data-pagination="true">
<thead>
<tr> 
<th tabindex="0" data-field="ColumnState" data-checkbox="true"></th> 
<th data-field="ColumnId" data-sortable="true">Id</th>
<th data-field="ColumnUsuario" data-sortable="true">Usuario</th>
<th data-field="ColumnAnno" data-sortable="true">Año</th>
<th data-field="ColumnMensualidad" data-sortable="true">Mensualidad</th>
<th data-field="ColumnCoste" data-sortable="true">Coste</th> 
<th data-field="ColumnPagado" data-sortable="true">Pagado</th>
</tr>
</thead><tbody>
	<%
		for(int i = 0;i<listaDesgloseCuotas.size();i++){
			DesgloseCuentas aux = listaDesgloseCuotas.get(i);
			%> <tr id="<%= aux.getId().getMensualidad() %>">
				<td></td>
				<td class="columnId"><%= aux.getId().getIdPersona() %></td> 
				<td class="columnUsuario"><%= Utilidades.getNameSurname(aux.getId().getIdPersona()) %></td> 
				<td class="columnAnno"><%= aux.getId().getAnnoCuenta() %></td> 
				<td class="columnMensualidad"><%= Utilidades.getMes(aux.getId().getMensualidad()) %></td>
        		<td class="columnCoste"><%= aux.getCoste() %></td>
        		<td class="columnPagado"><%= Utilidades.getValueBooleanSelectToJSP(aux.isPagado()) %></td>
        		</tr>
        <%
		}
	%>
</tbody></table>        
<%
if(p.getIdRol() == Constantes.ROLE_TESORERO){
	%>
	        <div id="toolbarEdit">
            <form method="post" action="ControllerDesglose" id="actualizaPagosMensualidad">
        	<input type="hidden" id="params" name="params" value="">
            <button id="button" class="btn btn-default" onclick="tratamientoFilaPagos('actualizaPagosMensualidad');">Actualiza</button>
            </form>
        </div>
	<%
}
%>                       

   <%
   						break;	
                        default://caso para cuotas adicionales

   
   
                        	  if(p.getIdRol() == Constantes.ROLE_TESORERO){
                        			%>
                        			<div id="toolbar" class="btn-group">
                        		    <button type="button" class="btn btn-default" id="btnEditAdicional">
                        		        <i class="glyphicon glyphicon-pencil"></i>
                        		    </button>
                        		</div>
                        			<%
                        		  }
                        		  %>
   <table data-toolbar="#toolbar" data-show-columns="true" data-unique-id="ColumnId" data-click-to-select="true" data-single-select="true" data-toggle="table" id="tablaDinamicaAdicional" data-search="true" data-pagination="true">
<thead>
<tr> 
<th tabindex="0" data-field="ColumnState" data-checkbox="true"></th> 
<th data-field="ColumnId" data-sortable="true">Id</th>
<th data-field="ColumnUsuario" data-sortable="true">Usuario</th>
<th data-field="ColumnAnno" data-sortable="true">Año</th>
<th data-field="ColumnTipoCuota" data-sortable="true">Tipo Cuota</th>
<th data-field="ColumnCuota" data-sortable="true">Precio Cuota</th> 
<th data-field="ColumnPagado" data-sortable="true">Pagado</th>
</tr>
</thead><tbody>
	<%
		for(int i = 0;i<listaDesgloseAdicional.size();i++){
			DesgloseCuentasAdicional aux = listaDesgloseAdicional.get(i);
			if(aux.getTipoCuota()!= loadList){
				continue;
			}
			%> <tr id="<%= aux.getIdAdicional() %>">
				<td></td>
				<td class="columnId"><%= aux.getIdPersona() %></td> 
				<td class="columnUsuario"><%= Utilidades.getNameSurname(aux.getIdPersona()) %></td> 
				<td class="columnAnno"><%= aux.getAnnoCuenta() %></td> 
				<td class="columnTipoCuota"><%= Utilidades.getTipoCuota(aux.getTipoCuota()) %></td>
        		<td class="columnCuota"><%= aux.getCuotaAdicional() %></td>
        		<td class="columnPagado"><%= Utilidades.getValueBooleanSelectToJSP(aux.isPagado()) %></td>
        		</tr>
        <%
		}
	%>
</tbody></table>   
<%if(p.getIdRol() == Constantes.ROLE_TESORERO){
%>
           <div id="toolbarEdit">
            <form method="post" action="ControllerDesglose" id="actualizaPagosAdicional">
        	<input type="hidden" id="params" name="params" value="">
            <button id="button" class="btn btn-default" onclick="tratamientoFilaPagos('actualizaPagosAdicional');">Actualiza</button>
            </form>
        </div>
<%
}
%>

   	   
  <% 
  break;
  } 
  %>                              
                                </div>
<div class="row">
    <div class="containerEditPagosMensualidad col-md-9" style="display: none;">
        <table id="tableEditMensualidad" class="table table-bordered" >
            <thead>
              <tr> 
              <th data-field="Usuario">Usuario</th>
             <th data-field="Anno">Año</th>
             <th data-field="Mensualidad">Mensualidad</th> 
			<th data-field="Coste">Coste</th> 
			<th data-field="Pagado">Pagado</th> 
              </tr>
              <tr>
              <td><input type="text" class="form-control" id="editUsuario" disabled/></td>
                <td><input type="text" class="form-control" id="editAnno" disabled/></td>
              <td><input type="text" class="form-control" id="editMensualidad" disabled/></td>
                <td><input type="text" class="form-control" id="editCoste" disabled/></td>
                   	<td><select class="form-control" id="editPagado">
                    <% 
                    
                    iterator = listadoBooleanos.entrySet().iterator();
                    while (iterator.hasNext()){	
                    	 Map.Entry<Boolean,String> entry = (Map.Entry<Boolean,String>) iterator.next();
                    	 	//if(p.isPagado() == entry.getKey()){
                    	// 		 %><option id="<%=entry.getKey() %>" selected><%=entry.getValue() %></option><%
                    	// 	}
                    	// 	else{
                    	 		%><option id="<%=entry.getKey() %>"><%=entry.getValue() %></option><% 
                    	// 	}
                    		
                   }
                    %>
                    </select></td> 
              </tr>
            </thead>
        </table>
        <div id="toolbarEdit">
            <form method="post" action="ControllerDesglose" id="actualizaPagos">
        	<input type="hidden" id="params" name="params" value="">
            <button id="button" class="btn btn-default" onclick="tratamientoFila('actualizaPagos');">Actualiza</button>
            </form>
        </div>
</div>

<!-- TABLA ADICIONALES EDIT -->
    <div class="containerEditPagosAdicional col-md-9" style="display: none;">
        <table id="tableEditAdicional" class="table table-bordered" >
            <thead>
              <tr> 
              <th data-field="Id">Id</th>
              <th data-field="Usuario">Usuario</th>
             <th data-field="Anno">Año</th>
             <th data-field="Mensualidad">Mensualidad</th> 
			<th data-field="Coste">Coste</th> 
			<th data-field="Pagado">Pagado</th> 
              </tr>
              <tr>
              
              <td><input type="text" class="form-control" id="editId" disabled/></td>
              <td><input type="text" class="form-control" id="editUsuario" disabled/></td>
              <td><input type="text" class="form-control" id="editAnno" disabled/></td>
                <td><input type="text" class="form-control" id="editTipoCuota" disabled/></td>
              <td><input type="text" class="form-control" id="editCuota" disabled/></td>
                   	<td><select class="form-control" id="editPagado">
                    <% 
                    
                    iterator = listadoBooleanos.entrySet().iterator();
                    while (iterator.hasNext()){	
                    	 Map.Entry<Boolean,String> entry = (Map.Entry<Boolean,String>) iterator.next();
                    	 	//if(p.isPagado() == entry.getKey()){
                    	// 		 %><option id="<%=entry.getKey() %>" selected><%=entry.getValue() %></option><%
                    	// 	}
                    	// 	else{
                    	 		%><option id="<%=entry.getKey() %>"><%=entry.getValue() %></option><% 
                    	// 	}
                    		
                   }
                    %>
                    </select></td> 
              </tr>
            </thead>
        </table>
        <div id="toolbarEdit">
            <form method="post" action="ControllerDesglose" id="actualizaPagosAdicional">
        	<input type="hidden" id="params" name="params" value="">
            <button id="button" class="btn btn-default" onclick="tratamientoFila('actualizaPagosAdicional');">Actualiza</button>
            </form>
        </div>
</div>
</div>                                
                        </div>
                    </div>
                </div>
                <!-- /.row -->
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
        <div id="formDesgloseCuentas">
            <form method="post" action="ControllerDesglose" id="listadoDesgloseCuentas">
        	<input type="hidden" id="option" name="option" value="">
            </form>
        </div>
    </div>
    <!-- /#wrapper -->
           <!-- jQuery -->
    <script src="lib/jquery/jquery-3.1.0.js"></script>
    <!-- Bootstrap Table JavaScript -->
<script type="text/javascript" src="js/pagos.js"></script>
<script type="text/javascript" src="lib/bootstraptable/dist/bootstrap-table.js"></script>
<script type="text/javascript" src="lib/bootstraptable/dist/locale/bootstrap-table-es-ES.js"></script>
    
    <!-- NavBar Left -->
 <script src="lib/navbar_left.js"></script>
  	<!-- main.js -->
 <script src="js/main.js"></script>
</body>

</html>