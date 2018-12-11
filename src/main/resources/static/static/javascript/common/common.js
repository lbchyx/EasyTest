function getURLParam(ParamName)
{
    var reg = new RegExp("(^|&)"+ ParamName +"=([^&]*)(&|$)");           
    var r = decodeURI(window.location.search).substr(1).match(reg);
    if (r!=null) {
    	return unescape(r[2]); 
    }
    return null;
}

function getRootPath(){
	var curWwwPath=window.document.location.href;
	var pathName=window.document.location.pathname;
	var pos=curWwwPath.indexOf(pathName);
	var localhostPaht=curWwwPath.substring(0,pos);
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
	return(localhostPaht+projectName);
}

function getJsonRequest(url, callBack) {
	jQuery.ajax({
		type:"GET",
		url:getRootPath()+url,
		timeout:6000000,
		headers: { "cache-control": "no-cache" },
		cache:false,
//		data: JSON.stringify(data),
//		async:tempasync,
		contentType: "application/json",
		success: function(nowData,textStatus,XMLHttpRequest ){
			 callBack(nowData,textStatus,XMLHttpRequest);
		  },
	    error :function(msg) {
			 alert($.toJSON(msg));
		 }
	});	
}