document.addEventListener("DOMContentLoaded", function () {
    document.querySelector("form").addEventListener("submit", function (event) {
        var nome = document.querySelector('input[name="txtNome"]').value;
        var cognome = document.querySelector('input[name="txtCognome"]').value;
        var telefono = document.querySelector('input[name="txtTelefono"]').value;
        var eta = document.querySelector('input[name="txtEta"]').value;

        var nomeCognomeRegex = /^[a-zA-Z]+$/;
        var telefonoRegex = /^\d{9}$/;

        if (!nomeCognomeRegex.test(nome)) {
            alert("Il campo Nome deve contenere solo lettere.");
            event.preventDefault();
            return;
        }

        if (!nomeCognomeRegex.test(cognome)) {
            alert("Il campo Cognome deve contenere solo lettere.");
            event.preventDefault();
            return;
        }

        if (!telefonoRegex.test(telefono)) {
            alert("Il numero di telefono deve essere lungo esattamente 9 cifre.");
            event.preventDefault();
            return;
        }

        if (eta < 12) {
            alert("Devi avere almeno 12 anni.");
            event.preventDefault();
            return;
        }
    });
});

function controllaEta(input) {
    if (input.value < 12) {
        alert("Devi avere almeno 12 anni.");
        input.value = '';
        input.focus();
    }
}
