//Constantes
const { Router } = require ("express");
const router = Router();

//Rutas
router.get ('/ControlUsuarios', (req, res) => {
    res.send('ControlUsuarios');
})

module.exports = router;