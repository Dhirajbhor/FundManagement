
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


function registerForm() {
	if(emailIdValidate() && passwordValidate() && panCardValidate() && adharCardValidate() && confirmPasswordValidate() && mobileNumberValidate() && isOkUser){

		const form = document.getElementById("regForm");
		
		//parse from data into json
		var formArray = objectifyForm(form);
		formArray.groupAmount = parseFloat((document.getElementById('groupAmount').value).replace(",",""));
		var jsonData = JSON.stringify(formArray);

		//ajax object
		var xhttp = new XMLHttpRequest();
		
		//rest call	
		//when ajax is ready to send call or get response
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				
				// parse json response in js object
				var response = JSON.parse(xhttp.responseText);
				var message = response.message;
				
				//check response if successful then rediret
				if(message == 'Register Successsful'){
					

					//parse data from json object
					var tokan = response.tokan;
					var groupName = response.groupName;
					var groupId = response.groupId;
					var userId = response.userId;
					var groupAmount = response.groupAmount;
					

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

		//rest url methods to send request	
		xhttp.open('POST', '/FundManagement/fund/loginRegister/register',  true);
		xhttp.send(jsonData);
	}else{
		Notiflix.Notify.Info("please Filled details correctly");
	} 
}


//function to covert from data into array
function objectifyForm(formArray) {
	var returnArray = {};
	
	for (var i = 0; i < formArray.length; i++){
		returnArray[formArray[i]['name']] = formArray[i]['value'];
	}
		return returnArray;
}



function showTotalAmount(){
	var input1 = parseFloat((document.getElementById('groupAmount').value).replace(",",""));
	var input2 = document.getElementById('shares').value;
	var sharesTotal = document.getElementById('totalShares');
	
	var answer = input1 * input2;
	
	sharesTotal.value = `${answer}.00`;
}










$(document).on('keyup', "input[data-type='currency']", function () {
  formatCurrency($(this));
  });
  $(document).on('blur', "input[data-type='currency']", function () {
  formatCurrency($(this), "blur");
  });
  
  function currencyNumber(n) {
  // format number 1000000 to 1,234,567
  // return n.replace(/\D/g, "").replace(/\B(?=(\d{3})+(?!\d))/g, ",")
  // format number 1000000 to 12,34,567
  return n.replace(/\D/g, "").replace(/(\d+?)(?=(\d\d)+(\d)(?!\d))(\.\d+)?/g, "$1,");
  }
  
  function formatCurrency(input, blur) {
  var input_val = input.val();
  if (input_val === "") { return; }
  var original_len = input_val.length;
  var caret_pos = input.prop("selectionStart");
  if (input_val.indexOf(".") >= 0) {
      var decimal_pos = input_val.indexOf(".");
      var left_side = input_val.substring(0, decimal_pos);
      var right_side = input_val.substring(decimal_pos);
      left_side = currencyNumber(left_side);
      right_side = currencyNumber(right_side);
      if (blur === "blur") {
          right_side += "00";
      }
      right_side = right_side.substring(0, 2);
      input_val = left_side + "." + right_side;
  
  } else {
      input_val = currencyNumber(input_val);
      input_val = input_val;
      if (blur === "blur") {
          input_val += ".00";
      }
  }
  input.val(input_val);
  var updated_len = input_val.length;
  caret_pos = updated_len - original_len + caret_pos;
  input[0].setSelectionRange(caret_pos, caret_pos);
  }