

var imported = document.createElement('script');
imported.src = 'js/notiflix-aio-2.1.3.js';
document.head.appendChild(imported);


var imported1 = document.createElement('script');
imported1.src = 'js/notiflix-aio-2.1.3.min.js';
document.head.appendChild(imported);


function registerForm() {

	const form = document.getElementById("regForm");
	
	//parse from data into json
	var formArray = objectifyForm(form);
	var jsonData = JSON.stringify(formArray);

	//ajax object
	var xhttp = new XMLHttpRequest();
	//rest call	
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			if(xhttp.responseText == "Register Successsful"){
//				sessionStorage.setItem("fundloginTokan",getCookie("fundloginTokan"));
//				sessionStorage.setItem("userId",getCookie("userId"));
//				sessionStorage.setItem("groupId",getCookie("groupId"));
				
				Notiflix.Notify.Success(xhttp.responseText);
				
				//window.location.href = "dashboard.html";
			}else{
				Notiflix.Notify.Failure(xhttp.responseText);
			}
		}
	};
	//rest url method	
	xhttp.open('POST', '/FundManagement/fund/loginRegister/register',  true);
	xhttp.send(jsonData);
     
}

//function to covert from data into array
function objectifyForm(formArray) {
	var returnArray = {};
	
	for (var i = 0; i < formArray.length; i++){
		returnArray[formArray[i]['name']] = formArray[i]['value'];
	}
		return returnArray;
}


function getCookie(cname) {
	var name = cname + "=";
	var ca = document.cookie.split(';');
	for(var i = 0; i < ca.length; i++) {
	  var c = ca[i];
	  while (c.charAt(0) == ' ') {
		c = c.substring(1);
	  }
	  if (c.indexOf(name) == 0) {
		return c.substring(name.length, c.length);
	  }
	}
	return "";
  }


