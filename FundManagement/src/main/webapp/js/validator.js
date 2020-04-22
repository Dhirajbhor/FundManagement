function mobileNumberValidate(){
    var position = document.getElementById('mobileNumber');
    var message = document.getElementById('mobileNumberValidator');

    var input = position.value;

    if (/^\d{10}$/.test(input)) {
        message.innerHTML = "";
        return true;
    }else if(input == ""){
        message.innerHTML = "";
        return false;
    }else{
        message.innerHTML = "Invalid Mobile Number";
        position.focus();
        return false;
    }
}

var isOkUser = false;

function emailIdValidate(){
    var position = document.getElementById('emailid');
    var message = document.getElementById('emailIdValidator');
    
    var input = position.value;

    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(input)){
        message.innerHTML = " ";
        return true;
    }else if(input == ""){
        message.innerHTML = "";
        return false;
    }else{
        message.innerHTML = "Invalid Email Id";
        position.focus();
        return false;
    }
}   

function panCardValidate(){
	var position = document.getElementById('panCardNumber');
    var message = document.getElementById('panNumberValidator');

    var input = position.value;

    if(/([A-Z]){5}([0-9]){4}([A-Z]){1}$/.test(input)){
        message.innerHTML = " ";
        return true;
    }else if(input == ""){
        message.innerHTML = "";
        return false;
    }else{
        message.innerHTML = "Invalid Pan Card Number";
        position.focus();
        return false;
    }
}

function adharCardValidate(){
	var position = document.getElementById('adharCardNumber');
    var message = document.getElementById('adharNumberValidator');

    var input = position.value;

    if(/^\d{12}$/.test(input)){
        message.innerHTML = " ";
        return true;
    }else if(input == ""){
        message.innerHTML = "";
        return false;
    }else{
        message.innerHTML = "Invalid Adhar Card Number";
        position.focus();
        return false;
    }
}

function passwordValidate(){
    var position = document.getElementById('password');
    var message = document.getElementById('passwordValidator');
    
    var input = position.value;

    if(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,20}$/.test(input)){
        message.innerHTML = " ";
        return true;
    }else if(input == ""){
        message.innerHTML = "";
        return false;
    }else{
        message.innerHTML = "Password contain at least one numeric digit, one uppercase and one lowercase letter & length 6-20.";
        position.focus();
        return false;
    }
}

function confirmPasswordValidate(){
    var position = document.getElementById('confirmPassword');
    var password = document.getElementById('password').value;
    var message = document.getElementById('confirmPasswordValidator');
    
    var input = position.value;
    
    if(password == input){
        message.innerHTML = "";
        return true;
    }else if(input == ""){
        message.innerHTML = "";
        return false;
    }else{
        message.innerHTML = "Password Does Not Match";
        position.focus();
        return false;
    }
}


function userValidate(){
    var position = document.getElementById('userName');
    var message = document.getElementById('userValidator');
    
    var userName = position.value;
    
    if(userName != ""){	
	    var xhttp = new XMLHttpRequest();
	  
	    xhttp.onreadystatechange = function(){
	        if(this.readyState == 4 && this.status == 200){
	            var response = xhttp.responseText;
	            if(response == 'true'){
	                message.innerHTML = "Try Another User Name";
                    position.focus();
                    isOkUser =  false;
	            }else if(response == 'false'){
	            	message.innerHTML = "";
                    isOkUser = true;
	            }
	        }
        }
	
	    xhttp.open('GET','/FundManagement/fund/users/0/' + userName + ' ',true);
        xhttp.send();
        
    }else{
        message.innerHTML = " ";
        isOkUser = false;
    }
}

var isOkPanNumber = false;
var isOkAdharNumber = false;
var isOkMobileNumber = false;
var isOkEmailId = false;


function checkPanCardNumber(){
    
    if(panCardValidate()){

        var position = document.getElementById('panCardNumber');
        var message = document.getElementById('panNumberValidator');
    
        var input = position.value;

        var xhttp = new XMLHttpRequest();
	  
	    xhttp.onreadystatechange = function(){
	        if(this.readyState == 4 && this.status == 200){
	            var response = xhttp.responseText;
	            if(response == 'true'){
	                message.innerHTML = "This Pan Card Number already registered";
                    position.focus();
                    isOkPanNumber =  false;
	            }else if(response == 'false'){
	            	message.innerHTML = "";
                    isOkPanNumber = true;
	            }
	        }
        }

        var groupId = sessionStorage.getItem("groupId");
	
	    xhttp.open('GET','/FundManagement/fund/users/'+ groupId +"/checkPan/"+ input +" ",true);
        xhttp.send();

    }else{
        isOkPanNumber = false;
    }
}

function checkAdharCardNumber(){
    
    if(adharCardValidate()){
        var position = document.getElementById('adharCardNumber');
        var message = document.getElementById('adharNumberValidator');
    
        var input = position.value;

        var xhttp = new XMLHttpRequest();
	  
	    xhttp.onreadystatechange = function(){
	        if(this.readyState == 4 && this.status == 200){
	            var response = xhttp.responseText;
	            if(response == 'true'){
	                message.innerHTML = "This Adhar Card Number already registered";
                    position.focus();
                    isOkAdharNumber =  false;
	            }else if(response == 'false'){
	            	message.innerHTML = "";
                    isOkAdharNumber = true;
	            }
	        }
        }

        var groupId = sessionStorage.getItem("groupId");
	
	    xhttp.open('GET','/FundManagement/fund/users/'+ groupId +"/checkAdhar/"+ input +" ",true);
        xhttp.send();

    }else{
        isOkAdharNumber = false;
    }
}


function checkEmailId(){
    
    if(emailIdValidate()){

        var position = document.getElementById('emailid');
        var message = document.getElementById('emailIdValidator');
        
        var input = position.value;

        var xhttp = new XMLHttpRequest();
	  
	    xhttp.onreadystatechange = function(){
	        if(this.readyState == 4 && this.status == 200){
	            var response = xhttp.responseText;
	            if(response == 'true'){
	                message.innerHTML = "This Email Id is already in Group";
                    position.focus();
                    isOkEmailId =  false;
	            }else if(response == 'false'){
	            	message.innerHTML = "";
                    isOkEmailId = true;
	            }
	        }
        }

        var groupId = sessionStorage.getItem("groupId");
	
	    xhttp.open('GET','/FundManagement/fund/users/'+ groupId +"/checkEmail/"+ input +" ",true);
        xhttp.send();

    }else{
        isOkEmailId = false;
    }
}

function checkMobileNumber(){
    
    if(mobileNumberValidate()){

        var position = document.getElementById('mobileNumber');
        var message = document.getElementById('mobileNumberValidator');
    
        var input = position.value;

        var xhttp = new XMLHttpRequest();
	  
	    xhttp.onreadystatechange = function(){
	        if(this.readyState == 4 && this.status == 200){
	            var response = xhttp.responseText;
	            if(response == 'true'){
	                message.innerHTML = "This Mobile Number already registered";
                    position.focus();
                    isOkMobileNumber =  false;
	            }else if(response == 'false'){
	            	message.innerHTML = "";
                    isOkMobileNumber = true;
	            }
	        }
        }

        var groupId = sessionStorage.getItem("groupId");
	
	    xhttp.open('GET','/FundManagement/fund/users/'+ groupId +"/checkMobile/"+ input +" ",true);
        xhttp.send();

    }else{
        isOkMobileNumber = false;
    }
}

