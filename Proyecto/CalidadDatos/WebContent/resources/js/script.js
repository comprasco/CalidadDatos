var screenWidth, screenHeight;
var snr_logo_footer, footer_container, hamburguer_Icon_Line, hamburguer_Icon, usuario_mobile_cont, wrapper_usuario, wrapper_menu_izq, listas_menu_out;
var pequeno_grande_1024, usuario, footer_outer, footer_middle, listas_menu_cont, wrapper_flujo_solicitudes, certificados_mobile_cont, certificado, hide_menu;
var right_big_container, wrapper_content_container, sidebar, hamburguer_usuario_cont, snr_header_out, container_hideLogos;

$(document).ready(function() {
  	createVars(); // cache de variables
  	resize();
    setListeners();  	
});



//FUNCION PARA LA CREACION DE LAS VARIABLES
function createVars(){
	snr_logo_footer = $("#snr_logo_footer");
	footer_container = $("#footer_container");
	hamburguer_Icon_Line = $(".hamburguer_Icon_Line");
	hamburguer_Icon = $("#hamburguer_Icon");
	usuario_mobile_cont = $("#usuario_mobile_cont");
	wrapper_usuario = $("#wrapper_usuario");
	wrapper_menu_izq = $("#wrapper_menu_izq");
	wrapper_flujo_solicitudes = $("#wrapper_menu_solicitudes_pago_mobile");
	listas_menu_out = $("#listas_menu_out");
	pequeno_grande_1024 = $(".pequeno_grande_1024");
	usuario = $("#usuario");
	footer_outer = $("#footer_outer");
	footer_middle = $("#footer_middle");
	listas_menu_cont = $("#listas_menu_cont");
  certificados_mobile_cont = $("#usuario_pedidos_mobile");
  certificado = $("#certificado");
  hide_menu = $("#hide_menu");	
  right_big_container = $("#right_big_container");
  wrapper_content_container = $("#wrapper_content_container");
  sidebar = $("#sidebar");
  hamburguer_usuario_cont = $("#hamburguer_usuario_cont");
  snr_header_out = $("#snr_header_out");
  container_hideLogos = $("#container_hideLogos");
}

//FUNCION RESIZE PARA EL CAMBIO DE PANTALLA
window.onorientationchange = resize;
$(window).resize(function() {
  resize();
});


function resize(){
	screenWidth = $(window).width();
  	screenHeight = $(window).height();

  	$(".section").each(function(){
	    if(screenWidth>1024){
	      $(this).height(screenHeight-111);
	    }else{
	      if($(this).hasClass("fullHeightMobile")){
	        $(this).height(screenHeight);
	      }else{
	        $(this).height("auto");
	      }
	    }
  	});


    //Calcula la altura para el menu izquierdo
    if (screenWidth > 1350) {
      var alturaMenu1350 = screenHeight - snr_header_out.height() - 40;

      sidebar.css({"max-height": alturaMenu1350}); 

    }else if(screenWidth > 992 && screenWidth < 1350){
      var alturaMenu992 = screenHeight - container_hideLogos.height() - 40;

      sidebar.css({"max-height": alturaMenu992});

    }else{
      var alturaMenu = screenHeight - hamburguer_usuario_cont.height();

      sidebar.css({"max-height": alturaMenu});
    }


  	//Calcula los margenes para centrar el logo del footer para mas de 992px
  	if (screenWidth > 992) {
  	 		snr_logo_footer.css({"margin-top": valor_margen});	
  	}else{
  		//snr_logo_footer.css({"margin": "20px 0px"});
  	}
  	

  	//Calcula la altura para el contenedor invsible que cierra los menus
  	listas_menu_out.height(screenHeight);

  	//Agrega la clase box-grande para algunas opciones cuando es mayor a 1024px
  	if (screenWidth > 992) {
  		pequeno_grande_1024.removeClass("opciones_box_pequeño");
  		pequeno_grande_1024.addClass("opciones_box_grande");  			
  	}else{
  		pequeno_grande_1024.addClass("opciones_box_pequeño");
  		pequeno_grande_1024.removeClass("opciones_box_grande");
  	}

  	//Agrega la clase collapsed al menu de usuario para mas de 992px
  	if (screenWidth > 992) {
  		usuario.addClass("collapse");
      certificado.addClass("collapse");
  	}else{
  		usuario.removeClass("collapse");
      certificado.removeClass("collapse");
  	}

  	//Agrega la clase outer y middle al footer para mas de 992px
  	if (screenWidth > 992) {
  		footer_outer.addClass("outer");
  		footer_middle.addClass("middle");
  	}else{
  		footer_outer.removeClass("outer");
  		footer_middle.removeClass("middle");
  	}

  	//Vuelve a fixed la posicion de los menus para menos de 992
  	if (screenWidth < 992) {
  		wrapper_menu_izq.css({"position": "fixed", "top": "-100%"});
  		wrapper_usuario.css({"position": "fixed", "top": "-30%"});
      wrapper_flujo_solicitudes.css({"position": "fixed", "top": "-100%"});
  	}else{
//  		wrapper_menu_izq.css("position", "absolute");
  		wrapper_usuario.css("position", "absolute");
      wrapper_flujo_solicitudes.css("position", "absolute");
  	}

  	menusFixed();
  	
}


// FUNCION PARA TODO LOS LISTENERS
function setListeners(){

  hamburguer_Icon.on("click",function(){
    HamburguerOpen();
  });

  usuario_mobile_cont.click(function(){
  	userOpen();
  })

  certificados_mobile_cont.click(function(){
    flujoSolicitudesOpen();
  })

  hide_menu.click(function(){
    menuLeftOpen();
  })

  listas_menu_out.on("click", function(){
  	closeMenu();
  	userClose();
  	listas_menu_out.css("display", "none");
  })

}

// WINDOW ON SCROLL

window.onscroll = function(){

  //menusFixed();
}



//FUNCIONES QUE PERMITEN ABRIR Y CERRAR EL MENU HAMBURGUESA
function HamburguerOpen(){
  
    var menuDisplay = wrapper_menu_izq.css("display");    

    if( menuDisplay == "none"){
    	listas_menu_out.css("display", "block");
    	userClose();
      flujoSolicitudesClose();
      wrapper_menu_izq.css("display", "block");
      wrapper_menu_izq.clearQueue().animate({"top": 60}, 500, function(){});
      hamburguer_Icon_Line.addClass('open');
    }
    else {      
      closeMenu();  
    }    
}

function closeMenu(){  

  wrapper_menu_izq.clearQueue().animate({"top": "-80%"}, 500, function(){
    wrapper_menu_izq.css("display", "none");
    closeAllMenus();
  });  
    hamburguer_Icon_Line.removeClass('open');
}



//FUNCIONES PARA ABRIR Y CERRAR EL MENU DE USUARIO
function userOpen(){

	var usuarioDisplay = wrapper_usuario.css("display");

	if( usuarioDisplay == "none"){
		listas_menu_out.css("display", "block");
		closeMenu();
    flujoSolicitudesClose();
		wrapper_usuario.css("display", "block");
		wrapper_usuario.clearQueue().animate({"top": 60}, 500, function(){});
	}
	else{
		userClose();
	}

}

function userClose(){

	wrapper_usuario.clearQueue().animate({"top": "-30%"}, 500, function(){
    	wrapper_usuario.css("display", "none");
    	closeAllMenus();
  	});  

}



//FUNCIONES PARA ABRIR Y CERRAR EL MENU DE CERTIFICADOS
function flujoSolicitudesOpen(){

  var usuarioDisplay = wrapper_flujo_solicitudes.css("display");

  if( usuarioDisplay == "none"){
    listas_menu_out.css("display", "block");
    closeMenu();
    userClose();
    wrapper_flujo_solicitudes.css("display", "block");
    wrapper_flujo_solicitudes.clearQueue().animate({"top": 60}, 500, function(){});
  }
  else{
    flujoSolicitudesClose();
  }

}

function flujoSolicitudesClose(){

  wrapper_flujo_solicitudes.clearQueue().animate({"top": "-100%"}, 500, function(){
      wrapper_flujo_solicitudes.css("display", "none");
      closeAllMenus();
    });  

}

//FUNCION PARA CERRAR LOS MENUS SI HAY UN CLICK POR FUERA
function closeAllMenus(){
	var usuarioDisplay = wrapper_usuario.css("display");
	var menuDisplay = wrapper_menu_izq.css("display"); 

	if (usuarioDisplay == "none" && menuDisplay == "none") {
		listas_menu_out.css("display", "none");
	}  
}

//FUNCION PARA QUE LOS MENUS SE VUELVAN FIXED DESPUES DE CIERTO SCROLL
function menusFixed(){
  var scrollPosY = window.pageYOffset | document.body.scrollTop;
  if (screenWidth > 992) {
  	if(scrollPosY > 150){

  		listas_menu_cont.addClass("listasFix");
      
    } 
    else {

    	listas_menu_cont.removeClass("listasFix");      
    }  	

  }  

}


//FUNCIONES PARA MOSTRAR Y ESCONDER EL MENU DE LA IZQUIERDA
function menuLeftOpen(){

  var menuDisplay = wrapper_menu_izq.width();

  if( menuDisplay == 0){
    wrapper_content_container.removeClass("closed");
  }
  else{
    menuLeftClosed();
  }

}

function menuLeftClosed(){

  wrapper_content_container.addClass("closed");

}

