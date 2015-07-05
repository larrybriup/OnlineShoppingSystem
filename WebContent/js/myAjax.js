function createXMLHttpRequest(){
		var xmlHttpRequest=null;
		if(window.ActiveXObject){
			xmlHttpRequest=new XMLHttpRequest("microsoft.XMLHTTP");
		}else if(window.XMLHttpRequest){
			xmlHttpRequest=new XMLHttpRequest();
		}else{
			alert("对不起!您的浏览器不支持ajax脚本!");
			xmlHttpRequest=false;
		}
		return xmlHttpRequest;
	}