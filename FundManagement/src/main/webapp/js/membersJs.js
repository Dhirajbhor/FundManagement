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





function addMember(){
    if(isOkPanNumber && isOkAdharNumber && isOkEmailId && isOkMobileNumber && isOkUser){
        const form = document.getElementById("memberForm");
		
		//parse from data into json
		var formArray = objectifyForm(form);
		var jsonData = JSON.stringify(formArray);

		//ajax object
		var xhttp = new XMLHttpRequest();
		
		//rest call	
		//when ajax is ready to send call or get response
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				
				// parse json response in js object
					var message = xhttp.responseText;
					if(message == "Log Out"){
						sessionStorage.setItem("message",message);
						//location.href = "";
					}else if(message == "Member Added"){
						sessionStorage.setItem("message",message);
						location.reload();
					}else{
						Notiflix.Notify.Failure(message);
					}
				}			

		};

        var groupId = sessionStorage.getItem("groupId");
        var userId = sessionStorage.getItem("userId");
        var tokan = sessionStorage.getItem("tokan");

		//rest url methods to send request	
		xhttp.open('POST', '/FundManagement/fund/users/'+ groupId + "/"+ userId +"/" + tokan +"/addMember",  true);
		xhttp.send(jsonData);
	}else{
		Notiflix.Notify.Info("please Filled details correctly");
	} 

}

function changeDate(){
	var dateColumn = document.getElementById("todaysDate");
    var todaysDate = new Date();
    var chDate = todaysDate *1;
	dateColumn.value = chDate;
}

function printMessage(){
    var message = sessionStorage.getItem("message");

    if(message != null){
        Notiflix.Notify.Success(message);
        sessionStorage.removeItem('message');	
    }
}

function putGroupName(){
    var groupName = sessionStorage.getItem("groupName");
    document.getElementById('groupName').innerHTML = groupName;
}

function showTotalAmount(){
	var groupAmount = sessionStorage.getItem("groupAmount");
	console.log(groupAmount);
	var input1 = groupAmount;
	var input2 = document.getElementById('shares').value;
	var sharesTotal = document.getElementById('totalShares');
	
	var answer = input1 * input2;
	
	sharesTotal.value = `${answer}.00`;
}