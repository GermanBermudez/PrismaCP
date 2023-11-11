//Constantes
const { Router } = require ('express');
const router = Router();
const ControlUsuarios = require ('../Usuarios.json');
    console.log (ControlUsuarios);
const _ = require ('underscore');

//Validación de Login
router.get('/', (req, res) => {    
    const {Usuario, Contraseña} =req.body;
    
    if(Usuario && Contraseña){        
        _.each(ControlUsuarios, (usuario, i) => {
            if (usuario.Usuario == Usuario) {
                if(usuario.Contraseña == Contraseña){
                    res.json(usuario)
                }
                else{
                    res.json('Contraseña errada')
                }                
            }                        
        });
        res.json('Usuario no encontrado')
    }
    else{
        res.json (ControlUsuarios);
    }
    
});

//Registro de un nuevo usuario
router.post('/', (req, res) => {
    console.log (req.body);
    
    const Id = ControlUsuarios.length + 1;
    const newControlUsuarios = {...req.body, Id}
        console.log(newControlUsuarios);
    const { Nombre, Contraseña, Usuario, Cedula } = req.body;
    if (Nombre && Contraseña && Usuario && Cedula){
        ControlUsuarios.push (newControlUsuarios);
        res.send ('Usuario Registrado');
    }
    else{
        res.send ('Operación fallida');
    }            
});

//Elimar un usuario
router.delete('/:Id', (req, res) => {
    console.log (req.params);
    const {Id} = req.params;
    res.send ('Usuario Eliminado');

    _.each (ControlUsuarios, (usuario, i) => {
        if (usuario.Id == Id) {
            ControlUsuarios.splice (i, 1);
        }
    });
});

//Actualizar uno de los registros
router.put ('/:Id', (req, res) => {
    const {Id} = req.params;
    const {Nombre, Contraseña, Usuario, Cedula} =req.body;
    if (Nombre && Contraseña && Usuario && Cedula){
        _.each(ControlUsuarios, (usuario, i) => {
            if (usuario.Id == Id) {
                usuario.Nombre = Nombre;
                usuario.Contraseña = Contraseña;
                usuario.Usuario = Usuario;
                usuario.Cedula = Cedula;
            }
        });
        res.json(ControlUsuarios);        
    }
    else {
        res.status(500).json({error: 'Hay un error, faltan datos'});
    }
});

module.exports = router;