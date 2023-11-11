//Constantes
const express = require ('express');
const app = express ();
const morgan = require ('morgan');

//Configuraciones
app.set ('port', 3002);
app.set ('port', process.env.PORT || 3002);
app.set ('json spaces', 2);

//Middleware
app.use (morgan('dev'));
app.use (express.json());
app.use (express.urlencoded({extended: false}));
app.use (require('./routes/routes'));
app.use (require('./routes/ControlUsuarios'));
app.use ('/api/ControlUsuarios', require ('./routes/ControlUsuarios'));

//Inicio del servidor
app.listen(app.get('port'), () => {
    console.log('Server on port ' + app.get('port'));
});
