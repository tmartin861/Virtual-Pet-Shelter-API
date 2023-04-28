// Make a GET request to the shelters endpoint and retrieve the data in JSON format
fetch('/shelters')
    .then(response => response.json())
    .then(data => {
        // Update the span elements with the number of shelters and pets
        const shelterSpan = document.querySelector('[data-shelter]');
        shelterSpan.textContent = `(${data.length})`;

        const petSpan = document.querySelector('[data-pet-name]');
        petSpan.textContent = `(${data.flatMap(shelter => shelter.roboticPets).length})`;

        // Create a table row for each shelter
        const tableBody = document.querySelector('table tbody');
        data.forEach(shelter => {
            const row = document.createElement('tr');

            // Add nameCell to each row with text content of the shelter's name
            const nameCell = document.createElement('td');
            nameCell.textContent = shelter.name;
            row.appendChild(nameCell);

            // Add petNameCell to each row with text content of the shelter's first pet's name
            const petNameCell = document.createElement('td');
            petNameCell.textContent = shelter.roboticPets[0].petName;
            row.appendChild(petNameCell);

            // Add the row to the table body
            tableBody.appendChild(row);
        });
    })
    .catch(error => console.error(error));

// Make a GET request to the pets endpoint and retrieve the data in JSON format
fetch('/pets')
    .then(response => response.json())
    .then(data => {
        // Update the table rows with pet data
        const rows = document.querySelectorAll('table tbody tr');
        data.forEach(pet => {
            const row = Array.from(rows).find(row => row.children[1].textContent === pet.petName);

            if (row) {
                row.children[0].textContent = pet.type;
                row.children[2].textContent = pet.happiness;
                row.children[3].textContent = pet.health;
                row.children[4].textContent = pet.cleaniness;
            }
        });
    })
    .catch(error => console.error(error));