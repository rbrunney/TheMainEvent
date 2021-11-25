const bcrypt = require('bcryptjs');

exports.index = (req, res) => {
    res.render('index')
};

exports.orderPage = (req, res) => {
    res.render('orderPage');
};

exports.accountInfo = (req, res) => {
    res.render('accountInfo');
};

exports.freezerMeals = (req, res) => {
    res.render('freezerMeals')
};

exports.signIn = (req, res) => {
    res.render('signIn')
};

exports.createAccount = (req, res) => {
    res.render('createAccount');
};

exports.addAccount = (req, res) => {
    if(req.body.password === req.body.confirmPassword) {
        let user = {
            fname: req.body.fname,
            lname: req.body.lname,
            email: bcrypt.hashSync(req.body.email, bcrypt.genSaltSync(10)),
            phone: bcrypt.hashSync(req.body.phone, bcrypt.genSaltSync(10)),
            username: bcrypt.hashSync(req.body.username, bcrypt.genSaltSync(10)),
            password: bcrypt.hashSync(req.body.password, bcrypt.genSaltSync(10)),
        }

        // Need to call REST API here so we can add their information to the Database
        

        res.redirect('/');
    } else {
        res.redirect('/createAccount');
    }
}