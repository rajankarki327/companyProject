<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=devidev-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>The Nim- Responsive Landing Page</title>
	
	<!-- [ FONT-AWESOME ICON ] 
        =========================================================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/home/library/font-awesome-4.3.0/css/font-awesome.min.css"/>"/>

	<!-- [ PLUGIN STYLESHEET ]
        =========================================================================================================================-->
	<link rel="shortcut icon" type="image/x-icon" href="<c:url value="/resources/home/images/icon.png"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/home/css/animate.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/home/css/owl.carousel.css"/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/home/css/owl.theme.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/home/css/magnific-popup.css"/>"/>
        <link rel ="stylesheet" type="text/css" href="<c:url value="/resources/home/library/vegas/vegas.min.css"/>"/>
	<!-- [ Boot STYLESHEET ]
        =========================================================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/home/library/bootstrap/css/bootstrap-theme.min.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/home/library/bootstrap/css/bootstrap.css"/>"/>
        <!-- [ DEFAULT STYLESHEET ] 
        =========================================================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/home/css/style.css"/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/home/css/responsive.css"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/home/css/color/rose.css"/>"/>
        
</head>
<body >
<!-- [ LOADERs ]
================================================================================================================================-->	
    <div class="preloader">
    <div class="loader theme_background_color">
        <span></span>
      
    </div>
</div>
<!-- [ /PRELOADER ]
=============================================================================================================================-->
<!-- [WRAPPER ]
=============================================================================================================================-->
<div class="wrapper">

 <!-- [NAV]
 ============================================================================================================================-->    
   <!-- Navigation
    ==========================================-->
    <nav  class=" nim-menu navbar navbar-default navbar-fixed-top">
      <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
            <a class="navbar-brand" href="index.html"><span class="themecolor">rk</span>technologies</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <c:forEach items="${nav}" var="nav">
          <ul class="nav navbar-nav navbar-right">    
            <li><a href="#nav_${nav.id}" class="page-scroll">${nav.navField }</a></li>
          </ul>
          </c:forEach>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container-fluid -->
    </nav>


   <!-- [/NAV]
 ============================================================================================================================--> 
    



<!-- [OUR TEAM]
 ============================================================================================================================-->
  <section class="our-team white-background black" id="Team">
      <div class="container">
       <div class="row text-center">
          <div class="col-md-12">
              <h3 class="title">Creative <span class="themecolor">Team</span></h3>
           
        </div>
        <c:forEach items="${teams}" var="team">
          <div class="row text-center">
          <div class="col-sm-3">
            <img src="<c:url value="/resources/uploads/${team.image }"/> " height="340px;" width="290px;" alt="team-member">
            <h4>${team.name }</h4>
            <h5>${team.post }</h5>
            <p>${team.details }</p>
            <ul class="list-inline top20">
              <li><a href="${team.fbURL}"><i class="fa fa-facebook"></i></a></li>
              <li><a href="${team.twitterURL }"><i class="fa fa-twitter"></i></a></li>
            </ul>
          </div> 
          </c:forEach>
        </div> 
  <c:url var="returnHome" value="/" ></c:url>

        <div class="row margin-top">
          <div class="col-md-12 text-center">
            <a href="${returnHome}" class="btn btn-custom theme_background_color ">Back home</a>
          </div> <!-- /col -->
        </div> <!-- /row -->
          
      </div>
  </section>
 
 <!-- [/OUR TEAM]
 ============================================================================================================================-->
 
 <!-- [FOOTER]
 ============================================================================================================================-->
 
<footer class="site-footer section-spacing text-center " id="eight">
    
  <div class="container">
    <div class="row">
      <div class="col-md-4">
        <p class="footer-links"><a href="#">Terms of Use</a> <a href="#">Privacy Policy</a></p>
      </div>
      <div class="col-md-4"> <small>&copy; 2015 Nim. All rights reserved.</small></div>
      <div class="col-md-4"> 
        <!--social-->
        
        <ul class="social">
          <li><a href="https://twitter.com/" target="_blank"><i class="fa fa-twitter "></i></a></li>
          <li><a href="https://www.facebook.com/" target="_blank"><i class="fa fa-facebook"></i></a></li>
          <li><a href="https://www.youtube.com/" target="_blank"><i class="fa fa-youtube-play"></i></a></li>
        </ul>
        
        <!--social end--> 
        
      </div>
    </div>
  </div>
</footer>
</div>

 
 
 <!-- [/FOOTER]
 ============================================================================================================================-->
 
 	<!-- [ DEFAULT SCRIPT ] -->
	<script src="<c:url value="/resources/home/library/modernizr.custom.97074.js"/>"/></script>
	<script src="<c:url value="/resources/home/library/jquery-1.11.3.min.js"/>"/></script>
        <script src="<c:url value="/resources/home/library/bootstrap/js/bootstrap.js"/>"/></script>
	<script type="text/javascript" src="<c:url value="/resources/homejs/jquery.easing.1.3.js"/>"/></script>	
	<!-- [ PLUGIN SCRIPT ] -->
      	<script src="<c:url value="/resources/home/js/plugins.js"/>"/></script>
        <!-- [ TYPING SCRIPT ] -->
         <script src="<c:url value="/resources/home/js/typed.js"/>"/></script>
         <!-- [ COUNT SCRIPT ] -->
         <script src="<c:url value="/resources/home/js/fappear.js"/>"/></script>
       <script src="<c:url value="/resources/home/js/jquery.countTo.js"/>"/></script>
	<!-- [ SLIDER SCRIPT ] -->  
        <script src="<c:url value="/resources/home/js/owl.carousel.js"/>"/></script>
         <script type="text/javascript" src="<c:url value="/resources/home/js/jquery.magnific-popup.min.js"/>"/></script>
        <script type="text/javascript" src="<c:url value="/resources/home/js/SmoothScroll.js"/>"/></script>
        
        <!-- [ COMMON SCRIPT ] -->
          <script src="<c:url value="/resources/home/library/vegas/vegas.min.js"/>"/></script>
	<script src="<c:url value="/resources/home/js/common.js"/>"/></script>
<%--     <c:set var="sliders" value="${slider}" />  --%>
    <input type="hidden" id="sliders" value="${slider}">
</body>
</html>
<script type="text/javascript">
 
 
 
 