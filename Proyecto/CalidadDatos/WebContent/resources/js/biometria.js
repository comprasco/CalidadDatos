var sfa_connection_calidad = null;
const URL_WS_SECOND_FACTOR_AUTH = 'ws://localhost:1104'
	
function connect(tramaOperacion) {
	let trama = tramaOperacion;
	
	// Verificar si la conexion esta abierta o asignada
	if (sfa_connection_calidad == null) {
		console.log('biometria-js:connect: Coneccion no asignada aun');
	}
	else { // Asignada
		// Codigo de estado,  Razon de cierre
		sfa_connection_calidad.close(3001, "Inicio de petición"); 
		sfa_connection_calidad = null;
	}
	
	//Establece una coneccion
	sfa_connection_calidad = new WebSocket(URL_WS_SECOND_FACTOR_AUTH);

	//Agrega listeners necesarios
	sfa_connection_calidad.onopen = function (event) { // Conexion establecida
		
		console.log("biometria-js:connect:onopen: WebSocket abierto", event);
		console.log('biometria-js:connect:onopen: Enviando peticion de operacion');
		sfa_connection_calidad.send(trama); // <-- Enviar la peticion de la operacion
	}
	
	
	sfa_connection_calidad.onmessage = function (message) { // Que hacer con la respuesta de una peticion
		
		console.log('biometria-js:connect:onmessage: Se recibio una respuesta a la peticion:', message);
		let response = JSON.parse(message.data);
		
		if (response.event === 'verify') { // respuesta de una operación verify
			if (response.response === 'success') {
				
				console.log('biometria-js:connect:onmessage: Se valido exitosamente la peticion');
				eventFire(document.getElementById('formInconsistencias:btnValidarUser1'), 'click');

			} else {
				console.log('biometria-js:connect:onmessage: Error en validacion de la peticion');
			}
		} 
		// Codigo de estado, Razon de cierre
		sfa_connection_calidad.close(3002, 'Fin operación');
	}

	sfa_connection_calidad.onclose = (event) => { // Que hacer cuando el servidor cierre la conexión
		
		console.log('biometria-js:connect:onclose: Conexion cerrada por el servidor, con codigo: ' + event.code, event);
	}
}

function eventFire(el, etype){
	if (el.fireEvent) {
		el.fireEvent('on' + etype);
	} else {
		let evObj = document.createEvent('Events');
		evObj.initEvent(etype, true, false);
		el.dispatchEvent(evObj);
	}
}

function me()
{
	let el = document.getElementById("btnValidarUser1");
	el.addEventListener("click");
	console.log('Texto de prueba biometria funcion.');

}
