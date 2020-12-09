var express = require('express');
var router = express.Router();


var fs = require('fs');

/* GET users listing. */
router.get('/', function(req, res, next) {
	res.send('respond with a resource');
});

router.post('/login', function(req, res, next) {
	console.log(req.body.userId);

	fs.readFile(__base +'dataSource/members.json', 'utf-8', function(error, data) {
		var memberData = JSON.parse(data);
		console.log(memberData.version);
		console.log(memberData.members[0])

	});

	req.session.userId="jb";
	console.log("b: "+req.session.userId)
	res.send({'result':'success'});
});

module.exports = router;
