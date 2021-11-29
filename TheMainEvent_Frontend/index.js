const express = require('express');
const routes = require('./routes/routes')
const pug = require('pug');
const path = require('path');

const app = express();

app.set('view engine', 'pug');
app.set('views', __dirname + '/views');

app.use(express.static(path.join(__dirname, '/public')));

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
app.get('/account', routes.accountInfo);
app.get('/meals', routes.freezerMeals);

app.listen(3000);