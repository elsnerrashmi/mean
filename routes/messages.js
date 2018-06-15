var express = require('express');
var router = express.Router();
var Message = require('../Models/message');
var User = require('../Models/user');
let jwt = require('jsonwebtoken');

router.use('/',function (req,res,next) {

    jwt.verify(req.query.token,'meanapp',function (err,decoded) {
        if(err)
        {
            return res.status(401).json({
                title:'Not Authenticated',
                message:'You are not logged In Or Your session is expired. Please login again.'
            })
        }
        next();
    })

})
router.post('/', function (req, res, next) {
    let decoded = jwt.decode(req.query.token);
    User.findById(decoded.user._id,function (err,user) {
        if(err)
        {
            return res.status(500).json({
                message:'An error',
                error:err,
            })
        }
        var message = new Message({
            content: req.body.content,
            user: user._id
        });
        console.log(message);
        message.save(function (err,result) {
            if(err)
            {
                return res.status(500).json({
                    message:'An error',
                    error:err,
                })
            }
            user.messages.push(result);
            user.save();
            res.status(200).json({
                message:'Message Saved',
                result:result
            })

        })
    })

});

router.get('/', function (req, res, next) {
    Message.find()
    .populate('user','first_name')
    .exec(function (err,messages) {
        console.log(messages);
        if(err)
        {
            return res.status(500).json({
                message:'An error',
                error:err,
            })
        }
        res.status(200).json({
            message:'Success',
            result:messages
        });
    });

});

router.patch('/:id', function (req, res, next) {
    let decoded = jwt.decode(req.query.token);
    Message.findById(req.params.id,function (err,message) {
        if(err)
        {
            return res.status(500).json({
                message:'An error',
                error:err,
            })
        }
        if(!message)
        {
            return res.status(204).json({
                message:'No message found.',
                error:{message:'Message not found'},
            })
        }
        if(message.user != decoded.user._id){
            return res.status(401).json({
                title:'Not Authenticated',
                error:{message:'Not Authenticated'}
            })
        }
        message.content = req.body.content;
        message.save(function (err,result) {
            if(err)
            {
                return res.status(500).json({
                    message:'An error',
                    error:err,
                })
            }
            res.status(200).json({
                message:'Message updated',
                result:result
            })

        })
        
    })

});

router.delete('/:id', function (req, res, next) {
    let decoded = jwt.decode(req.query.token);
    Message.findById(req.params.id,function (err,message) {
        if(err)
        {
            return res.status(500).json({
                message:'An error',
                error:err,
            })
        }
        if(!message)
        {
            return res.status(204).json({
                message:'No message found.',
                error:{message:'Message not found'},
            })
        }
        if(message.user != decoded.user._id){
            return res.status(401).json({
                title:'Not Authenticated',
                error:{message:'Not Authenticated'}
            })
        }
        message.remove(function (err,result) {
            if(err)
            {
                return res.status(500).json({
                    message:'An error',
                    error:err,
                })
            }
            res.status(200).json({
                message:'Message deleted',
                result:result
            })

        })

    })

});

module.exports = router;
