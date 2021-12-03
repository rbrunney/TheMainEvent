const bcrypt = require('bcryptjs');
const XMLHttpRequest = require("xmlhttprequest").XMLHttpRequest;

exports.index = (req, res) => {
    res.render('index');
};

exports.admin = (req, res) => {
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
            if(req.cookies.path === undefined) {
              res.redirect('/')  
            } else {
                res.redirect(req.cookies.path)
            }
            
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
        request.onload = () => {
            console.log(request.responseText);
        }

        const sendEmail = new XMLHttpRequest();
        sendEmail.open("GET", "http://localhost:8082/email/sendEmailConfirmation/" + req.body.email);
        sendEmail.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        sendEmail.send();
        sendEmail.onload = () => {
            console.log(sendEmail.responseText);
        }
        res.redirect('/');
    } else {
        res.redirect('/createAccount');
    }
};

exports.addOrder = (req, res) => {
    const GrilledChicken = document.getElementById('Grilled Chicken');
    const AmericanPicnic = document.getElementById('American Picnic');
    const BaconSteak = document.getElementById('Bacon Steak');
    const HorDevours = document.getElementById('Hor Devours');
    let orderDetails = {
        typeOfEvent: req.body.typeOfEvent,
        dateOfEvent: req.body.dateOfEvent,
        locationOfEvent: req.body.locationOfEvent,
        numberOfGuests: req.body.numberOfGuests,
        totalCostOfEvent: req.body.totalCostOfEvent,
        menuItems: req.body.menuItems
    }

    console.log(orderDetails)

    try {
        if(req.session.user.isAuthenticated){
            const request = new XMLHttpRequest();
            request.open("POST", "http://localhost:8082/orderDetails/add")
            request.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
            request.send(JSON.stringify(orderDetails));
            res.redirect('/');

            const sendEmail = new XMLHttpRequest();
            sendEmail.open("POST", "http://localhost:8082/email/sendOrderPending/" + req.body.email);
            sendEmail.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
            sendEmail.send(JSON.stringify(orderDetails));
            sendEmail.onload = () => {
                console.log(sendEmail.responseText);
            }
        } else {
            res.redirect('/signIn');
        }
    } catch(err) {
        res.cookie('path', '/confirmOrder', {maxAge:60000});
        res.cookie('orderInfo', orderDetails, {maxAge:60000})
        res.redirect('/signIn');
    }
}

exports.confirmOrder = (req, res) => {

    let orderDetails = req.cookies.orderInfo;
    res.clearCookie('orderInfo');

    const request = new XMLHttpRequest();
    request.open("POST", "http://localhost:8082/orderDetails/add")
    request.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    request.send(JSON.stringify(orderDetails));

    const sendEmail = new XMLHttpRequest();
    sendEmail.open("POST", "http://localhost:8082/email/sendOrderPending/" + req.body.email);
    sendEmail.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    sendEmail.send(JSON.stringify(orderDetails));
    sendEmail.onload = () => {
        console.log(sendEmail.responseText);
    }
    res.redirect('/');
}