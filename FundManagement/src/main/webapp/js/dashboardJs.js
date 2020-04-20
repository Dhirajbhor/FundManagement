var imported = document.createElement('script');
imported.src = 'js/notiflix-aio-2.1.3.js';
document.head.appendChild(imported);


var imported1 = document.createElement('script');
imported1.src = 'js/notiflix-aio-2.1.3.min.js';
document.head.appendChild(imported);

putGroupName();
printMessage();







function putGroupName(){
    var groupName = sessionStorage.getItem("groupName");
    document.getElementById('groupName').innerHTML = groupName;
}



function printMessage(){
    var message = sessionStorage.getItem("message");

    if(message != null){
        Notiflix.Notify.Success(message);
        sessionStorage.removeItem('message');	
    }
}


