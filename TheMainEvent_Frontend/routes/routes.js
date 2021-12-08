const bcrypt = require('bcryptjs');
const XMLHttpRequest = require("xmlhttprequest").XMLHttpRequest;

exports.index = (req, res) => {
    res.render('index');
};

exports.admin = (req, res) => {
    res.render('adminDesign');
}

exports.orderPage = (req, res) => {
    res.render('orderPage', {
        user: req.session.user
    });
};

exports.accountInfo = (req, res) => {
    res.render('accountInfo', {
        user: req.session.user
    });
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
    request.open("GET", `http://mainevent-api.ngrok.io/user/checkUser/${req.body.username}`);
    request.send();
    request.onload = () => {
        userInfo = JSON.parse(request.responseText)
        if (bcrypt.compareSync(req.body.password, userInfo.password)) {

            req.session.user = {
                isAuthenticated: true,
                name: userInfo.fname,
                username: userInfo.username,
                email: userInfo.email,
                phone: userInfo.phone
            }

            if(req.cookies.path === undefined) {
                res.redirect('/');  
            } else {
                res.redirect(req.cookies.path);
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
            email: req.body.email,
            phone: req.body.phone,
            username: req.body.username,
            password: bcrypt.hashSync(req.body.password, bcrypt.genSaltSync(10)),
        }
        // Need to call REST API here so we can add their information to the Database
        const request = new XMLHttpRequest();
        request.open("POST", "http://mainevent-api.ngrok.io/user/add");
        request.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        request.send(JSON.stringify(user));
        request.onload = () => {
            console.log(request.responseText);
        }

        const sendEmail = new XMLHttpRequest();
        sendEmail.open("GET", "http://mainevent-api.ngrok.io/email/sendEmailConfirmation/" + req.body.email);
        sendEmail.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        sendEmail.send();
        sendEmail.onload = () => {
            console.log(sendEmail.responseText);
        }
        res.redirect('/signIn');
    } else {
        res.redirect('/createAccount');
    }
};

exports.addOrder = (req, res) => {
    let meal = "";
    
    if(req.body.HorDevours){
        meal = 'Hor Devours';
    } else if(req.body.BaconSteak){
        meal = 'Bacon Wrapped Steak';
    } else if(req.body.AmericanPicnic){
        meal = 'American Picnic';
    } else if(req.body.GrilledChicken){
        meal = 'Grilled Chicken';
    } else {
        meal = 'TBD';
    }

    let orderDetails = {
        typeOfEvent: req.body.typeOfEvent,
        dateOfEvent: req.body.dateOfEvent,
        locationOfEvent: req.body.locationOfEvent,
        numberOfGuests: req.body.numberOfGuests,
        totalCostOfEvent: req.body.totalCostOfEvent,
        menuItems: meal
    }

    console.log(orderDetails)

    try {
        if(req.session.user.isAuthenticated){
            const request = new XMLHttpRequest();
            request.open("POST", "http://mainevent-api.ngrok.io/orderDetails/add")
            request.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
            request.send(JSON.stringify(orderDetails));

            const sendEmail = new XMLHttpRequest();
            sendEmail.open("POST", "http://mainevent-api.ngrok.io/email/sendOrderPending/" + req.session.user.email);
            sendEmail.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
            sendEmail.send(JSON.stringify(orderDetails));
            sendEmail.onload = () => {
                console.log(sendEmail.responseText);
            }

            res.redirect('/');

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
    request.open("POST", "http://mainevent-api.ngrok.io/orderDetails/add")
    request.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    request.send(JSON.stringify(orderDetails));

    const sendEmail = new XMLHttpRequest();
    sendEmail.open("POST", "http://mainevent-api.ngrok.io/email/sendOrderPending/" + req.session.user.email);
    sendEmail.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    sendEmail.send(JSON.stringify(orderDetails));
    sendEmail.onload = () => {
        console.log(sendEmail.responseText);

        res.redirect('/');
    }

}