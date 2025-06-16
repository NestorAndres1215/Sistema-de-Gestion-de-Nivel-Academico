// Client-side pagination logic
const estudiantesCards = document.getElementById('estudiantesCards');
const paginationControls = document.getElementById('paginationControls');
const searchInput = document.getElementById('searchInput');
const searchForm = document.getElementById('searchForm');

let estudiantesData = [];
let currentPage = 1;
const pageSize = 10;

// Function to initialize data from cards
function initializeData() {
    estudiantesData = Array.from(estudiantesCards.getElementsByClassName('student-card')).map(card => ({
        id: card.dataset.id,
        nombre: card.querySelector('h3').textContent.split(' ')[0],
        apellido: card.querySelector('h3').textContent.split(' ').slice(1).join(' '),
        dni: card.querySelector('p').textContent.replace('DNI: ', ''),
        editLink: card.querySelector('.card-action-button').outerHTML
    }));
    renderPage(currentPage);
}

// Function to render a specific page
function renderPage(page) {
    currentPage = page;
    const start = (page - 1) * pageSize;
    const end = start + pageSize;
    const filteredData = searchInput.value.trim() === ''
        ? estudiantesData
        : estudiantesData.filter(est =>
            est.nombre.toLowerCase().includes(searchInput.value.toLowerCase()) ||
            est.apellido.toLowerCase().includes(searchInput.value.toLowerCase()) ||
            est.dni.includes(searchInput.value)
        );

    // Clear cards container
    estudiantesCards.innerHTML = '';

    // Render cards for current page
    filteredData.slice(start, end).forEach(est => {
        const card = document.createElement('div');
        card.className = 'student-card';
        card.dataset.id = est.id;
        card.innerHTML = `
                        <h3>${est.nombre} ${est.apellido}</h3>
                        <p>DNI: ${est.dni}</p>
                        <div class="actions">${est.editLink}</div>
                    `;
        estudiantesCards.appendChild(card);
    });

    // Render pagination controls
    renderPagination(filteredData.length);
}

// Function to render pagination controls
function renderPagination(totalItems) {
    const totalPages = Math.ceil(totalItems / pageSize);
    paginationControls.innerHTML = '';

    // Previous button
    const prevButton = document.createElement('button');
    prevButton.className = `pagination-button ${currentPage === 1 ? 'disabled' : ''}`;
    prevButton.innerHTML = '<i class="fas fa-chevron-left"></i> Anterior';
    prevButton.disabled = currentPage === 1;
    prevButton.addEventListener('click', () => {
        if (currentPage > 1) renderPage(currentPage - 1);
    });
    paginationControls.appendChild(prevButton);

    // Page numbers
    for (let i = 1; i <= totalPages; i++) {
        const pageButton = document.createElement('button');
        pageButton.className = `pagination-button ${i === currentPage ? 'active' : ''}`;
        pageButton.textContent = i;
        pageButton.addEventListener('click', () => renderPage(i));
        paginationControls.appendChild(pageButton);
    }

    // Next button
    const nextButton = document.createElement('button');
    nextButton.className = `pagination-button ${currentPage === totalPages ? 'disabled' : ''}`;
    nextButton.innerHTML = 'Siguiente <i class="fas fa-chevron-right"></i>';
    nextButton.disabled = currentPage === totalPages;
    nextButton.addEventListener('click', () => {
        if (currentPage < totalPages) renderPage(currentPage + 1);
    });
    paginationControls.appendChild(nextButton);
}

// Handle search input
searchInput.addEventListener('input', () => {
    renderPage(1); // Reset to first page on search
});

// Prevent form submission for client-side search
searchForm.addEventListener('submit', (e) => {
    e.preventDefault();
    renderPage(1);
});

// Initialize pagination
initializeData();