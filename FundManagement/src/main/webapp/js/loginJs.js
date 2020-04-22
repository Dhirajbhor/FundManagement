//added notiflix files in page
var imported = document.createElement('script');
imported.src = 'js/notiflix-aio-2.1.3.js';
document.head.appendChild(imported);


var imported1 = document.createElement('script');
imported1.src = 'js/notiflix-aio-2.1.3.min.js';
document.head.appendChild(imported);

var imported1 = document.createElement('script');
imported1.src = 'js/validator.js';
document.head.appendChild(imported);

var imported1 = document.createElement('script');
imported1.src = 'js/ToolsJs.js';
document.head.appendChild(imported);


function logIn(){
	
    var form = document.getElementById('loginForm');
	var formArray = objectifyForm(form);	
	var jsonData = JSON.stringify(formArray);


    var xhttp = new XMLHttpRequest();
		
		//rest call	
		//when ajax is ready to send call or get response
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				
				// parse json response in js object
				var response = JSON.parse(xhttp.responseText);
				var message = response.message;
				
				//check response if successful then rediret
				if(message == "Login Successsful"){
					

					//parse data from json object
					var tokan = response.tokan;
					var groupName = response.groupName;
					var groupId = response.groupId;
					var userId = response.userId;
					var groupAmount = response.groupAmount;
					console.log(groupAmount);

					//store session,useful data for next/future page 
					sessionStorage.setItem("tokan",tokan);
					sessionStorage.setItem("userId",userId);
					sessionStorage.setItem("groupId",groupId);
					sessionStorage.setItem("groupName",groupName);
					sessionStorage.setItem("message",message);
					sessionStorage.setItem("groupAmount",groupAmount);

					//redirect page to dashboard.
					location.href = "dashboard.html";
				
				}else{
					//print when failed to register.
					Notiflix.Notify.Failure(message);
				}			
			}

        };
        
        xhttp.open('POST', '/FundManagement/fund/loginRegister/login',  true);
		xhttp.send(jsonData);
}


function changeDate(){
	var dateColumn = document.getElementById("todaysDate");
	var todaysDate = Date.now();
	dateColumn.value = todaysDate;
}