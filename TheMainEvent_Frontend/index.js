const express = require('express');
const routes = require('./routes/routes')
const pug = require('pug');
const path = require('path');

const app = express();

app.set('view engine', 'pug');
app.set('views', __dirname + '/views');

app.use(express.static(path.join(__dirname, '/public')));

app.get('/', routes.index);
app.get('/order', routes.orderPage);
app.get('/account', routes.accountInfo);
app.get('/meals', routes.freezerMeals);

app.listen(3000);