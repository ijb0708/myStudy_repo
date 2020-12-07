const http = require('http');
const fs = require('fs');
const url = require("url");

const server = http.createServer((request, response) => {

	var urlData = url.parse(request.url, true);

	var urlPath= urlData.pathname;
	var redirectView;

	redirectView='views/index.html';

	if (urlPath == '/favicon.ico') {
		redirectView='favicon.ico';
	}else if (urlPath == '/login') {
		fs.readFile('database/id.json', null, (err, data) => {
			var obj =JSON.parse(data);
			console.log(obj.id);
		})
	}

	console.log(urlPath);

	fs.readFile(redirectView, null, (err, data) => {
		response.write(data);
		response.end();
	})

})

server.listen(8800)