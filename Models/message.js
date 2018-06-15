
var mongoose = require('mongoose');
var Schema = mongoose.Schema;
let User = require('./user');
var schema = new Schema({
    content : {type:String,require:true},
    user:{type:Schema.Types.ObjectId,ref:'User'}
})

schema.post('remove',function(message){
    User.findById(message.user,function (err,user) {
        user.messages.pull(message._id);
        user.save();
    })
})
module.exports = mongoose.model('Message',schema);