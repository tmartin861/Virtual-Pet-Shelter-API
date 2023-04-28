document.getElementById("generateRandomPet").addEventListener("click", generateRandomPet);
document.getElementById("customPetForm").addEventListener("submit", createCustomPet);
function generateRandomPet() {
    let petTypes = ["Organic Dog", "Organic Cat", "Robotic Dog", "Robotic Cat"];
    let randomPetType = petTypes[Math.floor(Math.random() * petTypes.length)];

    let petNames = ["Buddy", "Charlie", "Max", "Bella", "Lucy", "Molly", "Daisy", "Lola", "Fido", "Shadow"];
    let randomPetName = petNames[Math.floor(Math.random() * petNames.length)];

    function getRelevantStats(pet) {
        if (pet.type.startsWith("Organic")) {
            return {
                happiness: 5,
                health: 5,
                hunger: 5,
                waste: 5
            };
        } else {
            return {
                happiness: 5,
                health: 5,
                oil: 5,
                batteryLife: 5
            };
        }
    }

    // Get the relevant stats for the random pet type
    let relevantStats = getRelevantStats({type: randomPetType});



    // Create a new object with the randomPetType, randomPetName, and other properties
    let newPet = {
        type: randomPetType,
        petName: randomPetName,
        ...relevantStats // Include the relevant stats using the object spread syntax
    };

    // Add the new pet to the allPets array
    allPets.push(newPet);

    // Make a POST request to the server
    fetch("/pets", {
        method: "POST",
        body: JSON.stringify(newPet),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(response => {
        if (response.ok) {
            addPetToAvailablePetsTable(newPet);
            alert("Random pet generated successfully!");
        } else {
            alert("Error generating random pet");
        }
    });
}

let allPets = [];

function validateStat(value) {
    return Math.max(0, Math.min(10, value));
}

function tick() {
    allPets.forEach(pet => {
        if (pet.type.startsWith("Organic")) {
            pet.hunger = validateStat(pet.hunger + 1);
            pet.waste = validateStat(pet.waste + 1);
            pet.happiness = validateStat(pet.happiness - 1);
            pet.health = validateStat(pet.health - 1);
        } else {
            pet.batteryLife = validateStat(pet.batteryLife - 1);
            pet.oil = validateStat(pet.oil - 1);
            pet.happiness = validateStat(pet.happiness - 1);
            pet.health = validateStat(pet.health - 1);
        }
    });
}

setInterval(tick, 10000); // Run the tick function every 10 seconds

function bindPropertyToCell(pet, property, cell) {
    Object.defineProperty(pet, property, {
        get: () => cell.innerText,
        set: (newValue) => (cell.innerText = newValue),
        configurable: true,
    });
}

function addPetToAvailablePetsTable(pet) {
    // Choose the correct table based on pet type
    let table = pet.type.startsWith("Organic")
        ? document.getElementById("organicPetsTable")
        : document.getElementById("roboticPetsTable");

    let newRow = table.insertRow(-1);

    let typeCell = newRow.insertCell(0);
    let nameCell = newRow.insertCell(1);
    let happinessCell = newRow.insertCell(2);
    let otherStat1Cell = newRow.insertCell(3);
    let otherStat2Cell = newRow.insertCell(4);

    typeCell.innerText = pet.type;
    nameCell.innerText = pet.petName;
    happinessCell.innerText = pet.happiness;

    if (pet.type.startsWith("Organic")) {
        otherStat1Cell.innerText = pet.hunger;
        otherStat2Cell.innerText = pet.waste;
    } else {
        otherStat1Cell.innerText = pet.oil;
        otherStat2Cell.innerText = pet.batteryLife;
    }

    // Add cells for each action button
    let playBtnCell = newRow.insertCell(5);
    let action1BtnCell = newRow.insertCell(6);
    let action2BtnCell = newRow.insertCell(7);
    let adoptBtnCell = newRow.insertCell(8);

    // Add play button to increase happiness
    let playBtn = document.createElement("button");
    playBtn.innerText = "Play";
    playBtn.addEventListener("click", () => {
        pet.happiness = validateStat(pet.happiness + 1);
        happinessCell.innerText = pet.happiness;
    });
    playBtnCell.appendChild(playBtn);

    if (pet.type.startsWith("Organic")) {
        // Add feed button for Organic Pets
        let feedBtn = document.createElement("button");
        feedBtn.innerText = "Feed";
        feedBtn.addEventListener("click", () => {
            pet.hunger = validateStat(pet.hunger - 1);
            otherStat1Cell.innerText = pet.hunger;
        });
        action1BtnCell.appendChild(feedBtn);

        // Add water button for Organic Pets
        let waterBtn = document.createElement("button");
        waterBtn.innerText = "Clean";
        waterBtn.addEventListener("click", () => {
            pet.waste = validateStat(pet.waste - 1);
            otherStat2Cell.innerText = pet.waste;
        });
        action2BtnCell.appendChild(waterBtn);

    } else {
        // Add recharge button for Robotic Pets
        let rechargeBtn = document.createElement("button");
        rechargeBtn.innerText = "Recharge";
        rechargeBtn.addEventListener("click", () => {
            pet.batteryLife = validateStat(pet.batteryLife + 1);
            otherStat2Cell.innerText = pet.batteryLife;
        });
        action1BtnCell.appendChild(rechargeBtn);

        // Add change oil button for Robotic Pets
        let changeOilBtn = document.createElement("button");
        changeOilBtn.innerText = "Change Oil";
        changeOilBtn.addEventListener("click", () => {
            pet.oil = validateStat(pet.oil + 1);
            otherStat1Cell.innerText = pet.oil;
        });
        action2BtnCell.appendChild(changeOilBtn);
    }

    // Add adopt button to remove the pet from the table
    let adoptBtn = document.createElement("button");
    adoptBtn.innerText = "Adopt";
    adoptBtn.addEventListener("click", () => {
        table.deleteRow(newRow.rowIndex);
        // Add additional code here if you want to update the backend when a pet is adopted
    });
    adoptBtnCell.appendChild(adoptBtn);
}

function createCustomPet(event) {
    event.preventDefault();

    let customPetType = document.getElementById("customPetType").value;
    let customPetName = document.getElementById("customPetName").value;

    if (!customPetName) {
        alert("Please enter a name for the custom pet.");
        return;
    }

    function getRelevantStats(pet) {
        if (pet.type.startsWith("Organic")) {
            return {
                happiness: 5,
                health: 5,
                hunger: 5,
                waste: 5
            };
        } else {
            return {
                happiness: 5,
                health: 5,
                oil: 5,
                batteryLife: 5
            };
        }
    }

    let relevantStats = getRelevantStats({type: customPetType});

    let customPet = {
        type: customPetType,
        petName: customPetName,
        ...relevantStats // Include the relevant stats using the object spread syntax
    };

    // Add the new pet to the allPets array
    allPets.push(customPet);

    // Make a POST request to the server
    fetch("/pets", {
        method: "POST",
        body: JSON.stringify(customPet),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(response => {
        if (response.ok) {
            addPetToAvailablePetsTable(customPet);
            alert("Custom pet created successfully!");
            document.getElementById("customPetName").value = ""; // Clear the name input
        } else {
            alert("Error creating custom pet");
        }
    });
}