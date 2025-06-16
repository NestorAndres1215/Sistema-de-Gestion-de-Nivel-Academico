        function filtrarEstadoServidor() {
            const estado = document.getElementById("estado").value;
            window.location.href = "/nivel-academico" + (estado ? "?estado=" + estado : "");
        }