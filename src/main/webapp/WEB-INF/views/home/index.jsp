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
    
   <!-- [/MAIN-HEADING]
 ============================================================================================================================--> 
   <section class="main-heading" id="Home">
       <div class="overlay">
           <div class="container">
               <div class="row">
                   <div class="main-heading-content col-md-12 col-sm-12 text-center">
        <h1 class="main-heading-title">We are Creative</h1>
        <p class="main-heading-text">Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore,<br/>cum soluta nobis est eligendi optio cumque nihil impedit quo facilis</p>
        <div class="btn-bar">
          <a href="#" class="btn btn-custom theme_background_color">Ge Started</a>
          <a href="#" class="btn btn-custom-outline">Contact Us</a>
        </div>
      </div>
               </div>
           </div>
       </div>  
      
   </section>
    
 <!-- [/MAIN-HEADING]
 ============================================================================================================================-->
 
 
 <!-- [ABOUT US]
 ============================================================================================================================-->
 <section class="aboutus white-background black" id="one">
     <div class="container">
         <div class="row">
             <div class="col-md-12 text-center black">
                 <h3 class="title">ABOUT <span class="themecolor">US</span></h3>
            <p class="a-slog">Lorem ipsum dolor sit amet ne onsectetuer adipiscing elit. Aenean commodo ligula eget dolor in tashin ty</p> 
             </div>
         </div>
         <div class="gap">
             
         </div>
         
         <div class="row about-box">
         <c:forEach items="${aboutUs}" var="about">
          <div class="col-sm-6 text-center">
            <div class="margin-bottom">
              <h4>${about.title }</h4>
              <p class="black">${about.details }</p>
            </div> <!-- / margin -->
          </div> <!-- /col -->
          </c:forEach>
        </div> <!-- /row -->
         
         
         
         
     </div>
 </section>
 
 
 <!-- [/ABOUTUS]
 ============================================================================================================================-->
 
 
 
 <!-- [RECENT-WORKS]
 ============================================================================================================================-->
     <section class="recent-works text-center" id="two">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
              <h3 class="title">Recent <span class="themecolor">Works</span></h3>
            <p class="a-slog">Lorem ipsum dolor sit amet ne onsectetuer adipiscing elit. Aenean commodo ligula eget dolor in tashin ty</p>
          </div> 
        </div>
          
          <div class="gap"></div>

        <div class="row">
          <div class="col-sm-4 port-item margin-bottom">
            <div class="item-img-wrap">
              <img src="images/work-1.jpg" class="img-responsive" alt="workimg">
              <div class="item-img-overlay">
                <a href="images/work-1.jpg" class="show-image">
                  <span></span>
                </a>
              </div>
            </div>
            <div class="work-desc">
              <h3><a href="#">Mockup Design</a></h3>
              <span>Photoshop</span>
            </div>
          </div> <!-- /portfolio-item -->

          <div class="col-sm-4 port-item margin-bottom">
            <div class="item-img-wrap">
              <img src="images/work-2.jpg" class="img-responsive" alt="workimg">
              <div class="item-img-overlay">
                <a href="images/work-2.jpg" class="show-image">
                  <span></span>
                </a>
              </div>
            </div>
            <div class="work-desc">
              <h3><a href="#">Graphic Design</a></h3>
              <span>Illustrator</span>
            </div>
          </div> <!-- /portfolio-item -->

          <div class="col-sm-4 port-item margin-bottom">
            <div class="item-img-wrap">
              <img src="images/work-3.jpg" class="img-responsive" alt="workimg">
              <div class="item-img-overlay">
                <a href="images/work-3.jpg" class="show-image">
                  <span></span>
                </a>
              </div>
            </div>
            <div class="work-desc">
              <h3><a href="#">Web Design</a></h3>
              <span>Html / Css</span>
            </div>
          </div> <!-- /portfolio-item -->
        </div> <!-- /row -->

        <div class="row">
          <div class="col-md-12 text-center">
            <a href="#" class="btn btn-custom theme_background_color">Load More</a>
          </div>
        </div> <!-- /row -->

      </div> <!-- /container -->
    </section>
    <!-- / Portfolio -->
 
 
 <!-- [/OUR-RECENT WORKS]
 ============================================================================================================================-->
 
  <!-- [OUR TEAM]
 ============================================================================================================================-->
  <section class="our-team white-background black" id="Team">
      <div class="container">
       <div class="row text-center">
          <div class="col-md-12">
              <h3 class="title">Creative <span class="themecolor">Team</span></h3>
           
        </div>
        <c:forEach items="${team}" var="team">
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

        <div class="row margin-top">
          <div class="col-md-12 text-center">
            <a href="#" class="btn btn-custom theme_background_color ">We are Hiring</a>
          </div> <!-- /col -->
        </div> <!-- /row -->
          
      </div>
  </section>
 
 <!-- [/OUR TEAM]
 ============================================================================================================================-->
 
 
 
 
 
 
 <!-- [/SERVICES]
 ============================================================================================================================-->
 
 
 <section class="services white-background black" id="seven">
      <div class="container">
        <div class="row text-center">
          <div class="col-md-12">
              <h3 class="title">We Are <span class="themecolor">Good In</span></h3>
            <p class="a-slog">Lorem ipsum dolor sit amet ne onsectetuer adipiscing elit. Aenean commodo ligula eget dolor in tashin ty</p>
          </div> <!-- /col -->
        </div> <!-- /row -->
        <div class="gap"></div>

        <div class="row">
          <div class="col-sm-4">
            <div class="nim-service margin-bottom">
              <i class="fa fa-diamond"></i>
              <div class="nim-service-detail">
                <h4>Strategy Solutions</h4>
                <p>Lorem ipsum dolor sit amet ne onsectetuer adipiscing elit. Aenean commodo ligula eget dolor in tashin ty dolor site amet ne onseceruter adipiscing</p>
              </div> <!-- /nim-service-detail -->
            </div> <!-- /nim-service margin-bottom -->
          </div> <!-- /col -->

          <div class="col-sm-4">
            <div class="nim-service margin-bottom">
              <i class="fa fa-tablet"></i>
              <div class="nim-service-detail">
                <h4>Digital Design</h4>
                <p>Lorem ipsum dolor sit amet ne onsectetuer adipiscing elit. Aenean commodo ligula eget dolor in tashin ty dolor site amet ne onseceruter adipiscing</p>
              </div> <!-- /nim-service-detail -->
            </div> <!-- /nim-service margin-bottom -->
          </div> <!-- /col -->

          <div class="col-sm-4">
            <div class="nim-service margin-bottom">
              <i class="fa fa-magic"></i>
              <div class="nim-service-detail">
                <h4>SEO</h4>
                <p>Lorem ipsum dolor sit amet ne onsectetuer adipiscing elit. Aenean commodo ligula eget dolor in tashin ty dolor site amet ne onseceruter adipiscing</p>
              </div> <!-- /nim-service-detail -->
            </div> <!-- /nim-service margin-bottom -->
          </div> <!-- /col -->       
        </div> <!-- end row -->

        <div class="row">
          <div class="col-sm-4">
            <div class="nim-service margin-bottom">
              <i class="fa fa-rocket"></i>
              <div class="nim-service-detail">
                <h4>Graphic Design</h4>
                <p>Lorem ipsum dolor sit amet ne onsectetuer adipiscing elit. Aenean commodo ligula eget dolor in tashin ty dolor site amet ne onseceruter adipiscing</p>
              </div> <!-- /nim-service-detail -->
            </div> <!-- /nim-service margin-bottom -->
          </div> <!-- /col -->

          <div class="col-sm-4">
            <div class="nim-service margin-bottom">
              <i class="fa fa-map-marker"></i>
              <div class="nim-service-detail">
                <h4>Analystics</h4>
                <p>Lorem ipsum dolor sit amet ne onsectetuer adipiscing elit. Aenean commodo ligula eget dolor in tashin ty dolor site amet ne onseceruter adipiscing</p>
              </div> <!-- /nim-service-detail -->
            </div> <!-- /nim-service margin-bottom -->
          </div> <!-- /col -->

          <div class="col-sm-4">
            <div class="nim-service margin-bottom">
              <i class="fa fa-paypal"></i>
              <div class="nim-service-detail">
                <h4>Dedicated Support</h4>
                <p>Lorem ipsum dolor sit amet ne onsectetuer adipiscing elit. Aenean commodo ligula eget dolor in tashin ty dolor site amet ne onseceruter adipiscing</p>
              </div> <!-- /nim-service-detail -->
            </div> <!-- /nim-service margin-bottom -->
          </div> <!-- /col -->         
        </div> <!-- end row -->

        <div class="row">
          <div class="col-sm-4">
            <div class="nim-service margin-bottom">
              <i class="fa fa-bar-chart-o"></i>
              <div class="nim-service-detail">
                <h4>Truly Multipurpose</h4>
                <p>Lorem ipsum dolor sit amet ne onsectetuer adipiscing elit. Aenean commodo ligula eget dolor in tashin ty dolor site amet ne onseceruter adipiscing</p>
              </div> <!-- /nim-service-detail -->
            </div> <!-- /nim-service margin-bottom -->
          </div> <!-- /col -->

          <div class="col-sm-4">
            <div class="nim-service margin-bottom">
              <i class="fa fa-delicious"></i>
              <div class="nim-service-detail">
                <h4>Unlimited Colors</h4>
                <p>We put a lot of effort in design, as it’s the most important ingredient of successful website.Sed ut perspiciatis unde omnis iste natus error sit.</p>
              </div> <!-- /nim-service-detail -->
            </div> <!-- /nim-service margin-bottom -->
          </div> <!-- /col -->

          <div class="col-sm-4">
            <div class="nim-service margin-bottom">
              <i class="fa fa-pencil-square"></i>
              <div class="nim-service-detail">
                <h4>Easy to customize</h4>
                <p>Lorem ipsum dolor sit amet ne onsectetuer adipiscing elit. Aenean commodo ligula eget dolor in tashin ty dolor site amet ne onseceruter adipiscing</p>
              </div> <!-- /nim-service-detail -->
            </div> <!-- /nim-service margin-bottom -->
          </div> <!-- /col -->                      
        </div> <!-- end row -->

      </div>  <!-- container -->
    </section>
 
 
 <!-- [/SERVICES]
 ============================================================================================================================-->
 
 
 <!-- [CONTACT]
 ============================================================================================================================-->
 <!--sub-form-->
<section class="sub-form text-center" id="eight">
  <div class="container">
    <div class="col-md-12">
        <h3 class="title">Subscribe to our <span class="themecolor"> News letter</span></h3>
            <p class="lead">Lorem ipsum dolor sit amet ne onsectetuer adipiscing elit. Aenean commodo ligula eget dolor in tashin ty</p>
    </div> 
    <div class="row">
        <div class="col-md-3 col-sm-3"></div>
      <div class="col-md-6 center-block col-sm-6 ">
        <form id="mc-form">
          <div class="input-group">
            <input type="email" class="form-control" placeholder="Email Address" required id="mc-email">
            <span class="input-group-btn">
            <button type="submit" class="btn btn-default">SUBSCRIBE <i class="fa fa-envelope"></i> </button>
            </span> </div>
          <label for="mc-email" id="mc-notification"></label>
        </form>
      </div>
    </div>
  </div>
</section>
<!--sub-form end--> 


 
 <!-- [/CONTACT]
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

 
 
 <!-- [/FOOTER]
 ============================================================================================================================-->
 
 
 
</div>
 

<!-- [ /WRAPPER ]
=============================================================================================================================-->

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
<script type="text/javascript">
   
 $(document).ready(function(){	
	 var images=$("#sliders").val();
	 var a=[];
	 images.split(",").forEach(function(i,index){
		 if(i!=null && i!==""){
			 a[index]={src:"resources/uploads/"+i};		 
		 } 
	 });
	 /* console.log(a); */
	 $("section.main-heading").vegas({
		delay: 2000,
	    slides:a,animation: 'kenburns'
	});
 }
 );
</script>

</html>