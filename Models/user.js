var mongoose = require('mongoose');
var Schema = mongoose.Schema;
var mongooseUniqueValidator = require('mongoose-unique-validator');

var schema = new Schema({
    first_name : {type:String,require:true},
    last_name : {type:String,require:true},
    password:{type:String,require:true},
    email:{type:String,require:true,unique:true},
    messages:[{type:Schema.Types.ObjectId,ref:'Message'}]
})

schema.plugin(mongooseUniqueValidator);

module.exports = mongoose.model('User',schema);