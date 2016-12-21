var directionsDisplay;
		var directionsService;
		 var myLocation;
		 var map;
		 var marker;
		function initMap() {
			  myLocation = {lat: 27.7116669, lng: 85.3229963};
		      map = new google.maps.Map(document.getElementById('map'), {
		          zoom: 18,
		          center: myLocation
		        });
			directionsDisplay = new google.maps.DirectionsRenderer;
			directionsService = new google.maps.DirectionsService;
			directionsDisplay.setMap(map);
			 marker = new google.maps.Marker({
		          position: myLocation,
		          map: map,
		          title: 'Hello World!'
		        });
			getLocation();
		}

		function getLocation() {
			if (navigator.geolocation) {
				return navigator.geolocation
						.getCurrentPosition(calculateAndDisplayRoute);
			} else {
				
				x.innerHTML = "Geolocation is not supported by this browser.";
			}
		}

		function calculateAndDisplayRoute(position) {
			var orgLang;
			var orgLat;
			if (position.coords != undefined) {
				orgLat = position.coords.latitude;
				orgLang = position.coords.longitude;
			}
			if (orgLang && orgLat) {
				marker.setMap(null);
				directionsService.route({
					origin : {
						lat : orgLat,
						lng : orgLang
					},
					destination : {
						lat : 27.7116669,
						lng : 85.3229963
					},
					travelMode :'DRIVING'
				}, function(response, status) {
					if (status == 'OK') {
						directionsDisplay.setDirections(response);
					} else {
						window.alert('Directions request failed due to '
								+ status);
					}
				});
			}
		}