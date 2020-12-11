var express = require('express');
var router = express.Router();

var fs = require('fs');

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', {
  	title: 'mainPage',
  	session: req.session
  });
})

router.get('/fuck', function(req, res, next) {
  res.render('index', {
    title: 'Page',
    session: req.session
  });
})

router.get('/cheat', function(req, res, next) {
  res.render('index', {
  	title: 'CheatPage',
  	session: req.session
  });
})

module.exports = router;
