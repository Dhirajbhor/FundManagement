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
  
  
//function to covert from data into array
  function objectifyForm(formArray) {
  	var returnArray = {};
  	
  	for (var i = 0; i < formArray.length; i++){
  		returnArray[formArray[i]['name']] = formArray[i]['value'];
  	}
  		return returnArray;
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
	    if(groupName != null){
	    	document.getElementById('groupName').innerHTML = groupName;
	    }
	    
	    
	}