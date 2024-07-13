// confermaAcquisto.js

// Aggiungi un elemento audio
const audio = new Audio('Audio/Children.mp3');

document.addEventListener("DOMContentLoaded", function() {
    const acquistaBtn = document.getElementById("acquistaBtn");
    const thankYouPopup = document.getElementById("thankYouPopup");
    const closePopupBtn = document.getElementById("closePopupBtn");

    acquistaBtn.addEventListener("click", function() {
        // Mostra il popup di ringraziamento
        thankYouPopup.style.display = "flex";
        
        // Riproduci il suono
        audio.play();
        
        // Avvia i coriandoli
        startConfetti();
    });

    closePopupBtn.addEventListener("click", function() {
        // Nascondi il popup di ringraziamento
        thankYouPopup.style.display = "none";
        
        // Ferma i coriandoli
        stopConfetti();
    });
});

// Funzioni per gestire i coriandoli
const confetti = [];

function startConfetti() {
    for (let i = 0; i < 100; i++) {
        createConfetti();
    }
}

function stopConfetti() {
    const confettiElements = document.querySelectorAll('.confetti');
    confettiElements.forEach(element => element.remove());
}

function createConfetti() {
    const confettiElement = document.createElement('div');
    confettiElement.className = 'confetti';
    document.body.appendChild(confettiElement);

    const colors = ['#FFC107', '#FF5722', '#4CAF50', '#2196F3', '#9C27B0'];
    confettiElement.style.backgroundColor = colors[Math.floor(Math.random() * colors.length)];
    confettiElement.style.left = Math.random() * 100 + 'vw';
    confettiElement.style.animationDuration = (Math.random() * 3 + 2) + 's';

    setTimeout(() => {
        confettiElement.remove();
        createConfetti();
    }, Math.random() * 3000 + 2000);
}
