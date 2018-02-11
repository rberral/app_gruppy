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

    <title>Asociaci�n</title>

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
</head>

<body>
<%
	Persona p = (Persona)request.getSession().getAttribute(Constantes.sessionUsuario);
	Asociacion a = (Asociacion) request.getAttribute("asociacion");
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
                            Asociaci�n <small>Datos Generales</small>
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="main.jsp">Principal</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-bar-chart-o"></i> Asociaci�n
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

<form class="col-md-8 col-md-offset-2" method="post" action="ControllerAsociacion" id="updateAsociacionForm">
<div class="form-group row">
  <!-- <label for="example-text-input" class="col-2 col-form-label">Asociaci�n</label>
  <div class="col-10">
    <input class="form-control" type="text" value="EL Beso de Judas" id="example-text-input">
  </div>
  -->
  <label class="col-md-4 control-label">Asociaci�n (*)</label>  
  <div class="col-md-4 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
  <input  name="name_asoc" placeholder="Nombre Asociaci�n" class="form-control"  type="text" value="<%= a.getNombre() %>">
     </div>
  </div>  
</div>

<div class="form-group row">
 <!--  <label for="example-text-input" class="col-2 col-form-label">Descripci�n</label>
  <div class="col-10">
    <input class="form-control" type="text" value="Asociaci�n cultural" id="example-text-input">
  </div>-->
    <label class="col-md-4 control-label">Descripci�n (*)</label>  
  <div class="col-md-4 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-pencil"></i></span>
  <input  name="descripcion_asoc" placeholder="Descripci�n" class="form-control"  type="text" value="<%= a.getDescripcion() %>">
     </div>
  </div>
</div>


<div class="form-group row">
<!--   <label for="example-text-input" class="col-2 col-form-label glyphicon glyphicon-home">Direcci�n</label>
  <div class="col-10">
    <input class="form-control" type="text" value="Calle Aguilar, s/n" id="example-text-input">
  </div>-->
  <label class="col-md-4 control-label">Direcci�n (*)</label>  
  <div class="col-md-4 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-tags"></i></span>
  <input  name="direccion_asoc" placeholder="Direcci�n" class="form-control"  type="text" value="<%= a.getDireccion() %>">
     </div>
  </div>  
</div>


<div class="form-group row">
 <!--  <label for="example-email-input" class="col-2 col-form-label glyphicon glyphicon-envelope">Email</label>
  <div class="col-10">
    <input class="form-control" type="email" value="elbeso@example.com" id="example-email-input">
  </div>-->
  <label class="col-md-4 control-label">Email</label>  
  <div class="col-md-4 inputGroupContainer">
  <div class="input-group">
<!--  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>-->
	<span class="input-group-addon">@</span>
  <input  name="email_asoc" placeholder="Email" class="form-control"  type="text" value="<%= a.getEmail() %>">
     </div>
  </div>  
</div>

<div class="form-group row">
<!--   <label for="example-tel-input" class="col-2 col-form-label glyphicon glyphicon-earphone">Tel�fono</label>
  <div class="col-10">
    <input class="form-control" type="tel" value="1-(555)-555-5555" id="example-tel-input">
  </div>-->
  <label class="col-md-4 control-label">Tel�fono</label>  
  <div class="col-md-4 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-phone-alt"></i></span>
  <input  name="telefono_asoc" placeholder="Tel�fono" class="form-control"  type="text" value="<%= a.getTelefono() %>">
     </div>
  </div>  
</div>

<div class="form-group row">
  <!-- <label for="example-date-input" class="col-2 col-form-label">Fecha Fundaci�n</label>
  <div class="col-10">
    <input class="form-control" type="date" value="2011-08-19" id="example-date-input">
  </div>-->
  <label class="col-md-4 control-label">Fecha Fundaci�n (*)</label>  
  <div class="col-md-4 inputGroupContainer">
  <div class="input-group">
  <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
  <input  name="fecha_fundacion_asoc" placeholder="AAAA/MM/DD" class="form-control"  type="datetime" value="<%= Utilidades.getFechaToJSP(a.getFechaFundacion()) %>">
     </div>
  </div>  
</div>


  <button type="button" class="btn btn-primary" onclick="checkFrmAsociacion();">Submit</button>
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
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
    <!-- NavBar Left -->
 <script src="lib/navbar_left.js"></script>
  	<!-- main.js -->
 <script src="js/main.js"></script>
</body>

</html>