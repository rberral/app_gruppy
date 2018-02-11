<%@page import="bean.TablonAnuncios"%>
<%@page import="java.util.List"%>
<%@page import="service.TablonService"%>
<%@page import="util.Constantes"%>
<%@page import="bean.Persona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <!--   <meta charset="utf-8">-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Tablón</title>

    <!-- Bootstrap Core CSS -->
    <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="lib/startbootstrap-sb-admin-gh-pages/css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="lib/startbootstrap-sb-admin-gh-pages/css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="lib/fonts/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- Main CSS -->
    <link href="lib/main.css" rel="stylesheet">
    
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

</head>

<body>
<%
	Persona p = (Persona)request.getSession().getAttribute("user");
	TablonService tablonS = new TablonService();
	List<TablonAnuncios> listaAnuncios = tablonS.listAnuncios();
	List<TablonAnuncios> listaMisAnuncios = tablonS.listAnunciosPersona(p.getEmail());
	
	
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
            <!-- Sidebar Navbar Left -->
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
                            Tablón
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="main.jsp">Principal</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-bar-chart-o"></i> Tablón
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->


<div class="row col-sm-8 col-md-8 scroll_anuncio" style="margin-right: 15px;">
<div class="form-group">
<form method="post" action="ControllerTablon" id="publishCommentForm">
<!-- Title -->
<div class="form-group row">
  <label class="col-md-4 control-label">Asunto</label>  
  <div class="col-md-8 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-text-color"></i></span>
  <input  name="asunto" placeholder="Asunto" class="form-control"  type="text">
    </div>
  </div>
</div>
<!-- Text area -->
<div class="form-group row">
  <label class="col-md-4 control-label">Descripción</label>
    <div class="col-md-8 inputGroupContainer">
    <div class="input-group">
        <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
            <textarea class="form-control" name="descripcion" placeholder="Descripción"></textarea>
  </div>
  </div>
</div>
<div class="form-group row">
    <button type="button" class="btn btn-warning" onclick="checkFrmPublish();">Publicar <span class="glyphicon glyphicon-send"></span></button>
</div>
</form>
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




  <div class="row">
    <div class="thumbnail" style="border: #ddd0;">
    <%
	if(listaAnuncios.isEmpty()){
		%><div class="caption" id="box_tablon"><h3>Publica tu primer anuncio! :)</h3></div><%
	}
    	for(int i=0;i<listaAnuncios.size();i++){
    		%>
    		 <div class="caption" id="box_tablon">
    		 <h3><%= listaAnuncios.get(i).getAsunto() %></h3>
    		 <h4><b><i>Publicado por: <%= listaAnuncios.get(i).getEmailPersona() %></i></b></h4>
    		<p><%= listaAnuncios.get(i).getDescripcion() %>
      		</div>
    		<%   	
    	}
    		%>
    </div>
</div>
</div>

<div class="row col-sm-4 col-md-4 scroll_anuncio">
  <h1>Mis Anuncios</h1>
  <div class="row">
    <div class="thumbnail" style="border: #ddd0;">
    <%
    	if(listaMisAnuncios.isEmpty()){
    		%><div class="caption" id="box_tablon"><h3>¡Publica tu primer anuncio! :)</h3></div><%
    	}
    	for(int i=0;i<listaMisAnuncios.size();i++){
    		%>
    		 <div class="caption" id="box_tablon">
    		 <h3><%= listaMisAnuncios.get(i).getAsunto() %></h3>
    		<p><%= listaMisAnuncios.get(i).getDescripcion() %>
      		</div>
    		<%    		
    	}
    		%>
    </div>
</div>
</div>
		
            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
    <!-- Navbar Left -->
 <script src="lib/navbar_left.js"></script>
 	<!-- main.js -->
 <script src="js/main.js"></script> 
</body>

</html>