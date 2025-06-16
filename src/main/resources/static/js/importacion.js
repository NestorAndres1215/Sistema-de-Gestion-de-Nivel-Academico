        // Display selected file names
        function updateFileName(inputId, displayId) {
            const input = document.getElementById(inputId);
            const display = document.getElementById(displayId);
            input.addEventListener('change', () => {
                display.textContent = input.files.length > 0 ? input.files[0].name : 'Ningún archivo seleccionado';
            });
        }

        updateFileName('excelFile', 'excelFileName');
        updateFileName('xmlFile', 'xmlFileName');