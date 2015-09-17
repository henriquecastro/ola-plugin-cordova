module.exports = {
	exibe: function(mensagem, sucesso, erro){
		cordova.exec(sucesso, erro, "MeuToast", "exibe", [mensagem]);
	}
}