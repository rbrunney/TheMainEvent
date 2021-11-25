const bcrypt = require('bcryptjs');
const XMLHttpRequest = require("xmlhttprequest").XMLHttpRequest;

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

// Here we need to grab from the database user names and passwords that have a similar name to what was enterd
// That way we can then allow them to log into the site
exports.checkAccount = (req, res) => {
    if ((bcrypt.compareSync(req.body.username, "Check Username") || bcrypt.compareSync(req.body.username, "Check Email")) 
    && bcrypt.compareSync(req.body.password, "Check Password")) {
        console.log("User has Logged On")
        res.redirect('/')
    } else {
        res.redirect('/signIn')
    }
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
        const request = new XMLHttpRequest();
        request.open("POST", "http://localhost:8082/user/add");
        request.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        request.send(JSON.stringify(user));
        res.redirect('/');
    } else {
        res.redirect('/createAccount');
    }

};