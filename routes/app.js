var express = require('express');
var router = express.Router();
var User = require('../Models/user');

router.get('/', function (req, res, next) {
    res.render('index');
});
module.exports = router;
