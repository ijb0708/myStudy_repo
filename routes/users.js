var express = require('express');
var router = express.Router();

var fs = require('fs');

/* GET users listing. */
router.get('/', function(req, res, next) {
	res.send('respond with a resource <script type="text/javascript">console.log("tet"+sessionStorage.getItem("userName"));</script>');
});

router.post('/login', function(req, res) {

	var reqUserId= req.body.userId, 
	    reqUserWd= req.body.passWd;
	var result= 0; 	//0:loginFail, 1:passwd loginFail, 2:loginsuccess

	var memberData = JSON.parse(fs.readFileSync(__base +'dataSource/members.json', 'utf-8'));

	for (member of memberData.members) {
		if(member.userId== reqUserId){
			if(member.passWd== reqUserWd) {
				req.session.userName=member.name;
				console.log("tt");

				// store.all((_, session) => {
				// 	console.log('ss'+session);
				// })
				result= 2;
			}else {
				result= 1;
			}
			break;	
		}
	}

	res.json({"result":result});
});

router.get('/logout', function(req, res) {
	delete req.session.userName
	res.clearCookie('sid');
	res.json({"result":"result"});
})

module.exports = router;
