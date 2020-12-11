var express = require('express');
var router = express.Router();

var fs = require('fs');

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', {
  	title: 'mainPage',
  	session: req.session
  });
});

router.get('/board', function(req, res, next) {
  var data = JSON.parse.readFileSync(__base +'dataSource/members.json', 'utf-8');
  res.render('board', {
  	title: 'BoardPage',
  	session: req.session,
    // boards:data["boards"]
  });
})

router.get('/cheat', function(req, res, next) {
  res.render('index', {
  	title: 'CheatPage',
  	session: req.session
  });
})

module.exports = router;
