const express = require('express');
const routes = require('./routes/routes');
const expressSession = require('express-session');
const cookieParser = require('cookie-parser');
const pug = require('pug');
const path = require('path');

const app = express();

app.set('view engine', 'pug');
app.set('views', __dirname + '/views');

app.use(express.static(path.join(__dirname, '/public')));
app.use(cookieParser());

app.use(expressSession({
    secret: 'sessionInfo',
    saveUninitialized: true,
    resave: true
}));

const checkAuthAccount = (req, res, next) => {
    if(req.session.user && req.session.user.isAuthenticated) {
        res.clearCookie('path');
        console.log("This is yee right here");
        next();
    } else {
        res.cookie('path', '/account', {maxAge:60000});
        res.redirect('/signIn');
    }
};

const checkAuthOrder = (req, res, next) => {
    if(req.session.user && req.session.user.isAuthenticated) {
        res.clearCookie('path');
        console.log("This is yee right here");
        next();
    } else {
        res.cookie('path', '/order', {maxAge:60000});
        res.redirect('/signIn');
    }
};

const urlencoderParser = express.urlencoded({
    extended: false
});

app.get('/', routes.index);
app.post('/', routes.index);
app.get('/adminDesign', routes.admin);
app.get('/signIn', routes.signIn);
app.post('/checkAccount', urlencoderParser, routes.checkAccount);
app.get('/createAccount', routes.createAccount);
app.post('/addAccount', urlencoderParser, routes.addAccount);
app.get('/order', routes.orderPage);
app.post('/addOrder', urlencoderParser, routes.addOrder);
app.get('/confirmOrder', routes.confirmOrder);
app.get('/account', checkAuthAccount, routes.accountInfo);
app.get('/meals', routes.freezerMeals);
app.post('/updateAccount', urlencoderParser, routes.updateAccount);

app.listen(3000);