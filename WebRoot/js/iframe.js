//iframe upload
function addIframe() {
	var seed = Math.floor(Math.random() * 1000);
	var id = "uploader-frame-" + seed;
	var callback = "uploader-cb-" + seed;
	var iframe = $('iframe id="' + id + '" name = " + id +" style=\"display: none\"');
	var url = form.attr('action');
	form.attr('target', id).append(iframe).attr('action',
			url + '?iframe = ' + callback);
}
var form = $('#upload-form');
form.on('submit', function() {
	addIframe();
});
window[callback] = function(data) {
	console.log('received callback: ', data);
	iframe.remove();
	form.removeAttr("target")
	form.attr('action', url);
	window[callback] = undefined;
}
//ajax upload
function addFormdata() {
if(window.FormData){
		var formData = new FormData();
		formdata.append('upload', document.getElementById('upload').files[0]);
		var xhr = new XmlHttpRequest();
		xhr.open('POST', $(this).attr('action'));
		xhr.onload = function(){
			if(xhr.status == 200){
				console.log('success!!!');
			}else{
				consoloe.log('error!!!');
			}
		};
		xhr.send(formData);
		
		//progress
		xhr.upload.onprogress = function (event) {
	　		if (event.lengthComputable) {
	　　　　　　var complete = (event.loaded / event.total * 100 | 0);
	　　　　　　var progress = document.getElementById('uploadprogress');
	　　　　　　progress.value = progress.innerHTML = complete;
　　　　		}	
　		};
	}	
}
form.on('submit', function(){
	addFormdata();
});


// 检查是否支持FileReader对象
if (typeof FileReader != 'undefined') {
　　var acceptedTypes = {
　　		'image/png': true,
　　　　 'image/jpeg': true,
　　　　 'image/gif': true
　　};
　　if (acceptedTypes[document.getElementById('upload').files[0].type] === true) {
　　　　var reader = new FileReader();
　　　　reader.onload = function (event) {
　　		　   var image = new Image();
　　　　　　image.src = event.target.result;
　　　　　　image.width = 100;
　　　　　　document.body.appendChild(image);
　　　　};
　　　　reader.readAsDataURL(document.getElementById('upload').files[0]);
　　}
}

/** drag drop  */
　// 检查浏览器是否支持拖放上传。
if('draggable' in document.createElement('span')){
　　var holder = document.getElementById('holder');
　　holder.ondragover = function () { this.className = 'hover'; return false; };
　　holder.ondragend = function () { this.className = ''; return false; };
　　holder.ondrop = function (event) {
　　		event.preventDefault();
　　		this.className = '';
　　		var files = event.dataTransfer.files;
　　		//do something with files
　	};
>>>>>>> 311684702c51bc2920713ba2a019bd0e26c3224b
} 