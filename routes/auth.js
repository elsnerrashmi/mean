let express = require('express');
let router = express.Router();
let User = require('../Models/user');
let bcrypt  = require('bcryptjs');
let jwt = require('jsonwebtoken');

router.get('/', function (req, res, next) {
    User.findOne({}, function (err, doc) {
        if (err) {
            return res.send('Error');
        }
        res.render('form', {email: doc.email});
    });

});



router.post('/', function (req, res, next) {
    let user = new User({
        first_name: req.body.first_name,
        last_name: req.body.last_name,
        email: req.body.email,
        password: bcrypt.hashSync( req.body.password,10),

    })
    user.save(function (err,result) {
        if(err)
        {
            return res.status(500).json({
                message:'An error',
                error:err,
            })
        }
        res.status(200).json({
            message:'User Saved',
            result:result
        })
    });

});

router.post('/signin', function (req, res, next) {

    User.findOne({email:req.body.email},function (err,user) {
        if(err)
        {
            return res.status(500).json({
                message:'An error',
                error:err,
            })
        }
        if(!user)
        {
            return res.status(401).json({
                title:'Authentication failed',
                message:'Credentials do not match with our records.',
            })
        }
        if (!bcrypt.compareSync(req.body.password,user.password))
        {
            return res.status(401).json({
                title:'Authentication failed',
                message:'Credentials do not match with our records.',
            })
        }
        let token = jwt.sign({user:user},'meanapp',{expiresIn:7200});
        res.status(200).json({
            message:'Logged In',
            token:token,
            user_id:user._id
        })
    });

});



module.exports = router;
