const bcrypt = require('bcryptjs');
const XMLHttpRequest = require("xmlhttprequest").XMLHttpRequest;

exports.index = (req, res) => {
    res.render('index');
};

exports.admin = (req, res) => {
    const request = new XMLHttpRequest();
    request.open("GET", 'http://localhost:8082/orderDetails/findAll'); // Read All Order Details
    request.send();
    request.onload = () => {
        console.log("good evenin")
        console.log(request.responseText)

    }
    res.render('adminDesign');
}

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

exports.signInChecked = (req, res) => {
    res.render('account')
};

exports.createAccount = (req, res) => {
    res.render('createAccount');
};

// Here we need to grab from the database user names and passwords that have a similar name to what was enterd
// That way we can then allow them to log into the site
exports.checkAccount = (req, res) => {
    const request = new XMLHttpRequest();
    request.open("GET", `http://localhost:8082/user/checkUser/${req.body.username}`);
    request.send();
    request.onload = () => {
        if (bcrypt.compareSync(req.body.password, request.responseText)) {
            req.session.user = {
                isAuthenticated: true
            }
            res.redirect(req.cookies.path)
        } else {
            res.redirect('/signIn')
        }
    }
};

exports.addAccount = (req, res) => {
    if(req.body.password === req.body.confirmPassword) {
        let user = {
            fname: req.body.fname,
            lname: req.body.lname,
            email: bcrypt.hashSync(req.body.email, bcrypt.genSaltSync(10)),
            phone: bcrypt.hashSync(req.body.phone, bcrypt.genSaltSync(10)),
            username: req.body.username,
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

//STILL WORKING ON IT
exports.addOrder = (req, res) => {
    let orderDetails = {
        typeOfEvent: req.body.typeOfEvent,
        dateOfEvent: req.body.dateOfEvent,
        locationOfEvent: req.body.locationOfEvent,
        numberOfGuests: req.body.numberOfGuests,
        totalCostOfEvent: req.body.totalCostOfEvent,
        menuItems: req.body.menu
    }
    if(req.session.user.isAuthenticated){
        const request = new XMLHttpRequest();
        request.open("POST", "http://localhost:8082/orderDetails/add")
        request.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        request.send(JSON.stringify(orderDetails));
        res.redirect('/');
    }else {
        res.redirect('/signIn')
    }
}