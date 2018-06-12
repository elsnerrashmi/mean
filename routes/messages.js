var express = require('express');
var router = express.Router();
var Message = require('../Models/message');
router.post('/', function (req, res, next) {
    var message = new Message({
        content: req.body.content
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
        res.status(200).json({
            message:'Message Saved',
            result:result
        })

    })
});

router.get('/', function (req, res, next) {
    Message.find()
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
