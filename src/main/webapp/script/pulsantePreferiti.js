document.addEventListener("DOMContentLoaded", function() {
    const starButton = document.getElementById("star-button");

    starButton.addEventListener("click", function() {
        starButton.classList.toggle("active");
    });
});