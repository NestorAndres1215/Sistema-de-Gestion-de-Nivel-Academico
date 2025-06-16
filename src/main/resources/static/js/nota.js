document.addEventListener("DOMContentLoaded", function () {
    const notas = document.querySelectorAll(".nota");

    notas.forEach(function (celda) {
        const valor = parseFloat(celda.textContent);
        if (!isNaN(valor)) {
            celda.textContent = valor.toFixed(2); // redondea a 2 decimales
        }
    });
});